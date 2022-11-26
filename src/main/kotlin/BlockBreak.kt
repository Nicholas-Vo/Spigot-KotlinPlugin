import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import java.util.UUID

object BlockBreak : Listener {
    private val map = mutableMapOf<UUID, MutableSet<Location>>()

    @EventHandler
    fun onBlockBreak(e: BlockBreakEvent) {
        val block: Material = e.block.type

        if (e.isCancelled) {
            return
        }

        val uuid: UUID = e.player.uniqueId
        map.putIfAbsent(uuid, HashSet())
        val set: MutableSet<Location>? = map[uuid]

        if (set!!.contains(e.block.location)) {
            return
        }

        set.add(e.block.location)
        if (set.size >= 10) {
            set.clear()
        }

        val theMap = KotlinPlugin.instance.pointsMap
        theMap[uuid] = theMap[uuid]?.plus(1.0) ?: 1.0
    }
}