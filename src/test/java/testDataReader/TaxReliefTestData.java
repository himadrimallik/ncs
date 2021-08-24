package testDataReader;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class TaxReliefTestData {

    public Map<String, Object> readTestData() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File("src/test/resources/testData/taxReliefData.yml"));

        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(inputStream);

        return data;
    }

}
