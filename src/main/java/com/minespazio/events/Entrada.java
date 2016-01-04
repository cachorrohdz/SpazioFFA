package com.minespazio.events;

import com.minespazio.FFA;
import com.minespazio.menus.KitSelector;
import com.minespazio.utils.Locations;
import com.minespazio.utils.Mensajes;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class Entrada implements Listener{

   Locations locs = new Locations();

   private FFA main;

   public Entrada(FFA core){
       main = core;
   }

    Mensajes msg = new Mensajes(main);


    @EventHandler(priority = EventPriority.NORMAL)
    public void Entrada(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        if (main.get().getConfig().getString("lobby") == null) {
             msg.Player(p, "&alobby aun no configurado");
             msg.Consola("&a[DEBUG] lobby no configurado");
        }else {
            final Location spawn = locs.getLoc(main.get().getConfig().getString("lobby"), true);
            p.teleport(spawn);
        }

        msg.Player(p, "&cselecciona tu kit porfavor /kits");

    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void Salida(PlayerQuitEvent e){
        e.setQuitMessage(null);
    }
}
