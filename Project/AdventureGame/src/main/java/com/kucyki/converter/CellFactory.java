package com.kucyki.converter;

import com.kucyki.model.cell.Cell;
import org.jdom2.Element;

import java.util.Arrays;
import java.util.List;

class CellFactory {

    private static List<ICellProvider> providers = Arrays.asList(new RoomProvider(), new WallProvider());

    static Cell getCell(Element cell) {
        String type = cell.getAttribute("type").getValue();

        return getProvider(type).getCell(cell);
    }

    private static ICellProvider getProvider(String type) {
        for(ICellProvider provider : providers) {
            if(provider.accept(type)) {
                return provider;
            }
        }
        return null;
    }
}
