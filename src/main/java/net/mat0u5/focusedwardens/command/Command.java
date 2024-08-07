package net.mat0u5.focusedwardens.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mat0u5.focusedwardens.Main;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

import java.util.Collection;

import static net.minecraft.server.command.CommandManager.literal;


public class Command {

    public static void register(CommandDispatcher<ServerCommandSource> serverCommandSourceCommandDispatcher,
                                CommandRegistryAccess commandRegistryAccess,
                                CommandManager.RegistrationEnvironment registrationEnvironment) {
        serverCommandSourceCommandDispatcher.register(
            literal("focusedwardens")
                .then(literal("enable")
                    .executes(context -> Command.setConfigValue(
                        context.getSource(),"enabled","true")
                    )
                )
                .then(literal("disable")
                    .executes(context -> Command.setConfigValue(
                        context.getSource(),"enabled","false")
                    )
                )
                .then(literal("settings")
                    /*
                    .then(literal("ignoreWardenSounds")
                        .then(literal("enable")
                            .executes(context -> Command.setConfigValue(
                                context.getSource(),"ignoreWardenSounds","true")
                            )
                        )
                        .then(literal("disable")
                            .executes(context -> Command.setConfigValue(
                                context.getSource(),"ignoreWardenSounds","false")
                            )
                        )
                    )*/
                    .then(literal("ignoreNonEntitySounds")
                        .then(literal("enable")
                            .executes(context -> Command.setConfigValue(
                                context.getSource(),"ignoreNonEntitySounds","true")
                            )
                        )
                        .then(literal("disable")
                            .executes(context -> Command.setConfigValue(
                                context.getSource(),"ignoreNonEntitySounds","false")
                            )
                        )
                    )
                    .then(literal("ignoreNonPlayerSounds")
                        .then(literal("enable")
                            .executes(context -> Command.setConfigValue(
                                context.getSource(),"ignoreNonPlayerSounds","true")
                            )
                        )
                        .then(literal("disable")
                            .executes(context -> Command.setConfigValue(
                                context.getSource(),"ignoreNonPlayerSounds","false")
                            )
                        )
                    )
                )
        );
    }
    public static int setConfigValue(ServerCommandSource source, String configName, String value) {
        MinecraftServer server = source.getServer();
        final PlayerEntity self = source.getPlayer();
        Main.config.setProperty(configName,value);
        return 1;
    }
}
