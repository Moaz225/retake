@PostMapping("/books/removeByRegex")
public String removeBooksByRegex(@RequestParam String queryRegex, Model model) {
    Pattern pattern = Pattern.compile(queryRegex);
    List<Book> booksToDelete = bookRepository.findAll().stream()
            .filter(book -> pattern.matcher(book.getAuthor()).find() 
                || pattern.matcher(book.getTitle()).find() 
                || pattern.matcher(String.valueOf(book.getSize())).find())
            .collect(Collectors.toList());

    if (!booksToDelete.isEmpty()) {
        bookRepository.deleteAll(booksToDelete);
        model.addAttribute("message", booksToDelete.size() + " books deleted.");
    } else {
        model.addAttribute("error", "No books matched the given regex.");
    }
    return "book_shelf";
}
