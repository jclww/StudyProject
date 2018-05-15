package com.lww.learnjdk.Lambda;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Lww on 2017/7/31.
 */
public class LearnLambda {
    public static void main(String[] a){
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

        String[] names = {"chaimm","peter","john"};
        List list = Arrays.stream(names).distinct().filter( s -> s.equals("peter") || s.equals("john")).limit(1).collect(Collectors.toList());
        list.forEach(s -> System.out.println(s));

        Runnable r = () -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello world");
        };

        new Thread(r).start();


        Map<String, String> map = new HashMap<String, String>() {};
        map.put("1","1");
        map.put("2","1");
        map.put("3","1");

        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(7, 5),
                Arrays.asList(9, 4, 0)
        );
        Stream<List<Integer>> inputStream2 = Stream.of(
                Arrays.asList(1),
                Arrays.asList(7, 5),
                Arrays.asList(9, 4, 0)
        );
        inputStream
                .flatMap((childList) -> childList.stream())
                .sorted( (x,y)->{
                    System.out.println("xy"+x+y);
                    return y-x;})
                .forEach(System.out::println);

        inputStream2
                .flatMap((childList) -> childList.stream())
                .sorted(Comparator.comparing(Integer::shortValue))
                .forEach(System.out::println);


        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        List<Integer> integers1 = integers.stream().filter(i -> i>2).collect(Collectors.toList());;
        System.out.println(JSON.toJSONString(integers1));

//        Arrays.stream(names).collect(Collectors.toMap(name, name));
//        Map<String, String> map2 = players.stream().collect(Collectors.toMap(Function.identity(),Function.identity().andThen()));
//        System.out.println(JSON.toJSONString(map2));

        // 以前的循环方式
//        for (String player : players) {
//            System.out.print(player + "; ");
//        }
//         使用 lambda 表达式以及函数操作(functional operation)
//        players.forEach(player -> System.out.print(player + "; "));

        // 在 Java 8 中使用双冒号操作符(double colon operator)
//        players.forEach(System.out::println);
    }
//    public Runnable toDoLater() {
//        return () -> {
//            System.out.println("later");
//        };
//    }


}
