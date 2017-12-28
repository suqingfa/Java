package jni;

public class Main
{
    public static void main(String[] args)
    {
        System.loadLibrary("HelloNative");

        HelloNative helloNative = new HelloNative();
        System.out.println(helloNative.getString(1));
        System.out.println(helloNative.getString());
    }
}
