package com.ashik.graphql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Book {
	
	Integer id;
	String title;
	Integer pages;
	Author author;
}
