package com.leonardobishop.quests.itemgetter;

import com.leonardobishop.quests.Quests;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public interface ItemGetter {

    /**
     * Gets an ItemStack from a configuration.
     * Implementations should specific to the server version.
     *
     * @param path the path to where the item is defined in the config (null if item is defined in second param)
     * @param config the configuration file
     * @param plugin Quests plugin instance
     * @param excludes exclude certain fields in the configuration
     * @return {@link org.bukkit.inventory.ItemStack}
     */
    ItemStack getItem(String path, ConfigurationSection config, Quests plugin, Filter... excludes);

    /**
     * Gets an ItemStack from a given string (which represents a material).
     * For pre-1.13 server implementations, the string may use a data code.
     *
     * @param material the string
     * @return {@link org.bukkit.inventory.ItemStack}
     */
    ItemStack getItemStack(String material, Quests plugin);

    enum Filter {
        DISPLAY_NAME,
        LORE,
        ENCHANTMENTS,
        ITEM_FLAGS,
        UNBREAKABLE,
        ATTRIBUTE_MODIFIER,
        CUSTOM_MODEL_DATA;
    }
}