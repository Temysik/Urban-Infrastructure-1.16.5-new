
package net.mcreator.ui.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import net.mcreator.ui.UiModElements;

@UiModElements.ModElement.Tag
public class MarkItemGroup extends UiModElements.ModElement {
	public MarkItemGroup(UiModElements instance) {
		super(instance, 87);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmark") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.GOLD_ORE);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
