import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class Main {
 
    public static void main(String[] args) throws IOException {
 
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(ir);
        int N = 0;
        int K = 0;
        int equals = 0;
        String[] line = null;
 
        N = Integer.parseInt(input.readLine());
        while (N > 0)
        {
            K = Integer.parseInt(input.readLine());
            line = new String[K];
 
            for (int i = 0; i < K; i++)
            {
                line[i] = input.readLine();
                if (i > 0)
                {
                    if (line[i].equalsIgnoreCase(line[i - 1]))
                    {
                        equals++;
                    }
                }
            }
            N--;
 
            if (K == (equals + 1))
            {
                System.out.print(line[0] + "\n");
            }
            else
            {
                System.out.print("ingles\n");
            }
            equals = 0;
        }
    }
}
