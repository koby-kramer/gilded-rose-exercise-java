package com.gildedrose;

import java.util.HashMap;

class GildedRose {
    HashMap<String, ExtendedItem> items = new HashMap<String, ExtendedItem>();
    final static int MAXQUALITY = 50;
    final static int MINQUALITY = 0;

    public GildedRose() {
        this.addItem(new ExtendedItem("+5 Dexterity Vest", 10, 20, "Normal"));
        this.addItem(new ExtendedItem("Aged Brie", 2, 0, "Inflation"));
        this.addItem(new ExtendedItem("Elixir of the Mongoose", 5, 7, "Regular"));
        this.addItem(new ExtendedItem("Sulfuras, Hand of Ragnaros", 0, 80, "Legendary"));
        this.addItem(new ExtendedItem("Backstage passes to a TAFKAL80ETC concert", 15, 20, "Inflation"));
        this.addItem(new ExtendedItem("Conjured Mana Cake", 3, 6, "Conjured"));
    }

    public void addItem(ExtendedItem item) {
        this.items.put(item.name, item);
    }

    public void updateQuality(ExtendedItem item) {
        if (item.quality == MAXQUALITY || item.quality == MINQUALITY)
            return;
        int updateQualityFactor = item.sellIn > 0 ? 1 : 2;
        if (item.category == "Inflation") {
            switch (item.name) {
                case "Aged Brie":
                    // Aged Brie grows in quality as time goes on.
                    item.quality = item.quality + 1;
                    break;
                case "Backstage passes to a TAFKAL80ETC concert.":
                    // Backstage passes get more valuable as the concert comes closer;
                    if (item.sellIn > 10)
                        item.quality += 1;
                    else if (item.sellIn <= 10 && item.sellIn > 5)
                        item.quality += 2;
                    else if (item.sellIn <= 5 && item.sellIn > 0)
                        item.quality += 3;
                    else
                        item.quality = 0;
                    break;
            }
        } else if (item.category == "Conjured") {
            // Conjured Items degrade twice as fast as regular items.
            item.quality -= 2 * updateQualityFactor;
        } else if (item.category == "Regular") {
            // Normal decary rates.
            item.quality -= 1 * updateQualityFactor;
        }
    }

    public void updateInventory() {
        this.items.forEach((itemKey, item) -> updateQuality(item));
    }
}
