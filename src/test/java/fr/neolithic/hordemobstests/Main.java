package fr.neolithic.hordemobstests;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        MobHandler mobHandler = new MobHandler();
        
        getCommand("hordemobs").setExecutor(new Commands(mobHandler));

        getServer().getPluginManager().registerEvents(new EventListener(mobHandler), this);

        // Crée une instance de MobSpawnScheduler et l'exécute toutes les 30min
        MobSpawnScheduler mobSpawnScheduler = new MobSpawnScheduler(mobHandler);
        mobSpawnScheduler.runTaskTimer(this, 36000, 36000);
        
        System.out.println("HordeMobs has been successfully enabled");
    }

    @Override
    public void onDisable() {
        System.out.println("HordeMobs has been successfully disabled");
    }
}
