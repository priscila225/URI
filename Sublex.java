
package training;

import java.io.*;
import java.util.*;

public class Sublex {
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {

        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out, true);

        int T = Integer.parseInt(in.readLine()); // test cases

        for (int tc = 1; tc <= T; tc++) {

            int k = Integer.parseInt(in.readLine());
            char[] s = in.readLine().toCharArray();
            int N = s.length;
            int[] arraySuffix = createSuffixArray(s);
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[arraySuffix[i]] = i;
            int[] arr2 = lcp(s, arraySuffix, arr);

            int[] pcount = new int[N];
            pcount[0] = N - arr[0];
            for (int i = 1; i < N; i++)
                pcount[i] = pcount[i - 1] + (N - arr[i]) - arr2[i];

            int lo = 0, hi = N - 1;
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (pcount[mid] < k)
                    lo = mid + 1;
                else
                    hi = mid;
            }

            if (k > (pcount[N - 1]))
            {
                System.out.println("#" + tc + " None");
            }
            else {
                System.out.print("#" + tc + " ");
                for (int i = arr[lo]; i <= N - (pcount[lo] - k) - 1; i++)
                    System.out.print(s[i]);
            }
            out.println();
        }
        out.close();
        System.exit(0);
    }

    private static int[] createSuffixArray(char[] s) {
        int n = s.length;
        int[] id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = s[i] - 'a';

        for (int j = 1; j <= n; j <<= 1) {
            Triplet[] elem = new Triplet[n];
            for (int i = 0; i < n; i++)
                elem[i] = new Triplet(id[i], (i + j < n) ? id[i + j] : -1, i);
            Arrays.sort(elem);
            int cur = -1;
            for (int i = 0; i < n; i++) {
                if (i == 0
                        || !(elem[i].a == elem[i - 1].a && elem[i].b == elem[i - 1].b))
                    cur++;
                id[elem[i].c] = cur;
            }
        }

        return id;
    }

    private static int[] lcp(char[] A, int[] order, int[] rank) {
        int n = order.length;
        int[] height = new int[n];

        int h = 0;
        for (int i = 0; i < n; i++) {
            if (order[i] > 0) {
                int j = rank[order[i] - 1];
                while (i + h < n && j + h < n
                        && A[i + h] == A[j + h])
                    h++;
                height[order[i]] = h;
                if (h > 0)
                    h--;
            }
        }
        return height;
    }

    static class Triplet implements Comparable<Triplet> {
        public int a, b, c;

        public Triplet(int _a, int _b, int _c) {
            a = _a;
            b = _b;
            c = _c;
        }

        public int compareTo(Triplet other) {
            return (a == other.a) ? b - other.b : a - other.a;
        }
    }
}
