package com.minespazio.utils;

import com.minespazio.FFA;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class Mensajes {

   private FFA main;
    public Mensajes(FFA core){
        main = core;
    }

    public void Player(Player p, String args) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', args));
    }

    public void Global(String args) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', args));
    }

    public void Consola(String args) {
        System.out.println(ChatColor.translateAlternateColorCodes('&', args));
    }

    public String Mensaje(String args){
      return   ChatColor.translateAlternateColorCodes('&', args);
    }

    public String KitsColor(String args){
        return ChatColor.translateAlternateColorCodes('&', FFA.kits.getConfig().getString(args));
    }

}
