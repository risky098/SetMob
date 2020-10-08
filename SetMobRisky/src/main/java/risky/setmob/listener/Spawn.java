package risky.setmob.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import risky.setmob.Mob;

import java.util.Set;

public class Spawn implements Listener {
    private Mob plugin;

    public Spawn(Mob plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority =  EventPriority.NORMAL)
    public void onMobSpawn(CreatureSpawnEvent e) {
        LivingEntity ley = e.getEntity();
        Set<String> monsters = plugin.getConfig().getConfigurationSection("monsters").getKeys(false);
        String[] mList = monsters.<String>toArray(new String[monsters.size()]);
        for(int i=0; i< monsters.size(); i++) {
            String monster = mList[i];
            if(ley.getType().equals(EntityType.valueOf(monster))) {
                int v = plugin.getConfig().getInt("monsters." + mList[i] + ".hp");
                ley.setMaxHealth(v);
                ley.setHealth(v);
                ItemStack helmet = new ItemStack(Material.getMaterial(plugin.getConfig().getString("monsters." + mList[i] + ".helmet")));
                ley.getEquipment().setHelmet(helmet);
                ItemStack chestplate = new ItemStack(Material.getMaterial(plugin.getConfig().getString("monsters." + mList[i] + ".chestplate")));
                ley.getEquipment().setChestplate(chestplate);
                ItemStack leggings = new ItemStack(Material.getMaterial(plugin.getConfig().getString("monsters." + mList[i] + ".leggings")));
                ley.getEquipment().setLeggings(leggings);
                ItemStack boots = new ItemStack(Material.getMaterial(plugin.getConfig().getString("monsters." + mList[i] + ".boots")));
                ley.getEquipment().setBoots(boots);
                ItemStack handitem = new ItemStack(Material.getMaterial(plugin.getConfig().getString("monsters." + mList[i] + ".handitem")));
                ley.getEquipment().setItemInMainHand(handitem);
            }
        }
    }
}
