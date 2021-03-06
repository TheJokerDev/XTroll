package me.TheJokerDev.XTroll.utils;

import org.bukkit.configuration.file.FileConfiguration;
import xyz.theprogramsrc.supercoreapi.spigot.utils.storage.SpigotYMLConfig;
import org.bukkit.entity.Player;

import java.io.File;

public class SettingsManager {
    public static FileConfiguration getSettings(){
        SpigotYMLConfig settings = new SpigotYMLConfig(new File("plugins/XTroll/Settings.yml"));
        return settings.getConfig();
    }
    public static Boolean checkUserSettings(Player p ){
        SpigotYMLConfig settings = new SpigotYMLConfig(new File("plugins/XTroll/Settings.yml"));
        Boolean returnbool;
        if (settings.getString("Users."+p.getName()) == null){
            returnbool = false;
            registerUserSettings(p);
        } else {
            returnbool = true;
        }
        return returnbool;
    }
    public static void registerUserSettings(Player p) {
        SpigotYMLConfig settings = new SpigotYMLConfig(new File("plugins/XTroll/Settings.yml"));
        settings.add("Users." + p.getName()+".guimode", "categories");
        settings.save();
    }
    public static String getGUIMode(Player p){
        SpigotYMLConfig settings = new SpigotYMLConfig(new File("plugins/XTroll/Settings.yml"));
        String rtString = null;
        if (!checkUserSettings(p)){
            registerUserSettings(p);
        } else {
            rtString = settings.getString("Users."+p.getName()+".guimode");
        }
        return rtString;
    }
    public static Boolean getRegeneratonBoolean(){
        SpigotYMLConfig settings = new SpigotYMLConfig(new File("plugins/XTroll/Settings.yml"));
        return settings.getBoolean("regenerationblocks.activated");
    }
    public static void changeRegenerationBoolean(){
        SpigotYMLConfig settings = new SpigotYMLConfig(new File("plugins/XTroll/Settings.yml"));
        if (settings.getBoolean("regenerationblocks.activated")){
            settings.set("regenerationblocks.activated", false);
            settings.save();
            return;
        }
        if (!settings.getBoolean("regenerationblocks.activated")){
            settings.set("regenerationblocks.activated", true);
            settings.save();
            return;
        }
    }
    public static void changeGUIMode(Player p){
        SpigotYMLConfig settings = new SpigotYMLConfig(new File("plugins/XTroll/Settings.yml"));
        if (getGUIMode(p).equals("categories")){
            settings.set("Users."+p.getName()+".guimode", "allinone");
            settings.save();
            return;
        }
        if (getGUIMode(p).equals("allinone")){
            settings.set("Users."+p.getName()+".guimode", "categories");
            settings.save();
            return;
        }
    }
}
