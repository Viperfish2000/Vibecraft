package com.viperfish2000.vscomod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class DrinkBlock extends HorizontalBlock {
	   protected static final VoxelShape SHAPE = Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D);

	   public DrinkBlock(Block.Properties builder) {
	      super(builder);
	   }

	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	      return SHAPE;
	   }

	   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		      return hasSolidSideOnTop(worldIn, pos.down());
		   }

	   public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		      return true;
		   }
	   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		      builder.add(HORIZONTAL_FACING);
		   }

		   public BlockState getStateForPlacement(BlockItemUseContext context) {
		      return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
		   }

		   /**
		    * @deprecated call via {@link IBlockState#getMobilityFlag()} whenever possible. Implementing/overriding is fine.
		    */
		   public PushReaction getPushReaction(BlockState state) {
		      return PushReaction.PUSH_ONLY;
		   }
}