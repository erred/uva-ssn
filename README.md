# Project Notes

[overleaf](https://www.overleaf.com/7471327444wprkwrkhbzbs)

decompiled from v2.1.25

JADX decompiler

## Threat Modelling

- Passive Attacker
  - observe raw bluetooth traffic
  - observe application messages
- Active Attacker

- Application
  - Confidentiality
    - Messages encrypted with receiver public key
    - headers unencrypted
  - Integrity
    - RSA/ECB/PKCS1Padding
      - block by block, 11 byte IV
  - Availability
    - guaranteed send?
    - SYN/ACK ?
  - Non-repudiation
    - sender verification?
- Transport
  - Confidentiality
    - basic bluetooth not very secure?
  - Integrity
    - bluetooth
  - Availability
    - jamming, out of scope
    - ddos
  - Non-repudiation
    - not secured
    - spamming
- Out of Band / Sidechannels
  - Client device
    - rooted device
    - modified library load path
    - database key
    - leak contacts
    - root of identity
    - SIM jacking
    - Certificate pinning

## Entrypoint

```
p140me/bridgefy/main/BridgefyApp.java
```

m10301a sync contacts: sync_bridgefy_contacts

send_mesh_reach: send received packet id to connected devices

```
BleEntity
    public static final int ENTITY_MESH_REACH = 4;
    public static final int ENTITY_TYPE_BINARY = 2;
    public static final int ENTITY_TYPE_FILE = 5;
    public static final int ENTITY_TYPE_HANDSHAKE = 0;
    public static final int ENTITY_TYPE_MESH = 3;
    public static final int ENTITY_TYPE_MESSAGE = 1;
id (string) | et (int) | len_int message_data | len_int message_uuid

message_data:
BleEntityContent
GSON: 
  pld: map
  id: string

ForwardTransaction
GSON:
  dump: bool, false
  sender: string
  mesh_reach: string
  mesh: []forward_packet

ForwardPacket
GSON:
    public static final int RECEIVER_TYPE_BROADCAST = 1;
    public static final int RECEIVER_TYPE_CONTACT = 0;
  id: string
  payload: map
  enc_payload: int
  sender: string
  receiver: string
  creation: timestamp
  expiration: timestamp
  receiver_type: int
  hops: int
  profile: int
  track: []long

BleHandshake
GSON: 
  rq (int, 0) 
  rp (json)

rp:
// request
    public static final int HS_REQUEST_TYPE_CANCEL = 2;
    public static final int HS_REQUEST_TYPE_GENERAL = 0;
    public static final int HS_REQUEST_TYPE_KEY = 1;
  type: int
  crc: string

// response
    public static final int HS_RESPONSE_TYPE_GENERAL = 0;
    public static final int HS_RESPONSE_TYPE_KEY = 1;
  type: int 
  dt: int
  crckey: long
  v: string // version
  lcv: string // version
  key: string // public key
  uuid: string // str4
```

## Mesh

```
request_handshake

handle_ble_entity
  process_handshake
    // general:
    //   responsetypegeneral
    // key:
    //   responsetypekey
    // cancel:
    //   disconnect
    // // reset?
    general:
      set_user_id
      is_encryption
        get_existing_key
          null or different: request key
          same: set_key
    key:
      set_key
      save_key

    get_public_key or ecryption is false:
      DevideManager.add_device
```

## Messaging

```
BridgefyCore.sendMessage
  core_listener_controller.send_message
    device: core_listener_controller.send_direct_message
    !device: forwarding: forward_controller.forward_to_list
      forward_controller.add_forward_packet_to_list
        forward_controller.send_pack_to_session
          !ble: transaction_manager.send_entity
          ble: BridgefyCore.send_entity
            transaction_manager.send_entity

BridgefyCore.sendBroadcastMessage
  core_listener_controller.send_broadcast_message
    core_listener_controller.send_broadcast_2
      forward_controller.add_forward_packet_to_list
        forward_controller.send_pack_to_session
          !ble: transaction_manager.send_entity
          ble: BridgefyCore.send_entity
            transaction_manager.send_entity

BridgefyCore.sendDirectMessage
  core_listener_controller.send_direct_message
    core_listener_controller.send_direct_2
      BridgefyCore.send_entity
        transaction_manager.send_entity


transaction_manager.send_entity
  !ble: queue_bluetooth.put chunk_generator
    send_in_background
  gatt_server: sessions_chunk.put chunk_generator
    send charachteristic m7861b
  ble: queue_ble.put chunk_generator
    send_ble_entity
```

## Encryption

### CryptoRSA

see [stackoverflow](https://crypto.stackexchange.com/questions/25899/using-ecb-as-rsa-encryption-mode-when-encrypted-messages-are-unique):
ECB is misleading, no chaining is done, works on individual chunks,
split message to 245byte chunks, encrypt individually with public key,
11 byte iv overhead

message.ReceiverId = key in get_key_pairs

## RSA pubkey

```
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApo3jL37+YzSaMCRfClZRUeZHDQ62ur5ivE2dvBdCBZPOqH+RckEDWJquQKAHq23dVQAWWw9RgkMHR7j/dQPnOzg51mQ7uNEUB1wm3cSEVA2epxch8kzf/vwVxeVtUQf86j8fJy4QRgofYUZbTZTezWPe8YcX6n7fXWDXvVFs/pNalk8v7QKtliuL3ZGHNq088kAOAdjFsyW7xYbV7GjM5eHJL440vXWkIjceT4/GTqX091xRTDoBfn4BSHvx7NmN+l1YZ7wyyhoO9VigowqtM/UX82MyzI7LvRwqlvSg2GGgxnvvewmPT/92cZhXUztM+qRCEalTflqEv4bVr3pggwIDAQAB
```

```
master » base64 -d cert | openssl rsa --text -pubin -inform DER
RSA Public-Key: (2048 bit)
Modulus:
    00:a6:8d:e3:2f:7e:fe:63:34:9a:30:24:5f:0a:56:
    51:51:e6:47:0d:0e:b6:ba:be:62:bc:4d:9d:bc:17:
    42:05:93:ce:a8:7f:91:72:41:03:58:9a:ae:40:a0:
    07:ab:6d:dd:55:00:16:5b:0f:51:82:43:07:47:b8:
    ff:75:03:e7:3b:38:39:d6:64:3b:b8:d1:14:07:5c:
    26:dd:c4:84:54:0d:9e:a7:17:21:f2:4c:df:fe:fc:
    15:c5:e5:6d:51:07:fc:ea:3f:1f:27:2e:10:46:0a:
    1f:61:46:5b:4d:94:de:cd:63:de:f1:87:17:ea:7e:
    df:5d:60:d7:bd:51:6c:fe:93:5a:96:4f:2f:ed:02:
    ad:96:2b:8b:dd:91:87:36:ad:3c:f2:40:0e:01:d8:
    c5:b3:25:bb:c5:86:d5:ec:68:cc:e5:e1:c9:2f:8e:
    34:bd:75:a4:22:37:1e:4f:8f:c6:4e:a5:f4:f7:5c:
    51:4c:3a:01:7e:7e:01:48:7b:f1:ec:d9:8d:fa:5d:
    58:67:bc:32:ca:1a:0e:f5:58:a0:a3:0a:ad:33:f5:
    17:f3:63:32:cc:8e:cb:bd:1c:2a:96:f4:a0:d8:61:
    a0:c6:7b:ef:7b:09:8f:4f:ff:76:71:98:57:53:3b:
    4c:fa:a4:42:11:a9:53:7e:5a:84:bf:86:d5:af:7a:
    60:83
Exponent: 65537 (0x10001)
writing RSA key
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApo3jL37+YzSaMCRfClZR
UeZHDQ62ur5ivE2dvBdCBZPOqH+RckEDWJquQKAHq23dVQAWWw9RgkMHR7j/dQPn
Ozg51mQ7uNEUB1wm3cSEVA2epxch8kzf/vwVxeVtUQf86j8fJy4QRgofYUZbTZTe
zWPe8YcX6n7fXWDXvVFs/pNalk8v7QKtliuL3ZGHNq088kAOAdjFsyW7xYbV7GjM
5eHJL440vXWkIjceT4/GTqX091xRTDoBfn4BSHvx7NmN+l1YZ7wyyhoO9Vigowqt
M/UX82MyzI7LvRwqlvSg2GGgxnvvewmPT/92cZhXUztM+qRCEalTflqEv4bVr3pg
gwIDAQAB
-----END PUBLIC KEY-----
```

## Bluetooth

mesh:

- uses TTL (hops)
- ignore forward from self(?)

GATT:

- BLE comm protocol/framework

## Sources

```
resources                   # ui
sources                     # -
  android                   # -
  androidx                  # -
  butterknife               # ui
  com                       # -
    bridgefy                # -
      sdk                   #
        client              # entrypoint, config, core
          registration      # certificates, registration
          BFBle*            # typedefs
          Bridgefy.java     # entrypoint
          BridgefyClient.java # client data
          Device.java       # remote devices accessible by hardware address, send
          DeviceProfile.java # capability detection
          Message.java      # message type, serialization
        framework           # -
          controller        # Bluetooth, BridgefyCore
            BridgeCore.java #
            C1895af.java    # current device?
          entities          # BLE routing
          exceptions        # -
          utils             # sessionid, serialization, multicast
        logging             # -
    fasterxml               # -
    firebase                # -
    github                  # ui
    google                  # -
    j256                    # -
    mikepenz                # ui
    p103a                   # - analytics
    p110b                   # -
    p113c                   # -
    squareup                # -
    twitter                 # -
    viewpagerindicator      # ui
  me                        # -
    bridgefy                # ui
  migration                 # database migration
  net                       # -
    sqlcipher               # encrypted database
  org                       # -
    apache                  # -
    joda                    # -
    msgpack                 # message format
    p153a                   # -
  p000a                     # utility
  p091a                     # utility tls
  p102c                     # utility
  p136d                     # utility
  p140me                    # -
    bridgefy                # -
      backend               # backend comms
      broadcast             # -
      chat                  # -
      cloud                 # -
      contacts              # -
      entities              # typedefs
      image                 # -
      integration           # BT event handlers
      intro                 # -
      main                  # -
      ormlite               # -
      p141a                 # -
      service               # -
        p148e               # broadcast
      settings              # -
      storage               # -
      utils                 # p2p wifi
  twitter4j                 # -
```
