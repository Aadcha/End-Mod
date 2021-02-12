package fireblaze.ender.ore;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EnderthystToolMaterial implements ToolMaterial {

    public static final EnderthystToolMaterial INSTANCE = new EnderthystToolMaterial();

    @Override
    public int getDurability() {
        return 3065;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0F;
    }

    @Override
    public float getAttackDamage() {
        return 5.0F;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.DIAMOND_PICKAXE);
    }
    
}