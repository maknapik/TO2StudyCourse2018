package com.kucyki.converter;

import com.kucyki.model.cell.Cell;
import com.kucyki.model.cell.Wall;
import org.jdom2.Element;

public class WallProvider implements ICellProvider {
    @Override
    public boolean accept(String type) {
        return type.equals("wall");
    }

    @Override
    public Cell getCell(Element cell) {
        return new Wall();
    }
}
