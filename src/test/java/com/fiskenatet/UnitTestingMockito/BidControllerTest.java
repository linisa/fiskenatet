package com.fiskenatet.UnitTestingMockito;

import com.fiskenatet.controllers.BidController;
import com.fiskenatet.models.BidModel;
import com.fiskenatet.models.ProductModel;
import com.fiskenatet.models.UserModel;
import com.fiskenatet.services.BidService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by nordi_000 on 2016-05-02.
 */
@RunWith(MockitoJUnitRunner.class)
public class BidControllerTest {

    @InjectMocks
    private BidController bidController;
    @Mock
    private BidService bidService;

    private static final UserModel BIDDER_1 = new UserBuilder().id(1L).firstName("Klas").build();
    private static final UserModel BIDDER_2 = new UserBuilder().id(2L).firstName("Lisa").build();
    private static final ProductModel PRODUCT_1 = new ProductBuilder().id(1L).title("Torsk").build();
    private static final ProductModel PRODUCT_2 = new ProductBuilder().id(2L).title("Bläckfisk").build();
    private static final Long ID_1 = 1L;
    private static final Long ID_2 = 2L;
    private static final int AMOUNT_1 = 10;
    private static final int AMOUNT_2 = 20;
    private static final BidModel bid1 = new BidBuilder().id(ID_1).amount(AMOUNT_1).bidder(BIDDER_1).currentProduct(PRODUCT_1).build();
    private static final BidModel bid2 = new BidBuilder().id(ID_2).amount(AMOUNT_2).bidder(BIDDER_2).currentProduct(PRODUCT_1).build();

    @Test
    public void testCreateBid(){
        bidController.createBid(bid1);
        verify(bidService).saveBid(bid1);
    }
}
