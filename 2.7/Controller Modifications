import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import javax.validation.Valid;

@Controller
public class BookShelfController {

    @PostMapping("/save")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("bookList", bookService.getAllBooks());
            return "book_shelf";  // Return to the page with error messages
        }
        bookService.saveBook(book);
        return "redirect:/books/shelf";
    }
}
