package xyz.ctbt.forf.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.ctbt.forf.Forf;

public class LivesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        int lives = Forf.getInstance().getConfig().getInt("lives." + player.getUniqueId(), 10);
        player.sendMessage("You have " + lives + " lives remaining.");
        return true;
    }
}