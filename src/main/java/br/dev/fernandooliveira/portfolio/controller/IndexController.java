package br.dev.fernandooliveira.portfolio.controller;

import br.dev.fernandooliveira.portfolio.model.Portfolio;
import br.dev.fernandooliveira.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("v1/portfolio")
public class IndexController {

    @Autowired
    PortfolioService portfolioService;

    @GetMapping("/public")
    public ResponseEntity<Page<Portfolio>> getAllPortfolio(@PageableDefault(page = 0, size = 10)Pageable pageable) {
        return ResponseEntity.ok(portfolioService.findAll(pageable));
    }

    @GetMapping("/public/{id}")
    public ResponseEntity<Object> getOnePortfolio(@PathVariable(value = "id") Integer id){
        Optional<Portfolio> portfolioOptional = portfolioService.findById(id);
        if(!portfolioOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Portfolio not found!");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(portfolioOptional.get());
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Object> updatePortfolio(@PathVariable(value = "id") Integer id,
                                                @RequestBody Portfolio portfolio) {
        Optional<Portfolio> portfolioOptional = portfolioService.findById(id);
        if (!portfolioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Could not update, Portfolio not found!");
        } else {
            portfolioService.save(portfolio);
            return ResponseEntity.status(HttpStatus.OK).body("Portfolio update successfully");
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Object> deletePortfolio(@PathVariable(value = "id") Integer id) {

        Optional<Portfolio> portfolioOptional = portfolioService.findById(id);
        if (!portfolioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Could not delete, Portfolio not found!");
        } else {
            portfolioService.delete(portfolioOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Portfolio deleted successfully!");
        }
    }
    @PostMapping("/post")
    public ResponseEntity<Object> registerArticle(@RequestBody Portfolio portfolio) {
        portfolio.setCreationDate(LocalDate.now(ZoneId.of("UTC")));
        portfolioService.save(portfolio);
        return ResponseEntity.status(HttpStatus.CREATED).body("Portfolio created successfully!");
    }
}

