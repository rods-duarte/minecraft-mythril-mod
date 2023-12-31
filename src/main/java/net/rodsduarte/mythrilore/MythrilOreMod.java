package net.rodsduarte.mythrilore;

import net.rodsduarte.mythrilore.block.ModBlocks;
import net.rodsduarte.mythrilore.item.ModCreativeModeTabs;
import net.rodsduarte.mythrilore.item.ModItems;
import software.bernie.geckolib.GeckoLib;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;



@Mod(MythrilOreMod.MOD_ID)
public class MythrilOreMod
{
    public static final String MOD_ID = "mythrilore";

    public MythrilOreMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.MYTHRIL_RAW);
            event.accept(ModItems.MYTHRIL_INGOT);
        }

        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.MYTHRIL_BLOCK);
        }

        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.MYTHRIL_ORE);
            event.accept(ModBlocks.DEEPSLATE_MYTHRIL_ORE);
        }

        if(event.getTab() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.MYTHRIL_SWORD);
            event.accept(ModItems.MYTHRIL_HELMET);
            event.accept(ModItems.MYTHRIL_CHESTPLATE);
            event.accept(ModItems.MYTHRIL_LEGGINGS);
            event.accept(ModItems.MYTHRIL_BOOTS);
        }

        if(event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.MYTHRIL_PICKAXE);
            event.accept(ModItems.MYTHRIL_AXE);
            event.accept(ModItems.MYTHRIL_SHOVEL);
            event.accept(ModItems.MYTHRIL_HOE);
        }

        if(event.getTab() == ModCreativeModeTabs.MYTHRIL_ORE_MOD_TAB) {
            event.accept(ModItems.MYTHRIL_RAW);
            event.accept(ModItems.MYTHRIL_INGOT);
            event.accept(ModBlocks.MYTHRIL_BLOCK);
            event.accept(ModBlocks.MYTHRIL_ORE);
            event.accept(ModBlocks.DEEPSLATE_MYTHRIL_ORE);
            event.accept(ModItems.MYTHRIL_SWORD);
            event.accept(ModItems.MYTHRIL_PICKAXE);
            event.accept(ModItems.MYTHRIL_AXE);
            event.accept(ModItems.MYTHRIL_SHOVEL);
            event.accept(ModItems.MYTHRIL_HOE);
            event.accept(ModItems.MYTHRIL_HELMET);
            event.accept(ModItems.MYTHRIL_CHESTPLATE);
            event.accept(ModItems.MYTHRIL_LEGGINGS);
            event.accept(ModItems.MYTHRIL_BOOTS);

        }

    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
