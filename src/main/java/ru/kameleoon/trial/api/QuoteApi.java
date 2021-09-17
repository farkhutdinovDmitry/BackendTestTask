package ru.kameleoon.trial.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kameleoon.trial.dto.quote.CreateQuoteDto;
import ru.kameleoon.trial.dto.quote.QuoteDto;
import ru.kameleoon.trial.dto.quote.UpdateQuoteDto;
import ru.kameleoon.trial.dto.vote.VoteDto;
import ru.kameleoon.trial.exception.BadInputException;
import ru.kameleoon.trial.service.QuoteService;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class QuoteApi {
	private final QuoteService service;

	public QuoteDto addQuote(CreateQuoteDto dto) {
		if (dto.getContent() == null) {
			throw new BadInputException("Quote content shouldn't be null");
		}
		return service.addQuote(dto);
	}

	public QuoteDto updateQuote(UpdateQuoteDto dto) {
		return service.updateQuote(dto);
	}

	public void deleteQuote(long id) {
		service.deleteQuote(id);
	}

	public QuoteDto getQuote(long id) {
		return service.getQuote(id);
	}

	public List<QuoteDto> getFirstNQuotesByScore(Integer count) {
		int defaultCount = 10;
		List<QuoteDto> quotes = service.getFirstNQuotesByScore(count == null ? defaultCount : count);
		quotes.forEach(q -> q.getVotes().sort(Comparator.comparing(VoteDto::getTime)));
		return quotes;
	}
}
