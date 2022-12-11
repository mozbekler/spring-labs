package com.cydeo.spring05thymeleaf.service.impl;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.CartItem;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());

    private final ProductService productService;

    /*public static void addToCart(){
       CART.getCartItemList().add(new CartItem(new Product(UUID.randomUUID(),10,5,BigDecimal.valueOf(1000),"PS"),2,BigDecimal.ZERO));
    }

     */

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){
        //todo retrieve product from repository method
        Product product = productService.findProductById(productId);
        product.setRemainingQuantity(product.getRemainingQuantity()-quantity);

        //todo initialise cart item


        if (CART.getCartItemList().stream().anyMatch(cartItem -> cartItem.getProduct().getName().equals(product.getName()))){
            CartItem cartItem2 = CART.getCartItemList().stream().filter(p -> p.getProduct().getId().equals(product.getId())).findFirst().orElseThrow();
            cartItem2.setQuantity(cartItem2.getQuantity()+quantity);
            cartItem2.setTotalAmount(cartItem2.getTotalAmount().add(product.getPrice().multiply(BigDecimal.valueOf(quantity))));
            CART.setCartTotalAmount(CART.getCartTotalAmount().add(product.getPrice().multiply(BigDecimal.valueOf(quantity))));
            return CART;
        }


        CartItem cartItem= new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

        //todo calculate cart total amount
        CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));



        //todo add to cart

        CART.getCartItemList().add(cartItem);

        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        //todo delete product object from cart using stream

        CartItem cartItem = CART.getCartItemList().stream().filter(p -> p.getProduct().getId().equals(productId)).findFirst().orElseThrow();

        CART.getCartItemList().removeIf(c->c.equals(cartItem));

        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(cartItem.getTotalAmount()));

        Product product = productService.findProductById(productId);
        product.setRemainingQuantity(product.getRemainingQuantity()+ cartItem.getQuantity());

        return true;
    }
}
