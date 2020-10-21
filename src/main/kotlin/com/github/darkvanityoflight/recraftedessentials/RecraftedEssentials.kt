package com.github.darkvanityoflight.recraftedessentials

import com.github.darkvanityoflight.recraftedessentials.commands.RollDice
import com.github.darkvanityoflight.recraftedcore.ARecraftedPlugin
class RecraftedEssentials : ARecraftedPlugin(){

    override fun onEnable() {
        super.onEnable()
        info("[DarkEssentials] Enabling DarkEssentials")
        this.getCommand("rolladice")?.setExecutor(RollDice())
    }
}