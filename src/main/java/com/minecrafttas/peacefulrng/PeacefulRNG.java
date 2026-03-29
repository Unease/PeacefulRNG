package com.minecrafttas.peacefulrng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class PeacefulRNG implements ModInitializer{

	public static Logger LOGGER = LogManager.getLogger("PeacefulRNG");
	public static boolean isTASMODLoaded = FabricLoader.getInstance().isModLoaded("tasmod");
	
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing...");
		
		if (isTASMODLoaded) {
			LOGGER.info("TASmod is detected!");
		} else {
			LOGGER.info("TASmod not detected!");
		}
		
	}
}
