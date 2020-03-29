package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void checkFirstItemName() {
        GildedRose app = new GildedRose();
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
    }

    @Test
    void checkThirdItemUpdatedQuality() {
        GildedRose app = new GildedRose();
        app.updateQuality();
        assertEquals(6, app.items[2].quality);
    }

    @Test
    void checkSulfurasStaticQuality() {
        GildedRose app = new GildedRose();
        app.updateQuality();
        assertEquals(80, app.items[3].quality);
    }

    @Test
    void checkAgedBrieQualityIncreased() {
        GildedRose app = new GildedRose();
        app.updateQuality();
        assertTrue(app.items[1].quality > 0);
    }

    @Test
    void checkSellInValueDecreased() {
        GildedRose app = new GildedRose();
        app.updateQuality();
        assertTrue(app.items[1].sellIn < 10);
    }
    
    @Test  
    void checkBackstagePassSellIn10QualityIncease() {
        GildedRose app = new GildedRose();
        app.items[4].sellIn = 10;
        app.updateQuality();
        assertEquals(22,app.items[4].quality);
    }

    @Test  
    void checkBackstagePassSellIn5QualityIncease() {
        GildedRose app = new GildedRose();
        app.items[4].sellIn = 5;
        app.updateQuality();
        assertEquals(23,app.items[4].quality);
    }

    @Test
    void checkBackstagePassQualityZerosOut() {
        GildedRose app = new GildedRose();
        app.items[4].sellIn = 0;
        app.updateQuality();
        assertEquals(0, app.items[4].quality);
    }
    
    @Test
    void checkQualityDegradesTwiceAfterSellIn() {
        GildedRose app = new GildedRose();
        app.items[0].sellIn = -1;
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
    }
}
