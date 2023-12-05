package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BooksPageDto;
import com.example.MyBookShopApp.data.ResourceStorage;
import com.example.MyBookShopApp.data.SearchWordDto;
import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.repo.BookRepo;
import com.example.MyBookShopApp.data.service.AuthorService;
import com.example.MyBookShopApp.data.service.BookService;
import com.example.MyBookShopApp.data.service.BooksRatingAndPopulatityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.logging.Logger;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;
    private final BooksRatingAndPopulatityService booksRatingAndPopulatityService;

    private final BookRepo bookRepository;
    private final ResourceStorage storage;

    @Autowired
    public BooksController(BookService bookService, BooksRatingAndPopulatityService booksRatingAndPopulatityService, BookRepo bookRepository, ResourceStorage storage) {
        this.bookService = bookService;
        this.booksRatingAndPopulatityService = booksRatingAndPopulatityService;
        this.bookRepository = bookRepository;
        this.storage = storage;
    }


    @GetMapping("/recent/index")
    public String recentPage(Model model) {
        model.addAttribute("booksData", bookService.getPageofRecentBooks(0, 5).getContent());
        return "books/recent";
    }

    @GetMapping("/recent")
    @ResponseBody
    public BooksPageDto getRecentBooksPage(@RequestParam("offset") Integer offset,
                                           @RequestParam("limit") Integer limit,
                                           @RequestParam(value = "from", required = false) Date from,
                                           @RequestParam(value = "to", required = false) Date to) {
        if(from != null && to != null)
            return new BooksPageDto(bookService.getPageofRecentBooks(offset, limit, from, to).getContent());
        return new BooksPageDto(bookService.getPageofRecentBooks(offset, limit).getContent());
    }

    @GetMapping("/popular/index")
    public String popularPage(Model model) {
        model.addAttribute("booksData", bookService.getPageofPopularBooks(0,5).getContent());
        return "books/popular";
    }

    @GetMapping("/popular")
    @ResponseBody
    public BooksPageDto getBooksPopularPage(@RequestParam("offset") Integer offset,
                                            @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getPageofPopularBooks(offset, limit).getContent());
    }


    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }


    @GetMapping("/{slug}")
    public String bookPage(@PathVariable("slug") String slug, Model model) {
        Book book = bookRepository.findBookBySlug(slug);
        model.addAttribute("slugBook", book);
        return "/books/slug";
    }

    @PostMapping("/{slug}/img/save")
    public String saveNewBookImage(@RequestParam("file") MultipartFile file, @PathVariable("slug")String slug) throws IOException {
        String savePath = storage.saveNewBookImage(file,slug);
        Book bookToUpdate = bookRepository.findBookBySlug(slug);
        bookToUpdate.setImage(savePath);
        bookRepository.save(bookToUpdate); //save new path in db here

        return "redirect:/books/"+slug;
    }

    @GetMapping("/download/{hash}")
    public ResponseEntity<ByteArrayResource> bookFile(@PathVariable("hash")String hash) throws IOException{
        Path path = storage.getBookFilePath(hash);
        Logger.getLogger(this.getClass().getSimpleName()).info("book file path: "+path);

        MediaType mediaType = storage.getBookFileMime(hash);
        Logger.getLogger(this.getClass().getSimpleName()).info("book file mime type: "+mediaType);

        byte[] data = storage.getBookFileByteArray(hash);
        Logger.getLogger(this.getClass().getSimpleName()).info("book file data len: "+data.length);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+path.getFileName().toString())
                .contentType(mediaType)
                .contentLength(data.length)
                .body(new ByteArrayResource(data));
    }
}
