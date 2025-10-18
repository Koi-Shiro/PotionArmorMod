package com.biens.PotionArmor.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ArmorBlessingEffect extends MobEffect {

    private static final Map<UUID, ItemStack[]> originalArmor = new HashMap<>();

    private static final int DURATION = 12000;
    private static final boolean SHOW_PARTICLES = true; 
    private static final boolean SHOW_ICON = true;      

    private final int color;

    public ArmorBlessingEffect(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap map, int amplifier) {
        super.addAttributeModifiers(entity, map, amplifier);

        UUID id = entity.getUUID();

        if (!originalArmor.containsKey(id)) {
            ItemStack[] armorCopy = new ItemStack[4];
            for (int i = 0; i < 4; i++) {
                armorCopy[i] = entity.getItemBySlot(EquipmentSlot.values()[i + 2]).copy(); 
            }
            originalArmor.put(id, armorCopy);

            giveArmor(entity, amplifier);
        }
    }

    private void giveArmor(LivingEntity entity, int amplifier) {
        boolean netherite = amplifier > 0;
        if (netherite) {
            entity.setItemSlot(EquipmentSlot.HEAD, enchanted(Items.NETHERITE_HELMET));
            entity.setItemSlot(EquipmentSlot.CHEST, enchanted(Items.NETHERITE_CHESTPLATE));
            entity.setItemSlot(EquipmentSlot.LEGS, enchanted(Items.NETHERITE_LEGGINGS));
            entity.setItemSlot(EquipmentSlot.FEET, enchanted(Items.NETHERITE_BOOTS));
        } else {
            entity.setItemSlot(EquipmentSlot.HEAD, enchanted(Items.DIAMOND_HELMET));
            entity.setItemSlot(EquipmentSlot.CHEST, enchanted(Items.DIAMOND_CHESTPLATE));
            entity.setItemSlot(EquipmentSlot.LEGS, enchanted(Items.DIAMOND_LEGGINGS));
            entity.setItemSlot(EquipmentSlot.FEET, enchanted(Items.DIAMOND_BOOTS));
        }
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap map, int amplifier) {
        super.removeAttributeModifiers(entity, map, amplifier);
        UUID id = entity.getUUID();

        // Restore original armor
        if (originalArmor.containsKey(id)) {
            ItemStack[] armorCopy = originalArmor.get(id);
            entity.setItemSlot(EquipmentSlot.HEAD, armorCopy[3]);
            entity.setItemSlot(EquipmentSlot.CHEST, armorCopy[2]);
            entity.setItemSlot(EquipmentSlot.LEGS, armorCopy[1]);
            entity.setItemSlot(EquipmentSlot.FEET, armorCopy[0]);
            originalArmor.remove(id);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return false;
    }

    private static ItemStack enchanted(Item item) {
        ItemStack stack = new ItemStack(item);
        stack.enchant(Enchantments.UNBREAKING, 5);
        stack.enchant(Enchantments.ALL_DAMAGE_PROTECTION, 4); 
        stack.enchant(Enchantments.PROJECTILE_PROTECTION, 4); 
        stack.enchant(Enchantments.BLAST_PROTECTION, 4); 
        stack.enchant(Enchantments.VANISHING_CURSE, 1); 
        stack.enchant(Enchantments.BINDING_CURSE,1);
        return stack;
    }

    public static int getDuration() { return DURATION; }
    public static boolean showParticles() { return SHOW_PARTICLES; }
    public static boolean showIcon() { return SHOW_ICON; }
}
