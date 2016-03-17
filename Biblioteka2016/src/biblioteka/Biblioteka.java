package biblioteka;

import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterface;

public class Biblioteka implements BibliotekaInterface {

	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();
	
	public void dodajKnjigu(Knjiga knjiga) {
		if(knjiga== null || knjige.contains(knjiga)) 
			throw new RuntimeException("Greska pri unosu knjige!");
		knjige.add(knjiga);
	}

	public void obrisiKnjigu(Knjiga knjiga) {
		if(knjiga== null || !knjige.contains(knjiga)) 
			throw new RuntimeException("Greska pri brisanju knjige!");
		knjige.remove(knjiga);
	}

	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {
		if(naslov == null || naslov.isEmpty())
			throw new RuntimeException("Naslov je prazan!");

		LinkedList<Knjiga> rezultat = new LinkedList<Knjiga>();
		
		for(int i = 0; i < knjige.size(); i++){
			if(knjige.get(i).getNaslov().contains(naslov))
				rezultat.add(knjige.get(i));
		}
		return rezultat;
	}
}