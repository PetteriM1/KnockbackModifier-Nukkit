package me.petterim1.knockbackmodifier;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase implements Listener {

    private float modifier;

    public void onEnable() {
        saveDefaultConfig();
        modifier = (float) getConfig().getDouble("knockbackModifier", 1.0d);
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            e.setKnockBack(e.getKnockBack() * modifier);
        }
    }
}
