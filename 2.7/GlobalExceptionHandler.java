import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FileNotSelectedException.class)
    public String handleFileNotSelected(FileNotSelectedException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "book_shelf";  // Return to the same page with an error message
    }
}
