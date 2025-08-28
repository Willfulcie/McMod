package net.mcreator.test.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.test.procedures.SodiumSwordWaterExplodeProcedure;
import net.mcreator.test.procedures.SodiumSwordExplodeProcedure;

import javax.annotation.Nullable;

public class SodiumSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10, 4f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("test:sodium_sword_repair_items")));

	public SodiumSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 0f, -3f));
	}

	@Override
	public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		super.hurtEnemy(itemstack, entity, sourceentity);
		SodiumSwordExplodeProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		if (equipmentSlot == EquipmentSlot.MAINHAND)
			SodiumSwordWaterExplodeProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}