package dev.dakoda.dmo.cooking.integration.dmo.skills

import dev.dakoda.dmo.skills.Skill.Companion.COOKING
import net.minecraft.item.Items

object CookingChecker : AbstractCookingChecker() {
    init {
        registry[Items.BREAD] = flat(2 to COOKING)
        registry[Items.COOKIE] = flat(4 to COOKING)
        registry[Items.BAKED_POTATO] = flat(5 to COOKING)
        registry[Items.PUMPKIN_PIE] = flat(8 to COOKING)
        registry[Items.CAKE] = flat(20 to COOKING)
        registry[Items.COOKED_BEEF] = flat(5 to COOKING)
        registry[Items.COOKED_CHICKEN] = flat(5 to COOKING)
        registry[Items.COOKED_COD] = flat(5 to COOKING)
        registry[Items.COOKED_MUTTON] = flat(5 to COOKING)
        registry[Items.COOKED_PORKCHOP] = flat(5 to COOKING)
        registry[Items.COOKED_RABBIT] = flat(5 to COOKING)
        registry[Items.COOKED_SALMON] = flat(5 to COOKING)
    }
}
