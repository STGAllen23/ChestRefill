package io.github.aquerr.chestrefill.commands;

import io.github.aquerr.chestrefill.PluginInfo;
import io.github.aquerr.chestrefill.entities.ContainerLocation;
import io.github.aquerr.chestrefill.managers.ContainerManager;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class RefillAllCommand implements CommandExecutor
{
    @Override
    public CommandResult execute(CommandSource source, CommandContext args) throws CommandException
    {
        boolean didSucceed = true;
        for (ContainerLocation containerLocation : ContainerManager.getContainerLocations())
        {
            boolean refilledContainer = ContainerManager.refillContainer(containerLocation);
            if(!refilledContainer)
                didSucceed = false;
        }

        if(didSucceed)
            source.sendMessage(Text.of(PluginInfo.PluginPrefix, TextColors.YELLOW, "Successfully refilled all containers!"));
        else source.sendMessage(Text.of(PluginInfo.PluginPrefix, TextColors.RED, "Some containers couldn't be refilled."));

        return CommandResult.success();
    }
}
