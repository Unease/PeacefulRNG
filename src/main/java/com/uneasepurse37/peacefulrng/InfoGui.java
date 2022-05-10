package com.uneasepurse37.peacefulrng;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * The InfoGui returns! Pancake says: No it doesn't.
 * 
 * @author ScribbleLP
 *
 */
public class InfoGui extends Gui {
	Minecraft mc = Minecraft.getMinecraft();
 
	@SubscribeEvent
	public void drawStuff(RenderGameOverlayEvent.Post event) {
		if (event.isCancelable() || event.getType() != ElementType.HOTBAR) {
			return;
		}
		ScaledResolution scaled = new ScaledResolution(mc);
		int width = scaled.getScaledWidth();
		int height = scaled.getScaledHeight();
		if (!(mc.gameSettings.showDebugInfo)) {
			if (!PeacefulRNG.isTASMODLoaded) {
				
				if (PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) { // Checks if every food is toggled on
					drawCenteredString(mc.fontRenderer, "PeacefulRNG is on!", width / 2, height -50, 0x336AD1); // Custom blue
				} else if (!PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {// Checks if every food is toggled off
					drawCenteredString(mc.fontRenderer, "PeacefulRNG is off!", width / 2, height -50, 0x55FFFF); // Aqua color
				} 
				
				if (PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) { // Checks if only poisonous potatoes are turned off
					drawCenteredString(mc.fontRenderer, "Only Poisonous Potatoes are off!", width / 2, height -50, 0x55FF55); // Green
				} else if (PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) { // Checks if only rotten flesh is turned off
					drawCenteredString(mc.fontRenderer, "Only Rotten Flesh is off!", width / 2, height -50, 0xFFFF55); // Yellow
				} else if (!PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) { // Checks if only raw chicken is turned off
					drawCenteredString(mc.fontRenderer, "Only Raw Chicken is off!", width / 2, height -50, 0xFF55FF); // Light Purple
				}
				
				if (!PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) { // Checks if both raw chicken and rotten flesh are turned off
					drawCenteredString(mc.fontRenderer, "Only Potatoes are on!", width / 2, height -50, 0x00AA00); // Dark Green
				} else if (!PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) { // Checks if both raw chicken and potatoes are turned off
					drawCenteredString(mc.fontRenderer, "Only Rotten Flesh is on!", width / 2, height -50, 0xFFAA00); // Gold
				} else if (PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) { // Checks if both rotten flesh and poisonous potatoes are turned off
					drawCenteredString(mc.fontRenderer, "Only Raw Chicken is on!", width / 2, height -50, 0xAA00AA); // Dark Purple
				}
				
			}
					
		}
		
	}
}