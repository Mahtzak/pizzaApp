package com.mahtzak.pizzeriamanagementapp.web.controllers;


import com.mahtzak.pizzeriamanagementapp.domain.model.Product;
import com.mahtzak.pizzeriamanagementapp.domain.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/add")
    public String prepareAddProductForm(Model model){
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(@Valid Product product, BindingResult result){
        if(result.hasErrors()){
            return "add-product";
        }
        productRepository.save(product);
        return "landing-site";
    }

    @GetMapping("/all")
    public String listAllProducts(Model model){
        model.addAttribute("products",productRepository.findAll());
        return "all-products";
    }

    @GetMapping("/edit/{id}")
    public String goToEditProductForm(@PathVariable String id, Model model){


        model.addAttribute("product",productRepository.findById(Long.valueOf(id)).get());
        return "edit-product-form";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("product") @Valid Product product,
                              BindingResult result){
        if(result.hasErrors()){
            return "edit-product-form";
        }
        productRepository.editProduct(product.getName(),product.getDescription(),
                product.getPrice(),product.getType(),product.getId());
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String goToConfirmation(@PathVariable Long id, Model model){
        model.addAttribute("product", productRepository.findById(id).get());
        return "delete-confirmation";
    }

    @PostMapping("/delete")
    public String deleteItem(@ModelAttribute Product product){
        productRepository.delete(product);
        return "redirect:/admin/product/all";
    }



}
