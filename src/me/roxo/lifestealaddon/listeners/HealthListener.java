package me.roxo.lifestealaddon.listeners;


import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.UUID;

public class HealthListener implements Listener {


    @EventHandler
    public void onDeathByPlayer(PlayerDeathEvent e){

        if(e.getEntity().getKiller() instanceof Player){
            Player killer = e.getEntity().getKiller();
            if((killer.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) > 40){
                killer.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
            }
        }
    }

    @EventHandler
    public void onHealthGetter(PlayerDeathEvent e){
        if(e.getEntity().getKiller() instanceof Player){
            Player player = e.getEntity();
            if((player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) < 2){
                Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(player.getUniqueId().toString(), "Player got Banned from too low health!", null, player.getDisplayName());
                Bukkit.getServer().getBanList(BanList.Type.NAME);
                player.kickPlayer(player.toString());

            }
        }
    }
}
