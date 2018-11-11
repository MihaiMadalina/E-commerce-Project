
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {

    private int orderID;
    private Payment payment;
    private Delivery delivery;
    private double totalPrice;
    private int quantity; // number of each product from the shopping cart
    private List<Product> shoppingCart;
    private Map<Product, Integer> productStock;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // method to add an item to the shopping cart
    public void addCartItem(Product item){
        shoppingCart.add(item);
    }

    // method to remove an item from the shopping cart
    public void removeCartItem(Product item) {
        if(shoppingCart.contains(item)) {
            shoppingCart.remove(item);
        }
    }

    // method to remove all items from the shopping cart
    public void emptyCart(){
        shoppingCart.removeAll(shoppingCart);
    }

    // method to view all items from the shopping cart
    public void displayShoppingCart(){

        System.out.println("The products from your shopping cart are the following: ");
        System.out.println("Product ID\t Product\t Price\t Quantity");
        for(Product items : shoppingCart){
            System.out.println(items.getIdProduct() + "\t" + items.getProductName() + "\t" + items.getPriceProduct() + "\t" + getQuantity());
        }
        System.out.println("0 - back");
        System.out.println("1 - next");
    }

    // method to calculate the total price of the items from the shopping cart
    public double calcShoppingCartTotal(){
        double totalPrice = 0.0; // declare and initiate the total which is 0
        for (Product item : shoppingCart) { // go through all products
            totalPrice += item.getPriceProduct();
        }
        return totalPrice;
    }

    public void buyProduct(Product product){
        // ............
    }

    public void deliverProduct(Product product){
        // ............
    }
}