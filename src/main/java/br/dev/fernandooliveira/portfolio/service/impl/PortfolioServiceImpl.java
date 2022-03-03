package br.dev.fernandooliveira.portfolio.service.impl;

import br.dev.fernandooliveira.portfolio.model.Portfolio;
import br.dev.fernandooliveira.portfolio.repository.PortfolioRepository;
import br.dev.fernandooliveira.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    PortfolioRepository portfolioRepository;


    @Override
    public Page<Portfolio> findAll(Pageable pageable) {
        return portfolioRepository.findAll(pageable);
    }

    @Override
    public Optional<Portfolio> findById(Integer id) {
        return portfolioRepository.findById(id);
    }

    @Override
    public void delete(Portfolio portfolio) {
        portfolioRepository.delete(portfolio);
    }

    @Override
    public void save(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }


}
