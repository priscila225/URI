import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
   
class Main {
       
    public static void main(String[] args) throws IOException {
           
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(ir);
           
        final int intMin = 0;
        final int intMax = (int) Math.sqrt(10000);
        int N = 0;
             
        boolean []vet = new boolean[10005];
             
        for(int i = 0; i<10005;i++)
            vet[i] = false;
     
        for (int a = intMin; a <= intMax; ++a) {
            for (int b = intMin; b <= intMax; ++b) {
                int sum2sq = (a * a) + (b * b);
                if (sum2sq < 10005) {
                    vet[sum2sq] = true;
                }
            }
        }
        String line;
        while ((line = input.readLine()) != null)
        {
            N = Integer.parseInt(line);
            if(N>=0)
            {
                if (vet[N])
                    System.out.println("YES");
                else
                    System.out.println("NO");
            } else {
                System.out.println("NO");
            }
        }       
    }   
}
