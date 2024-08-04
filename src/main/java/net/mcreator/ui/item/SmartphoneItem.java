
package net.mcreator.ui.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.ui.itemgroup.ItemsItemGroup;
import net.mcreator.ui.UiModElements;

@UiModElements.ModElement.Tag
public class SmartphoneItem extends UiModElements.ModElement {
	@ObjectHolder("ui:smartphone")
	public static final Item block = null;

	public SmartphoneItem(UiModElements instance) {
		super(instance, 101);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("smartphone");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
