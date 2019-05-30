package br.com.factory;

//faz as importações de classes necessárias para o funcionamento do programa 
import java.sql.Connection;
//conexão SQL para Java 
import java.sql.DriverManager;
//driver de conexão SQL para Java 
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetojava", "postgres", "Dev@2019");
		} catch (SQLException excecao) {
			throw new RuntimeException(excecao);
		}
	}

}
