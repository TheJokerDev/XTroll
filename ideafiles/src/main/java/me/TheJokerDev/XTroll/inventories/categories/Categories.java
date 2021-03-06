package me.TheJokerDev.XTroll.inventories.categories;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.inventories.Selector;
import me.TheJokerDev.XTroll.language.LBase;
import org.bukkit.entity.Player;
import xyz.theprogramsrc.supercoreapi.spigot.SpigotPlugin;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUI;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;
import xyz.theprogramsrc.supercoreapi.spigot.guis.objects.GUIRows;
import xyz.theprogramsrc.supercoreapi.spigot.items.SimpleItem;
import xyz.theprogramsrc.supercoreapi.spigot.utils.xseries.XMaterial;

public class Categories extends GUI {

    public Categories(SpigotPlugin plugin, Player player) {
        super(plugin, player);
        this.open();
    }

    @Override
    protected String getTitle() {
        return Main.prefix+ LBase.Titles_Categories.toString();
    }

    @Override
    protected GUIRows getRows() {
        return GUIRows.THREE;
    }

    @Override
    public boolean isTitleCentered() {
        return false;
    }

    @Override
    protected GUIButton[] getButtons() {
        return new GUIButton[]{this.getChatTrollsButton(), this.getWorldTrollsButton(), this.getToggleableTrollsButton(), getBackItem()};
    }

    private GUIButton getChatTrollsButton(){
        SimpleItem item = new SimpleItem(XMaterial.PAPER)
                .setDisplayName("&aChat")
                .setLore(
                        "&7",
                        "&7Chat trolls"
                );
        return new GUIButton(0, item, a-> {

        });
    }

    private GUIButton getWorldTrollsButton(){
        SimpleItem item = new SimpleItem(XMaterial.GRASS)
                .setDisplayName("&aWorld")
                .setLore(
                        "&7",
                        "&7World trolls"
                );
        return new GUIButton(1, item, a-> {

        });
    }

    private GUIButton getToggleableTrollsButton(){
        SimpleItem item = new SimpleItem(XMaterial.REDSTONE_TORCH)
                .setDisplayName("&aToggle")
                .setLore(
                        "&7",
                        "&7Toggleable trolls"
                );
        return new GUIButton(2, item, a-> {
            new ToggleCategory(Main.i, getPlayer());
        });
    }

    private GUIButton getBackItem(){
        return new GUIButton(18, Main.i.getPreloadedItems().getBackItem(), a-> {
            new Selector(getPlayer());
        });
    }

}
