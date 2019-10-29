package fr.neolithic.hordemobstests;

import java.util.List;

import com.google.common.collect.Lists;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

public class Commands implements TabExecutor {
    private MobHandler mobHandler;

    private List<String> mobsList = Lists.newArrayList();
    private List<String> argumentsList = Lists.newArrayList();

    public Commands(MobHandler mobHandler) {
        this.mobHandler = mobHandler;

        mobsList.add("asterios");
        mobsList.add("lucifer");
        mobsList.add("neith");
        mobsList.add("seliph");
        mobsList.add("tsuchigumo");

        argumentsList.add("help");
        argumentsList.add("killall");
        argumentsList.add("list");
        argumentsList.add("spawn");
        argumentsList.add("spawnhere");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("hordemobs") && sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                showHelp(player);
            }

            return true;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("hordemobs")) {
            List<String> correspondingArgs = Lists.newArrayList();

            switch (args.length) {
                case 1:
                    for (String argument : argumentsList) {
                        if (argument.toLowerCase().startsWith(args[0].toLowerCase())) {
                            correspondingArgs.add(argument);
                        }
                    }

                    return correspondingArgs;
                
                case 2:
                    if (args[0].equalsIgnoreCase("spawn") || args[0].equalsIgnoreCase("spawnhere")) {
                        for (String mob : mobsList) {
                            if (mob.toLowerCase().startsWith(args[1].toLowerCase())) {
                                correspondingArgs.add(mob);
                            }
                        }

                        if (args[0].equalsIgnoreCase("spawn")) {
                            correspondingArgs.add("all");
                        }

                        return correspondingArgs;
                    }

                    return null;

                default:
                    return null;
            }
        }

        return null;
    }

    private void showHelp(CommandSender sender) {
        sender.sendMessage("§e=====================§6Help§e=====================");
        sender.sendMessage("§9/hordemobs help : §3shows all commands");
        sender.sendMessage("§9/hordemobs list : §3displays a list of summonable mobs added by this plugin");
        sender.sendMessage("§9/hordemobs spawn <mob> : §3spawns the selected mob randomly in the world");
        sender.sendMessage("§9/hordemobs spawn all : §3summons a horde of custom mobs randomly in the world");
        sender.sendMessage("§9/hordemobs spawnhere <mob> : §3spawns the selected mob where you are");
        sender.sendMessage("§9/hordemobs killall : §3kills all of the custom mobs");
        sender.sendMessage("§e=====================§6Help§e=====================");
    }
}