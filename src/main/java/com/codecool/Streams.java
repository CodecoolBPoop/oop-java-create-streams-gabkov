package com.codecool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Streams {
    public static void main(String[] args) {
        /*
         * Create a stream out of the following array.
         */

        String[] a1 = {"one", "two", "three"};
        Stream<String> s1 = Arrays.stream(a1);

        /*
         * Create a stream containing the Strings "one" , "two" and "three"
         * without using an array
         */
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        Stream<String> s2 = list.stream();

        /*
         * Create a stream using a stream builder.
         */

        Stream.Builder<String> b1 = Stream.builder();
        b1.add("one");
        b1.add("two");
        b1.add("three");
        Stream<String> s3 = b1.build();

        /*
         * Collect one of the above defined streams into a list.
         *
         * HINT: the keyword here is "collect"
         */

        List<String> l1 = s1.collect(Collectors.toList());

        /*
         * Streams can be infinite.  We obviously cannot create such a
         * stream by supplying all the elements ourselves.
         *
         * HINT: When looking for methods to create such streams
         * realize that:
         * - These methods cannot belong to an instance
         * - They are returning streams
         */

        /*
         * Create a stream of the powers of two.
         */

        Integer twoToTheZeroth = 1;
        UnaryOperator<Integer> doubler = (Integer x) -> 2 * x;
        Stream<Integer> s4 = Stream.iterate(twoToTheZeroth, doubler);

        /*
         * Create a stream containing the first ten elements of s4.
         */

        Stream<Integer> s5 = s4.limit(10);

        /*
         * Create a stream containing the elements of the Fibonacci
         * sequence.
         *
         * HINT: You will need to create a new class for this.
         */

        Supplier<Integer> fibSupp = new Fibonacci();
        Stream<Integer> s6 = Stream.generate(fibSupp);
        //List<Integer> fibek = s6.limit(15).collect(Collectors.toList());

        String fibS = s6.map(n -> n.toString()).limit(10).collect(Collectors.joining(", "));

        //System.out.println(fibek);
        System.out.println(fibS);
    }
}

