package net.rodsduarte.mythrilore.block;

import java.util.function.Supplier;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rodsduarte.mythrilore.MythrilOreMod;
import net.rodsduarte.mythrilore.item.ModItems;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MythrilOreMod.MOD_ID);

    public static final RegistryObject<Block> MYTHRIL_BLOCK = registerBlock("mythril_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5.0f, 6.0f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> MYTHRIL_ORE = registerBlock("mythril_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(8, 12)));

    public static final RegistryObject<Block> DEEPSLATE_MYTHRIL_ORE = registerBlock("deepslate_mythril_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(4.0F, 4.0F), UniformInt.of(8, 12)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
