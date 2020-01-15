# Zadatak 1

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

Napraviti javnu klasu **StatistikaException** u paketu **popis.izuzeci** koja predstavlja proveravani izuzetak i ima:
- Javni **konstruktor** koji kao parametar prima poruku greške i poziva odgovarajući konstruktor nadklase prosleđujući mu parametar.

Napraviti javnu klasu **Domacinstvo** u paketu **popis** koja može da bude serijalizovana i ima:
- Privatni atribut **mesto** koji predstavlja naziv mesta u kojem se domaćinstvo nalazi.
- Privatni atribut **brojOdraslih** koja predstavlja broj odraslih članova domaćinstva.
- Privatni atribut **brojDece** koja predstavlja broj dece u domaćinstvu.
- Privatni atribut **mesečnaPrimanja** koji predstavlja iznos mesečnih primanja cele porodice u dinarima.
- Odgovarajuće javne **get i set metode** za ove atribute. Nedozvoljena vrednost za atribut mesto je null String i svaki String kraći od 5 znakova ili duži od 13 znakova, a ostali atributi moraju biti nula ili veći od nule. U slučaju unosa nedozvoljenih vrednosti, baciti izuzetak klase RuntimeException sa odgovarajućom porukom.
- Redefinisanu **toString** metodu klase Object koja vraća String sa svim podacima o Domaćinstvu uz odgovarajuću poruku, ali da se posle svakog atributa upiše u String i znak "tab“.
- Redefinisanu **equals** metodu klase Object. Metoda prvo proverava da li je uneti objekat klase **Domacinstvo**, pa ako nije, metoda vraća false. Metoda vraća true ako su vrednosti svih atributa jednaki vrednostima odgovarajućih atributa unetog domaćinstva, a inače false.

Napraviti javnu klasu **PopisDomacinstava** u paketu **popis** koja ima:
- Privatni atribut **domacinstva** koji predstavlja listu objekata klase **Domacinstvo**.
- Javni **konstruktor** bez argumenata koji inicijalizuje listu.
- Javnu metodu **upisiDomacinstvaBezPrimanja** koja u tekstualni fajl "domacinstva\_bez\_prihoda.txt" upisuje samo podatke o onim domaćinstvima u kojima je iznos mesečnih primanja nula i to u formatu &lt;mesto&gt;#&lt;broj odraslih&gt;#&lt;broj dece&gt;. Ako je lista prazna, baciti izuzetak klase **StatistikaException**.
- Javnu metodu **statistikaDomacinstava** koja na osnovu podataka iz liste domaćinstava sastavlja izveštaj i upisuje ga u fajl "izvestaj.txt". U njemu treba da se nađe u posebnim redovima: ukupan broj domaćinstava, prosečan iznos mesečnih primanja po domaćinstvu, prosečan broj odraslih po domaćinstvu, prosečan broj dece po domaćinstvu i prosečan iznos mesečnih primanja po članu domaćinstva (računaju se i odrasli članovi i deca).
- Javnu metodu **ucitajDomacinstvaSaTastature** koja sa tastature učitava podatke o nekoliko domaćinstava i unosi ih u listu. Broj domaćinstava se unosi na početku. U slučaju pojavljivanja izuzetka pri unosu za neko domaćinstvo, uhvatiti izuzetak, ispisati njegovu poruku i pokušati još jednom unos sa tastature za to domaćinstvo.

# Zadatak 2 (ispravka koda)

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

U produžetku teksta je dat kod klase sa metodom koja bi trebalo da u tekstualni fajl "brojevi.txt" upiše u posebnim redovima sve proste brojeve u rasponu od 1 do 100. Broj je prost ako je deljiv isključivo brojem 1 i sobom. Konkretno, u fajlu bi trebalo da se nađu brojevi: 1, 2, 3, 5, 7, 11, 13, 17, 19, ..... i 97.

Dati kod se kompajlira, ali ne radi to šta treba. Napraviti javnu klasu **UpisivanjeUTXTfajl** u paketu **ispravka_koda**, prekucati u nju kod koji je dat i uz minimalne izmene ga ispraviti tako da funkcioniše kako treba. Napraviti test klasu i, koristeći njenu **main** metodu, pozvati metodu **upisiProsteBrojeve()** i proveriti njen rad.

	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	
	public class UpisivanjeUTXTFajl {
		public static void upisiProsteBrojeve() {
			try {
				PrintWriter out = new PrintWriter(new FileWriter("brojevi.txt"));
	
				for (int i = 1; i <= 100; i++) {
					boolean prost = true;
					for (int j = 1; j < i; j++)
						if (i % j == 0)
							prost = false;
					if (prost)
						out.println(i);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}