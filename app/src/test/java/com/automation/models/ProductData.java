package com.automation.models;

public class ProductData {
    private final String name;
    private final String type;
    private final String category;
    private final String price;

    private ProductData(Builder builder) {
        this.name     = builder.name;
        this.type     = builder.type;
        this.category = builder.category;
        this.price    = builder.price;
    }

    public String getName()     { return name; }
    public String getType()     { return type; }
    public String getCategory() { return category; }
    public String getPrice()    { return price; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String name;
        private String type     = "HOT_DISH";
        private String category;
        private String price;

        public Builder name(String name)         { this.name = name; return this; }
        public Builder type(String type)         { this.type = type; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder price(String price)       { this.price = price; return this; }

        public ProductData build() { return new ProductData(this); }
    }
}
