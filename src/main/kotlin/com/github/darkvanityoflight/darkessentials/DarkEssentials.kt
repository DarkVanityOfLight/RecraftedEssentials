package com.github.darkvanityoflight.darkessentials

import com.github.darkvanityoflight.darkessentials.commands.RollDice
import com.github.darkvanityoflight.darkmodcore.ADarkMod
class DarkEssentials : ADarkMod(){

    override fun onEnable() {
        super.onEnable()
        info("[DarkEssentials] Enabling DarkEssentials")
        this.getCommand("rolladice")?.setExecutor(RollDice())
    }
}