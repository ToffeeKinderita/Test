package jsonParser.jsonParserTests;

import com.google.gson.JsonSyntaxException;
import jsonParser.jsonParserHelpers.ExceptionCustom;
import jsonParser.jsonParserHelpers.Json_HelperClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.NoSuchFileException;

import java.io.File;


public class Test_Json_ExceptionsClass extends Json_HelperClass {


    @ExtendWith(ExceptionCustom.class)
    @Test
    @DisplayName("Test_No_Such_File_Exc")
    public void test_exception() {
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

