// src/main/java/<your-package>/model/Book.java
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String size;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // Getters and setters...
}
