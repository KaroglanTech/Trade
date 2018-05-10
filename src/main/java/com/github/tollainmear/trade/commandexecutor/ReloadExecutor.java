package com.github.tollainmear.trade.commandexecutor;

import com.github.tollainmear.trade.Trade;
import com.github.tollainmear.trade.CommandManager;
import com.github.tollainmear.trade.utils.Translator;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.serializer.TextSerializers;

import java.io.IOException;

public class ReloadExecutor implements CommandExecutor {
    private Trade kse;
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        kse = Trade.getInstance();
        try {
            kse.cfgInit();
            kse.setTranslator(new Translator(kse));
            kse.getTranslator().checkUpdate();
            kse.setCmdManager(new CommandManager(kse));
        } catch (IOException e) {
            e.printStackTrace();
        }
        src.sendMessage(TextSerializers.FORMATTING_CODE.deserialize(kse.getTranslator().getstring("message.KSEprefix")+kse.getTranslator().getstring("message.reload")));
        return CommandResult.success();
    }
}
