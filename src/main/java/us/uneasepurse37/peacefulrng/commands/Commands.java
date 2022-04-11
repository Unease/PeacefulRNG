package us.uneasepurse37.peacefulrng.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import us.uneasepurse37.peacefulrng.PeacefulRNG;

public class Commands extends CommandBase {

	@Override
	public String getName() {

		// The name of the command
		return "toggleprng";
	}

	@Override
	public String getUsage(ICommandSender sender) {

		// Displays usage when typing in chat.
		return "/toggleprng";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

		// Sets the values of the booleans to be the opposite of what it was.
		PeacefulRNG.toggledchicken = !PeacefulRNG.toggledchicken;
		PeacefulRNG.toggledflesh = !PeacefulRNG.toggledflesh;
		PeacefulRNG.toggledpotato = !PeacefulRNG.toggledpotato;

		// For debugging purposes
		System.out.println("Toggled! " + PeacefulRNG.toggledchicken);
	}

}
