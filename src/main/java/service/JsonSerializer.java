package service;


import com.google.gson.Gson;
import lombok.ToString;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;


@ToString
public class JsonSerializer {
    private static final Logger log = (Logger) LoggerFactory.getLogger(JsonSerializer.class);

    public String createJson(String Xml) {
        XmlSerializer.XmlStructure xmlStructure = new XmlSerializer.XmlStructure();
        Path path = Paths.get("json_reqs");
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String filePath = "json_reqs/jsonReq_" + LocalDateTime.now().toString().substring(0, 19).replace(":", "_") + ".json";
        JSONObject jsonString = XML.toJSONObject(Xml);
        try {
            FileWriter writer = new FileWriter(filePath, false);
            writer.write(String.valueOf(jsonString));
            writer.flush();
            log.info("Json writed in file " + filePath);
        } catch (IOException e) {
            log.error("Json not writed in file - " + e.getMessage());
            e.printStackTrace();
        }
        return jsonString.toString();
    }
}
