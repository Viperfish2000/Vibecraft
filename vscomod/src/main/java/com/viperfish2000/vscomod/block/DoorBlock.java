package com.viperfish2000.vscomod.block;

import net.minecraft.block.Block;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;

public class DoorBlock extends net.minecraft.block.DoorBlock {
		   public DoorBlock(Block.Properties builder) {
	      super(builder);
	      this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(OPEN, Boolean.valueOf(false)).with(HINGE, DoorHingeSide.LEFT).with(POWERED, Boolean.valueOf(false)).with(HALF, DoubleBlockHalf.LOWER));

	   }


}