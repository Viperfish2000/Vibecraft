package com.viperfish2000.vscomod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class LilyFlowerBlock extends BushBlock {
	   protected static final VoxelShape LILY_PAD_AABB = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);

	   public LilyFlowerBlock(Block.Properties properties) {
	      super(properties);
	   }

	   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
	      super.onEntityCollision(state, worldIn, pos, entityIn);
	      if (entityIn instanceof BoatEntity) {
	         worldIn.destroyBlock(new BlockPos(pos), true);
	      }

	   }

	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	      return LILY_PAD_AABB;
	   }

	   protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      IFluidState ifluidstate = worldIn.getFluidState(pos);
	      return ifluidstate.getFluid() == Fluids.WATER || state.getMaterial() == Material.ICE;
	   }
	}