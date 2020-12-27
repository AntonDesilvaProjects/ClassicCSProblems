package com.algorithms.basic;

import com.algorithms.Utils;

import java.util.HashMap;
import java.util.Map;

/*
 *  Fibonacci sequence is a sequence of numbers such that any number, except the first two, is the sum of the previous
 *  two.
 *  0, 1, 1, 2, 3, 5, 8, 13, 21
 *
 * */
public class Fibonacci {
    public static void main(String... args) {
        Utils.time("Memoized_Recursive", () -> System.out.println(fib_recursive_memoized(1000)));
        Utils.time("Iterative", () -> System.out.println(fib_itr(1000)));
    }

    /**
     * A basic recursive approach which uses the following formula:
     * <p>
     * fib(n) = fib(n - 1) + fib(n - 2) for n > 2
     * fib(0) = 0
     * fib(1) = 1
     */
    public static int fib_recursive(int n) {
        return n < 2 ? n : fib_recursive(n - 1) + fib_recursive(n - 2);
    }

    /**
     * Uses a map to remember previously computed values. This approach reduces the recursive calls significantly.
     */
    static Map<Integer, Long> memo = new HashMap<>(Map.of(0, 0L, 1, 1L));

    public static long fib_recursive_memoized(int n) {
        if (!memo.containsKey(n)) {
            memo.put(n, fib_recursive_memoized(n - 1) + fib_recursive_memoized(n - 2));
        }
        return memo.get(n);
    }

    /**
     *  Uses an iterative approach where we keep track of the previous two numbers and generate the sum as
     *  needed.
     * */
    public static long fib_itr(int n) {
        long last = 0;
        long next = 1;
        for (int i = 0; i < n; i++) {
            long oldLast = last;
            last = next;
            next = oldLast + next;
        }
        return last;
    }
}
