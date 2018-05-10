package com.github.tollainmear.trade;

import com.github.tollainmear.trade.commandexecutor.MainExecutor;
import com.github.tollainmear.trade.commandexecutor.ReloadExecutor;
import com.github.tollainmear.trade.commandexecutor.VersionExecutor;
import com.github.tollainmear.trade.utils.Translator;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandCallable;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class CommandManager {
    private final Trade kse;
    private Translator translator;

    private CommandSpec remote;
    private CommandSpec accecpt;
    private CommandSpec reload;
    private CommandSpec version;

    public CommandManager(Trade plugin) {
        this.kse = plugin;

        remote = CommandSpec.builder()
                .permission("kse.remote")
                .description(Text.of("allow you to trade with a remote player."))
                .arguments(GenericArguments.player(Text.of("target")))
                .executor(new ReloadExecutor())
                .build();

        accecpt = CommandSpec.builder()
                .permission("kse.use")
                .description(Text.of("allow you to accept a trade request from other player."))
                .arguments(GenericArguments.none())
                .executor(new ReloadExecutor())
                .build();

        reload = CommandSpec.builder()
                .permission("kse.reload")
                .description(Text.of("relaod the KSE."))
                .arguments(GenericArguments.none())
                .executor(new ReloadExecutor())
                .build();

        version = CommandSpec.builder()
                .permission("kse.version")
                .description(Text.of("Show the version of KSE"))
                .arguments(GenericArguments.none())
                .executor(new VersionExecutor())
                .build();


    }

    public void init(Trade plugin) {
        org.spongepowered.api.command.CommandManager cmdManager = Sponge.getCommandManager();
        cmdManager.register(plugin, this.cmd(), "trade", "tra", "tr");
        translator = kse.getTranslator();
        translator.logInfo("reportBug");
        translator.logInfo("github");
    }

    public CommandCallable cmd() {
        return CommandSpec.builder()
                .description(Text.of("KSE's main command."))
                .child(remote, "set")
                .child(accecpt, "accept","yes")
                .child(reload, "reload", "r")
                .child(version, "version", "ver", "v")
                .executor(new MainExecutor())
                .arguments(GenericArguments.none())
                .build();
    }
}
