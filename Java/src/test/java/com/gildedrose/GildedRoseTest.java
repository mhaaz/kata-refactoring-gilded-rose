package com.gildedrose;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append("OMGHAI!"+'\n');

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
                // this conjured item does not work properly yet
//                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 20; i++) {
            sb.append("-------- day " + i + " --------"+'\n');
            sb.append("name, sellIn, quality"+'\n');
            for (Item item : items) {
                sb.append(item.toString()+'\n');
            }
            sb.append('\n');
            app.updateQuality();
        }

        assertEquals(Files.readString(Path.of("expectedOutput.txt")), sb.toString());
    }
}
