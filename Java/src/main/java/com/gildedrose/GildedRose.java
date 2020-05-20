package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // Lesbarkeit verbessert; an Struktur sind wir verzweifelt xD
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (isNotItem(i, "Aged Brie")
                    && isNotItem(i, "Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (isNotItem(i, "Sulfuras, Hand of Ragnaros")) {
                        item.quality--;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality++;

                    if (!isNotItem(i, "Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality++;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality++;
                            }
                        }
                    }
                }
            }

            if (isNotItem(i, "Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (isNotItem(i, "Aged Brie")) {
                    if (isNotItem(i, "Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (isNotItem(i, "Sulfuras, Hand of Ragnaros")) {
                                item.quality--;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                }
            }
        }
    }

    private boolean isNotItem(int index, String itemName) {
        return !items[index].name.equals(itemName);
    }
}