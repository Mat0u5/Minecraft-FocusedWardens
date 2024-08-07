package net.mat0u5.focusedwardens.mixin;


import net.mat0u5.focusedwardens.events.Events;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.Vibrations;
import net.minecraft.world.event.listener.GameEventListener;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.event.GameEvent.Emitter;
import net.minecraft.world.event.Vibrations.VibrationListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VibrationListener.class)
public abstract class VibrationListenerMixin implements GameEventListener {

    @Inject(method = "listen", at = @At("HEAD"), cancellable = true)
    private void onListen(ServerWorld world, GameEvent event, GameEvent.Emitter emitter, Vec3d emitterPos, CallbackInfoReturnable<Boolean> cir) {
        Events.wardenListen(world, event, emitter, emitterPos, cir);
    }
}