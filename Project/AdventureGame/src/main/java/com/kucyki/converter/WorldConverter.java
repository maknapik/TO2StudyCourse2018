package com.kucyki.converter;

import com.kucyki.model.World;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.DataConversionException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class WorldConverter {

    public static World convert() {
        File inputFile = new File("data/world.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;

        try {
            document = saxBuilder.build(inputFile);
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }

        Element worldSettings = document.getRootElement();
        World world = convertWorldSettings(worldSettings);

        List<Element> cells = worldSettings.getChildren();

        for(int y = 0 ; y < world.getHeight() ; y++) {
            for(int x = 0 ; x < world.getWidth() ; x++) {
                world.setCell(x, y, CellFactory.getCell(cells.get(x * world.getWidth() + y)));
            }
        }

        return world;
    }

    private static World convertWorldSettings(Element worldSettings) {
        try {
            int width = worldSettings.getAttribute("width").getIntValue();
            int height = worldSettings.getAttribute("height").getIntValue();
            return new World(width, height);
        } catch (DataConversionException e) {
            e.printStackTrace();
        }
        return new World(0, 0);
    }
}
