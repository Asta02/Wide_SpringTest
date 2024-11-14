package astratech.latihanspring010.controller;

import astratech.latihanspring010.model.OrderCart;
import astratech.latihanspring010.model.Product;
import astratech.latihanspring010.service.OrderCartService;
import astratech.latihanspring010.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class OrderCartController {
    @Autowired
    private OrderCartService orderCartService;

    @Autowired
    private ProductService productService;

    // Get the current order cart
    @GetMapping
    public List<Product> getCart() {
        return orderCartService.getCart();
    }

    // Add a product to the cart
    @PostMapping("/add/{productId}")
    public void addProductToCart(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            orderCartService.addProductToCart(product);
        }
    }

    // Place the order and clear the cart
    @PostMapping("/placeOrder")
    public OrderCart placeOrder() {
        return orderCartService.placeOrder();
    }
}
