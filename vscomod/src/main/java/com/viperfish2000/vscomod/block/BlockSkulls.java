package com.viperfish2000.vscomod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.MobEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.SkullBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockSkulls extends SkullBlock {
	   protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	   public BlockSkulls(SkullBlock.ISkullType p_i48332_1_, Block.Properties builder) {
	      super(p_i48332_1_, builder);
	   }

	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	      return SHAPE;
	   }

	   protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      Block block = state.getBlock();
	     if(block!=Blocks.AIR||block != Blocks.WATER||block != Blocks.LAVA){
	    
	    	 
	    	 return  true ;}
	 
	   return false;  
	   }
	   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		      ItemStack itemstack = playerIn.getHeldItem(handIn);
		      EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(itemstack);
		      ItemStack itemstack1 = playerIn.getItemStackFromSlot(equipmentslottype);
		      if (itemstack1.isEmpty()) {
		         playerIn.setItemStackToSlot(equipmentslottype, itemstack.copy());
		         itemstack.setCount(0);
		         return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
		      } else {
		         return new ActionResult<>(ActionResultType.FAIL, itemstack);
		      }
		   }
	}