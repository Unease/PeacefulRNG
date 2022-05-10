package com.uneasepurse37.peacefulrng.mixin;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.uneasepurse37.peacefulrng.PeacefulRNG;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

@Mixin(ItemFood.class) // Tells Mixin which class to target
public class MixinFood extends Item { //Extends Item to access the food

	@Shadow
	private float potionEffectProbability;

	@Redirect(method = "onFoodEaten", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemFood;potionEffectProbability:F", opcode = Opcodes.GETFIELD))
	private float getFieldValue(ItemFood food) {
		String name = this.getTranslationKey();
		if (name.equals("item.chickenRaw")) {
			if (PeacefulRNG.toggledchicken == true) {
				return 0F;
			}
		} else if (name.equals("item.rottenFlesh")) {
			if (PeacefulRNG.toggledflesh == true) { 
				return 0F;
			}
		} else if (name.equals("item.potatoPoisonous")) {
			if(PeacefulRNG.toggledpotato == true) {
				return 0F;
			}
			
		} 		
		return potionEffectProbability;

	}
}