package com.viperfish2000.vscomod.entity;

import java.util.List;

import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "vscomod", bus = EventBusSubscriber.Bus.MOD)
public class EntityRegistry {
    private static List<EntityType> entities = Lists.newArrayList();
    private static List<Item> spawnEggs = Lists.newArrayList();

 //   public static final EntityType<VSCODecal2> VSCO_DECAL = createEntity(VSCODecal2.class, VSCODecal2::new, 0.4F, 0.95F, 0x000000, 0xFFFFFF);
    public static final EntityType<HedgehogEntity> HEDGEHOG = createEntity(HedgehogEntity.class, HedgehogEntity::new, 0.4F, 0.4F, 0x4d3932, 0x866c69);
    public static final EntityType<YodaEntity> YODA = createEntity(YodaEntity.class, YodaEntity::new, 0.4F, 0.4F, 0x4d3932, 0x866c69);
    public static final EntityType<ButterflyEntity> BUTTERFLY = createEntity(ButterflyEntity.class, ButterflyEntity::new, 0.4F, 0.4F, 0x4cd4ee, 0x01144c);
    public static final EntityType<KoiEntity> KOI = createEntity(KoiEntity.class, KoiEntity::new, 0.4F, 0.4F, 0xffffff, 0xfc4c12);
    public static final EntityType<BisonEntity> BISON = createEntity(BisonEntity.class, BisonEntity::new, 6.4F, 5F, 0xe7e4d5, 0x877c6f);
    public static final EntityType<StrawberryBeeEntity> STRAWBERRY_BEE = createEntity(StrawberryBeeEntity.class, StrawberryBeeEntity::new, 1F, 1F, 0xe7e4d5, 0x877c6f);
    
    
    private static <T extends Entity> EntityType<T> createEntity(Class<T> entityClass, EntityType.IFactory<T> factory, float width, float height, int eggPrimary, int eggSecondary) {
        ResourceLocation location = new ResourceLocation("vscomod", classToString(entityClass));
        EntityType<T> entity = EntityType.Builder.create(factory, EntityClassification.CREATURE).size(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        entity.setRegistryName(location);
        entities.add(entity);
        Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary, (new Item.Properties()).group(ItemGroup.MISC));
        spawnEgg.setRegistryName(new ResourceLocation("vscomod", classToString(entityClass) + "_spawn_egg"));
       spawnEggs.add(spawnEgg);

        return entity;
    }

    private static String classToString(Class<? extends Entity> entityClass) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.getSimpleName()).replace("_entity", "");
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerPenguins(RegistryEvent.Register<EntityType<?>> event) {
        for (EntityType entity : entities) {
            Preconditions.checkNotNull(entity.getRegistryName(), "registryName");
            event.getRegistry().register(entity);
        }
    }

    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
        for (Item spawnEgg : spawnEggs) {
            Preconditions.checkNotNull(spawnEgg.getRegistryName(), "registryName");
            event.getRegistry().register(spawnEgg);
        }
    }

    public static void addSpawn() {
      
    }
}