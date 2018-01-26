package lib.winmister332.wmlib.spigot.library.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * CommandArgs Created By: WinMister332 On 1/6/2018 At 10:20 PM.
 * Copyright © WinMister332 2018!
 */
public class CommandArgs
{
    private List<String> args = null;

    public CommandArgs(String[] args)
    {
        this.args = new ArrayList<>(args.length);
        for (String s : args)
        {
            this.args.add(s);
        }
    }

    public CommandArgs(List<String> args)
    {
        this((String[])args.toArray());
    }

    /**
     * Checks to see if there are any arguments that where parsed to this class.
     * @return {@link Boolean} - Where arguments parsed to this class?
     */
    public boolean isEmpty()
    {
        if (args.size() == 0) return true;
        return false;
    }

    /**
     * Gets the arg that is at the specified position in the arg array.
     * @param position The position to find the arg in the array.
     * @return {@link String} - The arg that was found at the position. Null if none.
     */
    public String getArgAtPosition(final int position)
    {
        String[] argx = (String[])args.toArray();
        return argx[position];
    }

    /**
     * Checks to see if the argument exists within the arg array.
     * @param s The arg to look for.
     * @return {@link Boolean} - Was the arg found in the array?
     */
    public boolean contains(final String s)
    {
        if (args.contains(s)) return true;
        return false;
    }

    /**
     * Gets the index of the following argument in the array.
     * @param arg The arg to look for.
     * @return {@link Integer} - The id of the specified arg in the array.
     */
    public int getIndexOfArg(final String arg)
    {
        return args.indexOf(arg);
    }

    /**
     * Creates a new array at the specified string.
     * @param arg The arg to clip at.
     * @return {@link String[]} - The arg array that was clipped from the following position.
     */
    public String[] Skip(final String arg)
    {
        return Skip(getIndexOfArg(arg));
    }

    /**
     * Creates a new array at the specified position.
     * @param position The position to clip the new array from.
     * @return {@link String[]} - The arg array that was clipped from the following position.
     */
    public String[] Skip(final int position)
    {
        return (String[])args.subList(position, args.size()).toArray();
    }
}
