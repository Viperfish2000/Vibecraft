package com.viperfish2000.vscomod.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class PoleBlock extends HorizontalBlock {
	//   public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	
	   public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	protected static final VoxelShape SOUTH = Block.makeCuboidShape(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 2.0D);
	   protected static final VoxelShape NORTH = Block.makeCuboidShape(0.0D, 14.0D, 14.0D, 16.0D, 16.0D, 16.0D);
	   protected static final VoxelShape EAST = Block.makeCuboidShape(0.0D, 14.0D, 0.0D, 2.0D, 16.0D, 16.0D);
	   protected static final VoxelShape WEST = Block.makeCuboidShape(14.0D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D);


	 //  protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	   public PoleBlock(Block.Properties builder) {
	      super(builder);
	   //   this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.X));
	   }

	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		   switch(state.get(HORIZONTAL_FACING)) {
		      case NORTH:
		         return NORTH;
		      case SOUTH:
			         return SOUTH;
		      case WEST:
		    	  return WEST;
		      case EAST:
		      default:
		         return EAST;
		      }
	   }

	 


	   public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		      return true;
		   }
	   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		      builder.add(HORIZONTAL_FACING);
		   }
	/**
	   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		      Direction direction = state.get(FACING);
		      BlockPos blockpos = pos.offset(direction.getOpposite());
		      BlockState blockstate = worldIn.getBlockState(blockpos);
		      return direction.getAxis().isHorizontal() && Block.hasSolidSide(blockstate, worldIn, blockpos, direction) && !blockstate.canProvidePower();
		   }
		   **/
	   @Nullable
	   public BlockState getStateForPlacement(BlockItemUseContext context) {
	      BlockState blockstate = this.getDefaultState();
	      IWorldReader iworldreader = context.getWorld();
	      BlockPos blockpos = context.getPos();
	      Direction[] adirection = context.getNearestLookingDirections();

	      for(Direction direction : adirection) {
	         if (direction.getAxis().isHorizontal()) {
	            Direction direction1 = direction.getOpposite();
	            blockstate = blockstate.with(HORIZONTAL_FACING, direction1);
	            if (blockstate.isValidPosition(iworldreader, blockpos)) {
	               return blockstate;
	            }
	         }
	      }

	      return null;
	   }

	   /**
	    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
	    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
	    * returns its solidified counterpart.
	    * Note that this method should ideally consider only the specific face passed in.
	    */
	   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
	      return facing.getOpposite() == stateIn.get(HORIZONTAL_FACING) && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : stateIn;
	   }
		   /**
		    * @deprecated call via {@link IBlockState#getMobilityFlag()} whenever possible. Implementing/overriding is fine.
		    */
		   public PushReaction getPushReaction(BlockState state) {
		      return PushReaction.PUSH_ONLY;
		   }
}