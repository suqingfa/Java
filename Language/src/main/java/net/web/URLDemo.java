package net.web;

import java.net.URL;
import java.util.Scanner;

public class URLDemo
{
    public static void main(String[] args) throws Exception
    {
        URL url = new URL("https://raw.githubusercontent.com/suqingfa/Java/master/Language/src/main/java/net/web/URLDemo.java");

        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNextLine())
        {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
