/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.shopping;

/**
 *
 * @author Admin
 */
public class Tea {

    private String id;
    private String name;
    private int quantity;
    private int price;

    public Tea() {
        this.id = "";
        this.name = "";
        this.quantity = 0;
        this.price = 0;
    }

    public Tea(String id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tea{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + '}';
    }

}
