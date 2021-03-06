package me.TheJokerDev.XTroll.inventories.categories;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.language.LBase;
import me.TheJokerDev.XTroll.utils.TrollItems;
import org.bukkit.entity.Player;
import xyz.theprogramsrc.supercoreapi.spigot.SpigotPlugin;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUI;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;
import xyz.theprogramsrc.supercoreapi.spigot.guis.objects.GUIRows;

public class ToggleCategory extends GUI {
    public ToggleCategory(SpigotPlugin plugin, Player player) {
        super(plugin, player);
        this.open();
    }

    @Override
    protected String getTitle() {
        return Main.prefix + LBase.Titles_InCategory.options().placeholder("{category}", "Toggle").toString(); }

    @Override
    public boolean isTitleCentered() {
        return false;
    }

    @Override
    protected GUIRows getRows() {
        return GUIRows.ONE;
    }

    @Override
    protected GUIButton[] getButtons() {
        return new GUIButton[]{TrollItems.FreezePlayerItem(0, getPlayer()),TrollItems.getBackItem(8, 1)};
    }
}
