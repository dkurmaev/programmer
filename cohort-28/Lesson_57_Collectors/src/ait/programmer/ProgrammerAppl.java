package ait.programmer;

import ait.programmer.model.Programmer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ProgrammerAppl {
    public static void main(String[] args) {
        List<Programmer> programmers = getProgrammers();
        System.out.println("======= Most Skilled =======");
        printMostSkilled(programmers);
        System.out.println("======= Most Popular Technologies =======");
        printMostPopularTechnologies(programmers);
    }

    private static void printMostPopularTechnologies(List<Programmer> programmers) {
        System.out.println("======= Show All Technologies =======");
        Iterable<String> technologies = programmers.stream()
                .map(Programmer::getTechnologies)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        StreamSupport.stream(technologies.spliterator(), false)
                .distinct()
                .forEach(System.out::println);
        System.out.println("======= Grouping by =======");
        Map<String, Long> techFrequency = programmers.stream()
                .map(Programmer::getTechnologies)
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(t -> t, Collectors.counting()));
        System.out.println(techFrequency);
        Long maxTech = techFrequency.values().stream()
                .max(Long::compare)
                .orElse(null);
        if(maxTech != null) {
            techFrequency.entrySet().stream()
                    .filter(e -> e.getValue().equals(maxTech))
                    .forEach(System.out::println);
        }
    }

    private static void printMostSkilled(List<Programmer> programmers) {
        Map<Integer, List<Programmer>> skilledProgrammers = programmers.stream()
                .collect(Collectors.groupingBy(p -> p.getTechnologies().length));
        Integer max = skilledProgrammers.keySet().stream()
                .max(Integer::compare)
                .orElse(null);
        skilledProgrammers.get(max).forEach(System.out::println);
    }

    private static List<Programmer> getProgrammers() {
        return List.of(
                new Programmer("Peter", "Java", "Python", "C++", "JavaScript"),
                new Programmer("John", "Java", "Python"),
                new Programmer("Helen", "Kotlin", "Scala", "Java", "JavaScript"),
                new Programmer("Jacob", "Python", "Go"),
                new Programmer("Petrovich", "Fortran", "Algol","PL/I")
        );

    }
}
