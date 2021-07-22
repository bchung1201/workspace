/*
ID: bryanch5
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.*;
public class namenum {

    public static void main(String args[]) throws Exception{
        BufferedReader b = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
        String name = b.readLine();
        List<String> keypad = new ArrayList<String>();
        List<Integer> digits = new ArrayList<Integer>();
        List<String> names = new ArrayList<String>();
        List<String> test = new ArrayList<String>();
        keypad.add("ABC");
        keypad.add("DEF");
        keypad.add("GHI");
        keypad.add("JKL");
        keypad.add("MNO");
        keypad.add("PRS"); 
        keypad.add("TUV");
        keypad.add("WXY");
        for (int i = 0; i < name.length(); i++){
            digits.add(Integer.parseInt(String.valueOf(name.charAt(i))));
        }
        for (int i : digits) {
            test.add(keypad.get(i - 2));
        }
        String nametester;
        while ((nametester = dict.readLine()) != null) {
            boolean same = true;
            if (test.size() == nametester.length()) {
                for (int i = 0; i < test.size(); i++) {
                    if (test.get(i).indexOf(nametester.charAt(i)) == -1) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    names.add(nametester);

                }
            }
        }
        if (names.size() > 0) {
            for (String givenname : names) {
                p.println(givenname);
            }
        }
        else {
            p.println("NONE");
        }
        b.close();
        p.close();
        dict.close();
    }
}
