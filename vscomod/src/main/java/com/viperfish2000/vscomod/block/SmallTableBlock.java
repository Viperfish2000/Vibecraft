package com.viperfish2000.vscomod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class SmallTableBlock extends Block {
	
	   public SmallTableBlock(Block.Properties builder) {
	      super(builder);
	   }

	

	   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		      return hasSolidSideOnTop(worldIn, pos.down());
		   }


	   public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		      return true;
		   }

}