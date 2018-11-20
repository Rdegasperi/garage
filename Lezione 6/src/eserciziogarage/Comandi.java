package eserciziogarage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Comandi {
	
	public void lista() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/garage", "root", "");
			Statement comandoSQL = conn.createStatement();
			ResultSet dati = comandoSQL.executeQuery("select * from automobili");
			while (dati.next()) {
				System.out.print(dati.getString("marca")+" | ");
				System.out.print(dati.getString("modello")+" | ");
				System.out.println(dati.getInt("numero_posti"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void cerca() {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/garage", "root", "");
			Statement comandoSql = conn.createStatement();
			ResultSet dati = comandoSql.executeQuery("select * from automobili");
			Scanner sc = new Scanner(System.in);
			System.out.println("Inserisci la marca da cercare > ");
			String marca = sc.nextLine();
			int k = 0;
			while (dati.next()) {
				if(marca.equals(dati.getString("marca"))) {
					System.out.print(dati.getString("marca")+" | ");
					System.out.print(dati.getString("modello")+" | ");
					System.out.println(dati.getInt("numero_posti"));
					k++;
				}
			}
			if(k==0) {
				System.out.println("Marca non presente");
			}
			//sc.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void inserisci() {
		
		Automobili inserimento = new Automobili();
		try {
			System.out.print("Inserisci la marca > ");
			inserimento.setMarca(new BufferedReader(new InputStreamReader(System.in)).readLine());
			System.out.print("Inserisci il modello > ");
			inserimento.setModello(new BufferedReader(new InputStreamReader(System.in)).readLine());
			System.out.print("Inserisci la cilindrata (separare i decimali col punto)> ");
			inserimento.setCilindrata(Float.parseFloat((new BufferedReader(new InputStreamReader(System.in)).readLine())));
			System.out.print("Inserisci la data di immatricolazione (yyyy-mm-gg> ");
			inserimento.setData_immatricolazione(Date.valueOf(String.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine())));
			System.out.print("Inserisci il numero di posti > ");
			inserimento.setNumero_posti(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
		}catch(IOException e) {
			e.printStackTrace();
		}
		

		String query = "INSERT INTO `garage`.`automobili` "
				+ "(`marca`, `modello`, `cilindrata`, `data_immatricolazione`, `numero_posti`) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/garage", "root", "");
			PreparedStatement comandoSql = conn.prepareStatement(query);
			comandoSql.setString(1, inserimento.getMarca());
			comandoSql.setString(2, inserimento.getModello());
			comandoSql.setFloat(3, inserimento.getCilindrata());
			comandoSql.setDate(4, inserimento.getData_immatricolazione());
			comandoSql.setInt(5, inserimento.getNumero_posti());
			comandoSql.executeUpdate();
			System.out.println("ho inserito una nuova auto");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void esporta() {
		
		File esporta = new File("C:\\Users\\User\\Desktop\\Corso\\File\\esportazione_auto.txt");
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/garage", "root", "");
			Statement comandoSql = conn.createStatement();
			ResultSet dati = comandoSql.executeQuery("select * from automobili");
			BufferedWriter bw = new BufferedWriter(new FileWriter(esporta));
			while (dati.next()) {
				bw.write(dati.getInt("id")+" | ");
				bw.write(dati.getString("marca")+" | ");
				bw.write(dati.getString("modello")+" | ");
				bw.write(Float.valueOf(dati.getFloat("cilindrata")).toString()+" | ");
				bw.write(dati.getDate("data_immatricolazione").toString()+" | ");
				bw.write(dati.getInt("numero_posti")+"");
				bw.newLine();
			}
			bw.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
