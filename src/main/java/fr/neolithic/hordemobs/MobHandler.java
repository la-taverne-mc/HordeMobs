package fr.neolithic.hordemobs;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Vindicator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MobHandler {
    // Liste des mobs ajoutés par le plugin
    public enum CustomMob {
        ASTERIOS,
        LUCIFER,
        NEITH,
        SELIPH,
        TSUCHIGUMO;
    }
    
    // Liste des mobs ayant déjà spawn
    public ArrayList<UUID> mobs;

    // Liste des mobs à faire spawn quand leur chunk attribué sera chargé
    public HashMap<Entry<Integer, Integer>, Entry<CustomMob, Location>> mobsToSpawn;
    
    private Random r;

    /**
     * Construit une nouvelle instance de MobHandler
     */
    public MobHandler() {
        mobs = new ArrayList<UUID>();
        mobsToSpawn = new HashMap<Entry<Integer, Integer>, Entry<CustomMob, Location>>();
        r = new Random();
    }

    /**
     * Fait spawn le mob choisi dans le monde sélectionné à des coordonnées
     * aléatoires dans la bordure du monde
     *
     * @param mob         Le mob à faire spawn
     * @param world       Le monde dans lequel le faire spawn
     * @param showMessage Si un message doit être afficher pour dire où le mob
     *                    choisi a spawn
     *
     * @return Retourne true si le mob a spawn, sinon false
     */
    public boolean spawnMob(CustomMob mob, World world, boolean showMessage) {
        int worldSize = Double.valueOf(world.getWorldBorder().getSize()).intValue();
        int x = r.nextInt(worldSize) - worldSize / 2 + world.getWorldBorder().getCenter().getBlockX();
        int z = r.nextInt(worldSize) - worldSize / 2 + world.getWorldBorder().getCenter().getBlockZ();

        return spawnMob(mob, world, x, z, showMessage);
    }

    /**
     * Fait spawn le mob choisi dans le monde sélectionné sur le bloc le plus haut
     * aux coordonnées X / Z
     *
     * @param mob         Le mob à faire spawn
     * @param world       Le monde dans lequel le faire spawn
     * @param x           La coordonnée X à laquelle faire spawn le mob
     * @param z           La coordonnée Z à laquelle faire spawn le mob
     * @param showMessage Si un message doit être affiché pour dire où le mob choisi
     *                    a spawn
     *
     * @return Retourne true si le mob a spawn, sinon false
     */
    public boolean spawnMob(CustomMob mob, World world, int x, int z, boolean showMessage) {
        return spawnMob(mob, world.getHighestBlockAt(x, z).getLocation(), showMessage);
    }

    /**
     * Fait spawn le mob choisi aux coordonnées indiqués
     *
     * @param mob         Le mob à faire spawn
     * @param loc         Les coordonnées auxquelles faire spawn le mob
     * @param showMessage Si un message doit être affiché pour dire où le mob choisi
     *                    a spawn
     *
     * @return Retourne true si le mob a spawn, sinon false
     */
    public boolean spawnMob(CustomMob mob, Location loc, boolean showMessage) {
        switch (mob) {
            case ASTERIOS:
                spawnAsterios(loc);
                if (showMessage) {
                    Bukkit.broadcastMessage("§4Asterios §eest apparu dans " + loc.getWorld().getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
                }
                return true;

            case LUCIFER:
                spawnLucifer(loc);
                if (showMessage) {
                    Bukkit.broadcastMessage("§4Lucifer §eest apparu dans " + loc.getWorld().getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
                }
                return true;
            
            case NEITH:
                spawnNeith(loc);
                if (showMessage) {
                    Bukkit.broadcastMessage("§4Neith §eest apparu dans " + loc.getWorld().getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
                }
                return true;
            
            case SELIPH:
                spawnSeliph(loc);
                if (showMessage) {
                    Bukkit.broadcastMessage("§4Seliph §eest apparu dans " + loc.getWorld().getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
                }
                return true;
            
            case TSUCHIGUMO:
                spawnTsuchigumo(loc);
                if (showMessage) {
                    Bukkit.broadcastMessage("§4Tsuchigumo §eest apparu dans " + loc.getWorld().getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
                }
                return true;
            
            default:
                return false;
        }
    }

    /**
     * Fait apparaitre Lucifer aux coordonnées indiquées
     *
     * @param loc Les coordonnées auxquelles faire spawn Lucifer
     */
    private void spawnLucifer(Location loc) {
        if (loc.getWorld().isChunkLoaded(loc.getBlockX() / 16, loc.getBlockZ() / 16)) {
            Skeleton lucifer = (Skeleton) loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
            lucifer.setCustomName("§4Lucifer");
            lucifer.setCustomNameVisible(true);
            ItemStack[] armor = {
                new ItemStack(Material.DIAMOND_BOOTS),
                new ItemStack(Material.DIAMOND_LEGGINGS),
                new ItemStack(Material.DIAMOND_CHESTPLATE),
                new ItemStack(Material.DIAMOND_HELMET)
            };
            lucifer.getEquipment().setArmorContents(armor);
            lucifer.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD));
            lucifer.getEquipment().setItemInOffHand(new ItemStack(Material.SHIELD));
            lucifer.getEquipment().setBootsDropChance(0);
            lucifer.getEquipment().setLeggingsDropChance(0);
            lucifer.getEquipment().setChestplateDropChance(0);
            lucifer.getEquipment().setHelmetDropChance(0);
            lucifer.getEquipment().setItemInMainHandDropChance(0);
            lucifer.getEquipment().setItemInOffHandDropChance(0);
            lucifer.addPotionEffects(Arrays.asList(
                new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2147483647, 0, false, false),
                new PotionEffect(PotionEffectType.SPEED, 2147483647, 2, false, false),
                new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2147483647, 2, false, false)
            ));
            lucifer.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(500);
            lucifer.setHealth(500);
            lucifer.setRemoveWhenFarAway(false);
            lucifer.addScoreboardTag("HordeMobs");

            mobs.add(lucifer.getUniqueId());
        }
        else {
            mobsToSpawn.put(new SimpleEntry<Integer, Integer>(loc.getBlockX() / 16, loc.getBlockZ() / 16), new SimpleEntry<CustomMob, Location>(CustomMob.LUCIFER, loc));
        }
    }

    /**
     * Fait apparaitre Asterios aux coordonnées indiquées
     *
     * @param loc Les coordonnées auxquelles faire spawn Asterios
     */
    private void spawnAsterios(Location loc) {
        if (loc.getWorld().isChunkLoaded(loc.getBlockX() / 16, loc.getBlockZ() / 16)) {
            Ravager asterios = (Ravager) loc.getWorld().spawnEntity(loc, EntityType.RAVAGER);
            asterios.setCustomName("§4Asterios");
            asterios.setCustomNameVisible(true);
            asterios.addPotionEffects(Arrays.asList(
                new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2147483647, 0, false, false),
                new PotionEffect(PotionEffectType.SPEED, 2147483647, 2, false, false),
                new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2147483647, 3, false, false),
                new PotionEffect(PotionEffectType.WATER_BREATHING, 2147483647, 0, false, false),
                new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 2147483647, 0, false, false)
            ));
            asterios.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(500);
            asterios.setHealth(500);
            asterios.setRemoveWhenFarAway(false);
            asterios.addScoreboardTag("HordeMobs");

            mobs.add(asterios.getUniqueId());
        }
        else {
            mobsToSpawn.put(new SimpleEntry<Integer, Integer>(loc.getBlockX() / 16, loc.getBlockZ() / 16), new SimpleEntry<CustomMob, Location>(CustomMob.ASTERIOS, loc));
        }
    }

    /**
     * Fait apparaitre Seliph aux coordonnées indiquées
     *
     * @param loc Les coordonnées auxquelles faire spawn Seliph
     */
    private void spawnSeliph(Location loc) {
        if (loc.getWorld().isChunkLoaded(loc.getBlockX() / 16, loc.getBlockZ() / 16)) {
            Vindicator seliph = (Vindicator) loc.getWorld().spawnEntity(loc, EntityType.VINDICATOR);
            seliph.setCustomName("§4Seliph");
            seliph.setCustomNameVisible(true);
            ItemStack[] armor = {
                new ItemStack(Material.DIAMOND_BOOTS),
                new ItemStack(Material.DIAMOND_LEGGINGS),
                new ItemStack(Material.DIAMOND_CHESTPLATE),
                new ItemStack(Material.DIAMOND_HELMET)
            };
            seliph.getEquipment().setBootsDropChance(0);
            seliph.getEquipment().setLeggingsDropChance(0);
            seliph.getEquipment().setChestplateDropChance(0);
            seliph.getEquipment().setHelmetDropChance(0);
            seliph.getEquipment().setArmorContents(armor);
            seliph.addPotionEffects(Arrays.asList(
                new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2147483647, 0, false, false),
                new PotionEffect(PotionEffectType.SPEED, 2147483647, 2, false, false),
                new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2147483647, 3, false, false),
                new PotionEffect(PotionEffectType.WATER_BREATHING, 2147483647, 0, false, false),
                new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 2147483647, 0, false, false)
            ));
            seliph.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(500);
            seliph.setHealth(500);
            seliph.setRemoveWhenFarAway(false);
            seliph.addScoreboardTag("HordeMobs");

            mobs.add(seliph.getUniqueId());
        }
        else {
            mobsToSpawn.put(new SimpleEntry<Integer, Integer>(loc.getBlockX() / 16, loc.getBlockZ() / 16), new SimpleEntry<CustomMob, Location>(CustomMob.SELIPH, loc));
        }
    }

    /**
     * Fait apparaitre Neith aux coordonnées indiquées
     *
     * @param loc Les coordonnées auxquelles faire spawn Neith
     */
    private void spawnNeith(Location loc) {
        if (loc.getWorld().isChunkLoaded(loc.getBlockX() / 16, loc.getBlockZ() / 16)) {
            Pillager neith = (Pillager) loc.getWorld().spawnEntity(loc, EntityType.PILLAGER);
            neith.setCustomName("§4Neith");
            neith.setCustomNameVisible(true);
            ItemStack[] armor = {
                new ItemStack(Material.DIAMOND_BOOTS),
                new ItemStack(Material.DIAMOND_LEGGINGS),
                new ItemStack(Material.DIAMOND_CHESTPLATE),
                new ItemStack(Material.DIAMOND_HELMET)
            };
            neith.getEquipment().setArmorContents(armor);
            neith.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD));
            neith.getEquipment().setItemInOffHand(new ItemStack(Material.SHIELD));
            neith.getEquipment().setBootsDropChance(0);
            neith.getEquipment().setLeggingsDropChance(0);
            neith.getEquipment().setChestplateDropChance(0);
            neith.getEquipment().setHelmetDropChance(0);
            neith.getEquipment().setItemInMainHandDropChance(0);
            neith.getEquipment().setItemInOffHandDropChance(0);
            neith.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(500);
            neith.setHealth(500);
            neith.setRemoveWhenFarAway(false);
            neith.addScoreboardTag("HordeMobs");

            mobs.add(neith.getUniqueId());
        }
        else {
            mobsToSpawn.put(new SimpleEntry<Integer, Integer>(loc.getBlockX() / 16, loc.getBlockZ() / 16), new SimpleEntry<CustomMob, Location>(CustomMob.NEITH, loc));
        }
    }

    /**
     * Fait apparaitre Tsuchigumo aux coordonnées indiquées
     *
     * @param loc Les coordonnées auxquelles faire spawn Tsuchigumo
     */
    private void spawnTsuchigumo(Location loc) {
        if (loc.getWorld().isChunkLoaded(loc.getBlockX() / 16, loc.getBlockZ() / 16)) {
            Spider tsuchigumo = (Spider) loc.getWorld().spawnEntity(loc, EntityType.SPIDER);
            tsuchigumo.setCustomName("§4Tsuchigumo");
            tsuchigumo.setCustomNameVisible(true);
            tsuchigumo.addPotionEffects(Arrays.asList(
                new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2147483647, 0, false, false),
                new PotionEffect(PotionEffectType.SPEED, 2147483647, 2, false, false),
                new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2147483647, 3, false, false),
                new PotionEffect(PotionEffectType.WATER_BREATHING, 2147483647, 0, false, false),
                new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 2147483647, 0, false, false),
                new PotionEffect(PotionEffectType.JUMP, 2147483647, 3, false, false),
                new PotionEffect(PotionEffectType.SLOW_FALLING, 2147483647, 0, false, false)
            ));
            tsuchigumo.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(500);
            tsuchigumo.setHealth(500);
            tsuchigumo.setRemoveWhenFarAway(false);
            tsuchigumo.addScoreboardTag("HordeMobs");

            mobs.add(tsuchigumo.getUniqueId());
        }
        else {
            mobsToSpawn.put(new SimpleEntry<Integer, Integer>(loc.getBlockX() / 16, loc.getBlockZ() / 16), new SimpleEntry<CustomMob, Location>(CustomMob.TSUCHIGUMO, loc));
        }
    }
}