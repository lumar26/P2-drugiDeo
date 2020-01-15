#Zadatak 2
U produžetku teksta je dat kod klase sa metodom koja bi trebalo da pronađe i u tekstualni fajl „brojevi4.txt“
upiše sve trocifrene Armstrongove brojeve. To su trocifreni brojevi koji su jednaki zbiru kubova svojih
cifara. Na primer, 153 = 1\*1\*1 + 5\*5\*5 + 3\*3\*3, tako da je broj 153 Armstrongov broj.

Dati kod se kompajlira, ali ne radi to šta treba. Napraviti u javnu klasu **UpisivanjeUTXTfajl4** u paketu
**ispravka_koda**, prekucati u nju kod koji je dat i, __uz minimalne izmene__ ga ispraviti tako da funkcioniše
kako treba. Napraviti test klasu i, koristeći njenu main metodu, pozvati metodu
**upisiArmstrongoveBrojeve()** i proveriti njen rad.


package ispravka_koda;

import java.io.*;

public class UpisivanjeUTXTFajl4 {

>public static void upisiArmstrongoveBrojeve(){

>>try {

>>>PrintWriter out = new PrintWriter(

>>>>new FileWriter("brojevi4.txt"));

>>>for (int i=100; i <= 999;i++)

>>>>if (i == (i/100 \* i/100 \* i/100)+

>>>>>>(i%10 \* i%10 \* i%10)+

>>>>>>(i/10 % 10)\*(i/10 % 10)\*(i/10 % 10))

>>>>>out.println(i);

>>>out.close();

>>} catch (IOException e) {

>>>e.printStackTrace();

>>}

>}

}