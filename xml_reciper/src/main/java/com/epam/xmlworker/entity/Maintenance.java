package com.epam.xmlworker.entity;

import com.epam.xmlworker.entity.additional.Price;
import com.epam.xmlworker.entity.additional.Unit;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

/**
 * Created by Kirill Kaluga on 21.07.2016.
 */
public class Maintenance {
    private final UUID id;
    private String name;
    private Price price;
    private short level;
    private Unit unit;
    private List<Action> actions;

    public Maintenance(UUID id){
        this.id = id;
    }

    public Maintenance(UUID id, String name, Price price, short level, Unit unit, List<Action> actions) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.level = level;
        this.unit = unit;
        this.actions = actions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
