package us.uneasepurse37.peacefulrng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import us.uneasepurse37.peacefulrng.commands.Commands;

/**
 * @author UneasePurse37
 * 
 */
//Most comments are for myself as this is my first mod!
@Mod(modid = PeacefulRNG.MODID, name = PeacefulRNG.NAME, version = PeacefulRNG.VERSION)

public class PeacefulRNG {

	public static final String MODID = "peacefulrng";
	public static final String NAME = "PeacefulRNG";
	public static final String VERSION = "${version}";

	private static Logger logger = LogManager.getLogger(NAME);

	// Creates values for each food for use in commands
	public static boolean toggledchicken = true;
	public static boolean toggledflesh = true;
	public static boolean toggledpotato = true;
	public static boolean isTASMODLoaded;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		System.out.println("PeacefulRNG is loaded!");
		MinecraftForge.EVENT_BUS.register(new InfoGui());
		
		isTASMODLoaded = Loader.isModLoaded("tasmod") | Loader.isModLoaded("lotas");
		
		if (isTASMODLoaded = Loader.isModLoaded("tasmod")) {
			System.out.println("TASMod is loaded with PeacefulRNG!");
		} else if (isTASMODLoaded = Loader.isModLoaded("lotas")) {
			System.out.println("LoTAS is loaded with PeacefulRNG!");
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		logger.info("Mod was initialized!");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

//		logger.warn("This is a warning!");
//		logger.error("Something went wrong, but you might be able to recover from it");
//		logger.fatal("Something broke, and you may not be able to recover, maybe the game crashed");
	}

	@EventHandler
	public void serverStart(FMLServerStartingEvent event) {

		event.registerServerCommand(new Commands());
	}

}
