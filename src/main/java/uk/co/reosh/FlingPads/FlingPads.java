package uk.co.reosh.FlingPads;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FlingPads extends JavaPlugin {

	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new InteractEvent(), this);
		
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		
		 InteractEvent.boostStrength = this.getConfig().getInt("boost-strength");
	}
}
