package lib.winmister332.wmlib.spigot.library.configuration;

import lib.winmister332.wmlib.spigot.library.logger.Logger;
import lib.winmister332.wmlib.spigot.main.WMPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

/**
 * GeneralConfig Created By: WinMister332 On 12/30/2017 At 1:46 AM.
 * Copyright © WinMister332 2017!
 */
public abstract class GeneralConfig
{
    private String fileName = "";
    private String header = "";
    private File dir;
    private FileConfiguration config;
    private File configFile;

    /**
     * Sets up the default configuration file in the jar, and saves the file to the plugin's data directory.
     * @param resource The resource file to copy over to the data directory.
     */
    public GeneralConfig(String resource)
    {
        this(resource, false);
    }

    /**
     * Sets up the default configuration file in the jar, and saves the file to the plugin's data directory.
     * @param resource The resource file to copy over to the data directory.
     * @param replace Tells the plugin that it can rewrite/replace the current file in that directory if one exists.
     */
    public GeneralConfig(String resource, boolean replace)
    {
        Plugin plugin = WMPlugin.INSTANCE;
        plugin.saveResource(resource, replace);
        this.config = plugin.getConfig();
        this.dir = plugin.getDataFolder();
        this.fileName = resource;
        reload();
    }

    /**
     * Sets up the class to be used to create, and control custom .yml files.
     * @param dir The directory that contains the YAML file.
     * @param fileName The name of the GeneralConfig file.
     */
    public GeneralConfig(File dir, String fileName)
    {
        if (!(dir.exists()))
            dir.mkdirs();
        this.dir = dir;
        if (fileName.endsWith(".yml"))
            this.fileName = fileName;
        else
            this.fileName = fileName + ".yml";
        reload();
    }

    /**
     * Sets up the class to be used to create, and control custom .yml files.
     * @param dir The directory that contains the YAML file.
     * @param fileName The name of the GeneralConfig file.
     * @param header The header of the file that displays information about it.
     */
    public GeneralConfig(File dir, String fileName, String header)
    {
        if (!(dir.exists()))
            dir.mkdirs();
        this.dir = dir;
        if (fileName.endsWith(".yml"))
            this.fileName = fileName;
        else
            this.fileName = fileName + ".yml";
        this.header = header;
        reload();
    }

    /**
     * Reloads the YAML/GeneralConfig file.
     */
    public void reload()
    {
        if (configFile == null)
            configFile = new File(dir, fileName);
        config = YamlConfiguration.loadConfiguration(configFile);
        if (!(header == "" || header == null))
        {
            config.options().header(header);
            config.options().copyHeader();
        }
        onReload(config);
        save();
    }

    /**
     * This function is invoked whenever the RELOAD method has been invoked either by the plugin, or a developer.
     * @param config This parameter is preset by the 'reload()' method, so you can manually grab config data.
     */
    public void onReload(FileConfiguration config){}

    /**
     * Saves all data from the YAML/GeneralConfig file methods/data to the physical file it represents.
     */
    public void save()
    {
        try
        {
            onSave(config);
            config.save(configFile);
        }
        catch (Exception ex)
        {
            WMPlugin.INSTANCE.getWMLogger().Log(Logger.LogStatus.ERROR, "Could not save \"" + fileName + "\"! -> " + ex.getMessage());
        }
    }

    /**
     * This function is invoked whenever the SAVE method has been invoked either by the plugin or a developer.
     * @param config This parameter is preset by the 'reload()' method, so you can manually grab config data.
     */
    public void onSave(FileConfiguration config){}

    /**
     * Checks to see if the file is valid, if not it will automatically reload the YAML/GeneralConfig file.
     */
    public void check()
    {
        if (isValid() == false)
            reload();
        return;
    }

    /**
     * Returns a value based on wheather or not the YAML/GeneralConfig file is valid.
     * @return {@link Boolean} - YAML/GeneralConfig file is valid? <br> True: The file is valid, False: The file is invalid.
     */
    public boolean isValid()
    {
        if ((config == null) || (configFile == null))
            return false;
        return true;
    }

    /**
     * Gets all data on the YAML/GeneralConfig file, if that data has been forwarded to this class.
     * @return {@link FileConfiguration} - The configuration data for the YAML/Config file.
     */
    public FileConfiguration GetConfig()
    {
        return config;
    }

    /**
     * Reads the YAML/GeneralConfig file for the value based on the key.
     * @param key The object that contains the value.
     * @return {@link String} - Returns the data that was found by the key, if the key exists.
     */
    public String ReadString(String key)
    {
        check();
        String value = config.getString(key);
        return value;
    }

    /**
     * Reads the YAML/GeneralConfig file for a value based on the key.
     * @param key The object that contains the value.
     * @return {@link Integer} - Returns the data that was found by the key, if it exists.
     */
    public int ReadInt(String key)
    {
        check();
        int value = config.getInt(key);
        return value;
    }

    /**
     * Reads the YAML/GeneralConfig file for a value based on the key.
     * @param key The object that contains the value.
     * @return {@link Boolean} - Returns the data that was found by the key, if it exists.
     */
    public boolean ReadBoolean(String key)
    {
        check();
        Boolean value = config.getBoolean(key);
        if (value.toString().isEmpty() || !(value))
            return !(value);
        return value;
    }

    /**
     * Reads the YAML/GeneralConfig file for a value based on the key.
     * @param key The object that contains the value.
     * @return {@link Character} - Returns the data that was found by the key, if it exists.
     */
    public char ReadChar(String key)
    {
        check();
        Character value = config.getString(key).charAt(0);
        return value;
    }

    /**
     * Reads the YAML/GeneralConfig file for a value based on the key.
     * @param key The object that contains the value.
     * @return {@link Object} - Returns the data that was found by the key, if it exists.
     */
    public Object GetValue(String key)
    {
        check();
        return config.get(key);
    }

    /**
     * Writes data to the YAML/Config file based on the specified key.
     * @param key The object that will contain the value.
     * @param value The value to place in the key.
     */
    public void WriteString(String key, String value)
    {
        check();
        config.set(key, value);
    }

    /**
     * Writes data to the YAML/Config file based on the specified key.
     * @param key The object that will contain the value.
     * @param value The value to place in the key.
     */
    public void WriteInteger(String key, int value)
    {
        check();
        config.set(key, value);
    }

    /**
     * Writes data to the YAML/Config file based on the specified key.
     * @param key The object that will contain the value.
     * @param value The value to place in the key.
     */
    public void WriteBoolean(String key, boolean value)
    {
        check();
        config.set(key, value);
    }

    /**
     * Writes data to the YAML/Config file based on the specified key.
     * @param key The object that will contain the value.
     * @param value The value to place in the key.
     */
    public void WriteChar(String key, char value)
    {
        check();
        config.set(key, value);
    }

    /**
     * Writes data to the YAML/Config file based on the specified key.
     * @param key The object that will contain the value.
     * @param value The value to place in the key.
     */
    public void WriteValue(String key, Object value)
    {
        check();
        config.set(key, value);
    }
}
