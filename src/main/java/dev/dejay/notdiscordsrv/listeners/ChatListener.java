package dev.dejay.notdiscordsrv.listeners;

import dev.dejay.reactor.listeners.BaseListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatListener extends BaseListener {

    public ChatListener(JavaPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent event) {
        // Here is where I'd send data to Discord
    }

}
