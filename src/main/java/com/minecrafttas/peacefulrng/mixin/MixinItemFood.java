package com.minecrafttas.peacefulrng.mixin;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.minecrafttas.peacefulrng.PeacefulRNG;

import net.minecraft.item.ItemFood;

//# 1.11.2
@Mixin(ItemFood.class)
//# end

public class MixinItemFood {
	//# 1.11.2
	@Shadow
	private float potionEffectProbability;
	//# end

	//# 1.11.2
	@Redirect(method = "onFoodEaten", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemFood;potionEffectProbability:F", opcode = Opcodes.GETFIELD))
	//# end
	private float effectChanceValueRedirect(ItemFood food) {
		//# 1.12.2
//$$		String name = food.getTranslationKey();
		//# 1.11.2
		String name = food.getUnlocalizedName();
		//# end
		String rottenFlesh = "item.rottenFlesh";
		String rawChicken = "item.chickenRaw";
		String potatoPoisonous = "item.potatoPoisonous";
		
		if (PeacefulRNG.isTASMODLoaded) {
			if (name.equalsIgnoreCase(rottenFlesh) || name.equalsIgnoreCase(potatoPoisonous) || name.equalsIgnoreCase(rawChicken)) {
				//# 1.11.2
				potionEffectProbability = 0F;
				return potionEffectProbability;
				//# end
			}
		}
		//# 1.11.2
		return potionEffectProbability;
		//# end
	}
}
