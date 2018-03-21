package com.lww.learnjdk.Lambda;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
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
