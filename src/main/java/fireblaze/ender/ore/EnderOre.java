package fireblaze.ender.ore;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.structure.rule.BlockMatchRuleTest;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import net.minecraft.util.Identifier;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import net.minecraft.world.gen.GenerationStep;

import net.minecraft.item.ArmorItem;
import net.minecraft.entity.EquipmentSlot;


public class EnderOre implements ModInitializer {

	public static final Item ENDERTHYST_SHARD = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Block ENDERTHYST_ORE = new EnderthystOreBlock(FabricBlockSettings.copy(Blocks.ANCIENT_DEBRIS));
	public static final Item ENDERTHYST_INGOT = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	private static final ConfiguredFeature<?,?> ENDERTHYST_ORE_END = Feature.ORE.configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), ENDERTHYST_ORE.getDefaultState(),9)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0,0,240))).spreadHorizontally().repeat(20);

	// Armor Variables
	public static final Item ENDERTHYST_HELMET     = new ArmorItem(CustomArmorMaterial.ENDERTHYST,  EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item ENDERTHYST_CHESTPLATE = new ArmorItem(CustomArmorMaterial.ENDERTHYST, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item ENDERTHYST_LEGGINGS   = new ArmorItem(CustomArmorMaterial.ENDERTHYST,  EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item ENDERTHYST_BOOTS      = new ArmorItem(CustomArmorMaterial.ENDERTHYST,  EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));
	

	@Override
	public void onInitialize() {

		Registry.register(Registry.ITEM,new Identifier("enderthyst","enderthyst_shard"), ENDERTHYST_SHARD);
		Registry.register(Registry.ITEM,new Identifier("enderthyst","enderthyst_ingot"), ENDERTHYST_INGOT); 
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

		// Register the tools
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_pickaxe"), new	 EnderthystPickaxe(new EnderthystToolMaterial(), pickaxeAttackDamage, pickaxeAttackSpeed, new Item.Settings().group(ItemGroup.TOOLS)));
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_axe"),     new	     EnderthystAxe(new EnderthystToolMaterial(),     axeAttackDamage,     axeAttackSpeed, new Item.Settings().group(ItemGroup.TOOLS)));
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_sword"),   new	   EnderthystSword(new EnderthystToolMaterial(),   swordAttackDamage,   swordAttackSpeed, new Item.Settings().group(ItemGroup.TOOLS)));
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_shovel"),  new	  EnderthystShovel(new EnderthystToolMaterial(),  shovelAttackDamage,  shovelAttackSpeed, new Item.Settings().group(ItemGroup.TOOLS)));
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_hoe"),     new	     EnderthystHoe(new EnderthystToolMaterial(),     hoeAttackDamage,     hoeAttackSpeed, new Item.Settings().group(ItemGroup.TOOLS)));


		// Register the armor
        Registry.register(Registry.ITEM, new Identifier("enderthyst",       "enderthyst_helmet"),   ENDERTHYST_HELMET);
        Registry.register(Registry.ITEM, new Identifier("enderthyst",   "enderthyst_chestplate"),   ENDERTHYST_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("enderthyst",     "enderthyst_leggings"),   ENDERTHYST_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("enderthyst",        "enderthyst_boots"),   ENDERTHYST_BOOTS);
		
		// // Register the block
		Registry.register(Registry.BLOCK, new Identifier("enderthyst", "enderthyst_ore"), ENDERTHYST_ORE);
		Registry.register(Registry.ITEM, new Identifier("enderthyst", "enderthyst_ore"), new BlockItem(ENDERTHYST_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		RegistryKey<ConfiguredFeature<?,?>> enderthystOreEnd = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("enderthyst", "enderthyst_ore_end"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, enderthystOreEnd.getValue(), ENDERTHYST_ORE_END);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, enderthystOreEnd);

	}
}