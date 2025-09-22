package me.matt5262.customInventory;

import me.matt5262.customInventory.commands.PlayerMenuCommand;
import me.matt5262.customInventory.listeners.MenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomInventory extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("menu").setExecutor(new PlayerMenuCommand());
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }
}
