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

package com.nike.vault.client.model;

/**
 * Represents a health response from Vault
 */
public class VaultHealthResponse {

    private boolean initialized;

    private boolean sealed;

    private boolean standby;

    public boolean isInitialized() {
        return initialized;
    }

    public VaultHealthResponse setInitialized(boolean initialized) {
        this.initialized = initialized;
        return this;
    }

    public boolean isSealed() {
        return sealed;
    }

    public VaultHealthResponse setSealed(boolean sealed) {
        this.sealed = sealed;
        return this;
    }

    public boolean isStandby() {
        return standby;
    }

    public VaultHealthResponse setStandby(boolean standby) {
        this.standby = standby;
        return this;
    }
}