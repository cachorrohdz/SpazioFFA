package com.minespazio;

import com.minespazio.commands.FFACommand;
import com.minespazio.commands.KitsCommand;
import com.minespazio.commands.Lobby;
import com.minespazio.events.Death;
import com.minespazio.events.Entrada;
import com.minespazio.events.Respawn;
import com.minespazio.kits.Kits;
import com.minespazio.menus.KitSelector;
import com.minespazio.menus.LobbyMenu;
import com.minespazio.utils.Configuracion;
import com.minespazio.utils.Economia;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class FFA extends JavaPlugin{

    // Instancias
    private Plugin pl;
    public Economy econ;
    public static Configuracion kits;
    Economia coins = new Economia(this);
// + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +

    // Cuando carga el plugin
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
        configs();
        Kits kitss = new Kits(this);
        kitss.saveKit();
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getCommand("lobby").setExecutor(new Lobby(this));
        getCommand("kits").setExecutor(new KitsCommand(this));
        getCommand("admin").setExecutor(new FFACommand(this));
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
    NuevoEvento(this, new KitSelector(this));
        NuevoEvento(this, new Death());
        NuevoEvento(this, new Respawn(this));
        NuevoEvento(this, new LobbyMenu(this));
    }

// + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +

    //Guardar configs para despues cargarlas
    private void configs(){
    kits = new Configuracion(this, "kits");
    }
    // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +

    //BungeeCord Random servers
    public String servers() {

        ArrayList servers = (ArrayList)getConfig().getStringList("servers");
        Random random = new Random();
        int index = random.nextInt(servers.size());
        return (String)servers.get(index);
    }
 //******************************************************************
    //BungeeCord Creador de coneccion
    public void conectar(Player player) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(servers());
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(this.pl, "BungeeCord", b.toByteArray());
    }
    // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // + // +

}
