package com.boot.CreditCardApplication;

import com.boot.CreditCardApplication.services.CustomerCreditCardService;
import com.boot.CreditCardApplication.services.TransactionCreditCardService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.logging.Logger;

@SpringBootApplication
public class CreditCardApplication {

	Logger logger = Logger.getLogger(CreditCardApplication.class.getSimpleName());

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(CreditCardApplication.class, args);
//		TransactionCreditCardService transactionCreditCardService = context.getBean(TransactionCreditCardService.class);
//		transactionCreditCardService.getAllTransactions();

		CustomerCreditCardService customerCreditCardService = context.getBean(CustomerCreditCardService.class);
		System.out.println(customerCreditCardService.getAllCustomers());
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET","POST","PUT","DELETE")
						.allowedOrigins("*");
			}
		};
	}

}
