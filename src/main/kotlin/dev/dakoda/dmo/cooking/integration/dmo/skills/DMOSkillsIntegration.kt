package dev.dakoda.dmo.cooking.integration.dmo.skills

import dev.dakoda.dmo.cooking.DMOCooking.modID
import dev.dakoda.dmo.skills.DMOSkills

object DMOSkillsIntegration {

    private var isModLoaded: Boolean = false

    fun initialise() {
        println("$modID detected ${DMOSkills.modID}, initialising EXP integration")

        CookingChecker

        isModLoaded = true
    }

    fun isLoaded() = isModLoaded

    fun ifLoaded(func: DMOSkillsIntegration.() -> Unit?) {
        if (isModLoaded) this.func()
    }
}
