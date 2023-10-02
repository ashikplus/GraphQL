package com.ashik.graphql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookRepository {

//	get all books
	public List<Book> allBooks() {

		List<Book> books = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/graphql_db", "root", "password");

			String query = "SELECT b.id, b.title, b.pages, a.name AS author_name FROM books b INNER JOIN authors a ON b.author_id = a.id";

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String authorName = resultSet.getString("author_name");
				int pages = resultSet.getInt("pages");

				Author author = new Author(authorName);
				// Create a new Book object
				Book book = new Book(id, title, pages, author);

				// Add the book to the list
				books.add(book);
			}

			// Close the resources
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

//	get book by id
	public Book bookById(Integer bookId) {
		Book book = null;

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/graphql_db", "root", "password");

			String query = "SELECT b.id, b.title, b.pages, a.name AS author_name FROM books b INNER JOIN authors a ON b.author_id = a.id WHERE b.id = ?";

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, bookId);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String authorName = resultSet.getString("author_name");
				int pages = resultSet.getInt("pages");

				Author author = new Author(authorName);

				book = new Book(id, title, pages, author);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;
	}

	public int createBook(String title, Integer pages) {
		try {
	        // Establish a connection to the MySQL database
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/graphql_db", "root", "password");

	        // Define the SQL query with parameter placeholders
	        String query = "INSERT INTO books (title, pages) VALUES (?, ?)";

	        // Create a PreparedStatement for executing the query
	        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

	        // Set the parameter values
	        statement.setString(1, title);
	        statement.setInt(2, pages);

	        // Execute the query
	        int rowsAffected = statement.executeUpdate();

	        if (rowsAffected > 0) {
	            // Retrieve the ID of the newly created book
	            ResultSet generatedKeys = statement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                int id = generatedKeys.getInt(1);

	                // Retrieve the created book from the database
//	                Book createdBook = bookById(id);

	                // Close the resources
	                generatedKeys.close();
	                statement.close();
	                connection.close();
	                System.out.println("djksdhjfk"+ id);

	                return id;
	            }
	        }

	        // Close the resources
	        statement.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return 0;
	}

//	public Book updateBook(Integer id, String title) {
//		Book book = bookById(id);
//		if (book != null) {
//			book.setTitle(title);
//		}
//		return book;
//	}
}
