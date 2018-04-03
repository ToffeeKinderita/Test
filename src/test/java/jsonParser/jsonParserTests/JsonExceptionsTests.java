package jsonParser.jsonParserTests;

import com.google.gson.JsonSyntaxException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.NoSuchFileException;

import java.io.File;


public class JsonExceptionsTests extends JsonParserTests {

    @Test
    @DisplayName("Test_No_Such_File_Exc")
    public void testNoSuchFileException() {
        Assertions.assertThrows(NoSuchFileException.class, () -> {
            parser.readFromFile(new File("src/main/resources/exception.json"));
        });
    }

    @ParameterizedTest
    @DisplayName("Test_Json_Syntax_Exc")
    @ValueSource(strings = {"badJson1.json", "badJson2.json", "pdf.pdf", "badJson3.json", "badJson4.json"})
    void test_JSONException(String path) {
        Assertions.assertThrows(JsonSyntaxException.class, () -> {
            parser.readFromFile(new File("src/main/resources/" + path));
        });
    }

}