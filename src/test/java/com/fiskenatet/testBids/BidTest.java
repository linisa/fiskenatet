package com.fiskenatet.testBids;

import com.fiskenatet.testProducts.TestProductModel;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by nordi_000 on 2016-04-28.
 */
public class BidTest {

    private static TestBidDAL mockedTestBidDAL;
    private static TestBidModel bid1;
    private static TestBidModel bid2;
    private static TestBidModel bid3;

    @BeforeClass
    public static void setUp() throws  Exception {
        mockedTestBidDAL = mock(TestBidDAL.class);

        TestProductModel product1 = new TestProductModel(1, "Torsk", 100, 350);
        TestProductModel product2 = new TestProductModel(2, "Abborre", 200, 700);

        bid1 = new TestBidModel(1, 100, 1, product1, 1);
        bid2 = new TestBidModel(2, 300, 1, product2, 2);
        bid3 = new TestBidModel(3, 350, 2, product2, 2);

        when(mockedTestBidDAL.getAllBids()).thenReturn(Arrays.asList(bid1, bid2, bid3));
        when(mockedTestBidDAL.getBidModel(1L)).thenReturn(bid1);
        when(mockedTestBidDAL.getBidModel(2L)).thenReturn(bid2);
        when(mockedTestBidDAL.getBidModel(3L)).thenReturn(bid3);
        when(mockedTestBidDAL.addBidModel(bid1)).thenReturn(bid1.getAmount());
        when(mockedTestBidDAL.addBidModel(bid2)).thenReturn(bid2.getAmount());
        when(mockedTestBidDAL.addBidModel(bid3)).thenReturn(bid3.getAmount());

    }

    @Test
    public void testGetAllBids() throws Exception {
        List<TestBidModel> allBids = mockedTestBidDAL.getAllBids();
        assertEquals(3, allBids.size());
        TestBidModel testBidModel = allBids.get(0);
        assertEquals(1, testBidModel.getId());
        assertEquals(100, testBidModel.getAmount());
        assertEquals(1, testBidModel.getBidder_id());
        assertEquals("Torsk", testBidModel.getTestProductModel().getTitle());
        assertEquals(1, testBidModel.getProduct_id());
    }

    @Test
    public void testGetBid() throws Exception{
        long id = 2;
        TestBidModel testBidModel = mockedTestBidDAL.getBidModel(id);
        assertNotNull(testBidModel);
        assertEquals(2, testBidModel.getId());
        assertEquals(300, testBidModel.getAmount());
        assertEquals(1, testBidModel.getBidder_id());
        assertEquals("Abborre", testBidModel.getTestProductModel().getTitle());
        assertEquals(2, testBidModel.getProduct_id());
    }

    @Test
    public void testAddProduct() throws Exception {
        int amount = mockedTestBidDAL.addBidModel(bid3);
        assertNotNull(amount);
        assertEquals(bid3.getAmount(), amount);
    }



}
