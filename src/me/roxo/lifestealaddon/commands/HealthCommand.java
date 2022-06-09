package me.roxo.lifestealaddon.commands;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealthCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){

            Player player = (Player) commandSender;
            //   if(player.hasPermission("spiritwars.islandtwospawn")) {
            Location location = player.getLocation();
            if(!commandSender.isOp())return true;
            //2. save the location
            player.sendMessage("Normal" + player.getHealth());
            player.sendMessage("Attribute" + player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            //player.sendMessage("GeneratorSpawnAmethyst Location set!");
            //   }else{player.sendMessage("you dont have perms");}
        }





        return false;
    }
}
