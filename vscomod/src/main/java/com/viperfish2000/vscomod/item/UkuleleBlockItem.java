package com.viperfish2000.vscomod.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import com.viperfish2000.vscomod.sounds.SoundMod;

public class UkuleleBlockItem extends BlockItem {
   public UkuleleBlockItem(Block blockIn, Item.Properties builder) {
      super(blockIn, builder);
   }
   @Override
   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	      ItemStack itemstack = playerIn.getHeldItem(handIn);

	      worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundMod.UKULELE, SoundCategory.NEUTRAL, 0.5F, 1.0F);
	      playerIn.getCooldownTracker().setCooldown(this, 92);


	      playerIn.addStat(Stats.ITEM_USED.get(this));
	      return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
}
}