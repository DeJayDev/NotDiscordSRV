/*
 * Copyright (c) 2021 Dj Isaac
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.dejay.notdiscordsrv.config;

import dev.dejay.notdiscordsrv.NotDiscordSRV;
import dev.dejay.reactor.config.type.JsonConfig;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotDiscordConfig extends JsonConfig {

    private static NotDiscordConfig DEFAULT_CONFIG = new NotDiscordConfig();

    private String token;
    private Map<Integer, ArrayList<Integer>> serverChannels;

    public NotDiscordConfig() {
        super(NotDiscordConfig.class);

        this.token = "";
        this.serverChannels = new HashMap<>();
    }

    @Override
    public Path getPath() {
        return NotDiscordSRV.get().getPath().resolve("config.json");
    }

    @Override
    public NotDiscordConfig getDefaultConfig() {
        return DEFAULT_CONFIG;
    }

}
