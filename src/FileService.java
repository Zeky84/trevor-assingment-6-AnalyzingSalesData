import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public List<SalesDataByModel> loadAllDataByModel(String salesModelInfo) throws IOException {
        String headerLine;
        List<SalesDataByModel> allDataByModel= new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(salesModelInfo))) {
            String line;
            //Reading the header line of the file to avoid the try-catch message
            headerLine = fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                try {
                    allDataByModel.add(new SalesDataByModel(line.split("\\p{Punct}"))); // will split in month, day and sales
                } catch (NumberFormatException nfe) {
                    System.out.println("NumberFormat Exception: " + nfe);
                }
            }
        }
        return allDataByModel;
    }
}
