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
        System.out.println("location: " + SimpleJSONFileParserTest.class.getProtectionDomain().getCodeSource().getLocation().getFile());
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
}
