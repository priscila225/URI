import java.util.Scanner;
 
 
public class Main {
    static int MAX = 999999999;
    static int g[][] = new int [1010][1010];
    static int N;
    static int vertices;
     
    static int dijkstra(int origem, int destino) {
        int minimo, atual;
        int passou[] = new int [1010];
        int pred[] = new int [1010];
        int custo[] = new int [1010];
 
        for (int i=1; i<=vertices;i++) {
            pred[i]=-1;
            custo[i]=MAX;
            passou[i]=0;
        }
        custo[origem] = 0;
        atual = origem;
        while (atual != destino) {
            for (int i=1; i<=vertices;  i++) {
                if (custo[i] > custo[atual] + g[atual][i]) {
                    custo[i] = custo[atual] + g[atual][i];
                }
            }
            minimo = MAX;
            passou[atual]=1;
            for (int i=1; i<=vertices; i++) {
                if ((custo[i]<minimo) && (passou[i]!=1)) {
                    minimo = custo[i];
                    atual = i;
                }
            }
            // caso nao consiga ir a lugar algum saindo da origem
            if (minimo == MAX) {
                return MAX;
            }
        }
        return custo[destino];
    }
     
    public static void main(String[] args) {
      int arestas, origem, destino, peso,consultas;
      Scanner input = new Scanner(System.in);
      vertices = input.nextInt();
      arestas = input.nextInt();
 
      while (vertices!=0 || arestas!=0) {
           
          for (int i=1; i<=vertices; i++) {
              for (int j=1;j<=vertices;j++) {
                  g[i][j]=MAX;
              }
          }
          for (int i=1; i<=arestas; i++) {
            origem = input.nextInt();
            destino = input.nextInt();
            peso = input.nextInt();
              g[origem][destino]=peso;
              if (g[destino][origem]!=MAX) {
                  g[origem][destino] = 0;
                  g[destino][origem] = 0;
              }
          }
          consultas = input.nextInt();
          for (int i=1; i<=consultas;i++) {
              origem = input.nextInt();
              destino = input.nextInt();
              if (dijkstra(origem,destino)== MAX) {
                  System.out.println("Nao e possivel entregar a carta");
              } else {
                  System.out.println(dijkstra(origem,destino));
              }
          }
          vertices = input.nextInt();
          arestas = input.nextInt();
          System.out.println("");
    
      }
    }
 
}
