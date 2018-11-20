package eserciziogarage;

import java.sql.Date;

public class Automobili {
	
	private int id;
	private String marca;
	private String modello;
	private float cilindrata;
	private Date data_immatricolazione;
	private int numero_posti;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public float getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(float cilindrata) {
		this.cilindrata = cilindrata;
	}
	public Date getData_immatricolazione() {
		return data_immatricolazione;
	}
	public void setData_immatricolazione(Date data_immatricolazione) {
		this.data_immatricolazione = data_immatricolazione;
	}
	public int getNumero_posti() {
		return numero_posti;
	}
	public void setNumero_posti(int numero_posti) {
		this.numero_posti = numero_posti;
	}

}
