package com.minespazio.utils;

import com.minespazio.FFA;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;


public class Economia {
    private FFA core;

    public Economia(FFA main) {
        core = main;
    }

    public double getMoney(Player p) {
        return core.econ.getBalance(p.getName());
    }

    public void setMoney(Player p, double money) {
        core.econ.depositPlayer(p.getName(), money);
    }

    public void removeMoney(Player p, double money) {
        core.econ.withdrawPlayer(p.getName(), money);
    }

    public boolean setupEconomy() {
        if (core.get().getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = core.get().getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        core.econ = (Economy) rsp.getProvider();
        return core.econ != null;
    }
}
