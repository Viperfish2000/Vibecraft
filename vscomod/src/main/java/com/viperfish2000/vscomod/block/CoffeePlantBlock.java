package com.viperfish2000.vscomod.block;

import com.viperfish2000.vscomod.item.ItemList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CoffeePlantBlock extends CropsBlock {
	

	   public CoffeePlantBlock(Block.Properties builder) {
	      super(builder);
	   }
	  
	   @Override
	   protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		      return state.getBlock() == Blocks.SAND;
		   }
	  
	   @Override
	   @OnlyIn(Dist.CLIENT)
	   protected IItemProvider getSeedsItem() {
	      return ItemList.coffee_beans;
	   }
	

}