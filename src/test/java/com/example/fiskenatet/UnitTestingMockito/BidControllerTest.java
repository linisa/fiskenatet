package com.example.fiskenatet.UnitTestingMockito;

import com.example.fiskenatet.controllers.BidController;
import com.example.fiskenatet.models.BidModel;
import com.example.fiskenatet.services.BidService;
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

    private static final BidModel bid1 = new BidBuilder().build();
    private static final BidModel bid2 = new BidBuilder().build();

    @Test
    public void testCreateBid(){
        bidController.createBid(bid1);
        verify(bidService).saveBid(bid1);
    }
}
