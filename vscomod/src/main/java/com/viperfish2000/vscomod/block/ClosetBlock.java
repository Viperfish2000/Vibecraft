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

public class ClosetBlock extends HorizontalBlock {
	//   public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	   protected static final VoxelShape X_AABB = Block.makeCuboidShape(0.0D, 14.0D, 7.0D, 16.0D, 16.0D, 9.0D);
	   protected static final VoxelShape Z_AABB = Block.makeCuboidShape(7.0D, 14.0D, 0.0D, 9.0D, 16.0D, 16.0D);


	 //  protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	   public ClosetBlock(Block.Properties builder) {
	      super(builder);
	   //   this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.X));
	   }

	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		   switch(state.get(HORIZONTAL_FACING)) {
		      case NORTH:
		         return X_AABB;
		      case SOUTH:
			         return X_AABB;
		      case WEST:
		    	  return Z_AABB;
		      case EAST:
		      default:
		         return Z_AABB;
		      }
	   }

	   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		      return hasSolidSideOnTop(worldIn, pos.up());
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