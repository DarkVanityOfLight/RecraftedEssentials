package com.github.darkvanityoflight.darkessentials.commands


import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class RollDice : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Fuck off console man!!"); return true
        }
        if (!com.github.darkvanityoflight.chatplugin.api.ParserAPI.initialized) {
            sender.sendMessage("An internal error occurred, please try again in a minute"); return false
        }
        com.github.darkvanityoflight.chatplugin.api.ParserAPI.dataParser.update()

        val channelName: String? =
            com.github.darkvanityoflight.chatplugin.api.ParserAPI.dataParser.playerChannelMap[sender.name]
        if (channelName == null) {
            sender.sendMessage("You don't seem to be in an channel, this is weird, try joining one if that doesn't work call an admin"); return false
        }

        val channel = com.github.darkvanityoflight.chatplugin.api.DataAPI.channels[channelName]
        if (channel == null){
            sender.sendMessage("We couldn't find the channel you are currently in this is an internal error, pls contact DarkVanityOfLight")
            return false
        }

        val num : Int
        try{
            num = args[0].toInt()
        } catch (exception : NumberFormatException){
            sender.sendMessage("${args[0]} is not a number you idiot")
            return false
        }

        val number : Int = (0 .. num).random()
        channel.sendMessage("rolled $number", sender, "{player_name} {message}")
        return true

    }

}