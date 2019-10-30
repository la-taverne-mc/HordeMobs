package fr.neolithic.hordemobs;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        MobHandler mobHandler = new MobHandler();
        getCommand("hordemobs").setExecutor(new Commands(mobHandler));

        getServer().getPluginManager().registerEvents(new ChunkEventListener(mobHandler), this);
        
        System.out.println("HordeMobs has been successfully enabled");
    }

    @Override
    public void onDisable() {
        System.out.println("HordeMobs has been successfully disabled");
    }
}
