/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.shopping;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Cart {

    private Map<String, Tea> cart;

    public Cart() {
    }

    public Cart(Map<String, Tea> cart) {
        this.cart = cart;
    }

    public Map<String, Tea> getCart() {
        return cart;
    }

    public void setCart(Map<String, Tea> cart) {
        this.cart = cart;
    }

    public void add(Tea tea) {
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(tea.getId())) {
            int currentQuantity = this.cart.get(tea.getId()).getQuantity();
            tea.setQuantity(currentQuantity + tea.getQuantity());
        }
        cart.put(tea.getId(), tea);
    }

    public void delete(String id) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }

    public void update(String id, Tea newTea) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.replace(id, newTea);
        }
    }

}
