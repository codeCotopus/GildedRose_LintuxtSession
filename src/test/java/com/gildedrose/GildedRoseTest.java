package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality(); // This is how we move days ahead.



        assertEquals("fixme", app.items[0].name);
    }


    @Test
    void sellingValue_DecreasesEveryTime_ForNonLegendaries (){

        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality(); // This is how we move days ahead.

        assertEquals(items[0].sellIn,-1);
+
    }
}
