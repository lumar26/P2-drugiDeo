package ispravka_koda;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UpisivanjeUTXTFajl {
    public static void upisiProsteBrojeve() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("brojevi.txt"));

            for (int i = 1; i <= 100; i++) {
                boolean prost = true;
                for (int j = 2; j < i; j++)
                    if (i % j == 0)
                        prost = false;
                if (prost)
                    out.println(i);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
