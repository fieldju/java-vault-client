/*
 * Copyright (c) 2016 Nike, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nike.vault.client;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * Tests the lookupVaultUrl methods on VaultClient
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DefaultVaultUrlResolver.class})
public class DefaultVaultUrlResolverTest {

    private DefaultVaultUrlResolver subject;

    @Before
    public void setup() {
        subject = new DefaultVaultUrlResolver();
    }

    @Test
    public void lookupVaultUrl_returns_url_if_env_variable_is_set() {
        final String url = "http://localhost:8080";
        mockStatic(System.class);
        when(System.getenv(DefaultVaultUrlResolver.VAULT_ADDR_ENV_PROPERTY)).thenReturn(url);

        assertThat(subject.resolve()).isEqualTo(url);
    }

    @Test
    public void lookupVaultUrl_returns_url_if_sys_property_is_set() {
        final String url = "http://localhost:8080";
        mockStatic(System.class);
        when(System.getProperty(DefaultVaultUrlResolver.VAULT_ADDR_SYS_PROPERTY)).thenReturn(url);

        assertThat(subject.resolve()).isEqualTo(url);
    }

    @Test(expected = VaultClientException.class)
    public void lookupVaultUrl_throws_error_if_env_and_sys_not_set() {
        mockStatic(System.class);
        when(System.getenv(DefaultVaultUrlResolver.VAULT_ADDR_ENV_PROPERTY)).thenReturn(null);
        when(System.getProperty(DefaultVaultUrlResolver.VAULT_ADDR_SYS_PROPERTY)).thenReturn(null);
        subject.resolve();
    }
}
