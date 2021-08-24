package pages;

import libraries.Hooks;
import org.testng.Assert;
import testDataReader.TaxReliefTestData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

public class OppenheimerAPIPage {

    Map<String, Object> data;
    List<Map<String, Object>> taxData;
    Map<String, Object> testUserData;
    Map<String, Object> firstUserData;
    Map<String, Object> lowTaxtUserData;

    int responseCode;
    String responseMessage;

    public OppenheimerAPIPage() {
        TaxReliefTestData taxReliefTestData = new TaxReliefTestData();
        try {
            data = taxReliefTestData.readTestData();
            taxData = (List<Map<String, Object>>) data.get("taxDetails");
            testUserData = taxData.get(0);
            firstUserData = taxData.get(1);
            lowTaxtUserData = taxData.get(2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void insertRecord(String recordType){

        String baseAPI = Hooks.prop.getProperty("oppenheimerBaseAPI");
        try {
            URL url;
            String jsonInputString;
            if (recordType.toLowerCase().contains("single")){

                url = new URL(baseAPI + "/calculator/insert");
                jsonInputString = "{\n" +
                        "  \"birthday\": \""+ testUserData.get("birthday").toString() +"\",\n" +
                        "  \"gender\": \""+ testUserData.get("gender").toString() +"\",\n" +
                        "  \"name\": \""+ testUserData.get("name").toString() +"\",\n" +
                        "  \"natid\": \""+ testUserData.get("natid").toString() +"\",\n" +
                        "  \"salary\": \""+ testUserData.get("salary").toString() +"\",\n" +
                        "  \"tax\": \""+ testUserData.get("tax").toString() +"\"\n" +
                        "}";
            }else {
                url = new URL(baseAPI + "/calculator/insertMultiple");
                jsonInputString = "[\n" +
                        "  {\n" +
                        "  \"birthday\": \""+ firstUserData.get("birthday").toString() +"\",\n" +
                        "  \"gender\": \""+ firstUserData.get("gender").toString() +"\",\n" +
                        "  \"name\": \""+ firstUserData.get("name").toString() +"\",\n" +
                        "  \"natid\": \""+ firstUserData.get("natid").toString() +"\",\n" +
                        "  \"salary\": \""+ firstUserData.get("salary").toString() +"\",\n" +
                        "  \"tax\": \""+ firstUserData.get("tax").toString() +"\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "  \"birthday\": \""+ lowTaxtUserData.get("birthday").toString() +"\",\n" +
                        "  \"gender\": \""+ lowTaxtUserData.get("gender").toString() +"\",\n" +
                        "  \"name\": \""+ lowTaxtUserData.get("name").toString() +"\",\n" +
                        "  \"natid\": \""+ lowTaxtUserData.get("natid").toString() +"\",\n" +
                        "  \"salary\": \""+ lowTaxtUserData.get("salary").toString() +"\",\n" +
                        "  \"tax\": \""+ lowTaxtUserData.get("tax").toString() +"\"\n" +
                        "  }\n" +
                        "]";
            }

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("accept", "application/json");
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
            os.flush();

            responseCode = connection.getResponseCode();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void verifyResponse(String response){
        Assert.assertEquals(responseCode, Integer.parseInt(response));
    }

    public void callGetTaxReliefAPI(){
        String baseAPI = libraries.Hooks.prop.getProperty("oppenheimerBaseAPI");
        try {
            URL url = new URL(baseAPI + "/calculator/taxRelief");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("accept", "application/json");
            connection.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            responseCode = connection.getResponseCode();
            responseMessage = response.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateGetTaxReliefAPIFields(){
        Assert.assertTrue(responseMessage.contains("natid"));
        Assert.assertTrue(responseMessage.contains("name"));
        Assert.assertTrue(responseMessage.contains("relief"));
    }

    public void validateNatidMasked(){
        if(responseMessage.contains("natid")){
            String natidValue = responseMessage.split("\"natid\":\"")[1].split("\",\"")[0];
            int natidLength = natidValue.length();
            for(int i = natidLength-1; i>=0; i--){
                if(i>3){
                    Assert.assertEquals(natidValue.charAt(i) + "", "$");
                }else {
                    Assert.assertNotEquals(natidValue.charAt(i) + "", "$");
                }
            }
        }else {
            Assert.fail("natid not found in response");
        }
    }

    public void validateTaxReliefCalculation(){
        String taxAmountAPI = responseMessage.split(testUserData.get("name").toString())[1].split("\":\"")[1].split("\\.")[0];
        int taxAmountCalculated = calcuateTax(testUserData.get("salary").toString(), testUserData.get("tax").toString(),
                testUserData.get("birthday").toString(), testUserData.get("gender").toString());
        Assert.assertEquals(Integer.parseInt(taxAmountAPI), taxAmountCalculated);
    }

    public void validateRounding(){
        String taxAmountDecimal = responseMessage.split(firstUserData.get("name").toString())[1].split("\":\"")[1].split("\\.")[1].split("\"}")[0];
        Assert.assertEquals(taxAmountDecimal, "00");
    }

    public void validateTaxReliefRoundedToFifty(int taxAmount){
        String lowTaxAmount = responseMessage.split(lowTaxtUserData.get("name").toString())[1].split("\":\"")[1].split("\\.")[0];
        Assert.assertEquals(Integer.parseInt(lowTaxAmount), taxAmount);
    }

    public void validateRoundingTruncate(int decimalPlaces){
        String taxAmountDecimal = responseMessage.split(firstUserData.get("name").toString())[1].split("\":\"")[1].split("\\.")[1].split("\"}")[0];
        Assert.assertEquals(taxAmountDecimal.length(), decimalPlaces);
    }

    private int calcuateTax(String sSalary, String sTaxPaid, String dateOfBirth, String gender){

        int bonus = 0;
        double variable = 0;
        int salary = Integer.parseInt(sSalary);
        int taxPaid = Integer.parseInt(sTaxPaid);

        int year = Integer.parseInt(dateOfBirth.substring(4,8));
        int month = Integer.parseInt(dateOfBirth.substring(2,4));
        int day = Integer.parseInt(dateOfBirth.substring(0,2));
        int age = getAgeInYears(LocalDate.of(year, month, day));

        if(gender.equalsIgnoreCase("f")) bonus = 500;

        if(age<=18){
            variable = 1;
        }else if(age<=35){
            variable = 0.8;
        }else if(age<=50){
            variable = 0.5;
        }else if(age<=75){
            variable = 0.367;
        }else {
            variable = 0.05;
        }

        double taxAmount = (salary - taxPaid)*variable + bonus;
        int roundedTaxAmount = (int) Math.round(taxAmount);

        if(roundedTaxAmount<50) roundedTaxAmount = 50;

        return roundedTaxAmount;
    }

    public int getAgeInYears(LocalDate birthday){
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthday, today);
        return period.getYears();
    }
}
