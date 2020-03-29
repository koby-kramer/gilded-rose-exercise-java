package com.gildedrose;

import java.util.HashMap;

class GildedRose {
    HashMap<String, ExtendedItem> items = new HashMap<String, ExtendedItem>();

    public GildedRose() {
            this.addItem(new ExtendedItem("+5 Dexterity Vest", 10, 20, "Normal"));
            this.addItem(new ExtendedItem("Aged Brie", 2, 0, "Cheese"));
            this.addItem(new ExtendedItem("Elixir of the Mongoose", 5, 7, "Regular"));
            this.addItem(new ExtendedItem("Sulfuras, Hand of Ragnaros", 0, 80, "Legendary"));
            this.addItem(new ExtendedItem("Backstage passes to a TAFKAL80ETC concert", 15, 20, "Inflation"));
            this.addItem(new ExtendedItem("Conjured Mana Cake", 3, 6, "Conjured"));
    }

    public void addItem(ExtendedItem item) {
        this.items.put(item.name, item);
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
