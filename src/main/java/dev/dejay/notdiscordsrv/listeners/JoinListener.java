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

package dev.dejay.notdiscordsrv.listeners;

import dev.dejay.reactor.listeners.BaseListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinListener extends BaseListener {

    public JoinListener(JavaPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onChatEvent(PlayerJoinEvent event) {
        getPlugin().getServer().broadcastMessage(event.getPlayer().getName());
    }

}
