package ru.kameleoon.trial.database;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kameleoon.trial.entity.Quote;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
	List<Quote> findByOrderByScoreDesc(PageRequest pageRequest);
}
