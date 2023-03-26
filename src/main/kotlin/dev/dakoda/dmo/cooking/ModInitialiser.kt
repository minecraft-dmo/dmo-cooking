package dev.dakoda.dmo.cooking
import dev.dakoda.dmo.cooking.integration.dmo.skills.DMOSkillsIntegration
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.block.SmokerBlock
import net.minecraft.block.entity.SmokerBlockEntity
import net.minecraft.item.ItemGroups

object ModInitialiser : ModInitializer {

    override fun onInitialize() {
        if (FabricLoader.getInstance().isModLoaded("dmo-skills")) {
            DMOSkillsIntegration.initialise()
        }

        DMOCooking.Items.addItemsToGroups()
    }
}
