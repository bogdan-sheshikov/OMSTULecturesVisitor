package visitor.omstulecturesvisitor.Parsers;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetScheduleFromSite {
    private String patternUrl = "https://rasp.omgtu.ru/api/schedule/group/";
    //  427?start=2022.01.10&finish=2022.01.16&lng=1
    private String response;

    GetScheduleFromSite(String group){
        patternUrl += group;
    }

    private String readAllToString(BufferedReader inputStream) throws IOException {
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = inputStream.readLine()) != null){
            response.append(inputLine);
        }
        inputStream.close();
        return response.toString();
    }

    private String formUrlRequest(){
        String formedRequest;
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        String startDate = dateTimeFormatter.format(ldt);
        String finishDate = dateTimeFormatter.format(ldt.plusDays(7));

        formedRequest = patternUrl + "?start=" + startDate + "&" +
                "finish=" + finishDate + "&lng=1";
        System.out.println(formedRequest);
        return formedRequest;
    }

    public JsonElement getResponse(){
        try {
            URL url = new URL(formUrlRequest());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)
            );
            System.out.println("response was get");

            String jsonString = readAllToString(inputStream);
            JsonElement response = JsonParser.parseString(jsonString);
            System.out.println(response.toString());
            return response;
        } catch (IOException exception){
            exception.printStackTrace();
        }
        return null;
    }
}
