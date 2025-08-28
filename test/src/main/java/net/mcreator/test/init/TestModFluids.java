/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.test.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.test.fluid.SaltwaterFluid;
import net.mcreator.test.TestMod;

public class TestModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, TestMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> SALT_WATER = REGISTRY.register("salt_water", () -> new SaltwaterFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_SALT_WATER = REGISTRY.register("flowing_salt_water", () -> new SaltwaterFluid.Flowing());

	@EventBusSubscriber(Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(SALT_WATER.get(), ChunkSectionLayer.TRANSLUCENT);
			ItemBlockRenderTypes.setRenderLayer(FLOWING_SALT_WATER.get(), ChunkSectionLayer.TRANSLUCENT);
		}
	}
}