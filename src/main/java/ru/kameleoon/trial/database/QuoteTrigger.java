package ru.kameleoon.trial.database;

import org.h2.tools.TriggerAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * When any user votes for quote, this trigger executes to change quote score
 * */

public class QuoteTrigger extends TriggerAdapter {
	@Override
	public void fire(Connection connection, ResultSet resultSet, ResultSet resultSet1) throws SQLException {
		try (PreparedStatement stmt = connection.prepareStatement(
			"update quotes " +
				"set score = CASEWHEN(? > 0, score + 1, score - 1) " +
				"where id = ?");
		) {
			stmt.setObject(1, resultSet1.getInt("choice"));
			stmt.setObject(2, resultSet1.getLong("quote_id"));
			stmt.executeUpdate();
		}
	}
}
