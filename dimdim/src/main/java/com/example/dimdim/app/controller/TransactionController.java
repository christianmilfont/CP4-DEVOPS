package com.example.dimdim.app.controller;


import com.example.dimdim.app.entity.Transaction;
import com.example.dimdim.app.entity.Transaction.Type;
import com.example.dimdim.app.repository.TransactionRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionRepository repo;

    public TransactionController(TransactionRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Transaction> list(
            @RequestParam(required = false) Type type,
            @RequestParam(required = false) LocalDateTime start,
            @RequestParam(required = false) LocalDateTime end
    ) {
        if (type != null) return repo.findByType(type);
        if (start != null && end != null) return repo.findByDateBetween(start, end);
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> get(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Transaction> create(@Valid @RequestBody Transaction t) {
        Transaction saved = repo.save(t);
        return ResponseEntity.created(URI.create("/api/transactions/" + saved.getId()))
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update(@PathVariable Long id, @Valid @RequestBody Transaction t) {
        return repo.findById(id).map(existing -> {
            existing.setDescription(t.getDescription());
            existing.setAmount(t.getAmount());
            existing.setType(t.getType());
            existing.setDate(t.getDate());
            return ResponseEntity.ok(repo.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

   @DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) {
    return repo.findById(id).map(t -> {
        repo.delete(t);
        return ResponseEntity.noContent().build();
    }).orElse(ResponseEntity.notFound().build());
}
}
