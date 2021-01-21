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

package dev.dejay.notdiscordsrv;

import dev.dejay.notdiscordsrv.config.NotDiscordConfig;
import dev.dejay.reactor.config.LoadableConfig;
import java.nio.file.Path;
import java.util.HashMap;
import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.intent.Intent;
import org.javacord.api.entity.server.Server;

@Getter
public final class NotDiscordSRV extends JavaPlugin {

    private Path path;
    @Getter(AccessLevel.NONE) private NotDiscordConfig config;
    private DiscordApi bot;

    private HashMap<Server, TextChannel> chatChannels = new HashMap<>();

    @Override
    public void onEnable() {
        path = getDataFolder().toPath();

        config = (NotDiscordConfig) LoadableConfig.getByClass(NotDiscordConfig.class).load();

        if (config.getToken().isEmpty()) {
            getLogger().info("Welcome to NotDiscordSRV!\n"
                + "There is no token, so a bot won't be starting..."
                + "To get started, I've dropped a config in: "
                + path.toString());
            return;
        }
        bot = new DiscordApiBuilder()
            .setIntents(Intent.GUILD_MESSAGES, Intent.DIRECT_MESSAGES)
            .setToken(config.getToken())
            .login().join();

        // Listeners
        //api.addListener();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Deprecated
    public FileConfiguration getConfig() {
        return super.getConfig(); // Fukkit's config should not be used in this project.
    }

    public NotDiscordConfig config() {
        return config;
    }

    public static NotDiscordSRV get() {
        return JavaPlugin.getPlugin(NotDiscordSRV.class);
    }

}
