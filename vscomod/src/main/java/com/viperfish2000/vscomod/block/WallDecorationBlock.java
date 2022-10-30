package com.viperfish2000.vscomod.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class WallDecorationBlock extends Block {
   public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
   protected static final VoxelShape NORTH = Block.makeCuboidShape(5.0D, 0.0D, 10.0D, 11.0D, 10.0D, 16.0D);
   protected static final VoxelShape SOUTH = Block.makeCuboidShape(5.0D, 0.0D, 0.0D, 11.0D, 10.0D, 6.0D);
   protected static final VoxelShape WEST = Block.makeCuboidShape(10.0D, 0.0D, 5.0D, 16.0D, 10.0D, 11.0D);
   protected static final VoxelShape EAST = Block.makeCuboidShape(0.0D, 0.0D, 5.0D, 6.0D, 10.0D, 11.0D);

   public WallDecorationBlock(Block.Properties properties) {
      super(properties);
      this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
   }

   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      switch((Direction)state.get(FACING)) {
      case EAST:
      default:
         return EAST;
      case WEST:
         return WEST;
      case SOUTH:
         return SOUTH;
      case NORTH:
         return NORTH;
      }
   }

   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
      Direction direction = state.get(FACING);
      BlockPos blockpos = pos.offset(direction.getOpposite());
      BlockState blockstate = worldIn.getBlockState(blockpos);
      return direction.getAxis().isHorizontal() && blockstate.isSolidSide(worldIn, blockpos, direction) && !blockstate.canProvidePower();
   }

   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
      return facing.getOpposite() == stateIn.get(FACING) && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
   }
   public BlockState rotate(BlockState state, Rotation rot) {
	      return state.with(FACING, rot.rotate(state.get(FACING)));
	   }



	   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	      builder.add(FACING);
	   }
	   @Nullable
	   public BlockState getStateForPlacement(BlockItemUseContext context) {
	      BlockState blockstate = this.getDefaultState();
	      IWorldReader iworldreader = context.getWorld();
	      BlockPos blockpos = context.getPos();
	      Direction[] adirection = context.getNearestLookingDirections();

	      for(Direction direction : adirection) {
	         if (direction.getAxis().isHorizontal()) {
	            Direction direction1 = direction.getOpposite();
	            blockstate = blockstate.with(FACING, direction1);
	            if (blockstate.isValidPosition(iworldreader, blockpos)) {
	               return blockstate;
	            }
	         }
	      }

	      return null;
	   }


}