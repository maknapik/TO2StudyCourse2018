package com.kucyki;

import com.kucyki.converter.WorldConverter;
import com.kucyki.model.World;

public class Main {

    public static void main(String[] args) {
        World world = WorldConverter.convert();
        System.out.println(world.getWidth());
    }
}
