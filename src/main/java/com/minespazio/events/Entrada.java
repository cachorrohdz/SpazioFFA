package com.minespazio.events;

import com.minespazio.FFA;
import com.minespazio.utils.Locations;
import com.minespazio.utils.Mensajes;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class Entrada implements Listener{

   Locations locs = new Locations();
   Mensajes msg = new Mensajes();
   private FFA main;

   public Entrada(FFA core){
       main = core;
   }



    @EventHandler(priority = EventPriority.NORMAL)
    public void Entrada(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        if (main.get().getConfig().getString("lobby") == null) {
             msg.Player(p, "&aLobby aun no configurado");
             msg.Consola("&a[DEBUG] Lobby no configurado");
        }else {
            final Location spawn = locs.getLoc(main.get().getConfig().getString("lobby"), true);
            p.teleport(spawn);
        }
    }
}
