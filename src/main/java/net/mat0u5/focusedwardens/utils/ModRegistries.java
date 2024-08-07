package net.mat0u5.focusedwardens.utils;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.mat0u5.focusedwardens.command.Resourcepack;
import net.mat0u5.focusedwardens.events.Events;

public class ModRegistries {
    public static void registerModStuff() {
        registerCommands();
        registerEvents();
    }
    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(Resourcepack::register);
    }
    private static void registerEvents() {
        Events.register();
    }
}
