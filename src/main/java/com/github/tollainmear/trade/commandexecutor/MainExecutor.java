package com.github.tollainmear.trade.commandexecutor;

import com.github.tollainmear.trade.Trade;
import com.github.tollainmear.trade.utils.Translator;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.ArrayList;
import java.util.List;

public class MainExecutor implements CommandExecutor {
    Translator translator;

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        List<Text> contents = new ArrayList<>();
        translator = Trade.getInstance().getTranslator();

        contents.add(Text.of(TextColors.GOLD, "/kse to [PlayrID]", TextColors.GRAY, " - ", TextColors.YELLOW, translator.getstring("command.edit")));
        contents.add(Text.of(TextColors.GOLD, "/kse version", TextColors.GRAY, " - ", TextColors.YELLOW, translator.getstring("command.version")));
        contents.add(Text.of(TextColors.GOLD, "/kse reload", TextColors.GRAY, " - ", TextColors.YELLOW, translator.getstring("command.reload")));
        contents.add(Text.of(translator.getstring("github")));

        PaginationList.builder()
                .title(Text.of(Trade.getPluginName()))
                .contents(contents)
                .padding(Text.of(TextColors.GRAY, "-"))
                .sendTo(src);
        return CommandResult.success();

    }
}
