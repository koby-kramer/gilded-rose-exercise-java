package com.gildedrose;

public class ExtendedItem extends Item {
    /**
     * Extended item class to encompass Item Category for easier business logic.
     * Item Categories: Legendary Item, Conjured Item, Regular Item, Infaltion Item
     */
    public String category;

    public ExtendedItem(String name, int sellIn, int quality, String category){
        super(name, sellIn, quality);
        this.category = category;
    }

    @Override
    public String toString() {
        return (super.toString() + ", " + this.category)
    }
}