package eserciziogarage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Eserciziojdbs {
	
	public static void main(String[] args) throws IOException {
		int a=1;
//		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		Comandi cmd = new Comandi();
		do {
		System.out.println("Lista comandi ");
		System.out.println("LISTA <visualizza a schermo la lista delle auto e le loro caratteristiche>");
		System.out.println("INSERISCI <permette di inserire una nuova auto>");
		System.out.println("CERCA <visualizza a schermo le auto con rispettive caratteristiche di una marca indicata>");
		System.out.println("ESPORTA <genera un file .txt di nome esportazione_auto contenente la lista delle auto e le loro caratteristiche>");
		System.out.println("ESCI <chiude il programma>");
		System.out.println("Inserisci il comando > ");
		String inserito = new BufferedReader(new InputStreamReader(System.in)).readLine();
		if (inserito.toLowerCase().equals("lista")) {
			cmd.lista();
		} else if (inserito.toLowerCase().equals("cerca")) {	
			cmd.cerca();
		}else if (inserito.toLowerCase().equals("esporta")) {
			cmd.esporta();
		}else if (inserito.toLowerCase().equals("esci")) {
			System.exit(0);
		}else if(inserito.toLowerCase().equals("inserisci")) {
			cmd.inserisci();
		}else {	
			System.out.println("!COMANDO NON RICONUSCIUTO!\n");
		}
		}while(a!=0);
	}
	
}
