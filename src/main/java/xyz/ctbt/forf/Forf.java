package xyz.ctbt.forf;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.ctbt.forf.commands.LivesCommand;
import xyz.ctbt.forf.listeners.DeathListener;

public final class Forf extends JavaPlugin {

    private static Forf instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getCommand("lives").setExecutor(new LivesCommand());

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Forf getInstance() {
        return instance;
    }
}
