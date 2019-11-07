package fr.neolithic.hordemobs;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class MobSpawnScheduler extends BukkitRunnable {
    private MobHandler mobHandler;
    private Random r;
    private Integer attempts;

    public MobSpawnScheduler(MobHandler mobHandler) {
        this.mobHandler = mobHandler;
        r = new Random();
        attempts = 0;
    }

    @Override
    public void run() {
        if (r.nextDouble() < 0.20 || attempts >= 6) {
            int mobsToSpawn = r.nextInt(mobHandler.mobList.size());
            int i = 0;
            ArrayList<Integer> spawnedMobs = new ArrayList<Integer>();
            while (i < mobsToSpawn) {
                int mobToSpawn = r.nextInt(mobHandler.mobList.size());
                if (!spawnedMobs.contains(mobToSpawn)) {
                    spawnedMobs.add(mobToSpawn);
                    mobHandler.spawnMob(mobHandler.mobList.get(mobToSpawn), Bukkit.getWorld("world"), true);
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