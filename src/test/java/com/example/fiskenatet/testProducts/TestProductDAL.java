package com.example.fiskenatet.testProducts;

import java.util.Collections;
import java.util.List;

/**
 * Created by nordi_000 on 2016-04-26.
 */
public class TestProductDAL {

    private static TestProductDAL testProductDAL = new TestProductDAL();

    public List<TestProductModel> getAllProducts() {
        return Collections.emptyList();
    }

    public TestProductModel getProductModel(long id) {
        return null;
    }

    public String addProductModel(TestProductModel testProductModel) {
        return  testProductModel.getTitle();
    }

    public static TestProductDAL getInstance() {
        return testProductDAL;
    }

}
