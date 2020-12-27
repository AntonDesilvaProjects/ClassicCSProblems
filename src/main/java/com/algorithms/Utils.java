package com.algorithms;

public class Utils {
    public static void time(String name, Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;
        System.out.println(name + ": " + duration + " ms");
    }
}
