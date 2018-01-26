package lib.winmister332.wmlib.spigot.library.util;

import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.List;

/**
 * EntityUtil Created By: WinMister332 On 9/11/2017 At 3:13 AM!
 * Copyright © WinMister332 2017!
 */
public class EntityUtil
{
    /**
     * Gets a static array of all entities in a specific range, from the specified entity.
     * @param from - The entity to search around.
     * @param range - The number of blocks in all directions to search.
     * @return {@link List} - A static list of all entities around the specified entity.
     */
    public static List<Entity> getAllEntities(Entity from, double range)
    {
        return from.getNearbyEntities(range, range, range);
    }

    /**
     * Launches a firework at the specified location with the specified {@link FireworkEffect}.
     * @param location - The location to launch the firework.
     * @param effect - The effect the firework will display when it explodes.
     */
    public static void launchFirework(Location location, FireworkEffect effect)
    {
        Firework f = (Firework)location.getWorld().spawn(location, Firework.class);
        FireworkMeta m = f.getFireworkMeta();
        m.addEffect(effect);
        m.setPower(0);
        f.setFireworkMeta(m);
        f.detonate();
    }

    /**
     * Tries to kill an entity, and returns wheather it is dead or not.
     * @param entity - The entity to check to see if they are alive or dead.
     * @return boolean - True: The entity is still alive, False: The entity is dead.
     */
    public static boolean kill(LivingEntity entity)
    {
        entity.setHealth(0.0D);
        if (entity.isDead())
        {
            return true;
        }
        return false;
    }

    /**
     * Spawns an entity with the specified health information.
     * @param location - The location where to spawn the entity.
     * @param type - The type of entity to spawn.
     * @param maxHealth - The maximum amount of health that the entity can have.
     * @param health - The amount of health the entity currently has.
     * @return {@link Entity} - Gets the entity information and data on the entity that was spawned.
     */
    public static Entity spawnEntity(Location location, EntityType type, double maxHealth, double health)
    {
        Entity e = location.getWorld().spawnEntity(location, type);
        if ((e instanceof LivingEntity))
        {
            LivingEntity le = (LivingEntity)e;
            ((Attributable) le).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
            le.setHealth(health);
            return le;
        }
        return e;
    }

    /**
     * Launches a firework at the specified location with the specified {@link FireworkEffect}s.
     * @param location - The location to launch the firework.
     * @param effects - The effects the firework will display when it explodes.
     */
    public static void launchFirework(Location location, FireworkEffect[] effects)
    {
        Firework f = (Firework)location.getWorld().spawn(location, Firework.class);
        FireworkMeta m = f.getFireworkMeta();
        for (FireworkEffect e : effects)
        {
            m.addEffect(e);
        }
        m.setPower(0);
        f.setFireworkMeta(m);
        f.detonate();
    }
}
