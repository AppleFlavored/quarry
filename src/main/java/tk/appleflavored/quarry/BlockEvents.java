package tk.appleflavored.quarry;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockEvents implements Listener {

    private Main plugin;

    public BlockEvents(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE) return;

        // store the broken block material
        Material block = event.getBlock().getType();

        switch (block) {
            case COAL_ORE:
            case IRON_ORE:
            case LAPIS_ORE:
            case GOLD_ORE:
            case REDSTONE_ORE:
            case DIAMOND_BLOCK:
                block = Material.STONE; // set the material variable to the new block type
                break;
            case STONE:
                block = Material.COBBLESTONE;
                break;
            case COBBLESTONE:
                block = Material.BEDROCK;
                break;
        }

        // if the block needs changes, cancel the event
        if (block != event.getBlock().getType()) event.setCancelled(true);

        event.getBlock().breakNaturally(event.getPlayer().getInventory().getItemInMainHand());
        event.getBlock().setType(block); // replace the block with the new material
    }

}
