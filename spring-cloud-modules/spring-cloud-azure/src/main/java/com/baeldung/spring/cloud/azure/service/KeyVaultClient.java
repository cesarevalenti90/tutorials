package com.baeldung.spring.cloud.azure.service;

import java.util.NoSuchElementException;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

public interface KeyVaultClient {

    SecretClient getSecretClient();

    default KeyVaultSecret getSecret(String key) {
        KeyVaultSecret secret;
        try {
            secret = getSecretClient().getSecret(key);
        } catch (Exception ex) {
            throw new NoSuchElementException(String.format("Unable to retrieve %s secret", key), ex);
        }
        return secret;
    }
}
