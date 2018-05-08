package com.github.tollainmear.trade;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.InteractEntityEvent;
import org.spongepowered.api.event.filter.cause.First;


public class TradeListener {
    @Listener
    private void OnPlayerInteractOtherPlayers(InteractEntityEvent event, @First Player player){
        if (event.getTargetEntity().getType().equals(EntityTypes.PLAYER)){

        }
        else{

        }
    }
}
