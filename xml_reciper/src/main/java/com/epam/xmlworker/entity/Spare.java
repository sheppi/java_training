package com.epam.xmlworker.entity;

import com.epam.xmlworker.entity.additional.Price;
import com.epam.xmlworker.entity.additional.SpareType;

import java.util.List;
import java.util.UUID;

/**
 * Created by Kirill Kaluga on 21.07.2016.
 */
public class Spare {
    private final UUID storeID;
    private UUID productID;
    private String name;
    private Price price;
    private SpareType type;
    private String manufacturer;
    private String supplier;

    public Spare(UUID storeID) {
        this.storeID = storeID;
    }

    public Spare(UUID storeID, UUID productID, String name, Price price, SpareType type, String manufacturer, String supplier) {
        this.storeID = storeID;
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.type = type;
        this.manufacturer = manufacturer;
        this.supplier = supplier;
    }

    public void setProductID(UUID productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setType(SpareType type) {
        this.type = type;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
