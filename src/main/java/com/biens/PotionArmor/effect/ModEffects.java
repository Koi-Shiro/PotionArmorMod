package com.biens.PotionArmor.effect;

import com.biens.PotionArmor.PotionArmor;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PotionArmor.MODID);

    public static final RegistryObject<MobEffect> ARMOR_BLESSING =
            EFFECTS.register("armor_blessing", () -> new ArmorBlessingEffect(0x00C8FF));

    public static final RegistryObject<MobEffect> UPGRADED_ARMOR_BLESSING =
            EFFECTS.register("upgraded_armor_blessing", () -> new ArmorBlessingEffect(0x5500FF));

    public static void register(IEventBus bus) {
        EFFECTS.register(bus);
    }
}
