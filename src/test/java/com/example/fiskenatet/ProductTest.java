package com.example.fiskenatet;


import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductTest {

    private static TestProductDAL mockedTestProductDAL;
    private static TestProductModel fish1;
    private static TestProductModel fish2;

    @BeforeClass
    public static void setUp() throws Exception {

        mockedTestProductDAL = mock(TestProductDAL.class);

        fish1 = new TestProductModel(1, "Torsk", 100, 350);
        fish2 = new TestProductModel(2, "Abborre", 50, 550);

        when(mockedTestProductDAL.getAllProducts()).thenReturn(Arrays.asList(fish1, fish2));
        when(mockedTestProductDAL.getProductModel(1)).thenReturn(fish1);
        when(mockedTestProductDAL.getProductModel(2)).thenReturn(fish2);
        when(mockedTestProductDAL.addProductModel(fish2)).thenReturn(fish2.getTitle());
        when(mockedTestProductDAL.addProductModel(fish1)).thenReturn(fish1.getTitle());
    }

    @Test
    public void testGetAllProducts() throws Exception {
        List<TestProductModel> allProducts = mockedTestProductDAL.getAllProducts();
        assertEquals(2, allProducts.size());
        TestProductModel testProductModel = allProducts.get(0);
        assertEquals("Torsk", testProductModel.getTitle());
        assertEquals(1, testProductModel.getId());
        assertEquals(100, testProductModel.getStartPrice());
        assertEquals(350, testProductModel.getEndPrice());
    }

    @Test
    public void testGetProduct() throws Exception{
        long id = 2;
        TestProductModel testProductModel = mockedTestProductDAL.getProductModel(id);
        assertNotNull(testProductModel);
        assertEquals("Abborre", testProductModel.getTitle());
        assertEquals(2, testProductModel.getId());
        assertEquals(50, testProductModel.getStartPrice());
        assertEquals(550, testProductModel.getEndPrice());
    }

    @Test
    public void testAddProduct() throws Exception {
        String title = mockedTestProductDAL.addProductModel(fish1);
        assertNotNull(title);
        assertEquals(fish1.getTitle(), title);
    }

}
