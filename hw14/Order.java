package ua.en.kosse.oksana.hillel.hw14;

public class Order {
    protected int orderNumber;
    protected String clientName;

    public Order(int orderNumber, String clientName) {
        this.orderNumber = orderNumber;
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}
