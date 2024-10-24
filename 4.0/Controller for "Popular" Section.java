// BookController.java
@Controller
public class BookController {

    @ModelAttribute("booksList")
    public List<Book> bookList() {
        return bookService.getBooksData();  // Fetch list of books from the database
    }

    @GetMapping("/books/popular")
    public String popularBooks() {
        return "books/popular";  // Return the template for the popular page
    }
}
