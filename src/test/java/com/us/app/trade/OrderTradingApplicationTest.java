package com.us.app.trade;

import com.us.app.trade.dto.Combine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTradingApplicationTest {

    @Test
    public void testingHashCode() {
        Map<Combine, Integer> test = new HashMap<>();
        test.put(new Combine("1","2","3"), 1);
        test.put(new Combine("1","2","3"), 1);
        test.put(new Combine("1","2","3"), 1);
        test.put(new Combine("1","2","3"), 5);
        System.out.println(test);
        System.out.println(test.containsKey(new Combine("1","2","3")));
    }


}