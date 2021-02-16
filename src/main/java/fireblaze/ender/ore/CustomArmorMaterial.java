package fireblaze.ender.ore;

import java.util.function.Supplier;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;

import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import net.minecraft.util.Lazy;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

// Make sure it is an enum
public enum CustomArmorMaterial implements ArmorMaterial {

    // I honestly don't know what type of syntax this is... It's supposed to be an enum ¯\_(ツ)_/¯
     ENDERTHYST("enderthyst", 40, new int[] {6, 9, 11, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 1.0F, () -> {
         return Ingredient.ofItems(Items.GUNPOWDER);
     });

    // Base durability is multiplied by the durabilityMultiplier, I have no idea why
    private static final int[] BASE_DURABILITY = new int[] { 13, 15, 16, 11 };

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final Lazy<Ingredient> repairIngredientSupplier;


    // Constructor function
    CustomArmorMaterial(String string_1, int int_1, int[] ints_1, int int_2, SoundEvent soundEvent_1, float float_1, Supplier<Ingredient> supplier_1) {
        this.name = string_1;
        this.durabilityMultiplier = int_1;
        this.protectionAmounts = ints_1;
        this.enchantability = int_2;
        this.equipSound = soundEvent_1;
        this.toughness = float_1;
        this.repairIngredientSupplier = new Lazy(supplier_1);
    }

    // Must implement these since we are implementing ArmorMaterial
    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) { return this.protectionAmounts[slot.getEntitySlotId()]; }

    @Override
    public int getEnchantability() { return this.enchantability; }

    @Override
    public SoundEvent getEquipSound() { return this.equipSound; }

    @Override
    public Ingredient getRepairIngredient() { return this.repairIngredientSupplier.get(); }

    @Environment(EnvType.CLIENT)
    public String getName() { return this.name; }

    public float getToughness() { return this.toughness; }

    // Knockback succ
    @Override
    public float getKnockbackResistance() { return 0; }

}