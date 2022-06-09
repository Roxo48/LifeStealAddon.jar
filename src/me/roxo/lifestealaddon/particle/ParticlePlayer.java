package me.roxo.lifestealaddon.particle;

import com.projectkorra.projectkorra.util.ActionBar;
import com.projectkorra.projectkorra.util.ParticleEffect;
import me.roxo.lifestealaddon.LifeStealAddon;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ParticlePlayer {
    private final LifeStealAddon plugin;
    private final double chargeTime;
    private Vector direction;
    private Player player;
    private Permission perm;
    private Listener listener;
    private static double Damage;
    private static double Range;
    private static double knockback;
    private double distanceTraveled;
    private double particles;
    private double particlesTwo;
    private double particlesThree;
    private  double particlesOne;
    private Location loc;
    private int distanceFromPlayer;
    private long cooldown;
    private double x;
    private double z;
    private double y;
    private double l;
    private double w;
    private Location destination;
    private double yaw, pitch;
    private double cosX, sinX, cosY, sinY;
    private double t;

    public ParticlePlayer(LifeStealAddon plugin, Player player){
        this.plugin = plugin;
        this.player = player;
        loc = player.getEyeLocation();
        direction = loc.getDirection().normalize();
        //  knockback = 1;
        distanceTraveled = 0;
        particles = 1.5;
        particlesOne = 2.5;
        particlesTwo = 1;
        particlesThree = 3;
        x = direction.getX();
        z = direction.getZ();
        y = direction.getY();
        yaw = Math.toRadians(player.getLocation().getYaw());
        pitch = Math.toRadians(player.getLocation().getPitch() - 90);
        cosX = Math.cos(pitch);
        sinX = Math.sin(pitch);
        cosY = Math.cos(-yaw);
        sinY = Math.sin(-yaw);
        chargeTime = 8000;



    }
    public void playParticles(){
        for (double i = 0; i < particlesOne; i += .25) {
            x = -1 + i;
            z = -1 + 0;
            destination = loc.clone();
            Vector vector = new Vector(x, 0, z);
            vector = rotateAroundAxisX(vector, cosX, sinX);
            vector = rotateAroundAxisY(vector, cosY, sinY);
            destination.add(vector);
            player.spawnParticle(Particle.ASH,destination,1);
            destination.subtract(vector);
            destination = loc.clone();
            x = -1 + i;
            z = -1 + 1.5;
            Vector vector1 = new Vector(x, 0, z);
            vector1 = rotateAroundAxisX(vector1, cosX, sinX);
            vector1 = rotateAroundAxisY(vector1, cosY, sinY);
            destination.add(vector1);
            player.spawnParticle(Particle.ASH,destination,1);
            destination.subtract(vector1);
        }
        for (double i = 0; i < particles; i += .25) {
            destination = loc.clone();
            x = -1 + 0;
            z = -1 + i;
            Vector vector2 = new Vector(x, 0, z);
            vector2 = rotateAroundAxisX(vector2, cosX, sinX);
            vector2 = rotateAroundAxisY(vector2, cosY, sinY);
            destination.add(vector2);
            player.spawnParticle(Particle.ASH,destination,1);
            destination.subtract(vector2);
            destination = loc.clone();
            x = -1 + 2;
            z = -1 + i;
            Vector vector3 = new Vector(x, 0, z);
            vector3 = rotateAroundAxisX(vector3, cosX, sinX);
            vector3 = rotateAroundAxisY(vector3, cosY, sinY);
            destination.add(vector3);
            player.spawnParticle(Particle.ASH,destination,1);
            destination.subtract(vector3);
        }
        for (double i = 0; i < particlesTwo; i += .25) {
            destination = loc.clone();
            x = -1 + i + .5;
            z = -1 + -.5;
            Vector vector4 = new Vector(x, 0, z);
            vector4 = rotateAroundAxisX(vector4, cosX, sinX);
            vector4 = rotateAroundAxisY(vector4, cosY, sinY);
            destination.add(vector4);
            player.spawnParticle(Particle.ASH,destination,1);
            destination.subtract(vector4);
            destination = loc.clone();
            x = -1 + i + .5;
            z = -1 + 2.5;
            Vector vector5 = new Vector(x, 0, z);
            vector5 = rotateAroundAxisX(vector5, cosX, sinX);
            vector5 = rotateAroundAxisY(vector5, cosY, sinY);
            destination.add(vector5);
            player.spawnParticle(Particle.ASH,destination,1);
            destination.subtract(vector5);
        }
        for (double i = 0; i < particlesThree; i += .25) {
            destination = loc.clone();
            x = -1 + .5;
            z = -1 + i - .5;
            Vector vector6 = new Vector(x, 0, z);
            vector6 = rotateAroundAxisX(vector6, cosX, sinX);
            vector6 = rotateAroundAxisY(vector6, cosY, sinY);
            destination.add(vector6);
            player.spawnParticle(Particle.ASH,destination,1);
            destination.subtract(vector6);
            destination = loc.clone();
            x = -1 + 1.5;
            z = -1 + i - .5;
            Vector vector7 = new Vector(x, 0, z);
            vector7 = rotateAroundAxisX(vector7, cosX, sinX);
            vector7 = rotateAroundAxisY(vector7, cosY, sinY);
            destination.add(vector7);
            player.spawnParticle(Particle.ASH,destination,1);
            destination.subtract(vector7);
        }


    }

    public void Start(double startTime) {
        new BukkitRunnable() {

            @Override
            public void run() {
                //The code inside will be executed in {timeInTicks} ticks.


       // if((System.currentTimeMillis() - startTime) <= chargeTime) {

            //  how would I do the charging text above the action bar as you did in thundersplice. I did find " player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Test"));" << this bit of code but i gives me an error when i build it saying "cannot find symbol, of method spigot".
            Location loc2 = player.getLocation();
            t += 0.05;
            for (double ring = 0.0; ring <= 6; ring += 2) {
                final double x = (8 - t) * Math.cos(t + ring);
                final double y = (8 - t);
                final double z = (8 - t) * Math.sin(t + ring);
                Vector vector = new Vector(x, y, z);
                loc2.add(x, y, z);
                ActionBar.sendActionBar(ChatColor.LIGHT_PURPLE + "**Charging**", player);
                if (System.currentTimeMillis() - startTime <= 200) {
                    ParticleEffect.CLOUD.display(loc2.add(vector), 15, 2.5D, 2.5D, 2.5D);
                    loc2.subtract(vector);
                } else if (System.currentTimeMillis() - startTime <= 600) {
                    ParticleEffect.CLOUD.display(loc2.add(vector), 15, 2D, 2D, 2D);
                    loc2.subtract(vector);
                } else if (System.currentTimeMillis() - startTime <= 1000) {
                    ParticleEffect.CLOUD.display(loc2.add(vector), 15, 1.5D, 1.5D, 1.5D);
                    loc2.subtract(vector);
                } else if (System.currentTimeMillis() - startTime <= 1800) {
                    ParticleEffect.CLOUD.display(loc2.add(vector), 15, 1D, 1D, 1D);
                    loc2.subtract(vector);
                } else if (System.currentTimeMillis() - startTime <= 2200) {
                    ParticleEffect.CLOUD.display(loc2.add(vector), 10, .8D, 0.8D, 0.8D);
                    loc2.subtract(vector);
                } else if (System.currentTimeMillis() - startTime <= 3000) {
                    ParticleEffect.CLOUD.display(loc2.add(vector), 8, 0.6D, .6D, 0.6D);
                    loc2.subtract(vector);
                } else if (System.currentTimeMillis() - startTime <= 3800) {
                    ParticleEffect.CLOUD.display(loc2.add(vector), 6, 0.5D, 0.5D, 0.5);
                    loc2.subtract(vector);
                } else if (System.currentTimeMillis() - startTime <= 4800) {
                    ParticleEffect.CLOUD.display(loc2.add(vector), 5, 0.4D, 0.4D, 0.4D);
                    loc2.subtract(vector);
                } else if (System.currentTimeMillis() - startTime <= 5600) {
                    ParticleEffect.CLOUD.display(loc2.add(vector), 4, 0.3D, 0.3D, 0.3D);
                    loc2.subtract(vector);
                } else if (System.currentTimeMillis() - startTime <= 6300) {
                    ParticleEffect.CLOUD.display(loc2.add(vector), 3, 0.2D, 0.2D, 0.2D);
                    loc2.subtract(vector);
                } else if (System.currentTimeMillis() - startTime <= 6900) {
                    ParticleEffect.CLOUD.display(loc2.add(vector), 3, 0.1D, 0.1D, 0.1D);
                    loc2.subtract(vector);
                } else if (System.currentTimeMillis() - startTime <= 7500) {
                    ParticleEffect.CLOUD.display(loc2.add(vector), 2, 0.1D, 0.1D, 0.1D);
                    loc2.subtract(vector);
                } else if (System.currentTimeMillis() - startTime <= 7900) {
                    ParticleEffect.CLOUD.display(loc2.add(vector), 2, 0.1D, 0.1D, 0.1D);
                    loc2.subtract(vector);
                }
                loc2.subtract(vector);
                if((System.currentTimeMillis() - startTime) > chargeTime){


                }
            }
            }

        }.runTaskTimerAsynchronously(plugin,0,200);
        }
  //  }





    private Vector rotateAroundAxisX(Vector v, double cos, double sin) {
        double y = v.getY() * cos - v.getZ() * sin;
        double z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }
    private Vector rotateAroundAxisY(Vector v, double cos, double sin) {
        double x = v.getX() * cos + v.getZ() * sin;
        double z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }
    private Vector rotateAroundAxisZ(Vector v, double cos, double sin) {
        double x = v.getX() * cos - v.getY() * sin;
        double y = v.getX() * sin + v.getY() * cos;
        return v.setX(x).setY(y);
    }
}
