package com.example.MyBookShopApp.data.repo;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.book.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends JpaRepository<Tag,Integer> {
}
