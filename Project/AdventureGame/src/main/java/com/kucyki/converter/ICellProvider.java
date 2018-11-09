package com.kucyki.converter;

import com.kucyki.model.cell.Cell;
import org.jdom2.Element;

public interface ICellProvider {
    boolean accept(String type);

    Cell getCell(Element cell);
}
