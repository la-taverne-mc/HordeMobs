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
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin {
    public static HashMap<String, LivingEntity> mobs = new HashMap<String, LivingEntity>();

    public static Pattern pLucifer = Pattern.compile("lucifer-[0-9]+");
    public static Pattern pAsterios = Pattern.compile("asterios-[0-9]+");
    public static Pattern pTsuchigumo = Pattern.compile("tsuchigumo-[0-9]+");
    public static Pattern pSeliph = Pattern.compile("seliph-[0-9]+");
    public static Pattern pNeith = Pattern.compile("neith-[0-9]+");

    @Override
    public void onEnable() {
        Commands commandExecutor = new Commands();
        getCommand("hordemobs").setExecutor(commandExecutor);
        
        System.out.println("HordeMobs has been successfully enabled");
    }

    @Override
    public void onDisable() {
        System.out.println("HordeMobs has been successfully disabled");
    }

    public static Integer getKeysMatching(Pattern pattern) {
        Integer keysMatching = 0;

        for (String key : mobs.keySet()) {
            if (pattern.matcher(key).matches()) {
                keysMatching++;
            }
        }

        return keysMatching;
    }

    public static void spawnLucifer(World world, Location loc) {
        Skeleton lucifer = (Skeleton) world.spawnEntity(loc, EntityType.SKELETON);
        lucifer.setCustomName("§4Lucifer");
        lucifer.setCustomNameVisible(true);
        ItemStack[] armor = {
            new ItemStack(Material.DIAMOND_BOOTS),
            new ItemStack(Material.DIAMOND_LEGGINGS),
            new ItemStack(Material.DIAMOND_CHESTPLATE),
            new ItemStack(Material.DIAMOND_HELMET)};
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
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2147483647, 2, false, false),
            new PotionEffect(PotionEffectType.SLOW_FALLING, 2147483647, 0, false, false)));
        lucifer.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(500);
        lucifer.setHealth(500);
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "data merge entity " + lucifer.getUniqueId().toString() + " {PersistenceRequired:1b}");

        mobs.put("lucifer-" + getKeysMatching(pLucifer).toString(), lucifer);

        Bukkit.broadcastMessage("§4Lucifer §eest apparu dans " + world.getName() + " en x: " + loc.getBlockX() + " z: " + loc.getBlockZ());
    }
}
