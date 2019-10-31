package fr.neolithic.hordemobstests;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public class ChunkEventListener implements Listener {
    private MobHandler mobHandler;

    public ChunkEventListener(MobHandler mobHandler) {
        this.mobHandler = mobHandler;
    }

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) {
        Chunk chunk = event.getChunk();
        SimpleEntry<Integer, Integer> chunkCoordinates = new SimpleEntry<Integer, Integer>(chunk.getX(), chunk.getZ());
        if (mobHandler.mobsToSpawn.containsKey(chunkCoordinates)) {
            Entry<String, Location> mobToSpawn = mobHandler.mobsToSpawn.get(chunkCoordinates);
            mobHandler.mobsToSpawn.remove(chunkCoordinates);
            mobHandler.spawnMob(mobToSpawn.getKey(), mobToSpawn.getValue().getWorld(), mobToSpawn.getValue(), false);
        }
    }
}