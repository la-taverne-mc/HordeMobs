package fr.neolithic.hordemobstests;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        MobHandler mobHandler = new MobHandler();
        Commands commandExecutor = new Commands(mobHandler);
        getCommand("hordemobs").setExecutor(commandExecutor);
        
        System.out.println("HordeMobs has been successfully enabled");
    }

    @Override
    public void onDisable() {
        System.out.println("HordeMobs has been successfully disabled");
    }
}
