package com.aca.generactive.generactiveweb.repository;

import com.aca.generactive.generactiveweb.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private static ItemRepository sInstance;

    private final List<Item> items = new ArrayList<>();

    public static ItemRepository getInstance() {
        if (sInstance == null) {
            sInstance = new ItemRepository();
        }

        return sInstance;
    }

    public Item addItem(Item item) {
        this.items.add(item);

        return item;
    }

    public void addItemAll(List<Item> items) {
        this.items.addAll(items);
    }

    public Item findItemById(int itemId) {
        for (Item item: items) {
            if (item.getId() == itemId) {
                return item;
            }
        }

        return null;
    }

    public List<Item> findAll() {
        return this.items;
    }

    private ItemRepository() {

    }


}
