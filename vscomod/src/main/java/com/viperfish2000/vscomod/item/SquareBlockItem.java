package com.viperfish2000.vscomod.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;

public class SquareBlockItem {
	public class TallBlockItem extends BlockItem {
		   public TallBlockItem(Block blockIn, Item.Properties builder) {
		      super(blockIn, builder);
		   }

		   protected boolean placeBlock(BlockItemUseContext context, BlockState state) {
		      context.getWorld().setBlockState(context.getPos().up(), Blocks.AIR.getDefaultState(), 27);
		      return super.placeBlock(context, state);
		   }
		}
}
