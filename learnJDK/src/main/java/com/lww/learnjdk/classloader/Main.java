package com.lww.learnjdk.classloader;

import java.net.URL;

public class Main {
    public static void main(String[] args) {

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
        URL[] urls2 = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls2.length; i++) {
            System.out.println(urls2[i].toExternalForm());
        }


        ClassLoader loader = MyClassLoader.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }


    }
}
