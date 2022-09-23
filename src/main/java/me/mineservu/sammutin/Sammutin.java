package me.mineservu.sammutin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public final class Sammutin extends JavaPlugin {

    @Override
    public void onEnable() {

        String sammutus1 = "08:30";
        String sammutus4 = "02:30";


        String varotus1 = "08:25";
        String varotus4 = "02:25";

        String varotusmin1 = "08:29";
        String varotusmin2 = "02:29";




        System.out.println("toimii");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String date=new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
                System.out.println(date);

                if (date.equals(sammutus1) ||  date.equals(sammutus4)){
                    Bukkit.shutdown();
                }
                if (date.equals(varotus1)  || date.equals(varotus4)){
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.sendMessage(ChatColor.RED + "Serveri restarttaa 5 MIN päästä!!!");
                        p.sendMessage(ChatColor.YELLOW + "/lagaa chattiin nii näkee sen aikataulun");
                    }
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.getWorld().playSound(p.getLocation(), Sound.ITEM_TRIDENT_RETURN, 1.0F, 1.0F);
                    }
                }if (date.equals(varotusmin1)  || date.equals(varotusmin2)){
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.sendMessage(ChatColor.RED + "Serveri restarttaa 1 MIN päästä!!!");

                    }
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.getWorld().playSound(p.getLocation(), Sound.ITEM_TRIDENT_RETURN, 1.0F, 1.0F);
                    }

                }
        }
        }, 0, 60*1000);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (command.getName().equalsIgnoreCase("lagaa")){

            if (sender instanceof Player){

                Player p = (Player) sender;
                p.sendMessage(ChatColor.GREEN+"Servu restarttaa kellonaikoina:");
                p.sendMessage(ChatColor.GREEN +"Klo: 08:30");
                //p.sendMessage(ChatColor.GREEN +"Klo: 16:30");
                //p.sendMessage(ChatColor.GREEN +"Klo: 22:30");
                p.sendMessage(ChatColor.GREEN +"Klo: 02:30");

            }

        }

            return true;
    }




}
