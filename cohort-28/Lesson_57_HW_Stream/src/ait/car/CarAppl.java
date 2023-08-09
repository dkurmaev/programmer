package ait.car;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CarAppl {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", 100000);
        Car car2 = new Car("MB", 70000);
        Car car3 = new Car("Opel", 30000);
        Car car4 = new Car("Volvo", 100000);
        Car car5 = new Car("Mazda", 150000);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        cars.stream()
                .map(Car :: getModel)
                .forEach(System.out :: println);

        System.out.println("======== flatMap - плоское отображение =========");
        String[] strings = {"Hello", "Jaaaaaaaava"};
        Arrays.stream(strings)
                .map(s -> s.split(""))
                .flatMap(Arrays :: stream).distinct()
                .forEach(System.out :: print);
        System.out.println("\n======== range() -  создает стрим целых чисел от 1 до 2 =========");
        IntStream.range(1,3).forEach(System.out :: print);
        LongStream.rangeClosed(1,3).forEach(System.out :: print);

        System.out.println("\nAnother example for flatMap");
        Stream.of(2,1,3)
                .flatMapToInt(i ->IntStream.range(0,i))
                .forEach(System.out::print);

        // [0 1 2][0][0,1,2]

        System.out.println("\n with map");

        Stream.of(2,1,3)
                .map(i ->IntStream.range(0,i))
                .forEach(System.out::println);


        // takeWhile() - выбирает элементы, пока они соответствуют условию. Если встречается элемент не соответствующий
        // условию, метод заканчивает работу
        Stream.of(-6,-9,-2,1,3,-4)
                .sorted()
                .takeWhile(n -> n < 0)
                .forEach(System.out::println);

        System.out.println("drop while");

        //dropWhile() -  обратное действие
        Stream.of(-6,-9,-2,1,3,-4)
                .dropWhile(n -> n<0)
                .forEach(System.out::println);


        // concat() -  обьединяет элементы двух потоков

        Stream<String> names1 = Stream.of("John","Jack");
        Stream<String> names2 = Stream.of("Jane","Kate");
        Stream.concat(names1,names2).forEach(System.out::println);


        System.out.println("skip/limit methods");
        // метод skip(long n)  - пропускает первые  n элементов
        // limit(long n) - ограничивает поток n элеменами
        Stream<String> names = Stream.of("John","Jack","Jane","Kate");
        names.skip(0).limit(5).forEach(System.out::println);

        // min() , max() - возвращают мин или макс элемент соответственно. Принимают компаратор.
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        System.out.println(min.get());
        System.out.println(max.get());

        //  метод reduce - терминальная операция, возвращает значение - результат операции.
        //  Optional<T> reduce (BinaryOperator<T>

        Optional<Integer> number = Stream.of(1,2,3,4,5).reduce((num1, num2)->num1*num2);
        System.out.println(number.get());
        // n1 *n2*n3*n4*n5

        Stream<String> words = Stream.of("java","is","simple");
        Optional<String> sentence = words.reduce((str1,str2)->str1+" "+str2);
        System.out.println(sentence.get());

        // T reduce ( T identity, BinaryOperator<T>
        // identity - начальное значение
        int result = Stream.of(1,2,3,4,5).reduce(2,(num1,num2)->num1 +num2);
        System.out.println(result);


        // collect -  собирает поток в коллекцию
        // collect(Collector collector)
        //  класс Collectors  предоставляет ряд встроенных функций  для сборки потока:
        // toList, toSet, toMap

        List<String> namesList = Arrays.asList("Jack","Ann","Bill","Benjamin","Bill");
        List<String>listStream = namesList.stream().filter(s->s.length()>3).collect(Collectors.toList());
        System.out.println(listStream);

        Set<String> setStream = namesList.stream().filter(s->s.length()>3)
                .collect(Collectors.toSet());
        System.out.println(setStream);

        //toMap

        Map<String, Integer> carMap = cars.stream()
                .collect(Collectors.toMap(Car::getModel, Car::getPrice));

        carMap.forEach((k,v)-> System.out.println(k +" "+v));


        // Группировка
        // Collectors.groupingBy()

        Car car11 = new Car("mercedes",100000,"red");
        Car car12 = new Car("mercedes",100000,"red");
        Car car22 = new Car("volvo",70000,"blue");
        Car car33 = new Car("Opel",30000,"black");
        Car car44 = new Car("bmw",150000,"green");
        Car car55 = new Car("acura",150000,"yellow");
        List<Car> cars1 = new ArrayList<>();
        cars1.add(car11);
        cars1.add(car12);
        cars1.add(car22);
        cars1.add(car33);
        cars1.add(car44);
        cars1.add(car55);

        Map<String,List<Car>> carsByBrand = cars1.stream()
                .collect(Collectors.groupingBy(Car ::getModel));

        for(Map.Entry<String,List<Car>>item:carsByBrand.entrySet()){

            System.out.println(item.getKey());

            for(Car car: item.getValue()) {
                System.out.println(car.getModel());
                System.out.println(car.getColor());
                System.out.println(car.getPrice());
            }
            System.out.println();

        }



    }
}

