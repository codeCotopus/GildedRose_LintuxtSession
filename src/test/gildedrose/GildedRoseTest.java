package gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void sellingValue_DecreasesEveryTime_ForNonLegendaries() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        assertSellinValue(items, -1);
    }

    @Test
    void sellingValue_DoesNotDecrease_ForLegendaries() {
        Item [] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 2, 80)};
        assertSellinValue(items, 2);
    }

    private void assertSellinValue(Item[] items, int i) {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(i, items[0].sellIn);
    }

}
