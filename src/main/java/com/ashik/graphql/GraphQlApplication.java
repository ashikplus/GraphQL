package com.ashik.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}
	
//	@Query("/graphql")
//    public Object graphql(@RequestParam String query) {
//        // Handle the GraphQL query using the graphql-java-kickstart library
//        // Return the result
//		return query;
//    }
	
	

}
