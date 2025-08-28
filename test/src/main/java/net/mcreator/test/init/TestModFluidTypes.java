/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.test.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.test.fluid.types.SaltwaterFluidType;
import net.mcreator.test.TestMod;

public class TestModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, TestMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> SALT_WATER_TYPE = REGISTRY.register("salt_water", () -> new SaltwaterFluidType());
}