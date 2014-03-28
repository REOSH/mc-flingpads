/* MC-FlingPads
 * Copyright (C) 2013 - 2014 REOSH Group and contributors

 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package uk.co.reosh.FlingPads;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener {
	private int boostStrength;

    public InteractEvent(int boostStrength) {
        this.boostStrength = boostStrength;
    }

	@EventHandler(priority = EventPriority.NORMAL)
	public void onInteract(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.PHYSICAL) && this.isPressurePlate(event.getClickedBlock().getType())) {
			event.getPlayer().setVelocity(event.getPlayer().getVelocity().add(event.getPlayer().getEyeLocation().getDirection().normalize().multiply(this.boostStrength).setY(0)));
		}
	}

	private boolean isPressurePlate(Material mat) {
		return (mat == Material.STONE_PLATE || mat == Material.WOOD_PLATE);
	}
}
