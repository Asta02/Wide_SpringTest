package astratech.latihanspring010.service;

import astratech.latihanspring010.model.OrderCart;
import astratech.latihanspring010.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderCartService {
    private List<Product> cartProducts = new ArrayList<>();

    public List<Product> getCart() {
        return cartProducts;
    }

    public void addProductToCart(Product product) {
        cartProducts.add(product);
    }

    public OrderCart placeOrder() {
        OrderCart orderCart = new OrderCart();
        orderCart.setProducts(cartProducts);
        cartProducts.clear();  // Clear the cart after placing the order
        return orderCart;
    }
}
