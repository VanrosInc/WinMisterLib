package lib.winmister332.wmlib.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Dictionary Created By: WinMister332 On 1/1/2018 At 10:48 PM.
 * Copyright © WinMister332 2018!
 */
public class Dictionary<K, V>
{
    private List<K> keys = null;
    private List<V> values = null;

    /**
     * Creates a new instance of the dictionary class.
     * @param size The maximum size of the dictionary.
     */
    public Dictionary(int size)
    {
        keys = new ArrayList<>(size);
        values = new ArrayList<>(size);
    }

    /**
     * Creates a new instance of the dictionary class.
     */
    public Dictionary()
    {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    /**
     * Adds the specified data to the dictionary.
     * @param key The key of the value.
     * @param value The primary value the key represents.
     */
    public void add(K key, V value)
    {
        keys.add(key);
        values.add(value);
    }

    /**
     * Removes the data from the dictionary.
     * @param key The key of the value.
     */
    public void remove(K key)
    {
        int id = keys.indexOf(key);
        keys.remove(id);
        values.remove(id);
    }

    /**
     * Gets the key of the value specified.
     * @param value The value that has the attached key to return.
     * @return {@link K} - The key that was attached to the specified value.
     */
    public K getKey(V value)
    {
        int id = values.indexOf(value);
        return keys.get(id);
    }

    /**
     * Gets the key of the value specified.
     * @param id The numerical id where the key is located.
     * @return {@link K} - The key that was attached to the specified ID.
     */
    public K getKey(int id)
    {
        return keys.get(id);
    }

    /**
     * Gets the value of the key specified.
     * @param key The key that has the attached value to return.
     * @return {@link V} - The value that was attached to the specified key.
     */
    public V getValue(K key)
    {
        int id = keys.indexOf(key);
        return values.get(id);
    }

    /**
     * Gets the value of the key specified.
     * @param id The numerical id where the key is located.
     * @return {@link V} - The value that was attached to the specified key.
     */
    public V getValue(int id)
    {
        return values.get(id);
    }

    /**
     * Clears the dictionary of all data.
     */
    public void clear()
    {
        values.clear();
        keys.clear();
    }

    /**
     * Gets the index of the specified key.
     * @param key The key of the ID to return.
     * @return {@link Integer} - The ID of the specified key.
     */
    public int indexOfKey(K key)
    {
        return keys.indexOf(key);
    }

    /**
     * Gets the index of the specified value.
     * @param value - The value of the ID to return.
     * @return {@link Integer} - The ID of the specified value;
     */
    public int indexOfValue(V value)
    {
        return values.indexOf(value);
    }

    /**
     * Checks and see if the dictionary contains the following key.
     * @param key The key to check.
     * @return {@link Boolean} - The result on whether the key exists in the dictionary.
     */
    public boolean containsKey(K key)
    {
        if (keys.contains(key)) return true;
        return false;
    }

    /**
     * Checks to see if a dictionary contains the following value.
     * @param value The value to check.
     * @return {@link Boolean} - The result on whether the value exists in the dictionary.
     */
    public boolean containsValue(V value)
    {
        if (values.contains(value)) return true;
        return false;
    }

    /**
     * Gets a collection of all the keys.
     * @return The collection of keys.
     */
    public List<K> getKeys()
    {
        return Collections.unmodifiableList(keys);
    }

    /**
     * Gets a collection of all the values.
     * @return The collection of values.
     */
    public List<V> getValues()
    {
        return Collections.unmodifiableList(values);
    }
}
