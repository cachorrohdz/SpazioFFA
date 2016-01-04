package com.minespazio.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class Mensajes {


    public void Player(Player p, String args){
        p.sendMessage(ChatColor.translateAlternateColorCodes('&',args));
    }

    public void Global(String args){
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',args));
    }

    public void Consola(String args){
        System.out.println(ChatColor.translateAlternateColorCodes('&',args));
    }

}
