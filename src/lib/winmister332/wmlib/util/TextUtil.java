package lib.winmister332.wmlib.util;

import org.bukkit.ChatColor;

/**
 * TextUtil Created By: WinMister332 On 9/10/2017 At 2:24 PM!
 * Copyright © WinMister332 2017!
 */
public class TextUtil
{
    /**
     * Converts spigot/bukkit 'ChatColor' into standered java console-based color.
     * @param data String raw data to parse.
     * @return String - A formatted string with console compadible colors.
     */
    public static String logToConsole(String data)
    {
        data = data.replaceAll("§0", "\003[0;30;40m");
        data = data.replaceAll("§1", "\003[0;34;40m");
        data = data.replaceAll("§2", "\003[0;32;40m");
        data = data.replaceAll("§3", "\003[0;36;40m");
        data = data.replaceAll("§4", "\003[0;31;40m");
        data = data.replaceAll("§5", "\003[0;35;40m");
        data = data.replaceAll("§6", "\003[0;33;40m");
        data = data.replaceAll("§7", "\003[0;37;40m");
        data = data.replaceAll("§8", "\003[1;30;40m");
        data = data.replaceAll("§9", "\003[1;34;40m");
        data = data.replaceAll("§a", "\003[1;32;40m");
        data = data.replaceAll("§b", "\003[1;36;40m");
        data = data.replaceAll("§c", "\003[1;31;40m");
        data = data.replaceAll("§d", "\003[1;35;40m");
        data = data.replaceAll("§e", "\003[1;33;40m");
        data = data.replaceAll("§f", "\003[0;0;0m");
        return data;
    }

    /**
     * Translates an input containing a color code using the selector symbol '§' and converts it to an ampersand colorcode value.
     * @param input The input containing the selection symbol color codes.
     * @return {@link String} - The codes that where converted to standard generic ampersand symbol colorcode.
     */
    public static String translateColorCodes(String input)
    {
        String x = input;
        if (x.contains("§")) x = x.replaceAll("§", "&");
        x = ChatColor.translateAlternateColorCodes('&', x);
        return x;
    }

    /**
     * Removes some unwanted values that could appear in a string where those values should not exist.
     * @param unsafeString The string containing the unwanted values that need to be purged.
     * @return {@link String} - A string no longer containing unwanted values and that are able to be used in code.
     */
    public static String convertToSafeString(String unsafeString)
    {
        String x = unsafeString;
        x = x.replaceAll("\\s+", "");
        x = x.replaceAll("-", "");
        x = x.replaceAll("!", "");
        x = x.replaceAll("@", "");
        x = x.replaceAll("#", "");
        x = x.replaceAll("%", "");
        x = x.replaceAll("^", "");
        x = x.replaceAll("&", "");
        x = x.replaceAll("=", "");
        x = x.replaceAll("`", "");
        x = x.replaceAll("~", "");
        x = x.replaceAll("|", "");
        x = x.replaceAll("/", "");
        x = x.replaceAll("\"", "");
        x = x.replaceAll("<", "");
        x = x.replaceAll(">", "");
        x = x.replaceAll(",", "");
        x = x.replaceAll(":", "");
        x = x.replaceAll(";", "");
        return x;
    }

    @Deprecated
    /**
     * Converts an object into a logger based string.
     * <br>
     * WARNING: Will be removed in a future release.
     * @param object The object that will be returned as a logger based string.
     * @return {@link String} - The name of the specified object in a logger-like bracket format.
     */
    public static String toString(Object object)
    {
        String string = "[" + object.getClass().getCanonicalName() + "] " + object.getClass().toString();
        return string;
    }
}
