package me.roxo.lifestealaddon.items;

import me.roxo.lifestealaddon.LifeStealAddon;
import me.roxo.lifestealaddon.models.InfomationDataType;
import me.roxo.lifestealaddon.models.Information;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.libs.org.apache.maven.model.License;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack totem;


    public void getCrafting(){createRevival();}

    private  ItemStack getID(Information info){
        ItemStack id = new ItemStack(Material.BARRIER);
        ItemMeta meta = id.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE  +" Revival Ceremony" + "{"+ info.getName() +"}");

        NamespacedKey key = new NamespacedKey(LifeStealAddon.getPlugin(LifeStealAddon.class), "lifestealaddon");

        meta.getPersistentDataContainer().set(key,new InfomationDataType(), info);

        id.setItemMeta(meta);
        return id;
    }
    public static void createRevival(){



        ItemStack item = new ItemStack(Material.BARRIER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.MAGIC  +"Revival Ceremony");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_RED + "This Item is from ancient times. Only used my the minecraft Elders to revive its fallen.");
        lore.add(ChatColor.DARK_RED + "It has traveled to many realms looking for a suitable host to use its magic.");
        lore.add(ChatColor.UNDERLINE + "If you use this item, there will be consequences." + ChatColor.BOLD + ChatColor.DARK_RED +  " YOU HAVE BEEN WARNED " );
        lore.add(ChatColor.GRAY + "To use: Change the name of this item in an anvil to a players name, then right click." );
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LURE, 1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


        item.setItemMeta(meta);

        totem = item;

        //Shaped Recipe
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft( "revival"), item);
        shapedRecipe.shape("DND", "NTN", "DND");

        shapedRecipe.setIngredient('D', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('N', Material.TOTEM_OF_UNDYING);
        shapedRecipe.setIngredient('T', Material.NETHER_STAR);

        Bukkit.getServer().addRecipe(shapedRecipe);







    }


}
