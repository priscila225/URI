
package teste;

import java.util.Scanner;

public class Main {

    static int[] result = new int[51];
    static int[] pacotes = new int[51];

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int pac;
        int quantidade;
        int peso;
        int pac2;

        while (T-- != 0)
        {
            result[0] = 0;
            pacotes[0] = 0;
            for (int j = 1; j <= 50; j++)
            {
                result[j] = -1;
                pacotes[j] = 0;
            }
            pac = input.nextInt();
            pac2 = pac;
            while (pac-- != 0) {

                quantidade = input.nextInt();
                peso = input.nextInt();

                for (int i = 50; i >= 0; i--) {
                    if (result[i] != -1) {
                        if (i + peso <= 50) {
                            if (result[i + peso] < result[i] + quantidade)
                            {
                                result[i + peso] = result[i] + quantidade;
                                pacotes[i + peso] = pacotes[i] + 1;
                            }
                        }
                    }
                }
            }

            int valor = 0;
            int pos = 0;
            for (int i = 0; i < 51; i++) {
                if (result[i] > valor) {
                    valor = result[i];
                    pos = i;
                }
            }

            System.out.println(valor + " brinquedos");
            System.out.println("Peso: " + pos + " kg");
            System.out.println("sobra(m) " + (pac2 - pacotes[pos]) + " pacote(s)");
            System.out.println("");

        }
    }
}
