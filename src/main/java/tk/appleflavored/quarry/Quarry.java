package tk.appleflavored.quarry;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Quarry extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) getDataFolder().mkdirs();

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new BlockEvents(this), this);
    }

}
