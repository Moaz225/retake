import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@PostMapping("/uploadFile")
public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
    if (file.isEmpty()) {
        throw new FileNotSelectedException("No file was selected!");
    }
    // File upload logic...
    return "redirect:/books/shelf";
}
