package com.kucyki.model.cell;

import com.kucyki.model.item.Chest;
import com.kucyki.model.npc.INPC;

import java.util.ArrayList;
import java.util.List;

public class Room extends Cell {

    private List<INPC> npcs;
    private List<Chest> chests;

    public List<INPC> getNPCs() {
        if(npcs == null) {
            npcs = new ArrayList<>();
        }
        return npcs;
    }

    public List<Chest> getChests() {
        if(chests == null) {
            chests = new ArrayList<>();
        }
        return chests;
    }
}
