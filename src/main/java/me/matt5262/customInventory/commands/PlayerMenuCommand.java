package me.matt5262.customInventory.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerMenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player){

            Inventory menu = Bukkit.createInventory(player, 27, ChatColor.AQUA + "Custom GUI");

            var feed = new ItemStack(Material.BREAD);
            var death = new ItemStack(Material.TNT);
            var sword = new ItemStack(Material.DIAMOND_SWORD);

            var feedMeta = feed.getItemMeta();
            feedMeta.setDisplayName(ChatColor.GREEN + "Feed");
            feedMeta.setLore(List.of("Hunger no more"));
            feed.setItemMeta(feedMeta);

            var deathMeta = death.getItemMeta();
            deathMeta.setDisplayName(ChatColor.GREEN + "Kill");
            deathMeta.setLore(List.of("Death, kys fr fr"));
            death.setItemMeta(deathMeta);

            var swordMeta = sword.getItemMeta();
            swordMeta.setDisplayName(ChatColor.GREEN + "Give Sword");
            swordMeta.setLore(List.of("Its sharp"));
            sword.setItemMeta(swordMeta);

            menu.setItem(9, feed);
            menu.setItem(13, death);
            menu.setItem(17, sword);

            player.openInventory(menu);

        }else{
            commandSender.sendMessage("Only players can use this command!");
        }
        return true;
    }
}
