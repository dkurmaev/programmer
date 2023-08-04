package ait.tv.model;
import java.util.List;
import java.util.Random;
public class Channel {
    private String name;
    private int number;
    private List<TVProgram> programList;
    public Channel(String name, int number, List<TVProgram> programList) {
        this.name = name;
        this.number = number;
        this.programList = programList;
    }
    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }
    public List<TVProgram> getProgramList() {
        return programList;
    }
    public void showRandomProgram() {
        Random random = new Random();
        int programIndex = random.nextInt(programList.size());
        TVProgram program = programList.get(programIndex);
        System.out.println("Playing program: " + program.getName());
    }
}