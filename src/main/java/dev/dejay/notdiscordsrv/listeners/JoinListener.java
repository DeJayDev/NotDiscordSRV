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
