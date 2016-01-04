package com.minespazio;

import com.minespazio.events.Entrada;
import com.minespazio.utils.Economia;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class FFA extends JavaPlugin{

    // Instancias
    private Plugin pl;
    public Economy econ;
    Economia coins = new Economia(this);
// + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +

    // Cuando cagar el plugin
    @Override
    public void onLoad(){

    }

// +  // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +

    //Cuando activa el plugin
    @Override
    public void onEnable(){
        pl = this;
        saveDefaultConfig();
        saveConfig();
        eventos();
        coins.setupEconomy();
    }

// + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +

    // Cuando desactiva el plugin
    @Override
    public void onDisable(){

    }

// + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +

    //Declaracion de pl
    public Plugin get(){
        return pl;
    }

// + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +

    //Colores en configuracion
    public String configuracionc(String args){
        return ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString(args));
    }

// + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +

    //Registrar eventos
    private void NuevoEvento(Plugin plugin, Listener listener) {
        Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
    }

// + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +

    //Guardar eventos para despues cargarlos
    private void eventos(){
    NuevoEvento(this, new Entrada(this));
    }

// + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +
}
