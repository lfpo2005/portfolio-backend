package br.dev.fernandooliveira.portfolio.repository;

import br.dev.fernandooliveira.portfolio.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
}
