import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(ir);

        int N = 0;
        int M = 0;
        int V = 0;
        int M1 = 0;
        int V1 = 0;
        int count = 1;
        String line = null;
        int time1 = 0;
        int time2 = 0;
        int val = 2;
        int time1_home = 0;
        int time2_home = 0;

        N = Integer.parseInt(input.readLine());
        N = N * 2;
        while (N > 0)
        {

            line = input.readLine();

            // Time 1 em casa
            if (val == 2) {
                M = Character.getNumericValue(line.charAt(0));
                V = Character.getNumericValue(line.charAt(4));
                time2_home += V;
                val--;
            }
            // Time 2 em casa
            else {
                M1 = Character.getNumericValue((line.charAt(4)));
                V1 = Character.getNumericValue(line.charAt(0));
                time1_home += M;
                val = 2;
            }
            if (count % 2 == 0)
            {
                time1 = M1 + M;
                time2 += V1 + V;

                if (time1 > time2)
                {
                    time1++;
                }
                else if (time1 < time2)
                {
                    time2++;
                }
                if (time1 == time2)
                {
                    time1++;
                    time2++;
                }

                if (time1 == time2)
                {
                    if (time1_home > time2_home)
                    {
                        System.out.println("Time 1");
                    }
                    else if (time2_home > time1_home) {
                        System.out.println("Time 2");
                    }
                    else {
                        System.out.println("Penaltis");
                    }
                }
                if (time1 > time2)
                {
                    System.out.println("Time 1");
                }
                if (time1 < time2)
                {
                    System.out.println("Time 2");
                }
                // clean it! ;)
                time1 = 0;
                time2 = 0;
                time1_home = 0;
                time2_home = 0;
            }
            count++;
            N--;
        }
    }
}
