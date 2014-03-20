package uk.co.reosh.FlingPads;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener {

	public static int boostStrength = 5;

	@EventHandler(priority = EventPriority.NORMAL)
	public void onInteract(PlayerInteractEvent event) {
		final Block b = event.getClickedBlock();

		if (event.getAction().equals(Action.PHYSICAL)) {
			if (isPressurePlate(b.getType())) {
				Player p = event.getPlayer();
				p.setVelocity(p.getVelocity().add(p.getEyeLocation().getDirection().normalize().multiply(boostStrength).setY(0)));
			}
		}
	}
	public static boolean isPressurePlate(Material mat) {
		return (mat == Material.STONE_PLATE) || (mat == Material.WOOD_PLATE);
	}
}
