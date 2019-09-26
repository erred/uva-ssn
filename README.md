# Project Notes

decompiled from v2.1.25

JADX decompiler

## Bluetooth

mesh:

- uses TTL (hops)
- ignore forward from self(?)

GATT:

- BLE comm protocol/framework

## Encrytion

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
