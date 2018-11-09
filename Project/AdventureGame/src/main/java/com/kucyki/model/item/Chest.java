package com.kucyki.model.item;

import java.util.ArrayList;
import java.util.List;

public class Chest {

    private List<IItem> items;

    public List<IItem> getItems() {
        if(items == null) {
            items = new ArrayList<>();
        }
        return items;
    }
}
