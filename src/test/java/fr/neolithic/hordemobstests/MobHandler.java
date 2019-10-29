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
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Skeleton;
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
}