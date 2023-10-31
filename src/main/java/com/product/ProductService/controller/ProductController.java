package com.product.ProductService.controller;


import com.product.ProductService.model.Product;
import com.product.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/hello")
    public String getHello(){
        return "Hello Product";
    }



    @GetMapping("getProduct/{productId}")
    public Product getProductById(@PathVariable("productId") Long productId){
        System.out.println("into getProductById");
       return productService.getProductById(productId);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts(){
        System.out.println("into getAllProducts");
        return productService.getAllProducts();
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        System.out.println("into saveProduct");
        return productService.saveProduct(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        System.out.println("into updateProduct");
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        System.out.println("into deleteProduct");
         productService.deleteProduct(productId);
         System.out.println("Product is deleted for productId :"+productId);
         return "deleted";
    }
}
