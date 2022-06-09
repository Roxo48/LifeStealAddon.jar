package me.roxo.lifestealaddon.listeners;

import me.roxo.lifestealaddon.LifeStealAddon;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class UseRevival implements Listener {

    private final LifeStealAddon plugin;
    public UseRevival(LifeStealAddon plugin){


        this.plugin = plugin;
    }
        @EventHandler
        public void onPlace(PlayerInteractEvent e){
            if(!e.hasItem()){
                return;
            }
            if(e.getItem().getType() != Material.BARRIER){
                return;
            }
            if(!e.getItem().hasItemMeta()){
                return;
            }
            if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) ||e.getAction().equals(Action.LEFT_CLICK_BLOCK) ){
                if(e.getItem().getType() == Material.BARRIER){
                    e.setCancelled(true);
                }
            }
            try {
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                    if (e.getItem().getType() == Material.BARRIER) {
                        long fistTime = System.currentTimeMillis();

                        Player player = e.getPlayer();


                        String playersName = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
                        Player player1 = Bukkit.getPlayer(playersName);
                        try {
                            player1.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(2);
                        }catch (Exception exception){
                            player.sendMessage(ChatColor.RED + "There is not a valid Player Name. Please change the name by putting it into an anvil.");
                        }


                            Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Someone is getting revived!!");
                            Bukkit.getServer().getBanList(BanList.Type.NAME).pardon(playersName);
                            e.setCancelled(true);
                            player.getInventory().remove(player.getInventory().getItemInMainHand());

                            return;
                        }

                    }

            }catch (Exception exception){
                Player player = e.getPlayer();
                Bukkit.getServer().broadcastMessage(exception.getMessage());
                player.sendMessage(ChatColor.RED + "There is not a valid Player Name. Please change the name by putting it into an anvil.");

            }
        }
}
