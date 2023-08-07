package ait.pomergranate.model;

import java.util.Iterator;
import java.util.List;

public class Box implements Iterable<Pomergranate>{
    private String name;
    private List<Pomergranate> pomergranates;
    private Box(String name, List<Pomergranate> pomergranates) {
        this.name = name;
        this.pomergranates = pomergranates;
    }
    @Override
    public Iterator<Pomergranate> iterator() {
        return pomergranates.iterator();
    }
    public String getName() {
        return name;
    }
}
