package com.boot.CreditCardApplication;

import com.boot.CreditCardApplication.dao.TransactionDALMongoTemplate;
import com.boot.CreditCardApplication.dto.SpendingByMerchant;
import com.boot.CreditCardApplication.entities.Transactions;
import com.boot.CreditCardApplication.repo.TransactionCreditCardrepo;
import com.boot.CreditCardApplication.services.TransactionCreditCardService;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;

import javax.management.Query;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.mongodb.assertions.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransactionSpec {
    @Mock
    TransactionCreditCardrepo transactionCreditCardrepo;
    TransactionDALMongoTemplate transactionDALMongoTemplate;

    @InjectMocks
    TransactionCreditCardService transactionCreditCardService;

    SpendingByMerchant spendingByMerchant;

    List<Transactions> collection ;
    Transactions trans1 ,trans2,trans3;

    @BeforeEach
    public void firstBeforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void befEach(){
//        transaction_Id, String trans_date_trans_time, Double amt, int trans_num, int customer_id,
//        String city, String state, int city_population, String merchant, String category, String first,
//        String last, String gender, String Job, String dob
        trans1 = new Transactions("trans1","17/08/2023 11:38", 10.0, 1008, 1002,
                "Mumbai", "Maharashtra", 50000, "Abbott-Rogahn","entertainment", "kamal",
                "twinss", "M","interpreter","17/05/1998");
        trans2 = new Transactions("trans2","11/05/2023 21:38", 50.0, 1009, 1003,
                "Pune", "Maharashtra", 61000, "Abbott","grocery", "siri",
                "thomas", "F","coder","15/03/2000");
        trans3 = new Transactions("trans3","16/04/2019 15:54", 2.97, 8, 324,
                "Achille", "OK",74720, "Auer-West","shopping_net", "Felicia",
                "Thomas", "X", "Seismic interpreter", "27/05/1993");
        collection = Arrays.asList(trans1,trans2,trans3);
    }

    @Test
    public void getAllTransactions(){

        when(transactionCreditCardrepo.findAll()).thenReturn(collection);

        assertEquals(3,transactionCreditCardService.getAllTransactions().size());

        assertEquals(collection , transactionCreditCardService.getAllTransactions());
    }

    //    @Test
//    public void testMerchantField() {
//        Transactions trans4 = new Transactions("trans2","11/05/2023 21:38", 50.0, 1009, 1003,
//                "Pune", "Maharashtra", 61000, "Abbott","grocery", "siri",
//                "thomas", "F","coder","15/03/2000");
//        String merchant = trans4.getMerchant();
//        assertEquals("Cummerata-Jones", merchant);
//    }
    @Test
    public void getByMerchantTest() {
        List<Transactions> ans=Arrays.asList(trans1);
        when(transactionCreditCardrepo.findTransactionByMerchant("Abbott-Rogahn")).thenReturn(ans);
        List<Transactions> actualTransactions = transactionCreditCardService.getTransactionByMerchant("Abbott-Rogahn");
//        assertEquals(ans, actualTransactions);
        List<Transactions> filteredActual = actualTransactions.stream()
                .filter(transaction -> "Abbott-Rogahn".equals(transaction.getMerchant()))
                .collect(Collectors.toList());
        assertEquals(ans, filteredActual);
    }
    @Test
    public void getByCityTest() {
        List<Transactions> ans=Arrays.asList(trans2);
        when(transactionCreditCardrepo.findTransactionByCity("Pune")).thenReturn(ans);
        List<Transactions> actualTransactions = transactionCreditCardService.getTransactionByCity("Pune");
//        assertEquals(ans, actualTransactions);
        List<Transactions> filteredActual = actualTransactions.stream()
                .filter(transaction -> "Pune".equals(transaction.getCity()))
                .collect(Collectors.toList());
        assertEquals(ans, filteredActual);
    }
    @Test
    public void getByCategoryTest() {
        List<Transactions> ans=Arrays.asList(trans3);
        when(transactionCreditCardrepo.findTransactionByCategory("shopping_net")).thenReturn(ans);
        List<Transactions> actualTransactions = transactionCreditCardService.getTransactionByCategory("shopping_net");
//        assertEquals(ans, actualTransactions);
        List<Transactions> filteredActual = actualTransactions.stream()
                .filter(transaction -> "shopping_net".equals(transaction.getCategory()))
                .collect(Collectors.toList());
        assertEquals(ans, filteredActual);
    }
}
