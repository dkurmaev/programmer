package ait.filesystem;

import java.io.File;

public class JavaFileAppl {
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        String path = File.separator + "C" + File.separator + "Users" + File.separator + "AIT TR Student" +
                File.separator + "OneDrive" + File.separator + "Desktop" + File.separator + "Java" + File.separator + "Java4Everyone" + File.separator +
                "src" + File.separator + "ait" + File.separator + "filesystem" + File.separator + "JavaFileAppl.java";
        File file = new File(path);
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        String newPath = path + File.separator + "newFile";
        File newFile = new File(newPath);
        System.out.println(newFile.exists());
        newFile.mkdir();
        System.out.println(newFile.exists());
    }
}
