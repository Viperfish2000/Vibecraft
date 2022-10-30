package com.viperfish2000.vscomod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class CeilingDecorationBlock extends Block {
	   protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 10.0D, 2.0D, 14.0D, 14.0D, 14.0D);

	   public CeilingDecorationBlock(Block.Properties builder) {
	      super(builder);
	   }

	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	      return SHAPE;
	   }

	   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		      return hasSolidSideOnTop(worldIn, pos.up());
		   }


	   public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		      return true;
		   }

}