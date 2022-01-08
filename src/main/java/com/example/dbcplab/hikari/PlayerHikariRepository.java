package com.example.dbcplab.hikari;

import com.example.dbcplab.domain.Player;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class PlayerHikariRepository {
    private final HikariDataSource dataSource;

    @Nullable
    public Player findFirstPlayerWithName(String name) {
        try {
            Connection connection = dataSource.getConnection();

            String query = "SELECT id, name, age, birthday FROM player WHERE name='" + name + "' LIMIT 0,1";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                BigInteger id = resultSet.getObject(1, BigDecimal.class).toBigInteger();
                String playerName = resultSet.getString(2);
                Integer age = resultSet.getInt(3);
                LocalDateTime birthday = resultSet.getObject(4, LocalDateTime.class);

                return new Player(id, playerName, age, birthday);
            }

            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
