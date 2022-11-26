import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object PointsCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, alias: String, args: Array<out String>): Boolean {
        if (sender is Player) { // Smart casting sender to player
            val points = sender.getPoints().toInt()
            sender.sendMessage("Points: $points")
        }
        return true
    }
}