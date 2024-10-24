@PostMapping("/books/delete/{id}")
public String deleteBookById(@PathVariable Long id, Model model) {
    Optional<Book> book = bookRepository.findById(id);
    if (book.isPresent()) {
        bookRepository.delete(book.get());
        model.addAttribute("message", "Book deleted successfully");
    } else {
        model.addAttribute("error", "Book with ID " + id + " does not exist");
    }
    return "book_shelf";
}
