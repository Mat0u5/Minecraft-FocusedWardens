package net.mat0u5.focusedwardens.events;



import net.mat0u5.focusedwardens.Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class Events {

    public static void register() {
    }
    public static void wardenListen(ServerWorld world, GameEvent event, GameEvent.Emitter emitter, Vec3d emitterPos, CallbackInfoReturnable<Boolean> cir) {
        String enabled = Main.config.getProperty("enabled");
        if (enabled == null) return;
        if (!enabled.equalsIgnoreCase("true")) return;

        Entity sourceEntity = emitter.sourceEntity();
/*Useless??
        String ignoreWardenSounds = Main.config.getProperty("ignoreWardenSounds");
        if (ignoreWardenSounds != null) {
            if ((sourceEntity instanceof WardenEntity) && ignoreWardenSounds.equalsIgnoreCase("true")) {
                cir.setReturnValue(false);
            }
        }*/

        String ignoreNonEntitySounds = Main.config.getProperty("ignoreNonEntitySounds");
        if (ignoreNonEntitySounds != null) {
            if (sourceEntity == null && ignoreNonEntitySounds.equalsIgnoreCase("true")) {
                cir.setReturnValue(false);
            }
        }

        String ignoreNonPlayerSounds = Main.config.getProperty("ignoreNonPlayerSounds");
        if (ignoreNonPlayerSounds != null) {
            if (!(sourceEntity instanceof ServerPlayerEntity) && ignoreNonPlayerSounds.equalsIgnoreCase("true")) {
                cir.setReturnValue(false);
            }
        }
    }
}
