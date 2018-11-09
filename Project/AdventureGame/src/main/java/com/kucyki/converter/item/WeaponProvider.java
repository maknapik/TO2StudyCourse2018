package com.kucyki.converter.item;

import com.kucyki.model.item.IItem;
import com.kucyki.model.item.Weapon;
import org.jdom2.Element;

public class WeaponProvider implements IItemProvider {
    @Override
    public boolean accept(String type) {
        return type.equals("weapon");
    }

    @Override
    public IItem getItem(Element item) {
        String name = item.getChild("name").getValue();
        int power = Integer.parseInt(item.getChild("power").getValue());

        return new Weapon(name, power);
    }
}
