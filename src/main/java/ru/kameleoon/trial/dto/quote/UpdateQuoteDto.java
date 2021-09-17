package ru.kameleoon.trial.dto.quote;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UpdateQuoteDto {
	private final long id;
	private final String content;
}
