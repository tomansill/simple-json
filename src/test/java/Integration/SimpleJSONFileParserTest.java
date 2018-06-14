import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//import junit.framework.Assume;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import com.simplejson.*;
import com.simplejson.parser.*;

/**
 * Unit test for simple App.
 */
public class SimpleJSONFileParserTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SimpleJSONFileParserTest(String testName){
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        TestSuite suite = new TestSuite(SimpleJSONFileParserTest.class);
        return suite;
    }

    public void testBigJSONFile(){
        //System.out.println("location: " + SimpleJSONFileParserTest.class.getProtectionDomain().getCodeSource().getLocation().getFile());
        try{
            FileReader fr = null;
            try{
                fr = new FileReader("src/test/resources/json_test_files/sample.json");
            }catch(FileNotFoundException fnfe){
                fail(fnfe.getMessage());
            }
            SimpleJSON json = SimpleJSONParser.fromJSON(fr);
        }catch(Exception e){
            fail(e.getMessage());
        }
    }

    public void testWriteJSONFile(){
        FileWriter fw = null;
        try{
            fw = new FileWriter("test.out");
            SimpleJSON json = SimpleJSON.getAsEmptyMap();
            json.put("string", new SimpleJSON("string"));
            json.put("number", new SimpleJSON(1231231231L));
            json.put("boolean", new SimpleJSON(true));
            StringBuilder sb = new StringBuilder();

            json.put("map", json);
            json.put("array", SimpleJSON.getAsEmptyArray());
            json.get("array").add(new SimpleJSON(1));
            json.get("array").add(new SimpleJSON("abc\n\n\t\t\n\r\\/def"));
            json.toStream(fw, true);
            fw.flush();
            fw.close();
        }catch(Exception e){
            fail(e.getMessage());
        }
    }
}
