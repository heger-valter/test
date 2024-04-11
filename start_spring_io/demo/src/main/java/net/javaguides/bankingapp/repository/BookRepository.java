package net.javaguides.bankingapp.repository;

import net.javaguides.bankingapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}