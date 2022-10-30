
package com.viperfish2000.vscomod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.viperfish2000.vscomod.block.BirkenstocksBlock;
import com.viperfish2000.vscomod.block.BlockList;
import com.viperfish2000.vscomod.block.CassavaBlock;
import com.viperfish2000.vscomod.block.CeilingDecorationBlock;
import com.viperfish2000.vscomod.block.ClosetBlock;
import com.viperfish2000.vscomod.block.CoffeePlantBlock;
import com.viperfish2000.vscomod.block.CurtainBlock;
import com.viperfish2000.vscomod.block.DecorationBlock;
import com.viperfish2000.vscomod.block.DoorBlock;
import com.viperfish2000.vscomod.block.DragonfruitBlock;
import com.viperfish2000.vscomod.block.DrinkBlock;
import com.viperfish2000.vscomod.block.FairyLightsBlock;
import com.viperfish2000.vscomod.block.HorizontalDecorationBlock;
import com.viperfish2000.vscomod.block.HorizontalDecorationBlockTranslucent;
import com.viperfish2000.vscomod.block.HorizontalFullBlock;
import com.viperfish2000.vscomod.block.HydroFlaskBlock;
import com.viperfish2000.vscomod.block.ModdedStairsBlock;
import com.viperfish2000.vscomod.block.PieBlock;
import com.viperfish2000.vscomod.block.PoleBlock;
import com.viperfish2000.vscomod.block.SmallTableBlock;
import com.viperfish2000.vscomod.block.TeaLeavesBlock;
import com.viperfish2000.vscomod.block.TrampolineBlock;
import com.viperfish2000.vscomod.block.UkuleleBlock;
import com.viperfish2000.vscomod.block.VansBlock;
import com.viperfish2000.vscomod.block.WallDecorationBlock;
import com.viperfish2000.vscomod.client.renderer.BisonRenderer;
import com.viperfish2000.vscomod.client.renderer.ButterflyRenderer;
import com.viperfish2000.vscomod.client.renderer.HedgehogRenderer;
import com.viperfish2000.vscomod.client.renderer.KoiRenderer;
import com.viperfish2000.vscomod.client.renderer.StrawberryBeeRenderer;
import com.viperfish2000.vscomod.client.renderer.YodaRenderer;
import com.viperfish2000.vscomod.entity.EntityMod;
import com.viperfish2000.vscomod.entity.EntityRegistry;
import com.viperfish2000.vscomod.item.AirpodsItem;
import com.viperfish2000.vscomod.item.ArmorMaterialList;
import com.viperfish2000.vscomod.item.BackpackItem;
import com.viperfish2000.vscomod.item.BunItem;
import com.viperfish2000.vscomod.item.DrinkCoffeeItem;
import com.viperfish2000.vscomod.item.DrinkCupItem;
import com.viperfish2000.vscomod.item.DrinkGlassItem;
import com.viperfish2000.vscomod.item.DrinkLatteItem;
import com.viperfish2000.vscomod.item.FlowerCrownItem;
import com.viperfish2000.vscomod.item.FoodList;
import com.viperfish2000.vscomod.item.HatItem;
import com.viperfish2000.vscomod.item.HydroFlaskItem;
import com.viperfish2000.vscomod.item.ItemList;
import com.viperfish2000.vscomod.item.MusicDiscModItem;
import com.viperfish2000.vscomod.item.NecklaceItem;
import com.viperfish2000.vscomod.item.PonytailItem;
import com.viperfish2000.vscomod.item.SunglassesItem;
import com.viperfish2000.vscomod.item.UkuleleBlockItem;
import com.viperfish2000.vscomod.proxy.CommonProxy;
import com.viperfish2000.vscomod.sounds.SoundMod;
import com.viperfish2000.vscomod.sounds.SoundTypeMod;

import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.TallBlockItem;
import net.minecraft.potion.Effects;
import net.minecraft.server.dedicated.ServerProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("vscomod")
public class VSCOMod 
{
	public static VSCOMod instance;
	public static final String modid = "vscomod";
	private static final Logger logger = LogManager.getLogger(modid);
	 private final CommonProxy proxy = (CommonProxy)DistExecutor.runForDist(() -> com.viperfish2000.vscomod.proxy.ClientProxy::new, () -> CommonProxy::new);
	  
	public static final ItemGroup vsco = new TutorialItemGroup();


    public VSCOMod() 
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
	
		MinecraftForge.EVENT_BUS.register(this);
		   this.proxy.construct();
	}

    public void dedicatedServerSetup(FMLDedicatedServerSetupEvent event)
    {
        ServerProperties serverProperties = event.getServerSupplier().get().getServerProperties();

     
    }
