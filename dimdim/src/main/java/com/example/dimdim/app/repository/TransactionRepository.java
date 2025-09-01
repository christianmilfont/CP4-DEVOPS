package com.example.dimdim.app.repository;

import com.example.dimdim.app.entity.Transaction;
import com.example.dimdim.app.entity.Transaction.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByType(Type type);
    List<Transaction> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
