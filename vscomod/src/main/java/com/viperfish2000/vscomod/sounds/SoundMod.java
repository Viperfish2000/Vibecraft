package com.viperfish2000.vscomod.sounds;


import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ObjectHolder;

import java.util.List;

@EventBusSubscriber(modid = "vscomod", bus = EventBusSubscriber.Bus.MOD)
@ObjectHolder("vscomod")
public class SoundMod{
    private static List<SoundEvent> sounds = Lists.newArrayList();
    public static final SoundEvent UKULELE = createSound("ukulele.strum");
    public static final SoundEvent SHINE_ON_TOP = createSound("disc.shine_on_top");
    public static final SoundEvent ULTIMATELY = createSound("disc.ultimately");
    public static final SoundEvent OBLIVION = createSound("disc.oblivion");
    public static final SoundEvent SUNFLOWER_FEELINGS = createSound("disc.sunflower_feelings");
    public static final SoundEvent BUBBLEGUM = createSound("disc.bubblegum");
    public static final SoundEvent AIRPLANE_MODE = createSound("disc.airplane_mode");
    public static final SoundEvent ENTITY_HEDGEHOG_WHINE = createSound("entity.hedgehog.whine");
    public static final SoundEvent ENTITY_HEDGEHOG_HURT = createSound("entity.hedgehog.hurt");
    public static final SoundEvent ENTITY_HEDGEHOG_DEATH = createSound("entity.hedgehog.death");
    public static final SoundEvent BLOCK_TRAMPOLINE_FALL = createSound("block.trampoline.fall");
    public static final SoundEvent ENTITY_YODA_LIVING = createSound("entity.yoda.living");
    private static SoundEvent createSound(String name) {
        ResourceLocation resourceLocation = new ResourceLocation("vscomod", name);
        SoundEvent sound = new SoundEvent(resourceLocation);
        sound.setRegistryName(resourceLocation);
        sounds.add(sound);
        return sound;
    }

    @SubscribeEvent
    public static void registerSound(RegistryEvent.Register<SoundEvent> event) {
        for (SoundEvent sound : sounds) {
            event.getRegistry().register(sound);
        }
    }
}