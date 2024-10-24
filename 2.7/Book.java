import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private Integer id;

    @NotEmpty(message = "Author is required")
    private String author;

    @NotEmpty(message = "Title is required")
    private String title;

    @NotEmpty(message = "Size is required")
    @Size(min = 1, message = "Size should be greater than 0")
    private String size;

    // Getters and setters...
}
