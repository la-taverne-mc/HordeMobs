package fr.neolithic.hordemobs;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Vindicator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MobHandler {
    public ArrayList<String> mobList;

    public ArrayList<LivingEntity> mobs;

    public HashMap<Entry<Integer, Integer>, Entry<String, Location>> mobsToSpawn;
    
    private Random r;

    public MobHandler() {
        mobList = new ArrayList<String>();

        mobList.add("asterios");
        mobList.add("lucifer");
        mobList.add("neith");
        mobList.add("seliph");
        mobList.add("tsuchigumo");

        mobs = new ArrayList<LivingEntity>();

        mobsToSpawn = new HashMap<Entry<Integer, Integer>, Entry<String, Location>>();

        r = new Random();
    }

    public boolean spawnMob(String mob, World world, boolean showMessage) {
        int worldSize = Double.valueOf(world.getWorldBorder().getSize()).intValue();
        int x = r.nextInt(worldSize) - worldSize / 2 + world.getWorldBorder().getCenter().getBlockX();
        int z = r.nextInt(worldSize) - worldSize / 2 + world.getWorldBorder().getCenter().getBlockZ();

        return spawnMob(mob, world, x, z, showMessage);
    }

    public boolean spawnMob(String mob, World world, int x, int z, boolean showMessage) {
        return spawnMob(mob, world, world.getHighestBlockAt(x, z).getLocation(), showMessage);
    }

    public boolean spawnMob(String mob, World world, Location loc, boolean showMessage) {
        switch (mob) {
            case "asterios":
                spawnAsterios(world, loc);
                if (showMessage) {
                    Bukkit.broadcastMessage("§4Asterios §eest apparu dans " + world.getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
                }
                return true;

            case "lucifer":
                spawnLucifer(world, loc);
                if (showMessage) {
                    Bukkit.broadcastMessage("§4Lucifer §eest apparu dans " + world.getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
                }
                return true;
            
            case "neith":
                spawnNeith(world, loc);
                if (showMessage) {
                    Bukkit.broadcastMessage("§4Neith §eest apparu dans " + world.getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
                }
                return true;
            
            case "seliph":
                spawnSeliph(world, loc);
                if (showMessage) {
                    Bukkit.broadcastMessage("§4Seliph §eest apparu dans " + world.getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
                }
                return true;
            
            case "tsuchigumo":
                spawnTsuchigumo(world, loc);
                if (showMessage) {
                    Bukkit.broadcastMessage("§4Tsuchigumo §eest apparu dans " + world.getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
                }
                return true;
            
            default:
                return false;
        }
    }

    private void spawnLucifer(World world, Location loc) {
        if (world.isChunkLoaded(loc.getBlockX() / 16, loc.getBlockZ() / 16)) {
            Skeleton lucifer = (Skeleton) world.spawnEntity(loc, EntityType.SKELETON);
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

            mobs.add(lucifer);
        }
        else {
            mobsToSpawn.put(new SimpleEntry<Integer, Integer>(loc.getBlockX() / 16, loc.getBlockZ() / 16), new SimpleEntry<String, Location>("lucifer", loc));
        }
    }

    private void spawnAsterios(World world, Location loc) {
        if (world.isChunkLoaded(loc.getBlockX() / 16, loc.getBlockZ() / 16)) {
            Ravager asterios = (Ravager) world.spawnEntity(loc, EntityType.RAVAGER);
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

            mobs.add(asterios);
        }
        else {
            mobsToSpawn.put(new SimpleEntry<Integer, Integer>(loc.getBlockX() / 16, loc.getBlockZ() / 16), new SimpleEntry<String, Location>("asterios", loc));
        }
    }

    private void spawnSeliph(World world, Location loc) {
        if (world.isChunkLoaded(loc.getBlockX() / 16, loc.getBlockZ() / 16)) {
            Vindicator seliph = (Vindicator) world.spawnEntity(loc, EntityType.VINDICATOR);
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

            mobs.add(seliph);
        }
        else {
            mobsToSpawn.put(new SimpleEntry<Integer, Integer>(loc.getBlockX() / 16, loc.getBlockZ() / 16), new SimpleEntry<String, Location>("seliph", loc));
        }
    }

    private void spawnNeith(World world, Location loc) {
        if (world.isChunkLoaded(loc.getBlockX() / 16, loc.getBlockZ() / 16)) {
            Pillager neith = (Pillager) world.spawnEntity(loc, EntityType.PILLAGER);
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

            mobs.add(neith);
        }
        else {
            mobsToSpawn.put(new SimpleEntry<Integer, Integer>(loc.getBlockX() / 16, loc.getBlockZ() / 16), new SimpleEntry<String, Location>("neith", loc));
        }
    }

    private void spawnTsuchigumo(World world, Location loc) {
        if (world.isChunkLoaded(loc.getBlockX() / 16, loc.getBlockZ() / 16)) {
            Spider tsuchigumo = (Spider) world.spawnEntity(loc, EntityType.SPIDER);
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

            mobs.add(tsuchigumo);
        }
        else {
            mobsToSpawn.put(new SimpleEntry<Integer, Integer>(loc.getBlockX() / 16, loc.getBlockZ() / 16), new SimpleEntry<String, Location>("tsuchigumo", loc));
        }
    }
}