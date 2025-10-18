package com.biens.PotionArmor.event;

import com.biens.PotionArmor.Potion.ModPotions;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "potionarmor", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvent {

 public static void registerBrewingRecipes() {

        // First recipe to make potion of armor blesser
        // GOD we are cooking
        BrewingRecipeRegistry.addRecipe(new IBrewingRecipe() {
            @Override
             public boolean isInput(ItemStack input) {
                return input.is(Items.POTION) && PotionUtils.getPotion(input) == Potions.AWKWARD;
            }

            @Override
            public boolean isIngredient(ItemStack ingredient) {
                return ingredient.is(Items.DIAMOND_BLOCK);
            }

            @Override
            public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
                if (!isInput(input) || !isIngredient(ingredient))
                    return ItemStack.EMPTY;

                ItemStack output = new ItemStack(Items.POTION);
                PotionUtils.setPotion(output, ModPotions.ARMOR_BLESSING_POTION.get());
                return output;
            }
        });

        BrewingRecipeRegistry.addRecipe(new IBrewingRecipe() {
            @Override
            public boolean isInput(ItemStack input) {
                return input.is(Items.POTION) && PotionUtils.getPotion(input) == ModPotions.ARMOR_BLESSING_POTION.get();
            }            

            @Override
            public boolean isIngredient(ItemStack ingredient) {
                return ingredient.is(Items.NETHERITE_INGOT);// expensive well its a great equavalent exchange
            }

            @Override
            public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
                if (!isInput(input) || !isIngredient(ingredient))
                    return ItemStack.EMPTY;
                    
                ItemStack output = new ItemStack(Items.POTION);
                PotionUtils.setPotion(output, ModPotions.UPGRADED_BLESSING_POTION.get());
                return output;
            }
        });
    }
}
