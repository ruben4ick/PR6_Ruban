package org.example;

import java.util.ArrayList;
import java.util.List;

public class WarehouseSystem {
    private List<Good> goods;

    public WarehouseSystem() {
        this.goods = new ArrayList<>();
    }

    public void login(String username, String password) {
        System.out.println("Logged in as " + username);
    }

    public void addGood(Good good) {
        goods.add(good);
    }

    public boolean hasAllGoods() {
        return !goods.isEmpty();
    }

    public List<Good> getGoods() {
        return goods;
    }

    public int getTotalQuantity() {
        return goods.stream().mapToInt(Good::getQuantity).sum();
    }
}