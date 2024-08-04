
package net.mcreator.ui.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.ui.itemgroup.CitiesInfrastrctureItemGroup;
import net.mcreator.ui.UiModElements;

import java.util.List;
import java.util.Collections;

@UiModElements.ModElement.Tag
public class TrashCanBigBlock extends UiModElements.ModElement {
	@ObjectHolder("ui:trash_can_big")
	public static final Block block = null;

	public TrashCanBigBlock(UiModElements instance) {
		super(instance, 126);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(CitiesInfrastrctureItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends Block {
		public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0).notSolid()
					.setOpaque((bs, br, bp) -> false));
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
			setRegistryName("trash_can_big");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			Vector3d offset = state.getOffset(world, pos);
			switch ((Direction) state.get(FACING)) {
				case SOUTH :
				default :
					return VoxelShapes.or(makeCuboidShape(2, 0, 15.9, 0, 2, 13.9), makeCuboidShape(2, 0, 1.9, 0, 2, -0.1),
							makeCuboidShape(16, 0, 1.9, 14, 2, -0.1), makeCuboidShape(16, 0, 15.9, 14, 2, 13.9),
							makeCuboidShape(17, 2, 17, -1, 3, -1), makeCuboidShape(16, 3, 17, 0, 18, 16), makeCuboidShape(17, 3, 17, 16, 18, 0),
							makeCuboidShape(0, 3, 17, -1, 18, 0), makeCuboidShape(17, 3, 0, -1, 18, -1), makeCuboidShape(-1, 15, 10, -2, 18, 7),
							makeCuboidShape(18, 15, 10, 17, 18, 7), makeCuboidShape(19, 16, 9, 18, 17, 8), makeCuboidShape(-2, 16, 9, -3, 17, 8))

							.withOffset(offset.x, offset.y, offset.z);
				case NORTH :
					return VoxelShapes.or(makeCuboidShape(14, 0, 0.1, 16, 2, 2.1), makeCuboidShape(14, 0, 14.1, 16, 2, 16.1),
							makeCuboidShape(0, 0, 14.1, 2, 2, 16.1), makeCuboidShape(0, 0, 0.1, 2, 2, 2.1), makeCuboidShape(-1, 2, -1, 17, 3, 17),
							makeCuboidShape(0, 3, -1, 16, 18, 0), makeCuboidShape(-1, 3, -1, 0, 18, 16), makeCuboidShape(16, 3, -1, 17, 18, 16),
							makeCuboidShape(-1, 3, 16, 17, 18, 17), makeCuboidShape(17, 15, 6, 18, 18, 9), makeCuboidShape(-2, 15, 6, -1, 18, 9),
							makeCuboidShape(-3, 16, 7, -2, 17, 8), makeCuboidShape(18, 16, 7, 19, 17, 8))

							.withOffset(offset.x, offset.y, offset.z);
				case EAST :
					return VoxelShapes.or(makeCuboidShape(15.9, 0, 14, 13.9, 2, 16), makeCuboidShape(1.9, 0, 14, -0.1, 2, 16),
							makeCuboidShape(1.9, 0, 0, -0.1, 2, 2), makeCuboidShape(15.9, 0, 0, 13.9, 2, 2), makeCuboidShape(17, 2, -1, -1, 3, 17),
							makeCuboidShape(17, 3, 0, 16, 18, 16), makeCuboidShape(17, 3, -1, 0, 18, 0), makeCuboidShape(17, 3, 16, 0, 18, 17),
							makeCuboidShape(0, 3, -1, -1, 18, 17), makeCuboidShape(10, 15, 17, 7, 18, 18), makeCuboidShape(10, 15, -2, 7, 18, -1),
							makeCuboidShape(9, 16, -3, 8, 17, -2), makeCuboidShape(9, 16, 18, 8, 17, 19))

							.withOffset(offset.x, offset.y, offset.z);
				case WEST :
					return VoxelShapes.or(makeCuboidShape(0.1, 0, 2, 2.1, 2, 0), makeCuboidShape(14.1, 0, 2, 16.1, 2, 0),
							makeCuboidShape(14.1, 0, 16, 16.1, 2, 14), makeCuboidShape(0.1, 0, 16, 2.1, 2, 14), makeCuboidShape(-1, 2, 17, 17, 3, -1),
							makeCuboidShape(-1, 3, 16, 0, 18, 0), makeCuboidShape(-1, 3, 17, 16, 18, 16), makeCuboidShape(-1, 3, 0, 16, 18, -1),
							makeCuboidShape(16, 3, 17, 17, 18, -1), makeCuboidShape(6, 15, -1, 9, 18, -2), makeCuboidShape(6, 15, 18, 9, 18, 17),
							makeCuboidShape(7, 16, 19, 8, 17, 18), makeCuboidShape(7, 16, -2, 8, 17, -3))

							.withOffset(offset.x, offset.y, offset.z);
			}
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
