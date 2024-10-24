@PostMapping("/books/save")
public String saveBook(@ModelAttribute Book book, Model model) {
    if (book.getAuthor().isEmpty() && book.getTitle().isEmpty() && book.getSize() == null) {
        model.addAttribute("error", "Cannot save an empty record. Please fill at least one field.");
        return "book_form";
    }
    bookRepository.save(book);
    return "redirect:/books";
}
