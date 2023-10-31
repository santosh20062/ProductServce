package com.product.ProductService.service;

import com.product.ProductService.dao.ProductRepository;
import com.product.ProductService.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(Long productId){
      return productRepository.findById(productId)
              .orElseThrow(()-> new RuntimeException("No product available for this id"));

    }

    public Product saveProduct(Product product){
        return productRepository.save(product);

    }

    public Product updateProduct(Product product){
       Product productOld =  productRepository.findById(product.getId())
               .orElseThrow(() -> new RuntimeException("no product is available for this productId"));

        productOld.setName(product.getName());
        productOld.setCompany(product.getCompany());
        productOld.setDescription(product.getDescription());
        productOld.setPrice(product.getPrice());
        productOld.setModel(product.getModel());
        return productRepository.save(productOld);

    }



    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }
}
