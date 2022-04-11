package us.uneasepurse37.peacefulrng;

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
			if(!PeacefulRNG.isTASMODLoaded) {
				drawCenteredString(Minecraft.getMinecraft().fontRenderer, "PeacefulRNG is loaded!", width / 2, height -50, 0x336AD1);
			}
					
		}
		
	}
}