package ru.kameleoon.trial.dao;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.kameleoon.trial.database.QuoteRepository;
import ru.kameleoon.trial.entity.Quote;
import ru.kameleoon.trial.exception.NotFoundException;

import java.util.List;

@AllArgsConstructor
@Repository
public class QuoteDao {
	private final QuoteRepository repository;

	public Quote addQuote(Quote quote) {
		return repository.save(quote);
	}

	public Quote getQuote(long id) {
		return repository.findById(id).orElseThrow(NotFoundException::new);
	}

	public Quote updateQuote(Quote quote) {
		return repository.save(quote);
	}

	public void deleteQuote(Long quoteId) {
		repository.deleteById(quoteId);
	}

	public List<Quote> getFirstNQuotesByScore(int N) {
		return repository
			.findAll(PageRequest.of(0, N, Sort.by(Sort.Direction.DESC, "score")))
			.getContent();
	}
}
