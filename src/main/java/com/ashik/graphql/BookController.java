package com.ashik.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

	@Autowired
	BookRepository book;
	
	@SchemaMapping(typeName = "Query", value="allBooks")
	public List<Book> getAllBooks() {
		return book.allBooks();
	}
	
	@QueryMapping
	public Book bookById(@Argument Integer id) {
		return book.bookById(id);
	}
	
	@MutationMapping
	public int createBook(@Argument String title, @Argument Integer pages) {
		return book.createBook(title, pages);
	}
}
