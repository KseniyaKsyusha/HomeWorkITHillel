package ua.en.kosse.oksana.hillel.hw14;

import java.util.LinkedList;


public class CoffeeOrderBoard {
    public LinkedList<Order> orderList = new LinkedList<>();

    public void add(int orderNumber, String clientName) {
        orderList.addLast(new Order(orderNumber, clientName));

    }

    public Order deliver() {
        Order order = orderList.getFirst();
        orderList.removeFirst();
        return order;
    }

    public Order deliver(int orderNumber) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNumber() == orderNumber) {
                orderList.addFirst(orderList.get(i));
                orderList.remove(i + 1);
                this.deliver();
            }
        }
        return null;
    }

    public void draw() {
        System.out.println("===================================");
        System.out.println("Num\t\t\t|\tName");
        for (Order orders : orderList) {
            System.out.print(orders.getOrderNumber());
            System.out.print("\t\t\t|\t");
            System.out.println(orders.getClientName());
        }
    }


    @Override
    public String toString() {
        return "CoffeeOrderBoard{" +
                "orderList=" + orderList +
                '}';
    }
}
