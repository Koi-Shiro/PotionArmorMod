package com.biens.PotionArmor.Potion;

import java.rmi.registry.Registry;

import com.biens.PotionArmor.PotionArmor;
import com.biens.PotionArmor.effect.ModEffects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, PotionArmor.MODID);

    public static final RegistryObject<Potion> ARMOR_BLESSING_POTION = POTIONS.register("armored_potion", () -> 
    new Potion(new MobEffectInstance(ModEffects.ARMOR_BLESSING.get(), 12000, 0)));

    public static final RegistryObject<Potion> UPGRADED_BLESSING_POTION = POTIONS.register("upgraded_armored_potion", () ->
    new Potion(new MobEffectInstance(ModEffects.ARMOR_BLESSING.get(), 10000, 1)));

    public static void register(IEventBus bus) {
        POTIONS.register(bus);
    }
}

