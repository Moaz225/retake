// src/main/java/<your-package>/controllers/MainController.java
@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";  // Main page
    }

    @GetMapping("/genres")
    public String genres() {
        return "genres";  // Genre page
    }

    @GetMapping("/authors")
    public String authors(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authorList", authors);
        return "authors";  // Author page
    }
}
