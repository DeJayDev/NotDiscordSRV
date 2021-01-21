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
