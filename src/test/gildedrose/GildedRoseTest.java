package gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


    //TESTS FOR SELLIN
    @Test
    void sellingValue_DecreasesEveryTime_ForNonLegendaries() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        assertSellinValue(items, -1);
    }

    @Test
    void sellingValue_DoesNotDecrease_ForLegendaries() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 80)};
        assertSellinValue(items, 2);
    }

    private void assertSellinValue(Item[] items, int i) {
        initAndOneUpdate(items);
        assertEquals(i, items[0].sellIn);
    }

    private GildedRose initAndOneUpdate(Item[] items) {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app;
    }


    @Test
    void quality_Decrease_WithUpdate_RegularItems() { // A regular item is non brie , not bakcstage pass , no legendary
        Item[] items = new Item[]{new Item("foo", 10, 10)};
        initAndOneUpdate(items);
        assertEquals(9, items[0].quality);
    }

    @Test
    void quality_RemainsZero_OnceItReachesZero() { // A regular item is non brie , not bakcstage pass , no legendary
        Item[] items = new Item[]{new Item("foo", 1, 0), new Item("negativeSellin", -1, 0)};
        GildedRose app = initAndOneUpdate(items);
        assertEquals(0, items[0].quality);
        assertEquals(0, items[1].quality);
        app.updateQuality();
        assertEquals(0, items[0].quality);
        assertEquals(0, items[1].quality);
    }

}
