package com.kucyki.converter.item;

import com.kucyki.model.item.IItem;
import org.jdom2.Element;

import java.util.Arrays;
import java.util.List;

public class ItemFactory {
    private static List<IItemProvider> providers = Arrays.asList(new WeaponProvider());

    public static IItem getItem(Element item) {
        String type = item.getAttribute("type").getValue();

        return getProvider(type).getItem(item);
    }

    private static IItemProvider getProvider(String type) {
        for(IItemProvider provider : providers) {
            if(provider.accept(type)) {
                return provider;
            }
        }
        return null;
    }
}
