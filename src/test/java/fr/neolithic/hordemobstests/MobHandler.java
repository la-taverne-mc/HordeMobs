package fr.neolithic.hordemobstests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

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
    private HashMap<String, LivingEntity> mobs = new HashMap<String, LivingEntity>();

    private Pattern pLucifer = Pattern.compile("lucifer-[0-9]+");
    private Pattern pAsterios = Pattern.compile("asterios-[0-9]+");
    private Pattern pSeliph = Pattern.compile("seliph-[0-9]+");
    private Pattern pNeith = Pattern.compile("neith-[0-9]+");
    private Pattern pTsuchigumo = Pattern.compile("tsuchigumo-[0-9]+");

    private Integer getKeysMatching(Pattern pattern) {
        Integer keysMatching = 0;

        for (String key : mobs.keySet()) {
            if (pattern.matcher(key).matches()) {
                keysMatching++;
            }
        }

        return keysMatching;
    }

    public void spawnLucifer(World world, int x, int z) {
        spawnLucifer(world, world.getHighestBlockAt(x, z).getLocation());
    }

    public void spawnLucifer(World world, Location loc) {
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
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "data merge entity " + lucifer.getUniqueId().toString() + " {PersistenceRequired:1b}");

        mobs.put("lucifer-" + getKeysMatching(pLucifer).toString(), lucifer);

        Bukkit.broadcastMessage("§4Lucifer §eest apparu dans " + world.getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
    }

    public void spawnAsterios(World world, int x, int z) {
        spawnAsterios(world, world.getHighestBlockAt(x, z).getLocation());
    }

    public void spawnAsterios(World world, Location loc) {
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
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "data merge entity " + asterios.getUniqueId().toString() + " {PersistenceRequired:1b}");

        mobs.put("asterios-" + getKeysMatching(pAsterios).toString(), asterios);

        Bukkit.broadcastMessage("§4Asterios §eest apparu dans " + world.getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
    }

    public void spawnSeliph(World world, int x, int z) {
        spawnSeliph(world, world.getHighestBlockAt(x, z).getLocation());
    }

    public void spawnSeliph(World world, Location loc) {
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
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "data merge entity " + seliph.getUniqueId().toString() + " {PersistenceRequired:1b}");

        mobs.put("seliph-" + getKeysMatching(pSeliph).toString(), seliph);

        Bukkit.broadcastMessage("§4Seliph §eest apparu dans " + world.getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
    }

    public void spawnNeith(World world, int x, int z) {
        spawnNeith(world, world.getHighestBlockAt(x, z).getLocation());
    }

    public void spawnNeith(World world, Location loc) {
        Pillager neith = (Pillager) world.spawnEntity(loc, EntityType.PILLAGER);
        neith.setCustomName("§4Lucifer");
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
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "data merge entity " + neith.getUniqueId().toString() + " {PersistenceRequired:1b}");

        mobs.put("neith-" + getKeysMatching(pNeith).toString(), neith);

        Bukkit.broadcastMessage("§4Neith §eest apparu dans " + world.getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
    }

    public void spawnTsuchigumo(World world, int x, int z) {
        spawnTsuchigumo(world, world.getHighestBlockAt(x, z).getLocation());
    }

    public void spawnTsuchigumo(World world, Location loc) {
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
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "data merge entity " + tsuchigumo.getUniqueId().toString() + " {PersistenceRequired:1b}");

        mobs.put("tsuchigumo-" + getKeysMatching(pTsuchigumo).toString(), tsuchigumo);

        Bukkit.broadcastMessage("§4Tsuchigumo §eest apparu dans " + world.getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
    }
}