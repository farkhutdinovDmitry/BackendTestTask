package ru.kameleoon.trial.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kameleoon.trial.api.QuoteApi;
import ru.kameleoon.trial.dto.quote.CreateQuoteDto;
import ru.kameleoon.trial.dto.quote.QuoteDto;
import ru.kameleoon.trial.dto.quote.UpdateQuoteDto;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/quote")
public class QuoteController {
	private final QuoteApi quoteApi;

	@PostMapping
	public QuoteDto addQuote(@RequestBody CreateQuoteDto quote) {
		return quoteApi.addQuote(quote);
	}

	@PutMapping
	public QuoteDto updateQuote(@RequestBody UpdateQuoteDto quote) {
		return quoteApi.updateQuote(quote);
	}

	@DeleteMapping("{id}")
	public void deleteQuote(@PathVariable long id) {
		quoteApi.deleteQuote(id);
	}

	@GetMapping("{id}")
	public QuoteDto getQuoteById(@PathVariable long id) {
		return quoteApi.getQuote(id);
	}

	@GetMapping("/top")
	public List<QuoteDto> getFirstNQuotesByScore(@RequestParam(required = false) Integer count) {
		return quoteApi.getFirstNQuotesByScore(count);
	}
}
