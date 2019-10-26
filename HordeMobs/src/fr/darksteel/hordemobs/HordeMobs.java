package fr.darksteel.hordemobs;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Vindicator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;





public class HordeMobs extends JavaPlugin {
	
	private Skeleton lucifer; 
	private Ravager asterios;
	private Spider tsuchigumo;
	private Vindicator seliph;
	private Pillager neith;
	


	@Override
	public void onEnable() {
		System.out.println("HordeMobs s'allume!");
		
		
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				
				Random g = new Random();
				double x = -30000 + g.nextInt(60000);
				double y = 60 + g.nextInt(10);
				double z = -30000 + g.nextInt(60000);
				
				
				 lucifer = (Skeleton)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), x, y, z), EntityType.SKELETON);
				 lucifer.setCustomName("§4Lucifer");
				 lucifer.setCustomNameVisible(true);
				 lucifer.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
				 lucifer.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
				 lucifer.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
				 lucifer.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));		
				 lucifer.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD, 1));
				 lucifer.getEquipment().setItemInOffHand(new ItemStack(Material.SHIELD, 1));
				 lucifer.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
				 lucifer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
				 lucifer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 3));
				 lucifer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
				 lucifer.setHealth(500);
		        
		        Bukkit.broadcastMessage("§4Lucifer §eest apparu en x: "+ x +" y:"+ y +" z:"+ z);
		        
		        Random b = new Random();
				double w = -30000 + b.nextInt(60000);
				double c = 90 + b.nextInt(10);
				double n = -30000 + b.nextInt(60000);
				
				 asterios = (Ravager)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), w, c, n), EntityType.RAVAGER);
				 asterios.setCustomName("§4Asterios");
				 asterios.setCustomNameVisible(true);
				 asterios.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
				 asterios.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
				 asterios.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
				 asterios.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
				 asterios.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
				 asterios.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
				 asterios.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 5));
				 asterios.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 3));
				 asterios.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 9));
				 asterios.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 999999, 9));
				 asterios.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
				 asterios.setHealth(500);
		        
		        Bukkit.broadcastMessage("§4Asterios §eest apparu en x: "+ w +" y:"+ c +" z:"+ n);
		        
		        Random h = new Random();
				double k = -30000 + h.nextInt(60000);
				double j = 90 + h.nextInt(10);
				double i = -30000 + h.nextInt(60000);
				
				
				 seliph = (Vindicator)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), k, j, i), EntityType.VINDICATOR);
		         seliph.setCustomName("§4Seliph");
		         seliph.setCustomNameVisible(true);
		         seliph.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
		         seliph.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
		         seliph.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
		         seliph.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
		         seliph.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
		         seliph.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
		         seliph.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 4));
		         seliph.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 3));
		         seliph.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 9));
		         seliph.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 999999, 9));
		         seliph.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
		         seliph.setHealth(500);
		        
		        Bukkit.broadcastMessage("§4Seliph §eest apparu en x: "+ k +" y:"+ j +" z:"+ i);
		        
		        Random a = new Random();
				double q = -30000 + a.nextInt(60000);
				double f = 90 + a.nextInt(10);
				double d = -30000 + a.nextInt(60000);
				
				
				 neith = (Pillager)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), q, f, d), EntityType.PILLAGER);
				 neith.setCustomName("§4Neith");
				 neith.setCustomNameVisible(true);
				 neith.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
				 neith.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
				 neith.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
				 neith.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
				 neith.getEquipment().setItemInMainHand(new ItemStack(Material.CROSSBOW, 1));
				 neith.getEquipment().setItemInOffHand(new ItemStack(Material.SHIELD, 1));
				 neith.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
				 neith.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
				 neith.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 2));
		         neith.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 3));
		         neith.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 9));
		         neith.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 999999, 9));
		         neith.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
		         neith.setHealth(500);
		         
		        Bukkit.broadcastMessage("§4Neith §eest apparu en x: "+ q +" y:"+ f +" z:"+ d);
		         
		        Random r = new Random();
				double o = -30000 + r.nextInt(60000);
				double l = 90 + r.nextInt(10);
			    double m = -30000 + r.nextInt(60000);
				 	
				 	
			     tsuchigumo = (Spider)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), o, l, m), EntityType.SPIDER);
			     tsuchigumo.setCustomName("§4Tsuchigumo");
			     tsuchigumo.setCustomNameVisible(true);
			     tsuchigumo.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
			     tsuchigumo.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
			     tsuchigumo.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
			     tsuchigumo.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));		
			     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
			     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
			     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 4));
			     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 4));
			     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 9));
			     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 999999, 9));
			     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
			     tsuchigumo.setHealth(500);
			        
		        Bukkit.broadcastMessage("§4Tsuchigumo §eest apparu en x: "+ o +" y:"+ l +" z:"+ m);
		        
		        lucifer.getLocation().getChunk().setForceLoaded(true);		        
		        lucifer.getLocation().getChunk().load();
		        
		        tsuchigumo.getLocation().getChunk().setForceLoaded(true);		        
		        tsuchigumo.getLocation().getChunk().load();
		        
		        neith.getLocation().getChunk().setForceLoaded(true);		        
		        neith.getLocation().getChunk().load();
		        
		        asterios.getLocation().getChunk().setForceLoaded(true);		        
		        asterios.getLocation().getChunk().load();
		        
		        seliph.getLocation().getChunk().setForceLoaded(true);		        
		        seliph.getLocation().getChunk().load();
			}
			
			
			
		},216000, 216000);
				
        getCommand("hordemobs").setExecutor(new CommandExecutor() {
			
			@Override
			public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] arg3) {
				
				if(sender instanceof Player) {
					
					Player p = (Player)sender;
					
					if(cmd.getName().equalsIgnoreCase("hordemobs")) {
						
						// /hordemobs
						if(arg3.length == 0) {
							p.sendMessage("§e=====================§4Help§e=====================");
							p.sendMessage("§3/hordemobs help : §8show all commands");
							p.sendMessage("§e=====================§4Help§e=====================");
							
						}
						// /hm help ou /hm spawn ou /hm killall ou /hm <name>
						if(arg3.length == 1) {
							
							if(arg3[0].equalsIgnoreCase("help")) {
								p.sendMessage("§e=====================§4Help 1/2§e=====================");
								p.sendMessage("§3/hordemobs help : §8show all commands");
								p.sendMessage("§3/hordemobs spawn : §8summon a hord of custome mob randomly in the world");
								p.sendMessage("§3/hordemobs killall : §8kill all of custome mob");
								p.sendMessage("§3/hordemobs lucifer : §8summon Lucifer");
								p.sendMessage("§3/hordemobs tsuchigumo : §8summon Tsuchigumo");
								p.sendMessage("§3/hordemobs neith : §8summon Neith");
								p.sendMessage("§e=====================§4Help 1/2§e=====================");
							}
							
							if(arg3[0].equalsIgnoreCase("help2")) {
								p.sendMessage("§e=====================§4Help 2/2§e=====================");
								p.sendMessage("§3/hordemobs seliph : §8summon Seliph");
								p.sendMessage("§3/hordemobs asterios : §8summon Asterios");
								p.sendMessage("§e=====================§4Help 2/2§e=====================");
							}
							
							if(arg3[0].equalsIgnoreCase("lucifer")) {
								
								Random g = new Random();
								double x = -30000 + g.nextInt(60000);
								double y = 90 + g.nextInt(10);
								double z = -30000 + g.nextInt(60000);
								
								
								 lucifer = (Skeleton)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), x, y, z), EntityType.SKELETON);
								 lucifer.setCustomName("§4Lucifer");
								 lucifer.setCustomNameVisible(true);
								 lucifer.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
								 lucifer.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
								 lucifer.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
								 lucifer.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));		
								 lucifer.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD, 1));
								 lucifer.getEquipment().setItemInOffHand(new ItemStack(Material.SHIELD, 1));
								 lucifer.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
								 lucifer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
								 lucifer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 3));
								 lucifer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
								 lucifer.setHealth(500);
						        
						        Bukkit.broadcastMessage("§4Lucifer §eest apparu en x: "+ x +" y:"+ y +" z:"+ z);
						        lucifer.getLocation().getChunk().setForceLoaded(true);		        
						        lucifer.getLocation().getChunk().load();
						         
							}
							
							if(arg3[0].equalsIgnoreCase("tsuchigumo")) {
								
								Random r = new Random();
								double o = -30000 + r.nextInt(60000);
								double l = 90 + r.nextInt(10);
								double m = -30000 + r.nextInt(60000);
								
								
								 tsuchigumo = (Spider)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), o, l, m), EntityType.SPIDER);
							     tsuchigumo.setCustomName("§4Tsuchigumo");
							     tsuchigumo.setCustomNameVisible(true);
							     tsuchigumo.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
							     tsuchigumo.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
							     tsuchigumo.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
							     tsuchigumo.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));		
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 4));
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 4));
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 9));
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 999999, 9));
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
							     tsuchigumo.setHealth(500);
						        
						        Bukkit.broadcastMessage("§4Tsuchigumo §eest apparu en x: "+ o +" y:"+ l +" z:"+ m);
						        tsuchigumo.getLocation().getChunk().setForceLoaded(true);		        
						        tsuchigumo.getLocation().getChunk().load();
								
							}
							
							if(arg3[0].equalsIgnoreCase("neith")) {
								
								Random a = new Random();
								double q = -30000 + a.nextInt(60000);
								double f = 90 + a.nextInt(10);
								double d = -30000 + a.nextInt(60000);
								
								
								 neith = (Pillager)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), q, f, d), EntityType.PILLAGER);
								 neith.setCustomName("§4Neith");
								 neith.setCustomNameVisible(true);
								 neith.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
								 neith.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
								 neith.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
								 neith.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
								 neith.getEquipment().setItemInMainHand(new ItemStack(Material.CROSSBOW, 1));
								 neith.getEquipment().setItemInOffHand(new ItemStack(Material.SHIELD, 1));
								 neith.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
								 neith.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
								 neith.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 9));
						         neith.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 3));
						         neith.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 9));
						         neith.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 999999, 9));
						         neith.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
						         neith.setHealth(500);
						        
						        Bukkit.broadcastMessage("§4Neith §eest apparu en x: "+ q +" y:"+ f +" z:"+ d);
						        neith.getLocation().getChunk().setForceLoaded(true);		        
						        neith.getLocation().getChunk().load();
						        
							}
							
							if(arg3[0].equalsIgnoreCase("seliph")) {
								
								Random h = new Random();
								double k = -30000 + h.nextInt(60000);
								double j =  90 + h.nextInt(10);
								double i = -30000 + h.nextInt(60000);
								
								
								 seliph = (Vindicator)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), k, j, i), EntityType.VINDICATOR);
						         seliph.setCustomName("§4Seliph");
						         seliph.setCustomNameVisible(true);
						         seliph.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
						         seliph.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
						         seliph.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
						         seliph.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 4));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 3));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 9));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 999999, 9));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
						         seliph.setHealth(500);
						        
						        Bukkit.broadcastMessage("§4Seliph §eest apparu en x: "+ k +" y:"+ j +" z:"+ i);
						        seliph.getLocation().getChunk().setForceLoaded(true);		        
						        seliph.getLocation().getChunk().load();
								
							}
							
							if(arg3[0].equalsIgnoreCase("asterios")) {
								
								Random b = new Random();
								double w = -30000 + b.nextInt(60000);
								double c = 90 + b.nextInt(10);
								double n = -30000 + b.nextInt(60000);
								
								 asterios = (Ravager)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), w, c, n), EntityType.RAVAGER);
								 asterios.setCustomName("§4Asterios");
								 asterios.setCustomNameVisible(true);
								 asterios.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
								 asterios.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
								 asterios.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
								 asterios.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 5));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 3));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 9));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 999999, 9));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
								 asterios.setHealth(500);
						        
						        Bukkit.broadcastMessage("§4Asterios §eest apparu en x: "+ w +" y:"+ c +" z:"+ n);
						        asterios.getLocation().getChunk().setForceLoaded(true);		        
						        asterios.getLocation().getChunk().load();
								
							}
							
							if(arg3[0].equalsIgnoreCase("spawn")) {
								
								Random g = new Random();
								double x = -30000 + g.nextInt(60000);
								double y = 60 + g.nextInt(10);
								double z = -30000 + g.nextInt(60000);
								
								
								 lucifer = (Skeleton)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), x, y, z), EntityType.SKELETON);
								 lucifer.setCustomName("§4Lucifer");
								 lucifer.setCustomNameVisible(true);
								 lucifer.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
								 lucifer.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
								 lucifer.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
								 lucifer.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));		
								 lucifer.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD, 1));
								 lucifer.getEquipment().setItemInOffHand(new ItemStack(Material.SHIELD, 1));
								 lucifer.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
								 lucifer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
								 lucifer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 3));
								 lucifer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
								 lucifer.setHealth(500);
						        
						        Bukkit.broadcastMessage("§4Lucifer §eest apparu en x: "+ x +" y:"+ y +" z:"+ z);
						        
						        Random b = new Random();
								double w = -30000 + b.nextInt(60000);
								double c = 90 + b.nextInt(10);
								double n = -30000 + b.nextInt(60000);
								
								 asterios = (Ravager)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), w, c, n), EntityType.RAVAGER);
								 asterios.setCustomName("§4Asterios");
								 asterios.setCustomNameVisible(true);
								 asterios.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
								 asterios.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
								 asterios.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
								 asterios.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 5));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 3));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 9));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 999999, 9));
								 asterios.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
								 asterios.setHealth(500);
						        
						        Bukkit.broadcastMessage("§4Asterios §eest apparu en x: "+ w +" y:"+ c +" z:"+ n);
						        
						        Random h = new Random();
								double k = -30000 + h.nextInt(60000);
								double j = 90 + h.nextInt(10);
								double i = -30000 + h.nextInt(60000);
								
								
								 seliph = (Vindicator)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), k, j, i), EntityType.VINDICATOR);
						         seliph.setCustomName("§4Seliph");
						         seliph.setCustomNameVisible(true);
						         seliph.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
						         seliph.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
						         seliph.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
						         seliph.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 4));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 3));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 9));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 999999, 9));
						         seliph.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
						         seliph.setHealth(500);
						        
						        Bukkit.broadcastMessage("§4Seliph §eest apparu en x: "+ k +" y:"+ j +" z:"+ i);
						        
						        Random a = new Random();
								double q = -30000 + a.nextInt(60000);
								double f = 90 + a.nextInt(10);
								double d = -30000 + a.nextInt(60000);
								
								
								 neith = (Pillager)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), q, f, d), EntityType.PILLAGER);
								 neith.setCustomName("§4Neith");
								 neith.setCustomNameVisible(true);
								 neith.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
								 neith.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
								 neith.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
								 neith.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
								 neith.getEquipment().setItemInMainHand(new ItemStack(Material.CROSSBOW, 1));
								 neith.getEquipment().setItemInOffHand(new ItemStack(Material.SHIELD, 1));
								 neith.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
								 neith.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
								 neith.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 2));
						         neith.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 3));
						         neith.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 9));
						         neith.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 999999, 9));
						         neith.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
						         neith.setHealth(500);
						         
						        Bukkit.broadcastMessage("§4Neith §eest apparu en x: "+ q +" y:"+ f +" z:"+ d);
						         
						        Random r = new Random();
								double o = -30000 + r.nextInt(60000);
								double l = 90 + r.nextInt(10);
							    double m = -30000 + r.nextInt(60000);
								 	
								 	
							     tsuchigumo = (Spider)Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), o, l, m), EntityType.SPIDER);
							     tsuchigumo.setCustomName("§4Tsuchigumo");
							     tsuchigumo.setCustomNameVisible(true);
							     tsuchigumo.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
							     tsuchigumo.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
							     tsuchigumo.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
							     tsuchigumo.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));		
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 10));
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3));
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 4));
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 4));
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 9));
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 999999, 9));
							     tsuchigumo.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 20));
							     tsuchigumo.setHealth(500);
						        
							}
							
                            if(arg3[0].equalsIgnoreCase("killall")) {
								
								
								lucifer.remove();
								lucifer.getLocation().getChunk().setForceLoaded(false);
								Bukkit.broadcastMessage("§4Lucifer §eest reparti en enfer!");
								
								tsuchigumo.remove();
								tsuchigumo.getLocation().getChunk().setForceLoaded(false);
								Bukkit.broadcastMessage("§4Tsuchigumo §eest reparti dans son trou!");
								
								seliph.remove();
								seliph.getLocation().getChunk().setForceLoaded(false);
								Bukkit.broadcastMessage("§4Seliph §eest reparti dans son royaume!");
								
								neith.remove();
								neith.getLocation().getChunk().setForceLoaded(false);
								Bukkit.broadcastMessage("§4Neith §eest repartie dans sa pyramine!");
								
								asterios.remove();
								asterios.getLocation().getChunk().setForceLoaded(false);
								Bukkit.broadcastMessage("§4Asterios §eest reparti dans son labyrinthe!");
								
								
								
							}
                            
						}
						
					}
					
				}
				return false;
				
			}
			
		});

	    }
	@Override
	public void onDisable() {
		System.out.println("HordeMobs s'éteint!");
	}

}
