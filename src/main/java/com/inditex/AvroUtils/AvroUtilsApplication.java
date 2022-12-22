package com.inditex.AvroUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONStyle;
import org.apache.avro.compiler.idl.Idl;
import org.apache.avro.compiler.idl.ParseException;

import java.io.File;
import java.io.IOException;

public class AvroUtilsApplication {

    public static void main(final String[] args) throws ParseException, IOException {
        if (args.length < 1) {
            throw new RuntimeException("Please provide the path to the avdl file");
        }
        final String avdlPath = args[0];

        final File inputFile = new File(avdlPath);
        final Idl idlParser = new Idl(inputFile);
        final String avroContent = idlParser.CompilationUnit().toString(true);
        final JSONArray array = JsonPath.parse(avroContent).read("$.types");
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        final JsonNode jsonNode = objectMapper.readTree(array.toString(JSONStyle.NO_COMPRESS));
        final String prettyJson = objectMapper.writeValueAsString(jsonNode);

        System.out.println(prettyJson);
    }
}
