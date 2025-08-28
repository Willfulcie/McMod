package net.mcreator.test.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class WickerWhipItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 300, 4f, 0, 30, TagKey.create(Registries.ITEM, ResourceLocation.parse("test:wicker_whip_repair_items")));

	public WickerWhipItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 1f, -3.6f));
	}
}