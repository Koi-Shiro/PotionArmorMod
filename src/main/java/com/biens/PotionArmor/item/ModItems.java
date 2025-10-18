/*package com.biens.PotionArmor.item;

import com.biens.PotionArmor.PotionArmor;
import com.biens.PotionArmor.Potion.ModPotions;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PotionItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PotionArmor.MODID);

    // Diamond Armor Blessing Potions
    public static final RegistryObject<Item> ARMOR_BLESSING_POTION_ITEM = ITEMS.register(
            "armored_potion",
            () -> new PotionItem(new Item.Properties().stacksTo(1))
    );

    public static final RegistryObject<Item> ARMOR_BLESSING_SPLASH_ITEM = ITEMS.register(
            "armored_splash",
            () -> new PotionItem(new Item.Properties().stacksTo(1))
    );

    public static final RegistryObject<Item> ARMOR_BLESSING_LINGERING_ITEM = ITEMS.register(
            "armored_lingering",
            () -> new PotionItem(new Item.Properties().stacksTo(1))
    );

    // Netherite Armor Blessing Potions
    public static final RegistryObject<Item> UPGRADED_ARMOR_BLESSING_POTION_ITEM = ITEMS.register(
            "upgraded_armored_potion",
            () -> new PotionItem(new Item.Properties().stacksTo(1))
    );

    public static final RegistryObject<Item> UPGRADED_ARMOR_BLESSING_SPLASH_ITEM = ITEMS.register(
            "upgraded_armored_splash",
            () -> new PotionItem(new Item.Properties().stacksTo(1))
    );

    public static final RegistryObject<Item> UPGRADED_ARMOR_BLESSING_LINGERING_ITEM = ITEMS.register(
            "upgraded_armored_lingering",
            () -> new PotionItem(new Item.Properties().stacksTo(1))
    );

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

}
*/