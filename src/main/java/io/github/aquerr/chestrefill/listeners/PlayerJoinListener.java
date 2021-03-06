package io.github.aquerr.chestrefill.listeners;

import io.github.aquerr.chestrefill.PluginInfo;
import io.github.aquerr.chestrefill.PluginPermissions;
import io.github.aquerr.chestrefill.version.VersionChecker;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class PlayerJoinListener
{
    @Listener
    public void onPlayerJoin(ClientConnectionEvent.Join event, @Root Player player)
    {
        if (player.hasPermission(PluginPermissions.VERSION_NOTIFY) && !VersionChecker.isLatest(PluginInfo.Version))
        {
            player.sendMessage(Text.of(PluginInfo.PluginPrefix, "There is a new version of ", TextColors.YELLOW, "Chest Refill", TextColors.WHITE, " available online!"));
        }
    }
}
