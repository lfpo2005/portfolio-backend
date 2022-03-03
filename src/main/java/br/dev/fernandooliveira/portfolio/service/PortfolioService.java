package br.dev.fernandooliveira.portfolio.service;

import br.dev.fernandooliveira.portfolio.model.Portfolio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface PortfolioService {


    Page<Portfolio> findAll(Pageable pageable);


    Optional<Portfolio> findById(Integer id);

    void delete(Portfolio portfolio);

    void save(Portfolio portfolio);
}
