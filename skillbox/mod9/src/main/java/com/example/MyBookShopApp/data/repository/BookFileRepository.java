package com.example.MyBookShopApp.data.repository;

import com.example.MyBookShopApp.data.model.BookFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookFileRepository extends JpaRepository<BookFile, Integer> {

    BookFile findBookFileByHash(String hash);
}
