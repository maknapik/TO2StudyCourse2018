package com.kucyki.converter;

import com.kucyki.converter.item.ItemFactory;
import com.kucyki.model.cell.Cell;
import com.kucyki.model.cell.Room;
import com.kucyki.model.item.Chest;
import com.kucyki.model.item.IItem;
import org.jdom2.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomProvider implements ICellProvider {

    @Override
    public boolean accept(String type) {
        return type.equals("room");
    }

    @Override
    public Cell getCell(Element cell) {
        Room room = new Room();

        room.getChests().addAll(getChests(cell.getChildren("chest")));

        return room;
    }

    private List<Chest> getChests(List<Element> elements) {
        List<Chest> chests = new ArrayList<>();

        for (Element element : elements) {
            chests.add(getChest(element));
        }

        return chests;
    }

    private Chest getChest(Element element) {
        Chest chest = new Chest();

        chest.getItems().addAll(getItems(element.getChildren()));

        return chest;
    }

    private List<IItem> getItems(List<Element> elements) {
        return elements.stream().map(ItemFactory::getItem).collect(Collectors.toList());
    }
}
