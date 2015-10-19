package training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String string, sub;
        int i, c, length;
        List<String> list = new ArrayList<String>();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string to print it's all substrings");
        string = in.nextLine();
        System.out.println("Enter K number: ");
        int k = in.nextInt();

        length = string.length();

        System.out.println("Substrings of \"" + string + "\" are :-");

        for (c = 0; c < length; c++)
        {
            for (i = 1; i <= length - c; i++)
            {
                sub = string.substring(c, c + i);

                if (!list.contains(sub))
                    list.add(sub);
            }
        }
        Collections.sort(list);

        for (i = 0; i < list.size(); i++)
        {
            System.out.println(i + 1 + "# " + list.get(i));
        }

        if (k > list.size())
        {
            System.out.println("# None");
        }
        else {
            System.out.println("Result = " + list.get(k - 1));
        }
    }

}
