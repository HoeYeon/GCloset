package com.gcloset.web.enums;

public enum ClothType {
    JEAN("Jean"),
    TSHIRT("T-shirt"),
    SHIRT("Shirt"),
    SKIRT("Skirt"),
    SHOES("Shoes"),
    BAG("Bag"),
    SOCKS("Socks");

    private String name;

    ClothType(String name) {
        this.name = name;
    }
    public static ClothType fromString(String text) {
        for (ClothType b : ClothType.values()) {
            if (b.name.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
