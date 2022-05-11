package com.uneasepurse37.peacefulrng.commands;

import java.util.ArrayList;
import java.util.List;

import com.uneasepurse37.peacefulrng.PeacefulRNG;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class Commands extends CommandBase {

	@Override
	public String getName() {

		// The name of the command
		return "peacefulrng";
	}

	@Override
	public String getUsage(ICommandSender sender) {

		// Displays usage when typing in chat.
		return "peacefulrng <food>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

		// Sets the values of the booleans to be the opposite of what it was.
//		PeacefulRNG.toggledchicken = !PeacefulRNG.toggledchicken;
//		PeacefulRNG.toggledflesh = !PeacefulRNG.toggledflesh;
//		PeacefulRNG.toggledpotato = !PeacefulRNG.toggledpotato;
		
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("rawchicken")) {
				PeacefulRNG.toggledchicken = !PeacefulRNG.toggledchicken;
			} else if (args[0].equalsIgnoreCase("rottenflesh")) {
				PeacefulRNG.toggledflesh = !PeacefulRNG.toggledflesh;
			} else if (args[0].equalsIgnoreCase("poisonouspotato")) {
				PeacefulRNG.toggledpotato = !PeacefulRNG.toggledpotato;
			} else if (args[0].equalsIgnoreCase("status")) {
				if (PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) {
					sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Everything is toggled" + TextFormatting.RED + " on!")); //Displays a red message in chat when the mod is toggled on!
				} else if (!PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {
					sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Everything is toggled" + TextFormatting.AQUA + " off!")); //Displays a blue message in chat when the mod is toggled off!
				} 
				
				if (PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {
					sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Only poisonous potatoes are" + TextFormatting.GREEN+ " off!"));
				} else if (PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) {
					sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Only rotten flesh is" + TextFormatting.YELLOW+ " off!"));
				} else if (!PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) {
					sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Only raw chicken is"+ TextFormatting.LIGHT_PURPLE + " off!"));
				}
				
				if (!PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) {
					sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Only potatoes are"+ TextFormatting.DARK_GREEN + " on!"));
				} else if (!PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {
					sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Only rotten flesh is"+ TextFormatting.GOLD + " on!"));
				} else if (PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {
					sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Only raw chicken is"+ TextFormatting.DARK_PURPLE + " on!"));
				}
			} 
			
		}  else if (args.length == 0) {
			
			boolean flag = PeacefulRNG.toggledchicken || PeacefulRNG.toggledflesh || PeacefulRNG.toggledpotato;
			
			PeacefulRNG.toggledchicken = !flag;
			PeacefulRNG.toggledflesh = !flag;
			PeacefulRNG.toggledpotato = !flag;
		}
		
		if (PeacefulRNG.isTASMODLoaded) {
			if (PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) {
				sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "PeacefulRNG is toggled" + TextFormatting.RED + " on!")); //Displays a red message in chat when the mod is toggled on!
			} else if (!PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {
				sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "PeacefulRNG is toggled" + TextFormatting.AQUA + " off!")); //Displays a blue message in chat when the mod is toggled off!
			} 
			
			if (PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {
				sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Only poisonous potatoes are" + TextFormatting.GREEN+ " off!"));
			} else if (PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) {
				sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Only rotten flesh is" + TextFormatting.YELLOW+ " off!"));
			} else if (!PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) {
				sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Only raw chicken is"+ TextFormatting.LIGHT_PURPLE + " off!"));
			}
			
			if (!PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && PeacefulRNG.toggledpotato) {
				sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Only potatoes are"+ TextFormatting.DARK_GREEN + " on!"));
			} else if (!PeacefulRNG.toggledchicken && PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {
				sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Only rotten flesh is"+ TextFormatting.GOLD + " on!"));
			} else if (PeacefulRNG.toggledchicken && !PeacefulRNG.toggledflesh && !PeacefulRNG.toggledpotato) {
				sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "Only raw chicken is"+ TextFormatting.DARK_PURPLE + " on!"));
			}
			
		}

	}
	
	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos){
		List<String> tab = new ArrayList<String>();
		if (args.length == 1) {
			tab.addAll(getListOfStringsMatchingLastWord(args, new String[] {"rawchicken", "rottenflesh", "poisonouspotato", "status"}));
		}
		return tab;
	} 
}
