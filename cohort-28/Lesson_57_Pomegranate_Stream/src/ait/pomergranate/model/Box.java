package ait.pomergranate.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Box implements Iterable<Pomergranate> {
    private String name;
    public List<Pomergranate> pomergranates;

    public Box(String name, int numPomergranates) {
        this.name = name;
        pomergranates = Stream.generate(() -> new Pomergranate(new Random().nextInt(301)+400))
                .limit(numPomergranates)
                .collect(Collectors.toList());

    }

    @Override
    public Iterator<Pomergranate> iterator() {
        return pomergranates.iterator();
    }

    public String getName() {
        return name;
    }

}
