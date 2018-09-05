package project.apitests.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import project.apitests.dto.JsonConvertible;

import java.io.File;

@Slf4j
public class JsonHandler {

    private static final ObjectMapper mapper = new ObjectMapper();


    public static JsonConvertible convertJsonIntoObject(String json, JsonConvertible jsonConvertible) throws Exception {
        jsonConvertible = mapper.readValue(json, jsonConvertible.getClass());
        return jsonConvertible;
    }

    public JsonConvertible convertJsonIntoObject(File file, JsonConvertible jsonConvertible) throws Exception {
        jsonConvertible = mapper.readValue(file, jsonConvertible.getClass());
        return jsonConvertible;
    }

    public static String formatJsonForConversion(String json) {

        String formatJson = json.replaceAll("\\n", "")
                .replaceAll("\\[", "")
                .replaceAll("]", "")
                .replace("\\r"," ")
                .trim();

        return formatJson;
    }
}
