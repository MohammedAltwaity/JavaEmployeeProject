package dataHandle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DataReader {
    public static List<String[]> readCSV(String fileName) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            //to skip the header in the file, if we don't have the header we can remove reader.readLine();
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace() ;
        }

        return data;
    }
}

