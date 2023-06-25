package ua.en.kosse.oksana.hillel.hw18.one;


import java.time.LocalDate;


public class Product {
    private long id;
    private final TypeProduct type;
    private final int prices;
    private boolean discount;
    private LocalDate dateShop;

    public Product(TypeProduct type, int prices) {
        this.type = type;
        this.prices = prices;
    }

    public Product(TypeProduct type, int prices, boolean discount) {
        this.type = type;
        this.prices = prices;
        this.discount = discount;
    }

    public Product(TypeProduct type, int prices, boolean discount, LocalDate dateShop) {
        this.type = type;
        this.prices = prices;
        this.discount = discount;
        this.dateShop = dateShop;
    }

    public Product(long id, TypeProduct type, int prices, boolean discount, LocalDate dateShop) {
        this.id = id;
        this.type = type;
        this.prices = prices;
        this.discount = discount;
        this.dateShop = dateShop;
    }

    public TypeProduct getType() {
        return type;
    }

    public int getPrices() {
        return prices;
    }

    public LocalDate getDateShop() {
        return dateShop;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type=" + type +
                ", prices=" + prices +
                ", discount=" + discount +
                ", dateShop=" + dateShop +
                '}';
    }

    public int compareTo(Product productNew) {
        return this.getPrices() - productNew.getPrices();

    }

}
