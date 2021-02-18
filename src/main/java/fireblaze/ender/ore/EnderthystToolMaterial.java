package fireblaze.ender.ore;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EnderthystToolMaterial implements ToolMaterial {

    public static final EnderthystToolMaterial INSTANCE = new EnderthystToolMaterial();

    private int durability = 3065;
    private float miningSpeedMultiplier = 10.0F;
    public float attackDamage = 5.0F;
    public int miningLevel = 5;
    public int enchantability = 25;
    public Ingredient repairIngredient = Ingredient.ofItems(Items.DIAMOND);

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeedMultiplier;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return miningLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.DIAMOND_PICKAXE);
    }
    
}