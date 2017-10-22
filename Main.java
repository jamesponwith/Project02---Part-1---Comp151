package com.booya;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        boolean isError = false;

        ArrayList list = new ArrayList();
        Scanner keyboard = new Scanner(System.in);
        do {
            try {
                System.out.println("Enter filename: ");
                File file = new File(keyboard.nextLine());
                Scanner readNameFile = new Scanner(file);

                while (readNameFile.hasNext()) {
                    list.add(readNameFile.nextLine());
                }
                readNameFile.close();

                for (int j = 0; j < list.size(); j++) {
                    if (((String) list.get(j)).contains("{")) {
                        list.set(j - 1, list.get(j - 1) + " {");
//                        out.println(list.get(j));
                        list.remove(j);
                    }
                }
                PrintWriter out = new PrintWriter(file);
                for (int i = 0; i < list.size(); i++) {
                    out.println(list.get(i));
                    //System.out.println(list.get(i));
                }

                out.close();
                isError = false;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                isError = true;
            }
        } while(isError);

    }
}
