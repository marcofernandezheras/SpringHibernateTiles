package model;

import javax.persistence.*;

/**
 * Created by Marco A. Fernández Heras on 9/03/16.
 */
@Entity
@Table(name = "billDetail")
public class BillDetail {
    private int id;
    private Bill bill;
    private int lineOrder;
    private String title;
    private double price;
    private int amount;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lineOrder", nullable = false)
    public int getLineOrder() {
        return lineOrder;
    }

    public void setLineOrder(int order) {
        this.lineOrder = order;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 150)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "amount", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @ManyToOne
    @JoinColumn(name="idBill")
    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillDetail that = (BillDetail) o;

        if (id != that.id) return false;
        if (lineOrder != that.lineOrder) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (amount != that.amount) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + lineOrder;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + amount;
        return result;
    }
}
