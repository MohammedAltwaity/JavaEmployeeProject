package processor;

import java.io.File;

public class ListFilesInRelativeDirectory {
    public static void listFilesInRelativeDirectory(String relativePath) {
        String basePath = System.getProperty("user.dir"); // get the current working directory
        String absolutePath = basePath + File.separator + relativePath;

        File directory = new File(absolutePath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }

//    public static void main(String[] args) {
//        String relativePath = "src/main/resources";
//        listFilesInRelativeDirectory(relativePath);
//    }

}

