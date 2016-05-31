package model;

/**
 * Created by Marco A. Fernández Heras on 24/05/16.
 */
public class AjaxCartResponse {

    public static final int OK_CODE = 1;
    public static final int FAIL_CODE = 0;

    private int code = FAIL_CODE;
    private int cartAmount = 0;
    private int lineAmount = 1;
    private double subtotal = 0;
    private double total = 0;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(int cartAmount) {
        this.cartAmount = cartAmount;
    }

    public int getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(int lineAmount) {
        this.lineAmount = lineAmount;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
