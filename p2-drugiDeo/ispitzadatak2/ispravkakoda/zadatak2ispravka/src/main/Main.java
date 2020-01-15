package main;

public class Main {
	public static void main(String[] args) {

		for (int i = 100; i <= 999; i++)

			if (i == (((i / 100)%10) * ((i / 100)%10) * ((i / 100)%10) +

					((i / 10)%10) * ((i / 10)%10) * ((i / 10)%10) + (i % 10) * (i % 10) * (i % 10)))

				System.out.println(i);

	}
}
