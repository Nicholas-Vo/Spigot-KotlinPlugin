import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object GroupChat : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, alias: String, args: Array<out String>): Boolean {
        if (!sender.hasPermission("groupchat.use")) {
            return true
        }

        if (args.isEmpty()) {
            sender.sendMessage("Usage: /chat <message>")
            return true
        }

        val message = StringBuilder()
        for (arg in args) {
            message.append(arg).append(" ")
        }

        for (player in Bukkit.getOnlinePlayers()) {
            player.sendMessage("[Group] $message")
        }
        return true
    }
}