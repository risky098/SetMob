package risky.setmob;

import org.bukkit.plugin.java.JavaPlugin;
import risky.setmob.command.Reload;
import risky.setmob.listener.Spawn;

public final class Mob extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("§aSetMobRisky Enable");
        new Reload(this);
        new Spawn(this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
    }
}
