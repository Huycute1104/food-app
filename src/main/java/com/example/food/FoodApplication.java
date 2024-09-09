package com.example.food;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class FoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public Cloudinary cloudinary() {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dpxs39hkb",
				"api_key", "679575712278322",
				"api_secret", "KJfkzpiXRnmkPCeRwH6TUAmFGks"));
		return cloudinary;
	}
//	@Bean
//	public CommandLineRunner commandLineRunner(
//			AuthenticationService service,
//			CategoryService categoryService
//	) {
//		return args -> {
//			//Admin
//			var admin = RegisterRequest.builder()
//					.name("Admin")
//					.email("Admin@gmail.com")
//					.password("123")
//					.phone("0392272536")
//					.status(true)
//					.role(ADMIN)
//					.build();
//			System.out.println("Admin token :" + service.register(admin).getAccessToken());
//
//			//staff
//			var staff = RegisterRequest.builder()
//					.name("Staff")
//					.email("staff@gmail.com")
//					.status(true)
//					.password("123")
//					.phone("0854512367")
//					.role(STAFF)
//					.build();
//			System.out.println("Staff token :" + service.register(staff).getAccessToken());
//
//			//Customer
//			var customer = RegisterRequest.builder()
//					.name("Trần Huy")
//					.email("huypt110402@gmail.com")
//					.status(true)
//					.password("123")
//					.phone("0854512367")
//					.role(CUSTOMER)
//					.build();
//			System.out.println("Customer token :" + service.register(customer).getAccessToken());
//
//			var customer2 = RegisterRequest.builder()
//					.name("Huyền Trân")
//					.email("tran123@gmail.com")
//					.status(true)
//					.password("123")
//					.phone("0854512367")
//					.role(CUSTOMER)
//					.build();
//			service.register(customer2);
//
//			var category = CreateCategoryRequest.builder()
//					.categoryName("Drink")
//					.build();
//			categoryService.createCategory(category);
//
//			var category1 = CreateCategoryRequest.builder()
//					.categoryName("Seafood")
//					.build();
//			categoryService.createCategory(category1);
//
//			var category2 = CreateCategoryRequest.builder()
//					.categoryName("Snacks")
//					.build();
//			categoryService.createCategory(category2);
//
//		};
//	}

	@GetMapping("")
	public String greeting() {
		return "Food Application From Huycute";
	}




}
