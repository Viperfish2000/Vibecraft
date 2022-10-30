
package com.viperfish2000.vscomod;

import com.viperfish2000.vscomod.item.ItemList;

//import harry.tutorialmod.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TutorialItemGroup extends ItemGroup
{
	public TutorialItemGroup() 
	{
		super("vsco");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(ItemList.vsco);
	}
}