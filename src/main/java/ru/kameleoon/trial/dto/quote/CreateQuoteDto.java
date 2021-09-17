package ru.kameleoon.trial.dto.quote;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateQuoteDto {
	private final String content;
	private final long userId;
}
