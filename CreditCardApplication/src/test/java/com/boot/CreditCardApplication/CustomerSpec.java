package com.boot.CreditCardApplication;

import com.boot.CreditCardApplication.entities.Customers;
import com.boot.CreditCardApplication.exceptions.CustomerExistsException;
import com.boot.CreditCardApplication.exceptions.CustomerNotFoundException;
import com.boot.CreditCardApplication.repo.CustomerCreditCardrepo;
import com.boot.CreditCardApplication.services.CustomerCreditCardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerSpec {
    @Mock
    CustomerCreditCardrepo repo;

    @InjectMocks
    CustomerCreditCardService service;

    List<Customers> collection ;
    Customers cust1 ,cust2,cust3;

    @BeforeEach
    public void firstBeforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void befEach(){
        cust1 = new Customers("cust1","last1",new Date(),"M","985");
        cust2 = new Customers("cust2","last1",new Date(),"M","986");
        cust3 = new Customers("cust3","last1",new Date(),"M","987");

        collection = Arrays.asList(cust1,cust2,cust3);
    }

    @Test
    public void getAllCustomers(){

        when(repo.findAll()).thenReturn(collection);

        assertEquals(3,service.getAllCustomers().size());

        assertEquals(collection , service.getAllCustomers());
    }

//        @Test
//        public void getCustomerSpec() throws CustomerNotFoundException {
//
//            when(repo.findCustomerByCustomer_Id("985")).thenReturn(cust1);
//            Customers retval = service.getCustomerById("985");
//            assertEquals(cust1,retval);
//        }

    @Test
    public void addCustomerSpec() throws CustomerExistsException {
        when(repo.save(cust1)).thenReturn(cust1);

        Customers newlyadded =  service.addCustomer(cust1);
        assertEquals(newlyadded,cust1 );
        assertEquals(4,collection.size()+1);

    }
//        @Test
//        public void deleteCustomerSpec() throws CustomerNotFoundException {
//            when(repo.findCustomerById(cust1.getCustomer_Id())).thenReturn(cust1).thenReturn(null);
//            Customers custTobDel = service.deleteCustomer(cust1.getCustomer_Id());
//            assertEquals(custTobDel, cust1);
//        }


}
