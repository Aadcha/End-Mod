import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback.Registry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class CustomArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] { 13, 15, 16, 11 };
    private static final int A = 0;
    private static final int B = 0;
    private static final int C = 0;
    private static final int D = 0;
    private static final int[] PROTECTION_VALUES = new int[] { A, B, C, D };

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 69;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_Netherite;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RegisterItems.netherite);
    }

    @Override
    public String getName() {
        return "enderthyst";
    }

    @Override
    public float getToughness() {
        return 4;
    }

    @Override
    public float getKnockbackResistance() {
        return (float) 0.75;
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // TODO Auto-generated method stub
        return null;
    }
}

// Probably a ton of bugs in the next few lines
public class RegisterItems {

    public static ItemConvertible netherite;
    public static final ArmorMaterial enderthystArmor = new CustomArmorMaterial();
    public static final Item ENDERTHYST = new CustomMaterialItem(new Item.Settings().group(name.NAME)); //Possibly buggy due to name having spaces+apostrophes
     // If you made a new material, this is where you would note it.
     public static final Item ENDERTHYST_HELMET = new ArmorItem(enderthystArmor, EquipmentSlot.HEAD, new Item.Settings().group(name.NAME));
     public static final Item ENDERTHYST_CHESTPLATE = new ArmorItem(enderthystArmor, EquipmentSlot.CHEST, new Item.Settings().group(name.NAME));
     public static final Item ENDERTHYST_LEGGINGS = new ArmorItem(enderthystArmor, EquipmentSlot.LEGS, new Item.Settings().group(name.NAME));
     public static final Item ENDERTHYST_BOOTS = new ArmorItem(enderthystArmor, EquipmentSlot.FEET, new Item.Settings().group(name.NAME));
  
 }

 //variable names might need changing
 public static void register() {
    Registry.register(Registry.ITEM, new Identifier("name", "enderthyst"), ENDERTHYST);
    Registry.register(Registry.ITEM, new Identifier("name", "enderthyst_helmet"), ENDERTHYST_HELMET);
    Registry.register(Registry.ITEM, new Identifier("name", "enderthyst_chestplate"), ENDERTHYST_CHESTPLATE);
    Registry.register(Registry.ITEM, new Identifier("name", "enderthyst_leggings"), ENDERTHYST_LEGGINGS);
    Registry.register(Registry.ITEM, new Identifier("name", "enderthyst_boots"), ENDERTHYST_BOOTS);
}

public static final ItemGroup EXAMPLE_MOD_GROUP = FabricItemGroupBuilder.create(
    new Identifier("armor", "endermod")) //Possibly buggy since names might need to match variables
    .icon(() -> new ItemStack(RegisterItems.ENDERTHYST)) // This uses the model of the new material you created as an icon, but you can reference to whatever you like
    .build();

@Override
public void onInitialize() {
RegisterItems.register();
}