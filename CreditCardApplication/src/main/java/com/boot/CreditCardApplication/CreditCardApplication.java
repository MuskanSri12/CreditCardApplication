package com.boot.CreditCardApplication;

import com.boot.CreditCardApplication.services.CustomerCreditCardService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CreditCardApplication {



	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(CreditCardApplication.class, args);
		CustomerCreditCardService customerCreditCardService = context.getBean(CustomerCreditCardService.class);
		customerCreditCardService.getAllCustomers();
	}

}
