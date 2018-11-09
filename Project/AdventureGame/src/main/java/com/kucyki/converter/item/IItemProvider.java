package com.kucyki.converter.item;

import com.kucyki.model.item.IItem;
import org.jdom2.Element;

public interface IItemProvider {
    boolean accept(String type);

    IItem getItem(Element item);
}
