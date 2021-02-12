package fireblaze.ender.ore;

import net.minecraft.util.registry.Registry;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class EnderOre implements ModInitializer {

	public static final Item ENDERTHYST_SHARD = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	@Override
	public void onInitialize() {

		Registry.register(Registry.ITEM,new Identifier("enderthyst","enderthyst_shard"),ENDERTHYST_SHARD);

		/** The enderthyst tools */

		// A value of -1 for the attack damage will not change the default attack damage
		// A value of 0 will add 1 to the default attack damage, a value of 1 will add 2, etc...
		final int pickaxeAttackDamage = -1;
		final int axeAttackDamage     =  4;
		final int swordAttackDamage   =  3;
		final int shovelAttackDamage  = -1;
		final int hoeAttackDamage     = -1;

		// MUST BE NEGATIVE: the closer the value is to 0 the faster it will "reload??"
		// Swords should always be faster than axes
		final float pickaxeAttackSpeed =  -2.0F;
		final float axeAttackSpeed     =  -1.8F;
		final float swordAttackSpeed   =  -1.5F;
		final float shovelAttackSpeed  =  -2.0F;
		final float hoeAttackSpeed     =  -2.0F;

		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_pickaxe"), new EnderthystPickaxe(new EnderthystToolMaterial(), pickaxeAttackDamage, pickaxeAttackSpeed, new Item.Settings().group(ItemGroup.TOOLS)));
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_axe"),     new     EnderthystAxe(new EnderthystToolMaterial(),     axeAttackDamage,     axeAttackSpeed, new Item.Settings().group(ItemGroup.TOOLS)));
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_sword"),   new   EnderthystSword(new EnderthystToolMaterial(),   swordAttackDamage,   swordAttackSpeed, new Item.Settings().group(ItemGroup.TOOLS)));
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_shovel"),  new  EnderthystShovel(new EnderthystToolMaterial(),  shovelAttackDamage,  shovelAttackSpeed, new Item.Settings().group(ItemGroup.TOOLS)));
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_hoe"),     new     EnderthystHoe(new EnderthystToolMaterial(),     hoeAttackDamage,     hoeAttackSpeed, new Item.Settings().group(ItemGroup.TOOLS)));

	}
}