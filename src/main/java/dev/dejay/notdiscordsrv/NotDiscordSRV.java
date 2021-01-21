package dev.dejay.notdiscordsrv;

import dev.dejay.notdiscordsrv.config.NotDiscordConfig;
import dev.dejay.reactor.config.LoadableConfig;
import java.nio.file.Path;
import java.util.HashMap;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.intent.Intent;
import org.javacord.api.entity.server.Server;

@Getter
public final class NotDiscordSRV extends JavaPlugin {

    // Things we do not want to be "settable"
    private Path path;
    private NotDiscordConfig config;
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

    public static NotDiscordSRV get() {
        return JavaPlugin.getPlugin(NotDiscordSRV.class);
    }


}
