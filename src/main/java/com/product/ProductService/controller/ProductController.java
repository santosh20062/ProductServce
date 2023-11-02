package com.product.ProductService.controller;


import com.product.ProductService.model.Product;
import com.product.ProductService.service.ProductService;
import org.apache.logging.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

   // Logger logger = (Logger) LoggerFactory.getLogger(ProductController.class);


    @Autowired
    private ProductService productService;

    @GetMapping("/hello")
    public String getHello(){
        System.out.println("into getHello method..");
        ///logger.info("into getHello Method");
        return "Hello Product";
    }



    @GetMapping("getProduct/{productId}")
    public Product getProductById(@PathVariable("productId") Long productId){
        System.out.println("into getProductById");
      //  logger.info("into getProductById Method :"+productId);
       return productService.getProductById(productId);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts(){
        System.out.println("into getAllProducts");
      //  logger.info("into getAllProducts Method ");
        return productService.getAllProducts();
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        System.out.println("into saveProduct");
       // logger.info("into saveProduct Method ");
        return productService.saveProduct(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        System.out.println("into updateProduct");
      //  logger.info("into updateProduct Method ");
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        System.out.println("into deleteProduct");
        //logger.info("into deleteProduct Method :"+productId);
         productService.deleteProduct(productId);
       // logger.info("into deleteProduct Method - deleted ");
         System.out.println("Product is deleted for productId :"+productId);
         return "deleted";
    }
}
