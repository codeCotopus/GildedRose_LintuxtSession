package gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void sellingValue_DecreasesEveryTime_ForNonLegendaries() {

        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality(); // This is how we move days ahead.

        assertEquals(-1, items[0].sellIn);

    }

    @Test
    void sellingValue_DoesNotDecrease_ForLegendaries() {
        Item [] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 2, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(2, items[0].sellIn);

    }
}
