package ait.byteio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteOutputAppl {
    public static void main(String[] args) {
        try{
        FileOutputStream fout = new FileOutputStream("./res/test3", true);
        fout.write(65);
        fout.write(1);
        fout.write(27);
        fout.write(257);
    }catch(FileNotFoundException e){
        e.printStackTrace();
    }catch(IOException e){
        e.printStackTrace();
        }

    }
}
