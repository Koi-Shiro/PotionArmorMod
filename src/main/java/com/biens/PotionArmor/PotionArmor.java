package com.biens.PotionArmor;

import com.biens.PotionArmor.Potion.ModPotions;
import com.biens.PotionArmor.effect.ModEffects;
//import com.biens.PotionArmor.item.ModItems;
import com.biens.PotionArmor.event.ModEvent;

import net.minecraft.world.item.LingeringPotionItem;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.SplashPotionItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

@Mod(PotionArmor.MODID)
public class PotionArmor {
    public static final String MODID = "potionarmor";

    public PotionArmor() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEffects.register(bus);
        ModPotions.register(bus);
        //ModItems.register(bus);

        MinecraftForge.EVENT_BUS.register(this);

        bus.addListener(this::commonSetup);
    }

        private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModEvent::registerBrewingRecipes);
    }
}
