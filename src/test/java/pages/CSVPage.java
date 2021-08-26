package pages;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.testng.Assert;

import java.io.FileReader;
import java.util.List;

public class CSVPage {

    String filePath;

    public CSVPage() {
    }

    public void openCSVFile(String fileType){
        String projectBasePath = libraries.Hooks.prop.getProperty("projectBasePath");
        if(fileType.toLowerCase().contains("single")){
            filePath = projectBasePath + "/src/test/resources/csv/oppenheimerCSV_SingleRecord.csv";
        }else {
            filePath = projectBasePath + "/src/test/resources/csv/oppenheimerCSV_MultipleRecords.csv";
        }
    }

    public void verifyHeader(){
        try {
            FileReader filereader = new FileReader(filePath);

            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();
            String[] headerLine = allData.get(0);
            String[] headerData = headerLine[0].split(",");

            // Verify Header
            for (int i=0; i < headerData.length; i++) {
                String data = headerData[i];

                switch (i){
                    case 0:
                        Assert.assertEquals(data, "natid");
                        break;
                    case 1:
                        Assert.assertEquals(data, "name");
                        break;
                    case 2:
                        Assert.assertEquals(data, "gender");
                        break;
                    case 3:
                        Assert.assertEquals(data, "salary");
                        break;
                    case 4:
                        Assert.assertEquals(data, "birthday");
                        break;
                    case 5:
                        Assert.assertEquals(data, "tax");
                        break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyRecords(){
        try {
            FileReader filereader = new FileReader(filePath);

            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            List<String[]> allData = csvReader.readAll();

            // Verify Data
            for (String[] row : allData) {
                for (String cell : row) {
                    Assert.assertFalse(cell.isEmpty());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
