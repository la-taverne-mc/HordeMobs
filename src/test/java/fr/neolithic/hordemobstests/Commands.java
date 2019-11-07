package fr.neolithic.hordemobstests;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.Lists;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import fr.neolithic.hordemobstests.MobHandler.CustomMob;

public class Commands implements TabExecutor {
    private MobHandler mobHandler;

    private List<String> mobList;
    private List<String> functionList;

    /**
     * Construit une instance de Commands
     */
    public Commands(MobHandler mobHandler) {
        this.mobHandler = mobHandler;

        mobList = Lists.newArrayList();
        for (CustomMob cm : CustomMob.values()) {
            mobList.add(cm.name().toLowerCase());
        }

        functionList = Lists.newArrayList();
        functionList.add("help");
        functionList.add("killall");
        functionList.add("list");
        functionList.add("spawn");
        functionList.add("spawnhere");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("hordemobs") && sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                switch (args[0].toLowerCase()) {
                    // Affiche le message d'aide
                    case "help":
                        showHelp(player);
                        return true;

                    // Affiche la liste les mobs ajouté par ce plugin
                    case "list":
                        String msg = "§3Summonable mobs added by this plugin : ";
                        for (String mob : mobList) {
                            msg += "§9" + mob + "§3, ";
                        }
                        msg = msg.substring(0, msg.length() - 4);
                        player.sendMessage(msg);
                        return true;

                    // Supprime tout les mobs ayant spawn et vide la liste des mobs à faire spawn
                    case "killall":
                        int killCount = 0;
                        for (UUID mob : mobHandler.mobs) {
                            Bukkit.getEntity(mob).remove();
                            killCount++;
                        }
                        mobHandler.mobs.clear();
                        for (int i = 0; i < mobHandler.mobsToSpawn.size(); i++) {
                            killCount++;
                        }
                        mobHandler.mobsToSpawn.clear();
                        player.sendMessage("§9" + String.valueOf(killCount) + " §3mobs where killed");
                        return true;
                    
                    // Affiche un message d'erreur
                    case "spawn":
                    case "spawnhere":
                        player.sendMessage("§cThe mob argument is missing");
                        player.sendMessage("§cUsage : /hordemobs " + args[0] + " <mob>");
                        return true;
                
                    default:
                        showHelp(player);
                        return true;
                }
            }

            if (args.length == 2) {
                switch (args[0].toLowerCase()) {
                    // Affiche un message d'erreur
                    case "help":
                    case "list":
                    case "killall":
                        player.sendMessage("§cToo much arguments for \"/hordemobs " + args[0] + "\"");
                        return true;
                        
                    // Verifie si le mob existe et tente de le faire spawn le mob aux coordonnées du joueur
                    case "spawnhere":
                        if (!mobList.contains(args[1].toLowerCase())) {
                            player.sendMessage("This mob doesn't exist");
                            String msg = "§3Here is a list of existing mobs added by this plugin : ";
                            for (String mob : mobList) {
                                msg += "§9" + mob + "§3, ";
                            }
                            msg = msg.substring(0, msg.length() - 4);
                            player.sendMessage(msg);
                            return true;
                        }
                        else {
                            mobHandler.spawnMob(CustomMob.valueOf(args[1].toUpperCase()), player.getLocation(), true);
                            return true;
                        }
                    
                    // Verifie si le mob existe et tente de le faire spawn aléatoirement dans le monde
                    case "spawn":
                        if (!mobList.contains(args[1].toLowerCase()) && !args[1].equalsIgnoreCase("all")) {
                            player.sendMessage("§cThis mob doesn't exist");
                            String msg = "§3Here is a list of existing mobs added by this plugin : ";
                            for (String mob : mobList) {
                                msg += "§9" + mob + "§3, ";
                            }
                            msg = msg.substring(0, msg.length() - 4);
                            player.sendMessage(msg);
                            return true;
                        }
                        else if (player.getWorld().getEnvironment() != Environment.NORMAL) {
                            player.sendMessage("§cYou need to be in a normal world, not in a dimension, for this command to work");
                            return true;
                        }
                        else if (args[1].equalsIgnoreCase("all")) {
                            World world = player.getWorld();
                            for (CustomMob mob : CustomMob.values()) {
                                mobHandler.spawnMob(mob, world, true);
                            }
                            return true;
                        }
                        else {
                            mobHandler.spawnMob(CustomMob.valueOf(args[1].toUpperCase()), player.getWorld(), true);
                            return true;
                        }
                    
                    default:
                        showHelp(player);
                        return true;
                }
            }

            showHelp(player);
            return true;
        }

        return false;
    }

    /**
     * Génère la liste des arguments possible grâce à la liste des fonctions functionList et à la liste des mobs mobList
     * 
     * @return La liste des arguments possible ou null si aucun n'a été trouvé
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("hordemobs")) {
            List<String> correspondingArgs = Lists.newArrayList();

            switch (args.length) {
                case 1:
                    for (String argument : functionList) {
                        if (argument.toLowerCase().startsWith(args[0].toLowerCase())) {
                            correspondingArgs.add(argument);
                        }
                    }

                    return correspondingArgs;
                
                case 2:
                    if (args[0].equalsIgnoreCase("spawn") || args[0].equalsIgnoreCase("spawnhere")) {
                        for (String mob : mobList) {
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

    /**
     * Envoie le message d'aide l'exécutant de la commande
     *
     * @param sender L'exécutant à qui envoyer le message d'aide 
     */
    private void showHelp(CommandSender sender) {
        sender.sendMessage("§e=====================§6Help§e=====================");
        sender.sendMessage("§9/hordemobs help : §3shows all commands");
        sender.sendMessage("§9/hordemobs list : §3displays a list of summonable mobs added by this plugin");
        sender.sendMessage("§9/hordemobs spawn <mob> : §3spawns the seslected mob randomly in the world");
        sender.sendMessage("§9/hordemobs spawn all : §3summons a horde of custom mobs randomly in the world");
        sender.sendMessage("§9/hordemobs spawnhere <mob> : §3spawns the selected mob where you are");
        sender.sendMessage("§9/hordemobs killall : §3kills all of the custom mobs");
        sender.sendMessage("§e=====================§6Help§e=====================");
    }
}