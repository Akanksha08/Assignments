package product.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akanksha
 *
 */
public class BookDao {
	List<Book> books;
	
	public BookDao() {
		books = new ArrayList<Book>();
	}
	
	public List<Book> getAllBooks(){
		return books;
	} 
	
	public Book getBookByName(String name) {
		for (Book book : books) {
			if (book.getName().equals(name))
				return book;
		}
		return null;
	}
	
	public List<Book> addBook(int id, String name, String author){
		Book book = new Book(id, name, author);
		books.add(book);
		return books;
	}
	
	public boolean removeBook(String name) {
		for (Book book : books) {
			if (book.getName().equals(name)) {
				books.remove(book);
				return true;
			}
		}
		return false;
	}
}
