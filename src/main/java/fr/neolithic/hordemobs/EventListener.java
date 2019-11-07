package fr.neolithic.hordemobs;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.world.ChunkLoadEvent;

import fr.neolithic.hordemobs.MobHandler.CustomMob;

public class EventListener implements Listener {
    private MobHandler mobHandler;

    /**
     * Construit une nouvelle instance de EventListener
     */
    public EventListener(MobHandler mobHandler) {
        this.mobHandler = mobHandler;
    }

    /**
     * Au chargement du chunk, si il y a un mob à faire spawn dans ce chunk,
     * le faire spawn aux coordonnées qui lui ont été attribuées
     */
    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) {
        Chunk chunk = event.getChunk();

        for (Entity entity : chunk.getEntities()) {
            if (entity.getScoreboardTags().contains("HordeMobs") && !mobHandler.mobs.contains(entity.getUniqueId())) {
                entity.remove();
            }
        }

        SimpleEntry<Integer, Integer> chunkCoordinates = new SimpleEntry<Integer, Integer>(chunk.getX(), chunk.getZ());
        if (mobHandler.mobsToSpawn.containsKey(chunkCoordinates)) {
            Entry<CustomMob, Location> mobToSpawn = mobHandler.mobsToSpawn.get(chunkCoordinates);
            mobHandler.mobsToSpawn.remove(chunkCoordinates);
            mobHandler.spawnMob(mobToSpawn.getKey(), mobToSpawn.getValue(), false);
        }
    }

    /**
     * À la mort d'un mob, si ce dernier à été spawn par ce plugin, afficher le message correspondant 
     */
    @EventHandler
    public void onMobDeath(EntityDeathEvent event) {
        if (mobHandler.mobs.contains(event.getEntity().getUniqueId())) {
            switch (event.getEntity().getCustomName()) {
                case "§4Asterios":
                    Bukkit.broadcastMessage("§4Asterios §eest reparti dans son labyrinthe !");
                    break;

                case "§4Lucifer":
                    Bukkit.broadcastMessage("§4Lucifer §eest reparti en enfer !");
                    break;

                case "§4Neith":
                    Bukkit.broadcastMessage("§4Neith §eest repartie dans sa pyramide !");
                    break;

                case "§4Seliph":
                    Bukkit.broadcastMessage("§4Lucifer §eest reparti dans son royaume !");
                    break;

                case "§4Tsuchigumo":
                    Bukkit.broadcastMessage("§4Lucifer §eest reparti dans son trou !");
                    break;

                default:
                    break;
            }
            mobHandler.mobs.remove(event.getEntity().getUniqueId());
            event.getDrops().clear();
        }
    }
}