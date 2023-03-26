package dev.dakoda.dmo.cooking

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.Items as VanillaItems
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries.ITEM
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object DMOCooking {
    const val modID = "dmo-cooking"

    object Items {

        private val BURNT_FOOD_POISON get() = statusEffect(
            type = StatusEffects.POISON,
            duration = 40,
        )

        val BURNT_BEEF = item("burnt_beef", food { hunger(1).statusEffect(BURNT_FOOD_POISON, 100f).meat() })
        val BURNT_CHICKEN = item("burnt_chicken", food { hunger(1).statusEffect(BURNT_FOOD_POISON, 100f).meat() })
        val BURNT_PORKCHOP = item("burnt_porkchop", food { hunger(1).statusEffect(BURNT_FOOD_POISON, 100f).meat() })
        val BURNT_MUTTON = item("burnt_mutton", food { hunger(1).statusEffect(BURNT_FOOD_POISON, 100f).meat() })
        val BURNT_RABBIT = item("burnt_rabbit", food { hunger(1).statusEffect(BURNT_FOOD_POISON, 100f).meat() })
        val BURNT_SALMON = item("burnt_salmon", food { hunger(1).statusEffect(BURNT_FOOD_POISON, 100f).meat() })
        val BURNT_COD = item("burnt_cod", food { hunger(1).statusEffect(BURNT_FOOD_POISON, 100f).meat() })
        val BURNT_POTATO = item("burnt_potato", food { hunger(1).statusEffect(BURNT_FOOD_POISON, 100f) })

        fun addItemsToGroups() {
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register {
                it.addAfter(VanillaItems.COOKED_BEEF, BURNT_BEEF)
                it.addAfter(VanillaItems.COOKED_CHICKEN, BURNT_CHICKEN)
                it.addAfter(VanillaItems.COOKED_PORKCHOP, BURNT_PORKCHOP)
                it.addAfter(VanillaItems.COOKED_MUTTON, BURNT_MUTTON)
                it.addAfter(VanillaItems.COOKED_RABBIT, BURNT_RABBIT)
                it.addAfter(VanillaItems.COOKED_SALMON, BURNT_SALMON)
                it.addAfter(VanillaItems.COOKED_COD, BURNT_COD)
                it.addAfter(VanillaItems.BAKED_POTATO, BURNT_POTATO)
            }
        }

        private fun item(name: String, settings: FabricItemSettings = FabricItemSettings()): Item {
            return Registry.register(ITEM, Identifier(modID, name), Item(settings))
        }

        private fun food(func: FoodComponent.Builder.() -> FoodComponent.Builder): FabricItemSettings {
            return FabricItemSettings().food(FoodComponent.Builder().func().build())
        }

        private fun statusEffect(
            type: StatusEffect, duration: Int = 0, amplifier: Int = 0,
            ambient: Boolean = false, visible: Boolean = true
        ) = StatusEffectInstance(type, duration, amplifier, ambient, visible)
    }
}
