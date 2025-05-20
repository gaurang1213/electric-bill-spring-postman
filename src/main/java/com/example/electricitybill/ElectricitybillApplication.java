package com.example.electricitybill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElectricitybillApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricitybillApplication.class, args);
	}

}

//folder - electricitybill

// http://localhost:8080/api/consumers

// {
//   "name": "John Doe",
//   "address": "123 Main St",
//   "email": "john@example.com"
// }

//http://localhost:8080/api/bills/generate?consumerId=1&units=120

