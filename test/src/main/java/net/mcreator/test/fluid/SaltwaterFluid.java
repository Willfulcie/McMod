package net.mcreator.test.fluid;

import org.apache.logging.log4j.core.util.Source;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.test.init.TestModItems;
import net.mcreator.test.init.TestModFluids;
import net.mcreator.test.init.TestModFluidTypes;
import net.mcreator.test.init.TestModBlocks;

public abstract class SaltwaterFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> TestModFluidTypes.SALT_WATER_TYPE.get(), () -> TestModFluids.SALT_WATER.get(), () -> TestModFluids.FLOWING_SALT_WATER.get())
			.explosionResistance(100f).tickRate(3).bucket(() -> TestModItems.SALT_WATER_BUCKET.get()).block(() -> (LiquidBlock) TestModBlocks.SALT_WATER.get());

	private SaltwaterFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.ASH;
	}

	public static class Source extends SaltwaterFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends SaltwaterFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}