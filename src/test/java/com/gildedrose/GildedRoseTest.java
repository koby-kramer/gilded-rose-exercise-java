package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        GildedRose app = new GildedRose();
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}
