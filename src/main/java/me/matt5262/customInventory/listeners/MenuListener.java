package me.matt5262.customInventory.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){

        if (e.getView().getTitle().equals(ChatColor.AQUA + "Custom GUI")){

            if (e.isRightClick()) return;

            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();

            switch (e.getCurrentItem().getType()){
                case BREAD:
                    player.setFoodLevel(20);
                    player.setSaturation(10);
                    e.getView().close();
                    break;
                case TNT:
                    player.setHealth(0);
                    e.getView().close();
                    break;
                case DIAMOND_SWORD:
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                    e.getView().close();
                    break;
            }

        }

    }

}
