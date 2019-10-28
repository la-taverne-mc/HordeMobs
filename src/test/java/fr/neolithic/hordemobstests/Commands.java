package fr.neolithic.hordemobstests;

import java.util.List;
import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import fr.neolithic.hordemobstests.Main;

public class Commands implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("hordemobs") && sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(Main.getKeysMatching(Main.pLucifer).toString());
            }
            else if (args[0].equalsIgnoreCase("lucifer")) {
                player.sendMessage("lucifer yay");
                Main.spawnLucifer(player.getWorld(), player.getLocation());
            }
            else {
                player.sendMessage(args[0]);
                Random r = new Random();
                Main.mobs.put("lucifer-" + r.nextInt(100), null);
            }

            return true;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        return null;
    }
}