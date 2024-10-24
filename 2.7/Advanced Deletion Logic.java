import org.springframework.web.bind.annotation.RequestParam;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@PostMapping("/removeByRegex")
public String removeBooksByRegex(@RequestParam("queryRegex") String queryRegex, 
                                 @RequestParam("field") String field, Model model) {
    if (queryRegex == null || queryRegex.isEmpty()) {
        model.addAttribute("errorMessage", "Regex cannot be empty");
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }

    try {
        Pattern pattern = Pattern.compile(queryRegex);
        List<Book> booksToRemove = bookService.getAllBooks().stream()
                .filter(book -> {
                    switch (field) {
                        case "author": return pattern.matcher(book.getAuthor()).find();
                        case "title": return pattern.matcher(book.getTitle()).find();
                        case "size": return pattern.matcher(book.getSize()).find();
                        default: return false;
                    }
                })
                .collect(Collectors.toList());

        if (booksToRemove.isEmpty()) {
            model.addAttribute("errorMessage", "No records match your query");
            model.addAttribute("bookList", bookService.getAllBooks());
            return "book_shelf";
        }

        bookService.deleteAll(booksToRemove);
        return "redirect:/books/shelf";
    } catch (PatternSyntaxException e) {
        model.addAttribute("errorMessage", "Invalid regex syntax");
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }
}
