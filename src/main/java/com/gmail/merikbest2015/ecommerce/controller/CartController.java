package com.gmail.merikbest2015.ecommerce.controller;

import com.gmail.merikbest2015.ecommerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.gmail.merikbest2015.ecommerce.constants.PathConstants.CART;

@Controller
@RequestMapping(CART)
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public String getCart(Model model) {
        model.addAttribute("perfumes", cartService.getPerfumesInCart());
        return "cart";
    }

    @PostMapping("/add")
    public String addPerfumeToCart(@RequestParam("perfumeId") Long perfumeId) {
        cartService.addPerfumeToCart(perfumeId);
        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String removePerfumeFromCart(@RequestParam("perfumeId") Long perfumeId) {
        cartService.removePerfumeFromCart(perfumeId);
        return "redirect:/cart";
    }
}
