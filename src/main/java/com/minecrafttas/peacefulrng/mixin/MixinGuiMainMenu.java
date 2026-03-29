package com.minecrafttas.peacefulrng.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.minecrafttas.peacefulrng.PeacefulRNG;

import net.minecraft.client.gui.GuiMainMenu;


@Mixin(GuiMainMenu.class)
public class MixinGuiMainMenu {
	//# 1.11.2
	@Shadow
	private float minceraftRoll;
	//# end
	
	@Shadow
	private String splashText;
	@Inject(at = @At("TAIL"), method = "initGui")
	private void initInject(CallbackInfo ci) {
		//# 1.11.2
		this.minceraftRoll = 0F;
		//# end
		this.splashText = "Without Forge world generation!";
		
		if (PeacefulRNG.isTASMODLoaded) {
			this.splashText = "Loaded with TASMod!";
		}
	}
}

