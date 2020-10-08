package risky.setmob.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import risky.setmob.Mob;

public class Spawn implements Listener {
    private Mob plugin;

    public Spawn(Mob plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onMobSpawn(EntitySpawnEvent e) {
        e.getEntity();
        if(e.getEntityType() == EntityType.ZOMBIE) {
            Zombie z = (Zombie)e.getEntity();
            z.setMaxHealth(plugin.getConfig().getDouble("zombie.hp"));
            z.setCanPickupItems(true);
            z.setAdult();
            z.getEquipment().setHelmet(new ItemStack(Material.getMaterial(plugin.getConfig().getString("zombie.helmet"))));
            z.getEquipment().setChestplate(new ItemStack(Material.getMaterial(plugin.getConfig().getString("zombie.chestplate"))));
            z.getEquipment().setLeggings(new ItemStack(Material.getMaterial(plugin.getConfig().getString("zombie.leggins"))));
            z.getEquipment().setBoots(new ItemStack(Material.getMaterial(plugin.getConfig().getString("zombie.boots"))));
            z.getEquipment().setItemInMainHand(new ItemStack(Material.getMaterial(plugin.getConfig().getString("zombie.handitem"))));
            if(z.getFireTicks() <= 1)
                z.setFireTicks(0);
        }
    }
}
