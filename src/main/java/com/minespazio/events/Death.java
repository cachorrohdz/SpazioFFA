package com.minespazio.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void Muerte(PlayerDeathEvent e){
      Player p = e.getEntity();
      e.setDeathMessage(null);
      e.getDrops().clear();
      e.setDroppedExp(0);

      if(p.getKiller() instanceof Player){

      }else{

      }
    }


}
