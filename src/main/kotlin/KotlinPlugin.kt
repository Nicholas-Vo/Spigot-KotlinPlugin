import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.util.UUID
import org.bukkit.entity.Player

class KotlinPlugin : JavaPlugin() {

    companion object {
        lateinit var instance: KotlinPlugin // Using lateinit, the initial value does not need to be assigned
    }

    override fun onEnable() {
        instance = this
        getCommand("points")?.setExecutor(PointsCommand)
        getCommand("chat")?.setExecutor(GroupChat)

        Bukkit.getLogger().info("Enabled KotlinPlugin.kt...")
        Bukkit.getPluginManager().registerEvents(BlockBreak, this)
    }

    val pointsMap = mutableMapOf<UUID, Double>()
}

// Extension function + Elvis operator
fun Player.getPoints(): Double = KotlinPlugin.instance.pointsMap[this.uniqueId] ?: 0.0


