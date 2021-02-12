package fireblaze.ender.ore;

import net.minecraft.util.registry.Registry;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class EnderOre implements ModInitializer {

	public static final Item ENDERTHYST = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	@Override
	public void onInitialize() {

		Registry.register(Registry.ITEM,new Identifier("enderthyst","enderthyst"),ENDERTHYST);

		/** The enderthyst tools */
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_pickaxe"), new EnderthystPickaxe(new EnderthystToolMaterial(), -1, 2, new Item.Settings().group(ItemGroup.TOOLS)));
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_axe"),     new     EnderthystAxe(new EnderthystToolMaterial(), -1, 2, new Item.Settings().group(ItemGroup.TOOLS)));
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_sword"),   new   EnderthystSword(new EnderthystToolMaterial(), -1, 2, new Item.Settings().group(ItemGroup.TOOLS)));
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_shovel"),  new  EnderthystShovel(new EnderthystToolMaterial(), -1, 2, new Item.Settings().group(ItemGroup.TOOLS)));
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_hoe"),     new     EnderthystHoe(new EnderthystToolMaterial(), -1, 2, new Item.Settings().group(ItemGroup.TOOLS)));

	}
}