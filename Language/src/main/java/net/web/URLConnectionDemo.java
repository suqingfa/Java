package net.web;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;

public class URLConnectionDemo
{
    public static void main(String[] args) throws Exception
    {
        // 自动处理Cookie
        CookieHandler.setDefault(new CookieManager());

        // get 默认产生的连接只有输入流
        URLConnection urlConnection = new URL("https://github.com").openConnection();

        urlConnection.connect();

        System.out.println(urlConnection.getHeaderFields());
        Scanner scanner = new Scanner(urlConnection.getInputStream());
        while (scanner.hasNextLine())
        {
            System.out.println(scanner.nextLine());
        }
        scanner.close();

        // post
        urlConnection = new URL("https://github.com").openConnection();
        urlConnection.setDoOutput(true);
        InputStream inputStream = urlConnection.getInputStream();
        OutputStream outputStream = urlConnection.getOutputStream();
    }
}
