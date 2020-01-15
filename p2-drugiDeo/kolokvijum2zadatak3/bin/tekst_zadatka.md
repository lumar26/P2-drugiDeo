# Zadatak 1

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

Napraviti javnu klasu **VaterpoloException** u paketu **vaterpolo.exception** koja predstavlja neproveravani izuzetak i ima:
- Javni konstruktor koji kao parametar prima poruku greške i poziva odgovarajući konstruktor nadklase prosleđujući mu parametar.

Napraviti javnu klasu **Vaterpolista** u paketu **vaterpolo** koja ima:
- Privatni atribut **imePrezime**. Vrednost za ovaj atribut je uvek u formatu "IME PREZIME".
- Privatni atribut **klub** koji predstavlja ime kluba za koji vaterpolista igra.
- Privatni atribut **poeni** koji predstavlja ukupan broj golova koje je vaterpolista postigao na utakmici.
- Odgovarajuće **javne get i set metode** za ove atribute. Nedozvoljene vrednosti za atribute imePrezime i klub su null i prazni Stringovi, a broj poena može biti nula ili veći od nule. U slučaju unosa nedozvoljenih vrednosti, baciti izuzetak klase **VaterpolistaException** sa odgovarajućom porukom.
- Redefinisanu **toString** metodu klase Object koja vraća String sa svim podacima o vaterpolisti uz odgovarajuću poruku.
- Redefinisanu **equals** metodu klase Object. Metoda prvo proverava da li je uneti objekat klase Vaterpolista, pa ako nije baca izuzetak klase **VaterpoloException**. Metoda vraća true ako su ime, prezime i naziv kluba jednaki imenu, prezimenu i nazivu kluba unetog vaterpoliste, a u suprotnom false.

Napraviti javnu klasu **VaterpoloUtakmica** u paketu **vaterpolo** koja ima:
- Privatni atribut **vaterpolisti** koji je lista objekata klase **Vaterpolista**. Listu odmah inicijalizovati.
- Javnu metodu **napraviIzvestaj** koja u tekstualni fajl "izvestaj.txt" upisuje podatke o onim vaterpolistima iz liste koji su ostvarili makar dva gola i to u formatu: &lt;ime prezime&gt;#&lt;klub&gt;#&lt;broj poena&gt. Podatke o svakom vaterpolisti upisati u poseban red.
- Javnu metodu **dodajVaterpolistu** koja dobija tri ulazna parametra: ime i prezime, klub i broj poena koji predstavljaju podatke o vaterpolisti. Metoda unosi novog vaterpolistu u listu samo ako u listi već ne postoji isti vaterpolista. U slučaju da u listi već postoji taj vaterpolista, potrebno je u tekstualni fajl "greske.txt" uneti sve podatke o tom vaterpolisti i upisati u sledeći red fajla poruku "Vec postoji u listi".
- Javnu metodu **unesiVaterpolisteSaTastature** koja sa tastature učitava podatke o dvadeset dvojici vaterpolista i unosi ih u listu. U slučaju greške (nekog izuzetka) u toku unosa podataka za nekog vaterpolistu, metoda bi trebalo da preskoči unos za tog vaterpolistu, ispiše poruku izuzetka i nastavi sa unosom za preostale vaterpoliste.

# Zadatak 2 (ispravka koda)

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

U produžetku teksta je dat kod klase sa metodom koja kao parametar dobija niz sa tačno četiri String vrednosti i na ekranu ispisuje ove String-ove, ali kao stranice kvadrata: gornju i donju stranicu čine horizontalno ispisani prvi i četvrti String iz niza, a levu i desnu stranicu čine vertikalno ispisani drugi i treći String iz niza. Kao teme kvadrata ispisati znak zvezda ('*'). Smatrati da nijedan String iz niza nije null i da su svi iste dužine. Na primer, ako metoda kao ulaz dobije niz sa četiri String vrednosti {“BELO“, “CRNO“, “ZUTO“, “SIVO“}, konačan izlaz na ekranu treba da izgleda ovako:

	*BELO*
	C    Z
	R    U
	N    T
	O    O
	*SIVO*

Dati kod se kompajlira, ali ne radi to šta treba. Napraviti klasu **StringIspisivac3** u paketu **ispravka_koda**, prekucati u nju kod koji je dat i uz minimalne izmene ga ispraviti tako da funkcioniše kako treba. Napraviti test klasu i, koristeći njenu **main** metodu, pozvati metodu **ispisiKvadrat() **i proveriti njen rad.

	public class StringIspisivac3 {
		public static void ispisiKvadrat(String[] niz) {
			String prazno = "";
			int j = 0;
			while (j < niz[0].length()) {
				prazno = prazno + "";
				j++;
			}
			System.out.println('*' + niz[0] + '*');
			for (int i = 0; i < niz[1].length(); i++)
				System.out.println(niz[i].charAt(j) + prazno + niz[i].charAt(j));
			System.out.println('*' + niz[3] + '*');
		}
	}