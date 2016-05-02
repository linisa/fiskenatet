package com.example.fiskenatet.UnitTestingMockito;

import com.example.fiskenatet.models.ProductModel;

/**
 * Created by nordi_000 on 2016-05-02.
 */
public class ProductBuilder {
    private ProductModel productModel = new ProductModel();

    public ProductBuilder id (Long id) {
        productModel.setId(id);
        return this;
    }

    public ProductBuilder title (String title){
        productModel.setTitle(title);
        return this;
    }
    public ProductBuilder description(String description){
        productModel.setDescription(description);
        return this;
    }
    public ProductBuilder category(String category){
        productModel.setCategory(category);
        return this;
    }

    public ProductModel build(){
        return productModel;
    }
}

