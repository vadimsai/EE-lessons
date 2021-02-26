package itdvn.jsonpars;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class JsonPars {
    public static void main(String[] args) throws IOException {
        URL url1=new URL("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5");
        ObjectMapper mapper=new ObjectMapper();
        MoneConvertBank[] banks1=mapper.readValue(url1,MoneConvertBank[].class);
        for (MoneConvertBank e : banks1) {
            System.out.println(e);   // получаем из API
        }

        String s1=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(banks1);// записываем в файл
        Files.write(Paths.get("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\jsonpars\\jacksonwrite.json"),s1.getBytes(), StandardOpenOption.CREATE);



        // Gson Parser (API)
        URL url=new URL("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5");
        GsonBuilder builder=new GsonBuilder();
        builder.setPrettyPrinting();// с табуляцией
        Gson gson=builder.create();
        JsonReader reader=new JsonReader(new InputStreamReader(url.openStream()));
        MoneConvertBank[] banks=gson.fromJson(reader,MoneConvertBank[].class);
        for (MoneConvertBank e : banks) {
            System.out.println(e);   // получаем из API
        }

        String s=gson.toJson(banks);// записываем в файл
        Files.write(Paths.get("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\jsonpars\\gsonwrite.json"),s.getBytes(), StandardOpenOption.CREATE);




     // jackson Parser из классов в json
        List<String> contacts=new ArrayList<>();
        contacts.add("universe"); contacts.add("AllOver"); contacts.add("SHAMBALA"); contacts.add("YourHeart");
        MahaAvatar mahaAvatar=new MahaAvatar("PREMA","SAI","LOVE",new Avatar("AUM","SATYA", 99999,contacts));
        File file=new File("C:\\Users\\it\\IdeaProjects\\HrProject\\src\\main\\java\\zadachi\\jsonpars\\maha.json");
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(file,mahaAvatar); // записали объекты в файл (в json формате)

        MahaAvatar mahaAvatar1=objectMapper.readValue(file, MahaAvatar.class);// читаем из файла
        System.out.println(mahaAvatar1.getEraPrema());


    }


}
