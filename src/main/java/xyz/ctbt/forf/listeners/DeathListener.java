package xyz.ctbt.forf.listeners;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import xyz.ctbt.forf.Forf;

import java.util.UUID;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        UUID uuid = player.getUniqueId();
        String path = "lives." + uuid.toString();

        int lives = Forf.getInstance().getConfig().getInt(path, 10); // default to 10

        lives -= 1;

        if (lives <= 0) {
            // Ban the player
            Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), "You have run out of lives.", null, null);
            player.kickPlayer("You have run out of lives and are now banned.");
        } else {
            player.sendMessage("You have " + lives + " lives remaining.");
        }

        // Save updated life count
        Forf.getInstance().getConfig().set(path, lives);
        Forf.getInstance().saveConfig();
    }
}