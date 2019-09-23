package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;

@Beta
public final class DataStoreCredentialRefreshListener implements CredentialRefreshListener {
    private final DataStore<StoredCredential> credentialDataStore;
    private final String userId;

    public DataStoreCredentialRefreshListener(String str, DataStoreFactory dataStoreFactory) throws IOException {
        this(str, StoredCredential.getDefaultDataStore(dataStoreFactory));
    }

    public DataStoreCredentialRefreshListener(String str, DataStore<StoredCredential> dataStore) {
        this.userId = (String) Preconditions.checkNotNull(str);
        this.credentialDataStore = (DataStore) Preconditions.checkNotNull(dataStore);
    }

    public void onTokenResponse(Credential credential, TokenResponse tokenResponse) throws IOException {
        makePersistent(credential);
    }

    public void onTokenErrorResponse(Credential credential, TokenErrorResponse tokenErrorResponse) throws IOException {
        makePersistent(credential);
    }

    public DataStore<StoredCredential> getCredentialDataStore() {
        return this.credentialDataStore;
    }

    public void makePersistent(Credential credential) throws IOException {
        this.credentialDataStore.set(this.userId, new StoredCredential(credential));
    }
}
