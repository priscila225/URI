import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int Answer;
	static int a;
	static int b;
	static int Array_A[] = new int[11];
	static int Array_B[] = new int[11];
	static int Array_P[] = new int[11 * 11];

	static int i = 0;
	static int Result = 1;

	static void find(int a, int b) {
		int x = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				Array_P[x] = (int) ((Math.pow(a, i)) * (Math.pow(b, j)));
				x++;

			}
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int T;
		int i = 0;

		T = input.nextInt();

		while (T-- != 0) {

			a = input.nextInt();
			b = input.nextInt();
			find(a, b);

			Arrays.sort(Array_P);

			// Print the answer to standard output(screen).
			System.out.println((++i) +"# " + Array_P[10]);
		}
		input.close();
	}
	
