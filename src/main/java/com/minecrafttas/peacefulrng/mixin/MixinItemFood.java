package com.minecrafttas.peacefulrng.mixin;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.minecrafttas.peacefulrng.PeacefulRNG;

import net.minecraft.item.ItemFood;

//# 1.11.2
@Mixin(ItemFood.class)
//# end
public class MixinItemFood {
	
	//# 1.11.2
	@WrapOperation(method = "onFoodEaten", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemFood;potionEffectProbability:F", opcode = Opcodes.GETFIELD))
	//# end
	private float receiveEffectChance(ItemFood food, Operation<Float> original) {
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
				return 0F; // They will never give the effect because its RNG
			}
		} 
		return original.call(food);
	}
}
