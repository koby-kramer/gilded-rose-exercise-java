package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void checkVestName() {
        final GildedRose app = new GildedRose();
        final ExtendedItem vest = app.items.get("+5 Dexterity Vest");
        assertEquals("+5 Dexterity Vest", vest.name);
    }

    @Test
    void checkMongooseElixirUpdatedQuality() {
        final GildedRose app = new GildedRose();
        final int preUpdateElixerQuality = app.items.get("Elixir of the Mongoose").quality;
        app.updateInventory();
        final int postUpdateElixerQuality = app.items.get("Elixir of the Mongoose").quality;
        assertEquals(preUpdateElixerQuality - 1, postUpdateElixerQuality);
    }

    @Test
    void checkSulfurasStaticQuality() {
        final GildedRose app = new GildedRose();
        final int preUpdateSulfurasQuality = app.items.get("Sulfuras, Hand of Ragnaros").quality;
        app.updateInventory();
        final int postUpdateSulfurasQuality = app.items.get("Sulfuras, Hand of Ragnaros").quality;
        assertEquals(preUpdateSulfurasQuality, postUpdateSulfurasQuality);
    }

    @Test
    void checkAgedBrieQualityIncreased() {
        final GildedRose app = new GildedRose();
        final int preUpdateAgedBrieQuality = app.items.get("Aged Brie").quality;
        app.updateInventory();
        final int postUpdateAgedBrieQuality = app.items.get("Aged Brie").quality;
        assertEquals(preUpdateAgedBrieQuality + 1, postUpdateAgedBrieQuality);
    }
    
    @Test
    void checkSellInValueDecreased() {
        final GildedRose app = new GildedRose();
        final int preUpdateManaCakeSellIn = app.items.get("Conjured Mana Cake").sellIn;
        app.updateInventory();
        final int postUpdateManaCakeSellIn = app.items.get("Conjured Mana Cake").sellIn;
        assertEquals(preUpdateManaCakeSellIn - 1, postUpdateManaCakeSellIn);
    }
    
    @Test
    void checkBackstagePassSellIn10QualityIncease() {
        final GildedRose app = new GildedRose();
        final ExtendedItem passes = app.items.get("Backstage passes to a TAFKAL80ETC concert");
        final int preUpdatePassQuality = passes.quality;
        passes.sellIn = 10;
        app.updateInventory();
        final int postUpdatePassQuality = passes.quality;
        assertEquals(preUpdatePassQuality + 2, postUpdatePassQuality);
    }

    @Test
    void checkBackstagePassSellIn5QualityIncease() {
        final GildedRose app = new GildedRose();
        final ExtendedItem passes = app.items.get("Backstage passes to a TAFKAL80ETC concert");
        final int preUpdatePassQuality = passes.quality;
        passes.sellIn = 5;
        app.updateInventory();
        final int postUpdatePassQuality = passes.quality;
        assertEquals(preUpdatePassQuality + 3, postUpdatePassQuality);
    }

    @Test
    void checkBackstagePassQualityZerosOut() {
        final GildedRose app = new GildedRose();
        final ExtendedItem passes = app.items.get("Backstage passes to a TAFKAL80ETC concert");
        passes.sellIn = 0;
        app.updateInventory();
        final int postUpdatePassQuality = passes.quality;
        assertEquals(0, postUpdatePassQuality);
    }

    @Test
    void checkQualityDegradesTwiceAfterSellIn() {
        final GildedRose app = new GildedRose();
        final ExtendedItem vest = app.items.get("+5 Dexterity Vest");
        final int preUpdateVestQuality = vest.quality;
        vest.sellIn = -1;
        app.updateInventory();
        final int postUpdateVestQuality = vest.quality;
        assertEquals(preUpdateVestQuality - 2, postUpdateVestQuality);
    }
    
    @Test
    void checkConjuredItemQualityDegradeTwice(){
        final GildedRose  app = new GildedRose();
        final ExtendedItem conjuredItem = app.items.get("Conjured Mana Cake");
        final int preUpdateConjuredItemQuality = conjuredItem.quality;
        app.updateInventory();
        final int postUpdateConjuredItemQuality = conjuredItem.quality;
        assertEquals(preUpdateConjuredItemQuality - 2, postUpdateConjuredItemQuality);
    }
    
    @Test
    void checkConjuredItemQualityDegradeAtZeroSellIn(){
        final GildedRose  app = new GildedRose();
        final ExtendedItem conjuredItem = app.items.get("Conjured Mana Cake");
        final int preUpdateConjuredItemQuality = conjuredItem.quality;
        conjuredItem.sellIn = -1;
        app.updateInventory();
        final int postUpdateConjuredItemQuality = conjuredItem.quality;
        assertEquals(preUpdateConjuredItemQuality - 4, postUpdateConjuredItemQuality);
    }
}
