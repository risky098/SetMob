package risky.setmob.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import risky.setmob.Mob;

public class Reload implements CommandExecutor {
    private Mob plugin;

    public Reload(Mob plugin) {
        this.plugin = plugin;
        plugin.getCommand("몹").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player)sender;
        if(sender instanceof Player) {
            if(p.hasPermission("setmob.admin")) {
                if(args.length == 1) {
                    String c = args[0];
                    if(c.equalsIgnoreCase("저장")) {
                        this.plugin.saveDefaultConfig();
                        this.plugin.getConfig().options().copyDefaults(true);
                        this.plugin.reloadConfig();;
                        this.plugin.saveConfig();
                        p.sendMessage("§a몹 설정 파일이 정상적으로 저장 되었습니다.");
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
