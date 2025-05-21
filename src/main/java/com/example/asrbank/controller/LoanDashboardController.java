package com.example.asrbank.controller;

import com.example.asrbank.model.LoanApplication;
import com.example.asrbank.repository.LoanRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class LoanDashboardController {

    private final LoanRepository loanRepository;

    public LoanDashboardController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @GetMapping("/all")
    public List<LoanApplication> getAllLoans() {
        return loanRepository.findAll();
    }

    @GetMapping("/{id}")
    public LoanApplication getLoanById(@PathVariable Long id) {
        return loanRepository.findById(id).orElse(null);
    }
}