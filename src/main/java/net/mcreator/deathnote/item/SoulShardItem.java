
package net.mcreator.deathnote.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SoulShardItem extends Item {
	public SoulShardItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
