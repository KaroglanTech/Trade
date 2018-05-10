package com.github.tollainmear.trade;

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.InteractEntityEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.text.Text;


public class TradeListener {
    @Listener
    public void OnPlayerInteractOtherPlayers(InteractEntityEvent event, @First Player player){
        if (player.hasPermission("trade.use")&&player.get(Keys.IS_SNEAKING).orElse(false)&&event.getTargetEntity().getType().equals(EntityTypes.PLAYER)) {
            player.sendMessage(Text.of("Clicking"));
        }
        else{
            player.sendMessage(Text.of("No player founded!"));
        }
    }
}