/**
    private void commonSetup(final FMLCommonSetupEvent event)
    {
        ModBiomes.setup();
        ModVanillaCompat.setup();
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        ModEntities.registerRendering();
    }
**/
    private void loadComplete(final FMLLoadCompleteEvent event) // PostRegistrationEven
    {
        proxy.init();
    }
	
	
	
	private void setup(final FMLCommonSetupEvent event)
	{
	//	OreGeneration.setupOreGeneration();
		this.proxy.setup();
		logger.info("Setup method registered.");
	}
	private void ready(FMLLoadCompleteEvent event)
	{
	//	OreGeneration.setupOreGeneration();
		this.proxy.complete();
		logger.info("Ready method registered.");
	}
	/* In charge of client initialization */
    private void onClientSetup(final FMLClientSetupEvent event) {
    	
    	//Block rendering
    	RenderTypeLookup.setRenderLayer(BlockList.crate, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.shelf1, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.shelf2, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.curtain, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.room_lamp, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.salt_lamp, RenderType.getTranslucent());
    	RenderTypeLookup.setRenderLayer(BlockList.rainbow_fairy_lights_horizontal, RenderType.getTranslucent());
    	RenderTypeLookup.setRenderLayer(BlockList.rainbow_fairy_lights_verticle, RenderType.getTranslucent());
    	RenderTypeLookup.setRenderLayer(BlockList.white_fairy_lights_horizontal, RenderType.getTranslucent());
    	RenderTypeLookup.setRenderLayer(BlockList.white_fairy_lights_verticle, RenderType.getTranslucent());
    	RenderTypeLookup.setRenderLayer(BlockList.ukulele, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.shirts, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.summer_shirts, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.tropical_plant, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.house_plant, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.wall_plant, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hanging_plant, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.succulent_short, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.succulent_spiky, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.succulent_tall, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.succulent_box, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.bamboo, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.orchid, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.vase1, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.vase2, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.mushroom_terrarium, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.plant_terrarium, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.calendula, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.calluna, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.desert_poppy, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hyacinth, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.marigold, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.petunia, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.purple_coneflower, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.buttercup, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.black_eyed_susan, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.sunflower, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.pale_rose_bush, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.vine, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.ivy, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hydro_flask, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hydro_flask_black, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hydro_flask_blue, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hydro_flask_cyan, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hydro_flask_green, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hydro_flask_orange, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hydro_flask_purple, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hydro_flask_red, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hydro_flask_rose, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hydro_flask_royal, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hydro_flask_teal, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.hydro_flask_yellow, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.birkenstocks, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.dark_birkenstocks, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.white_birkenstocks, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.cassava, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.dragonfruit, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.coffee_plant, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.tea_leaves_plant, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.jam, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.dragonfruit_smoothie, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.metal_straw_dragonfruit_smoothie, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.berry_smoothie, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.metal_straw_berry_smoothie, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.matcha_boba_tea, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.metal_straw_matcha_boba_tea, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.thai_boba_tea, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.metal_straw_thai_boba_tea, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.coffee, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.latte, RenderType.getCutoutMipped());
     	RenderTypeLookup.setRenderLayer(BlockList.potted_calendula, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.potted_calluna, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.potted_desert_poppy, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.potted_hyacinth, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.potted_marigold, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.potted_petunia, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.potted_purple_coneflower, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.potted_buttercup, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.potted_black_eyed_susan, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.lemonade, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.basket, RenderType.getCutoutMipped());
     	RenderTypeLookup.setRenderLayer(BlockList.star, RenderType.getCutoutMipped());
     	RenderTypeLookup.setRenderLayer(BlockList.presents, RenderType.getCutoutMipped());
     	 
    	
    	
    	
    	//Entity rendering
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.BISON, manager -> new BisonRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.BUTTERFLY, manager -> new ButterflyRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.HEDGEHOG, manager -> new HedgehogRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.KOI, manager -> new KoiRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.YODA, manager -> new YodaRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.STRAWBERRY_BEE, manager -> new StrawberryBeeRenderer(manager));
      
    }
    
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegsitryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
				ItemList.mahogany_planks = new BlockItem(BlockList.mahogany_planks, new Item.Properties().group(vsco)).setRegistryName(BlockList.mahogany_planks.getRegistryName()),
				ItemList.ash_planks = new BlockItem(BlockList.ash_planks, new Item.Properties().group(vsco)).setRegistryName(BlockList.ash_planks.getRegistryName()),
				ItemList.walnut_planks = new BlockItem(BlockList.walnut_planks, new Item.Properties().group(vsco)).setRegistryName(BlockList.walnut_planks.getRegistryName()),
				ItemList.beach_planks = new BlockItem(BlockList.beach_planks, new Item.Properties().group(vsco)).setRegistryName(BlockList.beach_planks.getRegistryName()),
				ItemList.white_painted_planks = new BlockItem(BlockList.white_painted_planks, new Item.Properties().group(vsco)).setRegistryName(BlockList.white_painted_planks.getRegistryName()),
				ItemList.varnished_planks = new BlockItem(BlockList.varnished_planks, new Item.Properties().group(vsco)).setRegistryName(BlockList.varnished_planks.getRegistryName()),
				ItemList.mahogany_stairs = new BlockItem(BlockList.mahogany_stairs, new Item.Properties().group(vsco)).setRegistryName(BlockList.mahogany_stairs.getRegistryName()),
				ItemList.ash_stairs = new BlockItem(BlockList.ash_stairs, new Item.Properties().group(vsco)).setRegistryName(BlockList.ash_stairs.getRegistryName()),
				ItemList.walnut_stairs = new BlockItem(BlockList.walnut_stairs, new Item.Properties().group(vsco)).setRegistryName(BlockList.walnut_stairs.getRegistryName()),
				ItemList.beach_stairs = new BlockItem(BlockList.beach_stairs, new Item.Properties().group(vsco)).setRegistryName(BlockList.beach_stairs.getRegistryName()),							
				ItemList.white_painted_stairs = new BlockItem(BlockList.white_painted_stairs, new Item.Properties().group(vsco)).setRegistryName(BlockList.white_painted_stairs.getRegistryName()),
				ItemList.varnished_stairs = new BlockItem(BlockList.varnished_stairs, new Item.Properties().group(vsco)).setRegistryName(BlockList.varnished_stairs.getRegistryName()),
				ItemList.mahogany_door = new TallBlockItem(BlockList.mahogany_door, new Item.Properties().group(vsco)).setRegistryName(BlockList.mahogany_door.getRegistryName()),	
				ItemList.ash_door = new TallBlockItem(BlockList.ash_door, new Item.Properties().group(vsco)).setRegistryName(BlockList.ash_door.getRegistryName()),	
				ItemList.walnut_door = new TallBlockItem(BlockList.walnut_door, new Item.Properties().group(vsco)).setRegistryName(BlockList.walnut_door.getRegistryName()),	
				ItemList.beach_door = new TallBlockItem(BlockList.beach_door, new Item.Properties().group(vsco)).setRegistryName(BlockList.beach_door.getRegistryName()),			
				ItemList.bookshelf = new BlockItem(BlockList.bookshelf, new Item.Properties().group(vsco)).setRegistryName(BlockList.bookshelf.getRegistryName()),
				ItemList.crate = new BlockItem(BlockList.crate, new Item.Properties().group(vsco)).setRegistryName(BlockList.crate.getRegistryName()),
								
				ItemList.bricks = new BlockItem(BlockList.bricks, new Item.Properties().group(vsco)).setRegistryName(BlockList.bricks.getRegistryName()),		
				ItemList.wall_navy = new BlockItem(BlockList.wall_navy, new Item.Properties().group(vsco)).setRegistryName(BlockList.wall_navy.getRegistryName()),
				ItemList.wall_yellow = new BlockItem(BlockList.wall_yellow, new Item.Properties().group(vsco)).setRegistryName(BlockList.wall_yellow.getRegistryName()),
				ItemList.wall_blue = new BlockItem(BlockList.wall_blue, new Item.Properties().group(vsco)).setRegistryName(BlockList.wall_blue.getRegistryName()),
				ItemList.wall_pink = new BlockItem(BlockList.wall_pink, new Item.Properties().group(vsco)).setRegistryName(BlockList.wall_pink.getRegistryName()),
				ItemList.wall_brown = new BlockItem(BlockList.wall_brown, new Item.Properties().group(vsco)).setRegistryName(BlockList.wall_brown.getRegistryName()),
				ItemList.blue_stripes = new BlockItem(BlockList.blue_stripes, new Item.Properties().group(vsco)).setRegistryName(BlockList.blue_stripes.getRegistryName()),
				ItemList.black_stripes = new BlockItem(BlockList.black_stripes, new Item.Properties().group(vsco)).setRegistryName(BlockList.black_stripes.getRegistryName()),
				ItemList.black_spots = new BlockItem(BlockList.black_spots, new Item.Properties().group(vsco)).setRegistryName(BlockList.black_spots.getRegistryName()),
				ItemList.pink_plaid = new BlockItem(BlockList.pink_plaid, new Item.Properties().group(vsco)).setRegistryName(BlockList.pink_plaid.getRegistryName()),
				ItemList.blue_plaid = new BlockItem(BlockList.blue_plaid, new Item.Properties().group(vsco)).setRegistryName(BlockList.blue_plaid.getRegistryName()),
										
				ItemList.small_table = new BlockItem(BlockList.small_table, new Item.Properties().group(vsco)).setRegistryName(BlockList.small_table.getRegistryName()),	
				ItemList.shelf = new BlockItem(BlockList.shelf, new Item.Properties().group(vsco)).setRegistryName(BlockList.shelf.getRegistryName()),	
				ItemList.shelf1 = new BlockItem(BlockList.shelf1, new Item.Properties().group(vsco)).setRegistryName(BlockList.shelf1.getRegistryName()),
				ItemList.shelf2 = new BlockItem(BlockList.shelf2, new Item.Properties().group(vsco)).setRegistryName(BlockList.shelf2.getRegistryName()),
								
				ItemList.chair = new BlockItem(BlockList.chair, new Item.Properties().group(vsco)).setRegistryName(BlockList.chair.getRegistryName()),					
				ItemList.curtain = new BlockItem(BlockList.curtain, new Item.Properties().group(vsco)).setRegistryName(BlockList.curtain.getRegistryName()),
				ItemList.pillow = new BlockItem(BlockList.pillow, new Item.Properties().group(vsco)).setRegistryName(BlockList.pillow.getRegistryName()),
				ItemList.pole = new BlockItem(BlockList.pole, new Item.Properties().group(vsco)).setRegistryName(BlockList.pole.getRegistryName()),				
				ItemList.lamp = new BlockItem(BlockList.lamp, new Item.Properties().group(vsco)).setRegistryName(BlockList.lamp.getRegistryName()),	
				ItemList.white_lamp = new BlockItem(BlockList.white_lamp, new Item.Properties().group(vsco)).setRegistryName(BlockList.white_lamp.getRegistryName()),		
				ItemList.room_lamp = new BlockItem(BlockList.room_lamp, new Item.Properties().group(vsco)).setRegistryName(BlockList.room_lamp.getRegistryName()),
				ItemList.salt_lamp = new BlockItem(BlockList.salt_lamp, new Item.Properties().group(vsco)).setRegistryName(BlockList.salt_lamp.getRegistryName()),
						
				ItemList.trampoline = new BlockItem(BlockList.trampoline, new Item.Properties().group(vsco)).setRegistryName(BlockList.trampoline.getRegistryName()),
						
				
				ItemList.rainbow_fairy_lights_horizontal = new BlockItem(BlockList.rainbow_fairy_lights_horizontal, new Item.Properties().group(vsco)).setRegistryName(BlockList.rainbow_fairy_lights_horizontal.getRegistryName()),		
				ItemList.rainbow_fairy_lights_verticle = new BlockItem(BlockList.rainbow_fairy_lights_verticle, new Item.Properties().group(vsco)).setRegistryName(BlockList.rainbow_fairy_lights_verticle.getRegistryName()),	
				ItemList.white_fairy_lights_horizontal = new BlockItem(BlockList.white_fairy_lights_horizontal, new Item.Properties().group(vsco)).setRegistryName(BlockList.white_fairy_lights_horizontal.getRegistryName()),	
				ItemList.white_fairy_lights_verticle = new BlockItem(BlockList.white_fairy_lights_verticle, new Item.Properties().group(vsco)).setRegistryName(BlockList.white_fairy_lights_verticle.getRegistryName()),	
					
				
				ItemList.fan = new BlockItem(BlockList.fan, new Item.Properties().group(vsco)).setRegistryName(BlockList.fan.getRegistryName()),	
				ItemList.ukulele = new UkuleleBlockItem(BlockList.ukulele, new Item.Properties().group(vsco)).setRegistryName(BlockList.ukulele.getRegistryName()),	
						
				ItemList.shirts = new BlockItem(BlockList.shirts, new Item.Properties().group(vsco)).setRegistryName(BlockList.shirts.getRegistryName()),	
				ItemList.summer_shirts = new BlockItem(BlockList.summer_shirts, new Item.Properties().group(vsco)).setRegistryName(BlockList.summer_shirts.getRegistryName()),	
				ItemList.vans = new BlockItem(BlockList.vans, new Item.Properties().group(vsco)).setRegistryName(BlockList.vans.getRegistryName()),	
				ItemList.blue_checkered_vans = new BlockItem(BlockList.blue_checkered_vans, new Item.Properties().group(vsco)).setRegistryName(BlockList.blue_checkered_vans.getRegistryName()),	
				ItemList.black_checkered_vans = new BlockItem(BlockList.black_checkered_vans, new Item.Properties().group(vsco)).setRegistryName(BlockList.black_checkered_vans.getRegistryName()),	
				ItemList.pink_checkered_vans = new BlockItem(BlockList.pink_checkered_vans, new Item.Properties().group(vsco)).setRegistryName(BlockList.pink_checkered_vans.getRegistryName()),	
				ItemList.yellow_vans = new BlockItem(BlockList.yellow_vans, new Item.Properties().group(vsco)).setRegistryName(BlockList.yellow_vans.getRegistryName()),	
				ItemList.orange_checkered_vans = new BlockItem(BlockList.orange_checkered_vans, new Item.Properties().group(vsco)).setRegistryName(BlockList.orange_checkered_vans.getRegistryName()),	
				ItemList.yellow_checkered_vans = new BlockItem(BlockList.yellow_checkered_vans, new Item.Properties().group(vsco)).setRegistryName(BlockList.yellow_checkered_vans.getRegistryName()),	
				ItemList.gray_checkered_vans = new BlockItem(BlockList.gray_checkered_vans, new Item.Properties().group(vsco)).setRegistryName(BlockList.gray_checkered_vans.getRegistryName()),	
				ItemList.red_checkered_vans = new BlockItem(BlockList.red_checkered_vans, new Item.Properties().group(vsco)).setRegistryName(BlockList.red_checkered_vans.getRegistryName()),	
				ItemList.checkered_vans = new BlockItem(BlockList.checkered_vans, new Item.Properties().group(vsco)).setRegistryName(BlockList.checkered_vans.getRegistryName()),	
				ItemList.birkenstocks = new BlockItem(BlockList.birkenstocks, new Item.Properties().group(vsco)).setRegistryName(BlockList.birkenstocks.getRegistryName()),	
				ItemList.dark_birkenstocks = new BlockItem(BlockList.dark_birkenstocks, new Item.Properties().group(vsco)).setRegistryName(BlockList.dark_birkenstocks.getRegistryName()),																					
				ItemList.white_birkenstocks = new BlockItem(BlockList.white_birkenstocks, new Item.Properties().group(vsco)).setRegistryName(BlockList.white_birkenstocks.getRegistryName()),	
				
				ItemList.tropical_plant = new BlockItem(BlockList.tropical_plant, new Item.Properties().group(vsco)).setRegistryName(BlockList.tropical_plant.getRegistryName()),	
				ItemList.house_plant = new BlockItem(BlockList.house_plant, new Item.Properties().group(vsco)).setRegistryName(BlockList.house_plant.getRegistryName()),	
						
				ItemList.hanging_plant = new BlockItem(BlockList.hanging_plant, new Item.Properties().group(vsco)).setRegistryName(BlockList.hanging_plant.getRegistryName()),
				ItemList.wall_plant = new BlockItem(BlockList.wall_plant, new Item.Properties().group(vsco)).setRegistryName(BlockList.wall_plant.getRegistryName()),
						
				
				ItemList.succulent_short = new BlockItem(BlockList.succulent_short, new Item.Properties().group(vsco)).setRegistryName(BlockList.succulent_short.getRegistryName()),	
				ItemList.succulent_tall = new BlockItem(BlockList.succulent_tall, new Item.Properties().group(vsco)).setRegistryName(BlockList.succulent_tall.getRegistryName()),	
				ItemList.succulent_spiky = new BlockItem(BlockList.succulent_spiky, new Item.Properties().group(vsco)).setRegistryName(BlockList.succulent_spiky.getRegistryName()),	
				ItemList.succulent_box = new BlockItem(BlockList.succulent_box, new Item.Properties().group(vsco)).setRegistryName(BlockList.succulent_box.getRegistryName()),	
				ItemList.bamboo = new BlockItem(BlockList.bamboo, new Item.Properties().group(vsco)).setRegistryName(BlockList.bamboo.getRegistryName()),	
				ItemList.orchid = new BlockItem(BlockList.orchid, new Item.Properties().group(vsco)).setRegistryName(BlockList.orchid.getRegistryName()),	
				ItemList.vase1 = new BlockItem(BlockList.vase1, new Item.Properties().group(vsco)).setRegistryName(BlockList.vase1.getRegistryName()),	
				ItemList.vase2 = new BlockItem(BlockList.vase2, new Item.Properties().group(vsco)).setRegistryName(BlockList.vase2.getRegistryName()),	
								
				ItemList.mushroom_terrarium = new BlockItem(BlockList.mushroom_terrarium, new Item.Properties().group(vsco)).setRegistryName(BlockList.mushroom_terrarium.getRegistryName()),
				ItemList.plant_terrarium = new BlockItem(BlockList.plant_terrarium, new Item.Properties().group(vsco)).setRegistryName(BlockList.plant_terrarium.getRegistryName()),
								
				
				ItemList.calendula = new BlockItem(BlockList.calendula, new Item.Properties().group(vsco)).setRegistryName(BlockList.calendula.getRegistryName()),																				
				ItemList.calluna = new BlockItem(BlockList.calluna, new Item.Properties().group(vsco)).setRegistryName(BlockList.calluna.getRegistryName()),																				
				ItemList.desert_poppy = new BlockItem(BlockList.desert_poppy, new Item.Properties().group(vsco)).setRegistryName(BlockList.desert_poppy.getRegistryName()),																				
				ItemList.hyacinth = new BlockItem(BlockList.hyacinth, new Item.Properties().group(vsco)).setRegistryName(BlockList.hyacinth.getRegistryName()),																				
				ItemList.marigold = new BlockItem(BlockList.marigold, new Item.Properties().group(vsco)).setRegistryName(BlockList.marigold.getRegistryName()),																				
				ItemList.pale_rose_bush = new TallBlockItem(BlockList.pale_rose_bush, new Item.Properties().group(vsco)).setRegistryName(BlockList.pale_rose_bush.getRegistryName()),																				
				ItemList.petunia = new BlockItem(BlockList.petunia, new Item.Properties().group(vsco)).setRegistryName(BlockList.petunia.getRegistryName()),		
				ItemList.sunflower = new TallBlockItem(BlockList.sunflower, new Item.Properties().group(vsco)).setRegistryName(BlockList.sunflower.getRegistryName()),																				
				ItemList.purple_coneflower = new BlockItem(BlockList.purple_coneflower, new Item.Properties().group(vsco)).setRegistryName(BlockList.purple_coneflower.getRegistryName()),																				
				ItemList.buttercup = new BlockItem(BlockList.buttercup, new Item.Properties().group(vsco)).setRegistryName(BlockList.buttercup.getRegistryName()),																				
				ItemList.black_eyed_susan = new BlockItem(BlockList.black_eyed_susan, new Item.Properties().group(vsco)).setRegistryName(BlockList.black_eyed_susan.getRegistryName()),																				
			//	ItemList.lily_flower = new LilyFlowerItem(BlockList.lily_flower, new Item.Properties().group(vsco)).setRegistryName(BlockList.lily_flower.getRegistryName()),
						
				ItemList.vine = new BlockItem(BlockList.vine, new Item.Properties().group(vsco)).setRegistryName(BlockList.vine.getRegistryName()),		
				ItemList.ivy = new BlockItem(BlockList.ivy, new Item.Properties().group(vsco)).setRegistryName(BlockList.ivy.getRegistryName()),	
											
				ItemList.mushroom_print = new Item(new Item.Properties().group(vsco)).setRegistryName(location("mushroom_print")),														
				ItemList.poppy_print = new Item(new Item.Properties().group(vsco)).setRegistryName(location("poppy_print")),														
				ItemList.apple_print = new Item(new Item.Properties().group(vsco)).setRegistryName(location("apple_print")),														
				ItemList.flower_print = new Item(new Item.Properties().group(vsco)).setRegistryName(location("flower_print")),														
				ItemList.butterfly_print = new Item(new Item.Properties().group(vsco)).setRegistryName(location("butterfly_print")),																								
				
				ItemList.hydro_flask_black = new HydroFlaskItem(BlockList.hydro_flask_black, new Item.Properties().group(vsco).maxStackSize(1)).setRegistryName(BlockList.hydro_flask_black.getRegistryName()),
				ItemList.hydro_flask_blue = new HydroFlaskItem(BlockList.hydro_flask_blue, new Item.Properties().group(vsco).maxStackSize(1)).setRegistryName(BlockList.hydro_flask_blue.getRegistryName()),
				ItemList.hydro_flask_cyan = new HydroFlaskItem(BlockList.hydro_flask_cyan, new Item.Properties().group(vsco).maxStackSize(1)).setRegistryName(BlockList.hydro_flask_cyan.getRegistryName()),
				ItemList.hydro_flask_green = new HydroFlaskItem(BlockList.hydro_flask_green, new Item.Properties().group(vsco).maxStackSize(1)).setRegistryName(BlockList.hydro_flask_green.getRegistryName()),
				ItemList.hydro_flask_orange = new HydroFlaskItem(BlockList.hydro_flask_orange, new Item.Properties().group(vsco).maxStackSize(1)).setRegistryName(BlockList.hydro_flask_orange.getRegistryName()),
				ItemList.hydro_flask_purple = new HydroFlaskItem(BlockList.hydro_flask_purple, new Item.Properties().group(vsco).maxStackSize(1)).setRegistryName(BlockList.hydro_flask_purple.getRegistryName()),
				ItemList.hydro_flask_red = new HydroFlaskItem(BlockList.hydro_flask_red, new Item.Properties().group(vsco).maxStackSize(1)).setRegistryName(BlockList.hydro_flask_red.getRegistryName()),
				ItemList.hydro_flask_rose = new HydroFlaskItem(BlockList.hydro_flask_rose, new Item.Properties().group(vsco).maxStackSize(1)).setRegistryName(BlockList.hydro_flask_rose.getRegistryName()),
				ItemList.hydro_flask_royal = new HydroFlaskItem(BlockList.hydro_flask_royal, new Item.Properties().group(vsco).maxStackSize(1)).setRegistryName(BlockList.hydro_flask_royal.getRegistryName()),
				ItemList.hydro_flask_teal = new HydroFlaskItem(BlockList.hydro_flask_teal, new Item.Properties().group(vsco).maxStackSize(1)).setRegistryName(BlockList.hydro_flask_teal.getRegistryName()),
				ItemList.hydro_flask_yellow = new HydroFlaskItem(BlockList.hydro_flask_yellow, new Item.Properties().group(vsco).maxStackSize(1)).setRegistryName(BlockList.hydro_flask_yellow.getRegistryName()),
				ItemList.hydro_flask = new HydroFlaskItem(BlockList.hydro_flask, new Item.Properties().group(vsco).maxStackSize(1)).setRegistryName(BlockList.hydro_flask.getRegistryName()),

				ItemList.frog = new Item(new Item.Properties().group(vsco)).setRegistryName(location("frog")),		
				ItemList.koi_bucket = new  FishBucketItem(EntityRegistry.KOI, Fluids.WATER, (new Item.Properties()).maxStackSize(1).group(vsco)).setRegistryName(location("koi_bucket")),
				
				ItemList.cassava = new BlockItem(BlockList.cassava, new Item.Properties().group(vsco)).setRegistryName(BlockList.cassava.getRegistryName()),		
				ItemList.tea_leaves_seeds = new BlockItem(BlockList.tea_leaves_plant, new Item.Properties().group(vsco)).setRegistryName(location("tea_leaves_seeds")),
								
				ItemList.tea_leaves = new Item(new Item.Properties().group(vsco)).setRegistryName(location("tea_leaves")),		
				ItemList.green_tea_leaves = new Item(new Item.Properties().group(vsco)).setRegistryName(location("green_tea_leaves")),		
				ItemList.black_tea_leaves = new Item(new Item.Properties().group(vsco)).setRegistryName(location("black_tea_leaves")),		
				ItemList.coffee_beans = new BlockItem(BlockList.coffee_plant, new Item.Properties().group(vsco)).setRegistryName(location("coffee_beans")),		
				ItemList.roasted_coffee_beans = new Item(new Item.Properties().group(vsco)).setRegistryName(location("roasted_coffee_beans")),		
								
				ItemList.dragonfruit = new BlockItem(BlockList.dragonfruit, new Item.Properties().group(vsco).food(FoodList.dragonfruit)).setRegistryName(BlockList.dragonfruit.getRegistryName()),
				ItemList.tapioca = new Item(new Item.Properties().group(vsco).food(FoodList.tapioca)).setRegistryName(location("tapioca")),				
				ItemList.avocado = new Item(new Item.Properties().group(vsco).food(FoodList.avocado)).setRegistryName(location("avocado")),
				
				ItemList.avocado_toast = new Item(new Item.Properties().group(vsco).food(FoodList.avocado_toast)).setRegistryName(location("avocado_toast")),
				ItemList.berry_toast = new Item(new Item.Properties().group(vsco).food(FoodList.berry_toast)).setRegistryName(location("berry_toast")),
				ItemList.jam = new BlockItem(BlockList.jam, new Item.Properties().group(vsco)).setRegistryName(BlockList.jam.getRegistryName()),																				
				
				ItemList.pie = new BlockItem(BlockList.pie, new Item.Properties().group(vsco)).setRegistryName(BlockList.pie.getRegistryName()),																				
						
				ItemList.icecream = new Item(new Item.Properties().group(vsco).food(FoodList.icecream)).setRegistryName(location("icecream")),
				ItemList.popsicle = new Item(new Item.Properties().group(vsco).food(FoodList.popsicle)).setRegistryName(location("popsicle")),
			
				
				ItemList.glass = new Item(new Item.Properties().group(vsco)).setRegistryName(location("glass")),		
				ItemList.mug = new Item(new Item.Properties().group(vsco)).setRegistryName(location("mug")),		
				ItemList.cup = new Item(new Item.Properties().group(vsco)).setRegistryName(location("cup")),		
								
				ItemList.dragonfruit_smoothie = new DrinkGlassItem(BlockList.dragonfruit_smoothie, new Item.Properties().group(vsco).containerItem(ItemList.glass).maxStackSize(1)).setRegistryName(BlockList.dragonfruit_smoothie.getRegistryName()),
				ItemList.berry_smoothie = new DrinkGlassItem(BlockList.berry_smoothie, new Item.Properties().group(vsco).containerItem(ItemList.glass).maxStackSize(1)).setRegistryName(BlockList.berry_smoothie.getRegistryName()),
				ItemList.coffee = new DrinkCoffeeItem(BlockList.coffee, new Item.Properties().group(vsco).containerItem(ItemList.mug).maxStackSize(1)).setRegistryName(BlockList.coffee.getRegistryName()),
				ItemList.latte = new DrinkLatteItem(BlockList.latte, new Item.Properties().group(vsco).containerItem(ItemList.mug).maxStackSize(1)).setRegistryName(BlockList.latte.getRegistryName()),
				ItemList.matcha_boba_tea = new DrinkCupItem(BlockList.matcha_boba_tea, new Item.Properties().group(vsco).containerItem(ItemList.cup).maxStackSize(1)).setRegistryName(BlockList.matcha_boba_tea.getRegistryName()),
				ItemList.thai_boba_tea = new DrinkCupItem(BlockList.thai_boba_tea, new Item.Properties().group(vsco).containerItem(ItemList.cup).maxStackSize(1)).setRegistryName(BlockList.thai_boba_tea.getRegistryName()),
				
				ItemList.chocolate_milk = new MilkBucketItem((new Item.Properties()).containerItem(Items.BUCKET).maxStackSize(1).group(vsco)).setRegistryName(location("chocolate_milk")),
						
						
				
				ItemList.metal_straw = new Item(new Item.Properties().group(vsco)).setRegistryName(location("metal_straw")),		
				ItemList.metal_straw_dragonfruit_smoothie = new DrinkGlassItem(BlockList.metal_straw_dragonfruit_smoothie, new Item.Properties().group(vsco).containerItem(ItemList.glass).maxStackSize(1)).setRegistryName(BlockList.metal_straw_dragonfruit_smoothie.getRegistryName()),
				ItemList.metal_straw_berry_smoothie = new DrinkGlassItem(BlockList.metal_straw_berry_smoothie, new Item.Properties().group(vsco).containerItem(ItemList.glass).maxStackSize(1)).setRegistryName(BlockList.metal_straw_berry_smoothie.getRegistryName()),
																				
				ItemList.metal_straw_matcha_boba_tea = new DrinkCupItem(BlockList.metal_straw_matcha_boba_tea, new Item.Properties().group(vsco).containerItem(ItemList.cup).maxStackSize(1)).setRegistryName(BlockList.metal_straw_matcha_boba_tea.getRegistryName()),
				ItemList.metal_straw_thai_boba_tea = new DrinkCupItem(BlockList.metal_straw_thai_boba_tea, new Item.Properties().group(vsco).containerItem(ItemList.cup).maxStackSize(1)).setRegistryName(BlockList.metal_straw_thai_boba_tea.getRegistryName()),
						
				ItemList.lemonade = new HydroFlaskItem(BlockList.lemonade, new Item.Properties().group(vsco).maxStackSize(1)).setRegistryName(BlockList.lemonade.getRegistryName()),
				ItemList.basket = new BlockItem(BlockList.basket, new Item.Properties().group(vsco)).setRegistryName(BlockList.basket.getRegistryName()),	
				ItemList.star = new BlockItem(BlockList.star, new Item.Properties().group(vsco)).setRegistryName(BlockList.star.getRegistryName()),	
				ItemList.presents = new BlockItem(BlockList.presents, new Item.Properties().group(vsco)).setRegistryName(BlockList.presents.getRegistryName()),	
												
				
				ItemList.vsco = new Item(new Item.Properties()).setRegistryName(location("vsco")),
				
				ItemList.orange_scrucnhie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_orange")),
				ItemList.blue_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_blue")),
				ItemList.red_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_red")),
				ItemList.cyan_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_cyan")),
				ItemList.magenta_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_magenta")),
				ItemList.purple_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_purple")),
				ItemList.white_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_white")),
				ItemList.yellow_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_yellow")),
				ItemList.black_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_black")),
				ItemList.green_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_green")),
				ItemList.black_spotted_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_spotted_black")),
				ItemList.red_spotted_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_spotted_red")),
				ItemList.white_spotted_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_spotted_white")),
				ItemList.navy_striped_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_striped_navy")),
				ItemList.pink_striped_scrunchie = new Item(new Item.Properties().group(vsco)).setRegistryName(location("scrunchie_striped_pink")),
						
				ItemList.cyan_backpack = new BackpackItem(ArmorMaterialList.backpack, EquipmentSlotType.CHEST, new Item.Properties().group(vsco)).setRegistryName(location("backpack_cyan")),
				ItemList.black_backpack = new BackpackItem(ArmorMaterialList.backpack_black, EquipmentSlotType.CHEST, new Item.Properties().group(vsco)).setRegistryName(location("backpack_black")),
				ItemList.green_backpack = new BackpackItem(ArmorMaterialList.backpack_green, EquipmentSlotType.CHEST, new Item.Properties().group(vsco)).setRegistryName(location("backpack_green")),
				ItemList.gray_backpack = new BackpackItem(ArmorMaterialList.backpack_gray, EquipmentSlotType.CHEST, new Item.Properties().group(vsco)).setRegistryName(location("backpack_gray")),
				ItemList.pink_backpack = new BackpackItem(ArmorMaterialList.backpack_pink, EquipmentSlotType.CHEST, new Item.Properties().group(vsco)).setRegistryName(location("backpack_pink")),
				ItemList.light_blue_backpack = new BackpackItem(ArmorMaterialList.backpack_light_blue, EquipmentSlotType.CHEST, new Item.Properties().group(vsco)).setRegistryName(location("backpack_light_blue")),
				ItemList.yellow_backpack = new BackpackItem(ArmorMaterialList.backpack_yellow, EquipmentSlotType.CHEST, new Item.Properties().group(vsco)).setRegistryName(location("backpack_yellow")),
				ItemList.red_backpack = new BackpackItem(ArmorMaterialList.backpack_red, EquipmentSlotType.CHEST, new Item.Properties().group(vsco)).setRegistryName(location("backpack_red")),
				ItemList.rose_backpack = new BackpackItem(ArmorMaterialList.backpack_rose, EquipmentSlotType.CHEST, new Item.Properties().group(vsco)).setRegistryName(location("backpack_rose")),
				ItemList.violet_backpack = new BackpackItem(ArmorMaterialList.backpack_violet, EquipmentSlotType.CHEST, new Item.Properties().group(vsco)).setRegistryName(location("backpack_violet")),					
				
				ItemList.pink_and_white_flower_crown = new FlowerCrownItem(ArmorMaterialList.pink_and_white_flower_crown, EquipmentSlotType.HEAD, new Item.Properties().group(vsco)).setRegistryName(location("pink_and_white_flower_crown")),
				ItemList.petunia_flower_crown = new FlowerCrownItem(ArmorMaterialList.petunia_flower_crown, EquipmentSlotType.HEAD, new Item.Properties().group(vsco)).setRegistryName(location("petunia_flower_crown")),
				ItemList.oxeye_daisy_flower_crown = new FlowerCrownItem(ArmorMaterialList.oxeye_daisy_flower_crown, EquipmentSlotType.HEAD, new Item.Properties().group(vsco)).setRegistryName(location("oxeye_daisy_flower_crown")),
				ItemList.dandelion_flower_crown = new FlowerCrownItem(ArmorMaterialList.dandelion_flower_crown, EquipmentSlotType.HEAD, new Item.Properties().group(vsco)).setRegistryName(location("dandelion_flower_crown")),
				ItemList.azure_bluet_flower_crown = new FlowerCrownItem(ArmorMaterialList.azure_bluet_flower_crown, EquipmentSlotType.HEAD, new Item.Properties().group(vsco)).setRegistryName(location("azure_bluet_flower_crown")),
																																						
				
				ItemList.airpods = new AirpodsItem(ArmorMaterialList.airpods, EquipmentSlotType.HEAD, new Item.Properties().group(vsco)).setRegistryName(location("airpods")),
				ItemList.blackpods = new AirpodsItem(ArmorMaterialList.blackpods, EquipmentSlotType.HEAD, new Item.Properties().group(vsco)).setRegistryName(location("blackpods")),
				ItemList.sunglasses = new SunglassesItem(ArmorMaterialList.sunglasses, EquipmentSlotType.HEAD, new Item.Properties().group(vsco)).setRegistryName(location("sunglasses")),
				ItemList.necklace = new NecklaceItem(ArmorMaterialList.necklace, EquipmentSlotType.CHEST, new Item.Properties().group(vsco)).setRegistryName(location("necklace")),
				ItemList.hat = new HatItem(ArmorMaterialList.hat, EquipmentSlotType.HEAD, new Item.Properties().group(vsco)).setRegistryName(location("hat")),
						
				
				ItemList.bun = new BunItem(ArmorMaterialList.bun, EquipmentSlotType.HEAD, new Item.Properties().group(vsco)).setRegistryName(location("bun")),
				ItemList.ponytail = new PonytailItem(ArmorMaterialList.ponytail, EquipmentSlotType.HEAD, new Item.Properties().group(vsco)).setRegistryName(location("ponytail")),
				ItemList.music_disc_shine_on_top = new MusicDiscModItem(13, SoundMod.SHINE_ON_TOP, new Item.Properties().maxStackSize(1).group(vsco).rarity(Rarity.RARE)).setRegistryName(location("music_disc_shine_on_top")),
				ItemList.music_disc_ultimately = new MusicDiscModItem(14, SoundMod.ULTIMATELY, new Item.Properties().maxStackSize(1).group(vsco).rarity(Rarity.RARE)).setRegistryName(location("music_disc_ultimately")),
				ItemList.music_disc_bubblegum = new MusicDiscModItem(15, SoundMod.BUBBLEGUM, new Item.Properties().maxStackSize(1).group(vsco).rarity(Rarity.RARE)).setRegistryName(location("music_disc_bubblegum")),
				ItemList.music_disc_sunflower_feelings = new MusicDiscModItem(16, SoundMod.SUNFLOWER_FEELINGS, new Item.Properties().maxStackSize(1).group(vsco).rarity(Rarity.RARE)).setRegistryName(location("music_disc_sunflower_feelings")),
				ItemList.music_disc_airplane_mode = new MusicDiscModItem(17, SoundMod.AIRPLANE_MODE, new Item.Properties().maxStackSize(1).group(vsco).rarity(Rarity.RARE)).setRegistryName(location("music_disc_airplane_mode")),
				ItemList.music_disc_oblivion = new MusicDiscModItem(18, SoundMod.OBLIVION, new Item.Properties().maxStackSize(1).group(vsco).rarity(Rarity.RARE)).setRegistryName(location("music_disc_oblivion"))
				
					
					);
			EntityMod.registerEntitySpawnEggs(event);
			logger.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BlockList.tropical_plant = new DecorationBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.STONE)).setRegistryName(location("tropical_plant")),
				BlockList.house_plant = new DecorationBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.STONE)).setRegistryName(location("house_plant")),
						
				BlockList.wall_navy = new Block(Block.Properties.create(Material.ROCK, MaterialColor.LAPIS).hardnessAndResistance(1.25F, 4.2F)).setRegistryName(location("wall_navy")),
				BlockList.wall_blue = new Block(Block.Properties.create(Material.ROCK, MaterialColor.LIGHT_BLUE).hardnessAndResistance(1.25F, 4.2F)).setRegistryName(location("wall_blue")),
				BlockList.wall_pink = new Block(Block.Properties.create(Material.ROCK, MaterialColor.PINK).hardnessAndResistance(1.25F, 4.2F)).setRegistryName(location("wall_pink")),
				BlockList.wall_brown = new Block(Block.Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(1.25F, 4.2F)).setRegistryName(location("wall_brown")),
				BlockList.wall_yellow = new Block(Block.Properties.create(Material.ROCK, MaterialColor.YELLOW).hardnessAndResistance(1.25F, 4.2F)).setRegistryName(location("wall_yellow")),
																
			
				BlockList.mahogany_planks = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(location("mahogany_planks")),
				BlockList.ash_planks = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(location("ash_planks")),
				BlockList.walnut_planks = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(location("walnut_planks")),
				BlockList.beach_planks = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(location("beach_planks")),
				BlockList.white_painted_planks = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(location("white_painted_planks")),
				BlockList.varnished_planks = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(location("varnished_planks")),
				BlockList.crate = new HorizontalFullBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).notSolid().hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(location("crate")),
				BlockList.bookshelf = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(location("bookshelf")),
								
						
				BlockList.hydro_flask = new HydroFlaskBlock(Block.Properties.create(Material.EARTH, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.METAL)).setRegistryName(location("hydro_flask")),	
				BlockList.hydro_flask_black = new HydroFlaskBlock(Block.Properties.create(Material.EARTH, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.METAL)).setRegistryName(location("hydro_flask_black")),
				BlockList.hydro_flask_yellow = new HydroFlaskBlock(Block.Properties.create(Material.EARTH, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.METAL)).setRegistryName(location("hydro_flask_yellow")),
				BlockList.hydro_flask_cyan = new HydroFlaskBlock(Block.Properties.create(Material.EARTH, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.METAL)).setRegistryName(location("hydro_flask_cyan")),
				BlockList.hydro_flask_blue = new HydroFlaskBlock(Block.Properties.create(Material.EARTH, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.METAL)).setRegistryName(location("hydro_flask_blue")),
				BlockList.hydro_flask_red = new HydroFlaskBlock(Block.Properties.create(Material.EARTH, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.METAL)).setRegistryName(location("hydro_flask_red")),
				BlockList.hydro_flask_royal = new HydroFlaskBlock(Block.Properties.create(Material.EARTH, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.METAL)).setRegistryName(location("hydro_flask_royal")),
				BlockList.hydro_flask_purple = new HydroFlaskBlock(Block.Properties.create(Material.EARTH, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.METAL)).setRegistryName(location("hydro_flask_purple")),
				BlockList.hydro_flask_green = new HydroFlaskBlock(Block.Properties.create(Material.EARTH, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.METAL)).setRegistryName(location("hydro_flask_green")),
				BlockList.hydro_flask_teal = new HydroFlaskBlock(Block.Properties.create(Material.EARTH, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.METAL)).setRegistryName(location("hydro_flask_teal")),
				BlockList.hydro_flask_orange = new HydroFlaskBlock(Block.Properties.create(Material.EARTH, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.METAL)).setRegistryName(location("hydro_flask_orange")),
				BlockList.hydro_flask_rose = new HydroFlaskBlock(Block.Properties.create(Material.EARTH, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.METAL)).setRegistryName(location("hydro_flask_rose")),
				BlockList.succulent_spiky = new DecorationBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.STONE)).setRegistryName(location("succulent_spiky")),
				BlockList.succulent_short = new DecorationBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.STONE)).setRegistryName(location("succulent_short")),
				BlockList.succulent_tall = new DecorationBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.STONE)).setRegistryName(location("succulent_tall")),
				BlockList.mushroom_terrarium = new DecorationBlock(Block.Properties.create(Material.GLASS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.STONE)).setRegistryName(location("mushroom_terrarium")),
				BlockList.plant_terrarium = new DecorationBlock(Block.Properties.create(Material.GLASS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.STONE)).setRegistryName(location("plant_terrarium")),
				BlockList.vase1 = new DecorationBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.STONE)).setRegistryName(location("vase1")),
				BlockList.vase2 = new DecorationBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.STONE)).setRegistryName(location("vase2")),
												
				BlockList.orchid = new DecorationBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.STONE)).setRegistryName(location("orchid")),
				BlockList.bamboo = new DecorationBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.STONE)).setRegistryName(location("bamboo")),
				BlockList.small_table = new SmallTableBlock(Block.Properties.create(Material.ROCK, MaterialColor.SNOW).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.STONE)).setRegistryName(location("small_table")),
				BlockList.mahogany_door = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(3.0F).sound(SoundType.WOOD)).setRegistryName(location("mahogany_door")),
				BlockList.ash_door = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(3.0F).sound(SoundType.WOOD)).setRegistryName(location("ash_door")),
				BlockList.walnut_door = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(3.0F).sound(SoundType.WOOD)).setRegistryName(location("walnut_door")),
				BlockList.beach_door = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(3.0F).sound(SoundType.WOOD)).setRegistryName(location("beach_door")),
				BlockList.lamp = new HorizontalDecorationBlock(Block.Properties.create(Material.GLASS, MaterialColor.STONE).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.METAL).lightValue(12)).setRegistryName(location("lamp")),
				BlockList.white_lamp = new HorizontalDecorationBlock(Block.Properties.create(Material.GLASS, MaterialColor.STONE).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.METAL).lightValue(12)).setRegistryName(location("white_lamp")),			
				BlockList.room_lamp = new DecorationBlock(Block.Properties.create(Material.GLASS, MaterialColor.STONE).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS).lightValue(12)).setRegistryName(location("room_lamp")),
				BlockList.salt_lamp = new HorizontalDecorationBlockTranslucent(Block.Properties.create(Material.GLASS, MaterialColor.YELLOW).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.METAL).lightValue(8)).setRegistryName(location("salt_lamp")),			
				BlockList.jam = new DecorationBlock(Block.Properties.create(Material.GLASS, MaterialColor.RED).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS)).setRegistryName(location("jam")),
									
				BlockList.shirts = new ClosetBlock(Block.Properties.create(Material.ROCK, MaterialColor.SNOW).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.METAL)).setRegistryName(location("shirts")),
				BlockList.summer_shirts = new ClosetBlock(Block.Properties.create(Material.ROCK, MaterialColor.SNOW).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.METAL)).setRegistryName(location("summer_shirts")),
				BlockList.mahogany_stairs = new ModdedStairsBlock(BlockList.mahogany_planks.getDefaultState(), Block.Properties.from(BlockList.mahogany_planks)).setRegistryName(location("mahogany_stairs")),
				BlockList.ash_stairs = new ModdedStairsBlock(BlockList.ash_planks.getDefaultState(), Block.Properties.from(BlockList.ash_planks)).setRegistryName(location("ash_stairs")),
				BlockList.beach_stairs = new ModdedStairsBlock(BlockList.beach_planks.getDefaultState(), Block.Properties.from(BlockList.beach_planks)).setRegistryName(location("beach_stairs")),
				BlockList.walnut_stairs = new ModdedStairsBlock(BlockList.walnut_planks.getDefaultState(), Block.Properties.from(BlockList.walnut_planks)).setRegistryName(location("walnut_stairs")),
				BlockList.varnished_stairs = new ModdedStairsBlock(BlockList.varnished_planks.getDefaultState(), Block.Properties.from(BlockList.varnished_planks)).setRegistryName(location("varnished_stairs")),
				BlockList.white_painted_stairs = new ModdedStairsBlock(BlockList.white_painted_planks.getDefaultState(), Block.Properties.from(BlockList.white_painted_planks)).setRegistryName(location("white_painted_stairs")),		
				BlockList.ukulele = new UkuleleBlock(Block.Properties.create(Material.WOOD, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.WOOD)).setRegistryName(location("ukulele")),
				BlockList.succulent_box = new DecorationBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.STONE)).setRegistryName(location("succulent_box")),
				BlockList.vans = new VansBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("vans")),
				BlockList.blue_checkered_vans = new VansBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("blue_checkered_vans")),
				BlockList.pink_checkered_vans = new VansBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("pink_checkered_vans")),
				BlockList.yellow_vans = new VansBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("yellow_vans")),
				BlockList.orange_checkered_vans = new VansBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("orange_checkered_vans")),
				BlockList.yellow_checkered_vans = new VansBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("yellow_checkered_vans")),
				BlockList.checkered_vans = new VansBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("checkered_vans")),
				BlockList.black_checkered_vans = new VansBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("black_checkered_vans")),
				BlockList.gray_checkered_vans = new VansBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("gray_checkered_vans")),
				BlockList.red_checkered_vans = new VansBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("red_checkered_vans")),
				BlockList.birkenstocks = new BirkenstocksBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("birkenstocks")),
				BlockList.dark_birkenstocks = new BirkenstocksBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("dark_birkenstocks")),
				BlockList.white_birkenstocks = new BirkenstocksBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("white_birkenstocks")),				
				BlockList.fan = new CeilingDecorationBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.WOOD).lightValue(14)).setRegistryName(location("fan")),
				BlockList.dragonfruit_smoothie = new DrinkBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS)).setRegistryName(location("dragonfruit_smoothie")),
				BlockList.berry_smoothie = new DrinkBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS)).setRegistryName(location("berry_smoothie")),
				BlockList.coffee = new DrinkBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS)).setRegistryName(location("coffee")),
				BlockList.latte = new DrinkBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS)).setRegistryName(location("latte")),
				BlockList.thai_boba_tea = new DrinkBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS)).setRegistryName(location("thai_boba_tea")),
				BlockList.matcha_boba_tea = new DrinkBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS)).setRegistryName(location("matcha_boba_tea")),
				BlockList.metal_straw_thai_boba_tea = new DrinkBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS)).setRegistryName(location("metal_straw_thai_boba_tea")),
				BlockList.metal_straw_matcha_boba_tea = new DrinkBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS)).setRegistryName(location("metal_straw_matcha_boba_tea")),
				BlockList.metal_straw_dragonfruit_smoothie = new DrinkBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS)).setRegistryName(location("metal_straw_dragonfruit_smoothie")),
				BlockList.metal_straw_berry_smoothie = new DrinkBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS)).setRegistryName(location("metal_straw_berry_smoothie")),	
				BlockList.dragonfruit = new DragonfruitBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setRegistryName(location("dragonfruit"))	,	
				BlockList.tea_leaves_plant = new TeaLeavesBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setRegistryName(location("tea_leaves_plant")),		
				BlockList.coffee_plant = new CoffeePlantBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setRegistryName(location("coffee_plant")),	
				BlockList.cassava = new CassavaBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setRegistryName(location("cassava")),
				BlockList.white_fairy_lights_horizontal = new FairyLightsBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).notSolid().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS).lightValue(8)).setRegistryName(location("white_fairy_lights_horizontal")),
				BlockList.white_fairy_lights_verticle = new FairyLightsBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).notSolid().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS).lightValue(8)).setRegistryName(location("white_fairy_lights_verticle")),
				BlockList.rainbow_fairy_lights_horizontal = new FairyLightsBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).notSolid().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS).lightValue(8)).setRegistryName(location("rainbow_fairy_lights_horizontal")),
				BlockList.rainbow_fairy_lights_verticle = new FairyLightsBlock(Block.Properties.create(Material.GLASS, MaterialColor.WOOL).notSolid().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.GLASS).lightValue(8)).setRegistryName(location("rainbow_fairy_lights_verticle")),
				BlockList.curtain = new CurtainBlock(Block.Properties.create(Material.WOOL, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).notSolid().sound(SoundType.CLOTH)).setRegistryName(location("curtain")),
				BlockList.pole = new PoleBlock(Block.Properties.create(Material.ROCK, MaterialColor.WOOL).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.METAL)).setRegistryName(location("pole")),
				BlockList.black_stripes = new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.25F, 4.2F)).setRegistryName(location("black_stripes")),
				BlockList.blue_stripes = new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.LAPIS).hardnessAndResistance(1.25F, 4.2F)).setRegistryName(location("blue_stripes")),
				BlockList.black_spots = new Block(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.25F, 4.2F)).setRegistryName(location("black_spots")),
				BlockList.pillow = new HorizontalDecorationBlock(Block.Properties.create(Material.WOOL, MaterialColor.SNOW).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CLOTH)).setRegistryName(location("pillow")),
				BlockList.shelf = new HorizontalFullBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.WOOD)).setRegistryName(location("shelf")),
				BlockList.chair = new HorizontalDecorationBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.WOOD)).setRegistryName(location("chair")),
				BlockList.trampoline = new TrampolineBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(0.0F, 0.0F).sound(SoundTypeMod.TRAMPOLINE)).setRegistryName(location("trampoline")),
				BlockList.calendula = new FlowerBlock(Effects.SATURATION, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT)).setRegistryName(location("calendula")),		
				BlockList.calluna = new FlowerBlock(Effects.SATURATION, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT)).setRegistryName(location("calluna")),		
				BlockList.desert_poppy = new FlowerBlock(Effects.SATURATION, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT)).setRegistryName(location("desert_poppy")),		
				BlockList.hyacinth = new FlowerBlock(Effects.SATURATION, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT)).setRegistryName(location("hyacinth")),		
				BlockList.marigold = new FlowerBlock(Effects.SATURATION, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT)).setRegistryName(location("marigold")),		
				BlockList.pale_rose_bush = new TallFlowerBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT)).setRegistryName(location("pale_rose_bush")),		
				BlockList.petunia = new FlowerBlock(Effects.SATURATION, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT)).setRegistryName(location("petunia")),		
				BlockList.sunflower = new TallFlowerBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT)).setRegistryName(location("sunflower")),		
				BlockList.purple_coneflower = new FlowerBlock(Effects.SATURATION, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT)).setRegistryName(location("purple_coneflower")),		
				BlockList.buttercup = new FlowerBlock(Effects.SATURATION, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT)).setRegistryName(location("buttercup"))	,	
				BlockList.black_eyed_susan = new FlowerBlock(Effects.SATURATION, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT)).setRegistryName(location("black_eyed_susan")),		
				BlockList.vine = new FairyLightsBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).notSolid().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.PLANT)).setRegistryName(location("vine")),
				BlockList.ivy = new FairyLightsBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).notSolid().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.PLANT)).setRegistryName(location("ivy")),
				BlockList.blue_plaid = new Block(Block.Properties.create(Material.WOOL, MaterialColor.LIGHT_BLUE).hardnessAndResistance(0.2F, 0.2F).sound(SoundType.CLOTH)).setRegistryName(location("blue_plaid")),
				BlockList.pink_plaid = new Block(Block.Properties.create(Material.WOOL, MaterialColor.PINK).hardnessAndResistance(0.2F, 0.2F).sound(SoundType.CLOTH)).setRegistryName(location("pink_plaid")),
				BlockList.potted_calendula = new FlowerPotBlock(BlockList.calendula, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F, 0.0F)).setRegistryName(location("potted_calendula")),		
				BlockList.potted_calluna = new FlowerPotBlock(BlockList.calluna, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F, 0.0F)).setRegistryName(location("potted_calluna")),		
				BlockList.potted_desert_poppy = new FlowerPotBlock(BlockList.desert_poppy, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F, 0.0F)).setRegistryName(location("potted_desert_poppy")),		
				BlockList.potted_hyacinth = new FlowerPotBlock(BlockList.hyacinth, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F, 0.0F)).setRegistryName(location("potted_hyacinth")),		
				BlockList.potted_marigold = new FlowerPotBlock(BlockList.marigold, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F, 0.0F)).setRegistryName(location("potted_marigold")),		
				BlockList.potted_petunia = new FlowerPotBlock(BlockList.petunia, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F, 0.0F)).setRegistryName(location("potted_petunia")),		
				BlockList.potted_purple_coneflower = new FlowerPotBlock(BlockList.purple_coneflower, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F, 0.0F)).setRegistryName(location("potted_purple_coneflower")),		
				BlockList.potted_buttercup = new FlowerPotBlock(BlockList.buttercup, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F, 0.0F)).setRegistryName(location("potted_buttercup"))	,	
				BlockList.potted_black_eyed_susan = new FlowerPotBlock(BlockList.black_eyed_susan, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F, 0.0F)).setRegistryName(location("potted_black_eyed_susan")),	
				BlockList.bricks = new Block(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(location("bricks")),
				//.lily_flower = new LilyFlowerBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.0F).sound(SoundType.PLANT)).setRegistryName(location("lily_flower"))		,
				BlockList.wall_plant = new WallDecorationBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.WOOD)).setRegistryName(location("wall_plant")),
				BlockList.hanging_plant = new CeilingDecorationBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.WOOD)).setRegistryName(location("hanging_plant")),
				BlockList.shelf1 = new WallDecorationBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.WOOD)).setRegistryName(location("shelf1")),
				BlockList.shelf2 = new WallDecorationBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRASS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.WOOD)).setRegistryName(location("shelf2")),
				BlockList.pie = new PieBlock(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)).setRegistryName(location("pie")),
				BlockList.lemonade = new HydroFlaskBlock(Block.Properties.create(Material.GLASS, MaterialColor.IRON).hardnessAndResistance(0.0F, 0.0F).doesNotBlockMovement().sound(SoundType.GLASS)).setRegistryName(location("lemonade")),	
				BlockList.basket = new HorizontalDecorationBlock(Block.Properties.create(Material.WOOD, MaterialColor.STONE).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.WOOD)).setRegistryName(location("basket"))	,		
				BlockList.star = new HorizontalDecorationBlock(Block.Properties.create(Material.WOOD, MaterialColor.STONE).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.WOOD)).setRegistryName(location("star"))	,		
				BlockList.presents = new HorizontalDecorationBlock(Block.Properties.create(Material.WOOD, MaterialColor.STONE).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.WOOD)).setRegistryName(location("presents"))			
					
					
					);
			
			logger.info("Blocks registered.");
		}
		
		
			
		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
		{
			event.getRegistry().registerAll
			(
			//	EntityRegistry.VSCO_DECAL
						
				);
			EntityMod.RegisterEntityWorldSpawn();
			
			logger.info("Entities registered.");
		}
		@SubscribeEvent
		public static void registerBiomes(final RegistryEvent.Register<Biome> event)
		{
			event.getRegistry().registerAll
			(
		//	BiomeMod.poppy_fields_biome = new PoppyFieldsBiome()
						
				);
		
	//			BiomeMod.registerBiomes();
			logger.info("Biomes registered.");
		}
		public static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}

	public static ResourceLocation location(String name) {
		// TODO Auto-generated method stub
		return new ResourceLocation(modid, name);
	}	
}

