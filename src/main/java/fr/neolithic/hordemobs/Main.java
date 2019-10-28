package fr.neolithic.hordemobs;

import java.util.HashMap;

import org.bukkit.entity.Mob;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static HashMap<String, Mob> mobs = new HashMap<String, Mob>();

    @Override
    public void onEnable() {

        Commands commandExecutor = new Commands();
        getCommand("hordemobs").setExecutor(commandExecutor);
        
        System.out.println("HordeMobs has been successfully enabled");
    }

    @Override
    public void onDisable() {
        System.out.println("HordeMobs has been successfully disabled");
    }
}
