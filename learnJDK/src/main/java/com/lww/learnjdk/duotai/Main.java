package com.lww.learnjdk.duotai;

import com.google.common.collect.Lists;
import com.lww.App;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        Plate<Fruit> p=new Plate<Apple>(new Apple());
//
//
//        Plate<? extends Fruit> ff =new Plate<Apple>(new Apple());
//
//
//        List<? extends Fruit> ss = new ArrayList<>();
//        Fruit fruit = ss.get(0);
//        List<Fruit> fruits = new ArrayList<>();
//        ss.addAll(fruits);
//
//        List<? super Apple> app = new ArrayList<>();
//        app.add(new Apple());
//        BiFunction
//
//        Apple apple = app.get(0);
//        Collectors.toList();
//
//        new Collectors.CollectorImpl<>((Supplier<List<T>>) ArrayList::new, List::add,
//                (left, right) -> { left.addAll(right); return left; },
//                CH_ID)
//
//    }
//    public static <T>
//    Collector<T, ?, List<T>> toList() {
//        return new Collectors.CollectorImpl<>((Supplier<List<T>>) ArrayList::new, List::add,
//                (left, right) -> { left.addAll(right); return left; },
//                CH_ID);
//        Collectors.toMap();
        Fruit fruit1 = new Fruit();
        fruit1.setName("apple");
        Fruit fruit2 = new Fruit();
        fruit2.setName("apple");
        Fruit fruit3 = new Fruit();
        fruit3.setName("apple2");
        List<Fruit> fruits = Lists.newArrayList(fruit1,fruit2,fruit3);
//        MyMapCollector myMapCollector = new MyMapCollector<String, Fruit>();
        Function<Fruit, String> stringFruitFunction = Fruit::getName;
//        myMapCollector.setKeyMapper(stringFruitFunction);
        Map<String, List<Fruit>> m = fruits.stream().collect(new MyMapCollector<String, Fruit>(stringFruitFunction));


    }
    public void test() {


    }

}
class MyMapCollector<K, T> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

    private Function<? super T, ? extends K> keyMapper;

    public MyMapCollector(Function<? super T, ? extends K> keyMapper) {
        this.keyMapper = keyMapper;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (map, element) ->  {
            List<T> value;
            value = map.get(keyMapper.apply(element));
            if (value != null) {
                value.addAll(Lists.newArrayList(element));
            } else {
                value = Lists.newArrayList(element);
            }
            map.put(keyMapper.apply(element), value);
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (a, b) -> { a.putAll(b); return a; };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED));
    }

    public Function<? super T, ? extends K> getKeyMapper() {
        return keyMapper;
    }

    public void setKeyMapper(Function<? super T, ? extends K> keyMapper) {
        this.keyMapper = keyMapper;
    }
}
