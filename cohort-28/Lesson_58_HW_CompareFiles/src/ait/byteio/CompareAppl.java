package ait.byteio;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class CompareAppl {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java FileComparator <file1> <file2> <file3>");
            return;
        }
        String file1Path = args[0];
        String file2Path = args[1];


        try {
            if (areFilesEqual(file1Path, file2Path)) {
                System.out.println("Files are the same.");
            } else {
                System.out.println("Files are different.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static boolean areFilesEqual(String path1, String path2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(path1);
             FileInputStream fis2 = new FileInputStream(path2)) {

            byte[] buffer1 = new byte[4096];
            byte[] buffer2 = new byte[4096];

            int bytesRead1;
            int bytesRead2;

            do {
                bytesRead1 = fis1.read(buffer1);
                bytesRead2 = fis2.read(buffer2);

                if (bytesRead1 != bytesRead2 || !Arrays.equals(buffer1, buffer2)) {
                    return false;
                }
            } while (bytesRead1 != -1);

            return true;
        }
    }
}
