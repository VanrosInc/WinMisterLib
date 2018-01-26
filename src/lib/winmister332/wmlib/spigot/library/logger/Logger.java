package lib.winmister332.wmlib.spigot.library.logger;

import lib.winmister332.wmlib.util.TextUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

import java.util.List;

/**
 * Logger Created By: WinMister332 On 12/30/2017 At 1:08 AM.
 * Copyright © WinMister332 2017!
 */
public class Logger
{
    private String name = "";
    private boolean allowDebug = false;

    @Deprecated
    /**
     * FOR INTERNAL USE ONLY DO NOT USE!
     * Creates a new instance of the 'Logger' class for spigot/bukkit.
     */
    Logger(String name, boolean allowDebug)
    {
        this.name = name;
        this.allowDebug = allowDebug;
    }

    /**
     * Creates a new instance of the 'Logger' class for spigot/bukkit.
     * @param plugin The MAIN class of your plugin that inherits either 'WMPlugin' or 'JavaPlugin'.
     */
    public Logger(Plugin plugin)
    {
        this(plugin, false);
    }

    /**
     * Creates a new instance of the 'Logger' class for spigot/bukkit.
     * @param plugin The MAIN class of your plugin that inherits either 'WMPlugin' or 'JavaPlugin'.
     * @param debug Tells the logger weather it should allow debug output.
     */
    public Logger(Plugin plugin, boolean debug)
    {
        name = plugin.getName();
        this.allowDebug = debug;
    }

    /**
     * Logs a blank output stream to the console.
     */
    public void Log()
    {
        Log(" ");
    }

    /**
     * Logs raw data to the console.
     * @param data The data or text to output to the console.
     */
    public void Log(String data)
    {
        Bukkit.getLogger().info(data);
    }

    /**
     * Logs a sorted status message to the console.
     * @param status The status to output as. (i.e.: INFO, WARNING, ERROR)
     * @param message The message to output as a status message.
     */
    public void Log(LogStatus status, String message)
    {
        if (CheckForDebug(allowDebug, status))
        {
            int id = getStatus(status);
            Log(colorByData(id, getStatusTag(id) + " " + message));
        }
        else
        {
            int id = getStatus(status);
            Log(colorByData(id, getStatusTag(id) + " " + message));
        }
    }

    /**
     * Logs a sorted status message in a listed format out to the console.
     * @param status The status to output as. (i.e.: INFO, WARNING, ERROR)
     * @param message The message to output as a status message.
     * @param output The list to format into the message.
     */
    public void Log(LogStatus status, String message, List<String> output)
    {
        String data = "";
        for (String s : output)
        {
            if (data == "" || data == null)
            {
                data = "    - " + s;
            }
            else
            {
                data += "\n    - " + s;
            }
            String outputData = getStatusTag(getStatus(status)) + "" + message + "\n" + data;
            Log(outputData);
        }
    }

    /**
     * Sets debug mode to true or false based on the setting 'debug'.
     * @param debug Tells weather the logger can or can't use debug output/
     */
    public void SetDebug(boolean debug)
    {
        this.allowDebug = debug;
    }

    /**
     * Checks weather debug output is currently allowed.
     * @param debug The current debug setting to check.
     * @param currentStatus The current status that was parsed, and checkes that it is indeed in debug status mode.
     * @return {@link Boolean} - Checks all settings that was passed and varifies that everything suggests debug mode. If true debug is accepted, if not it will not be used.
     */
    private boolean CheckForDebug(boolean debug, LogStatus currentStatus)
    {
        LogStatus[] debugStatuses = {LogStatus.DEBUG_INFO, LogStatus.DEBUG_WARNING, LogStatus.DEBUG_ERROR, LogStatus.DEBUG_SEVERE};
        int id = getStatus(currentStatus);
        for (LogStatus logStatus : debugStatuses)
        {
            int idx = getStatus(logStatus);
            if (id == idx && debug == true)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Converts 'LogStatus' to a numerical status id that is used by this logger class.
     * @param status The 'LogStatus' to parse.
     * @return {@link Integer} - The numerical ID of the status that was passed.
     */
    private int getStatus(LogStatus status)
    {
        int out = 0;
        if (status == LogStatus.DEBUG_INFO)
            out = -1;
        else if (status == LogStatus.DEBUG_WARNING)
            out = -2;
        else if (status == LogStatus.DEBUG_ERROR)
            out = -3;
        else if (status == LogStatus.DEBUG_SEVERE)
            out = -4;
        else if (status == LogStatus.INFO)
            out = 0;
        else if (status == LogStatus.WARNING)
            out = 1;
        else if (status == LogStatus.ERROR)
            out = 2;
        else if (status == LogStatus.SEVERE)
            out = 3;
        return out;
    }

    /**
     * Converts a numerical status id to a word-based status id that is pre-formatted to be sent as text in a log status message.
     * @param id The numerical id to parse and convert to a word-based one.
     * @return {@link String} - A pre-formatted that can be directly used in an output.
     */
    private String getStatusTag(int id)
    {
        String output = "";
        if (id == 0)
            output = "[INFO]";
        else if (id == 1)
            output = "[WARNING]";
        else if (id == 2)
            output = "[ERROR]";
        else if (id == 3)
            output = "[SEVERE]";
        else if (id == -1)
            output = "[DEBUG][INFO]";
        else if (id == -2)
            output = "[DEBUG][WARNING]";
        else if (id == -3)
            output = "[DEBUG][ERROR]";
        else if (id == -4)
            output = "[DEBUG][SEVERE]";
        else
            output = "[INFO]";
        return output;
    }

    /**
     * Converts all data provided into a string of Console-Compadible color schemes.
     * @param id The numerical id of the current status.
     * @param data The data in which will use the presented compadible formatted console color.
     * @return {@link String} - A string with console-based color.
     */
    private String colorByData(int id, String data)
    {
        String output = "";
        if (id == -1 || id == -2 || id == -3 | id == -4)
        {
            //Debug: Blue;
            data += ChatColor.AQUA;
        }
        else if (id == 1)
        {
            //Warning: Orange.
            data += ChatColor.GOLD;
        }
        else if (id == 2)
        {
            //Error: Red.
            data += ChatColor.RED;
        }
        else if (id == 3)
        {
            //Severe: Dark Red.
            data += ChatColor.DARK_RED;
        }
        return TextUtil.logToConsole(data);
    }

    /**
     * Contains all valid status values that can be used in 'Logger'.
     */
    public enum LogStatus
    {
        INFO, WARNING, ERROR, SEVERE, DEBUG_INFO, DEBUG_WARNING, DEBUG_ERROR, DEBUG_SEVERE
    }
}
