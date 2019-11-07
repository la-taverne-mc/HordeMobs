package fr.neolithic.hordemobs;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import fr.neolithic.hordemobs.MobHandler.CustomMob;

public class MobSpawnScheduler extends BukkitRunnable {
    private MobHandler mobHandler;
    private Random r;
    private Integer attempts;

    /**
     * Construit une nouvelle instance de MobSpawnScheduler
     */
    public MobSpawnScheduler(MobHandler mobHandler) {
        this.mobHandler = mobHandler;
        r = new Random();
        attempts = 0;
    }

    /**
     * À chaque execution, il y 20% de chance de faire spawn un ou plusieurs mobs de
     * façon aléatoire, au bout du 6ème sans réussite le pourcentage de chance monte
     * à 100%
     */
    @Override
    public void run() {
        if (r.nextDouble() < 0.20 || attempts >= 5) {
            int mobsToSpawn = r.nextInt(CustomMob.values().length);
            int i = 0;
            ArrayList<Integer> spawnedMobs = new ArrayList<Integer>();
            while (i < mobsToSpawn) {
                int mobToSpawn = r.nextInt(CustomMob.values().length);
                if (!spawnedMobs.contains(mobToSpawn)) {
                    spawnedMobs.add(mobToSpawn);
                    mobHandler.spawnMob(CustomMob.values()[mobToSpawn], Bukkit.getWorld("world"), true);
                    i++;
                }
            }
            attempts = 0;
        }
        else {
            attempts++;
        }
    }
}