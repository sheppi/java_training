package com.epam.xmlworker.entity;

import com.epam.xmlworker.entity.additional.Price;

import java.util.List;
import java.util.UUID;

/**
 * Created by Kirill Kaluga on 21.07.2016.
 */
public class Action {
    private final UUID id;
    private String name;
    private double manhours;
    private Price price;
    private List<Spare> spares;

    public Action(UUID actionID){
        this.id = actionID;
    }

    public Action(UUID id, String name, double manhours, Price price, List<Spare> spares) {
        this.id = id;
        this.name = name;
        this.manhours = manhours;
        this.price = price;
        this.spares = spares;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManhours(double manhours) {
        this.manhours = manhours;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setSpares(List<Spare> spares) {
        this.spares = spares;
    }
}
