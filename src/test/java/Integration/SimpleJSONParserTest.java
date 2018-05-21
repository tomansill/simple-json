import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.simplejson.*;
import com.simplejson.parser.*;

/**
 * Unit test for simple App.
 */
public class SimpleJSONParserTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SimpleJSONParserTest(String testName){
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        TestSuite suite = new TestSuite(SimpleJSONParserTest.class);
        //suite.addTestSuite(SimpleJSONNullTest.class.getSimpleName());
        return suite;
    }

    public void testSanity(){
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(-1);
        arr1.add(100);

        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(1);
        arr2.add(2);
        arr2.add(-1);
        arr2.add(100);

        assertEquals(arr1, arr2);
    }

    public void testParseNull(){
        String test_json = "null";
        try{
            SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
            assertEquals(json.getType(), "null");
            assertTrue(json.get() == null);
        }catch(ParseException e){
            System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
            e.printStackTrace();
            fail();
        }
    }

    public void testParseTrue(){
        String test_json = "true";
        try{
            SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
            assertEquals(json.getType(), "boolean");
            assertTrue(((Boolean)json.get()).booleanValue());
        }catch(ParseException e){
            System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
            e.printStackTrace();
            fail();
        }
    }

    public void testParseFalse(){
        String test_json = "false";
        try{
            SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
            assertEquals(json.getType(), "boolean");
            assertFalse(((Boolean)json.get()).booleanValue());
        }catch(ParseException e){
            System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
            e.printStackTrace();
            fail();
        }
    }

     public void testParseString(){
         String test_json = "\"abcdef\"";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
             assertEquals(json.getType(), "string");
             assertEquals(json.get().getClass().getSimpleName(), String.class.getSimpleName());
             assertEquals(json.getString(), "abcdef");
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseNumberInteger(){
         int value = 12345;
         String test_json = value + "";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
             assertEquals(json.getType(), "number");
             assertEquals(json.get().getClass().getSimpleName(), BigDecimal.class.getSimpleName());
             assertEquals(json.getByte(), (byte)value);
             assertEquals(json.getShort(), (short)value);
             assertEquals(json.getInt(), (int)value);
             assertEquals(json.getLong(), (long)value);
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseNumberLong(){
         long value = 1234567890L;
         String test_json = value + "";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
             assertEquals(json.getType(), "number");
             assertEquals(json.get().getClass().getSimpleName(), BigDecimal.class.getSimpleName());
             assertEquals(json.getByte(), (byte)value);
             assertEquals(json.getShort(), (short)value);
             assertEquals(json.getInt(), (int)value);
             assertEquals(json.getLong(), (long)value);
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseNumberIntegerNegative(){
         int value = -54321;
         String test_json = value + "";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
             assertEquals(json.getType(), "number");
             assertEquals(json.get().getClass().getSimpleName(), BigDecimal.class.getSimpleName());
             assertEquals(json.getByte(), (byte)value);
             assertEquals(json.getShort(), (short)value);
             assertEquals(json.getInt(), (int)value);
             assertEquals(json.getLong(), (long)value);
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseNumberLongNegative(){
         long value = -9876543210L;
         String test_json = value + "";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
             assertEquals(json.getType(), "number");
             assertEquals(json.get().getClass().getSimpleName(), BigDecimal.class.getSimpleName());
             assertEquals(json.getByte(), (byte)value);
             assertEquals(json.getShort(), (short)value);
             assertEquals(json.getInt(), (int)value);
             assertEquals(json.getLong(), (long)value);
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseNumberFloat(){
         float value = 123213.123123f;
         String test_json = value + "";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
             assertEquals(json.getType(), "number");
             assertEquals(json.get().getClass().getSimpleName(), BigDecimal.class.getSimpleName());
             assertEquals(json.getByte(), (byte)value);
             assertEquals(json.getShort(), (short)value);
             assertEquals(json.getInt(), (int)value);
             assertEquals(json.getLong(), (long)value);
             assertEquals(json.getFloat(), (float)value);
             assertEquals(json.getDouble(), (double)value);
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseNumberFloatNegative(){
         float value = -1232132423.123123f;
         String test_json = value + "";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
             assertEquals(json.getType(), "number");
             assertEquals(json.get().getClass().getSimpleName(), BigDecimal.class.getSimpleName());
             assertEquals(json.getByte(), (byte)value);
             assertEquals(json.getShort(), (short)value);
             assertEquals(json.getInt(), (int)value);
             assertEquals(json.getLong(), (long)value);
             assertEquals(json.getFloat(), (float)value);
             assertEquals(json.getDouble(), (double)value);
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseNumberDouble(){
         double value = 32423.123123f;
         String test_json = value + "";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
             assertEquals(json.getType(), "number");
             assertEquals(json.get().getClass().getSimpleName(), BigDecimal.class.getSimpleName());
             assertEquals(json.getByte(), (byte)value);
             assertEquals(json.getShort(), (short)value);
             assertEquals(json.getInt(), (int)value);
             assertEquals(json.getLong(), (long)value);
             assertEquals(json.getFloat(), (float)value);
             assertEquals(json.getDouble(), (double)value);
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseNumberDoubleNegative(){
         double value = -323.123123f;
         String test_json = value + "";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
             assertEquals(json.getType(), "number");
             assertEquals(json.get().getClass().getSimpleName(), BigDecimal.class.getSimpleName());
             assertEquals(json.getByte(), (byte)value);
             assertEquals(json.getShort(), (short)value);
             assertEquals(json.getInt(), (int)value);
             assertEquals(json.getLong(), (long)value);
             assertEquals(json.getFloat(), (float)value);
             assertEquals(json.getDouble(), (double)value);
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseNumberDoubleLarge(){
         double value = 12321324231232132423.123123f;
         String test_json = value + "";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
             assertEquals(json.getType(), "number");
             assertEquals(json.get().getClass().getSimpleName(), BigDecimal.class.getSimpleName());
             assertEquals(json.getFloat(), (float)value);
             assertEquals(json.getDouble(), (double)value);
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseNumberDoubleLargeNegative(){
         double value = 12321324231232132423.123123f;
         String test_json = value + "";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
             assertEquals(json.getType(), "number");
             assertEquals(json.get().getClass().getSimpleName(), BigDecimal.class.getSimpleName());
             assertEquals(json.getFloat(), (float)value);
             assertEquals(json.getDouble(), (double)value);
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseArrayNumbers(){
         float[] arr = {1.0f, 2.0f, -12321.0f, 2.112f, 124124214124.0f};
         String test_json = "[";
         for(int i = 0; i < arr.length; i++){
             if(i != 0) test_json += ",";
             test_json += arr[i] + "";
         }
         test_json += "]";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
             assertEquals(json.getType(), "array");
             assertEquals(json.get().getClass().getSimpleName(), ArrayList.class.getSimpleName());
             for(int i = 0; i < arr.length; i++){
                 assertEquals((float)arr[i], json.get(i).getFloat());
             }
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseArrayStrings(){
         String[] arr = {"abcd", "efef", "a", "\n", "something"};
         String test_json = "[";
         for(int i = 0; i < arr.length; i++){
             if(i != 0) test_json += ",";
             test_json += "\"" + arr[i] + "\"";
         }
         test_json += "]";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
             assertEquals(json.getType(), "array");
             assertEquals(json.get().getClass().getSimpleName(), ArrayList.class.getSimpleName());
             for(int i = 0; i < arr.length; i++){
                 assertEquals(arr[i], json.get(i).getStringOnly());
             }
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseArrayMixed(){ //TODO add Map
         SimpleJSON test_json = new SimpleJSON(new ArrayList<SimpleJSON>());
         test_json.add("abawawf");
         test_json.add(1);
         test_json.add(1.324234234f);
         test_json.add(true);
         test_json.add(new SimpleJSON());
         SimpleJSON map = new SimpleJSON();
         map.setEmptyMap();
         map.put("something", "else");
         map.put("num", 123123);
         map.put("bool", false);
         map.put("null", new SimpleJSON());
         SimpleJSON arr = new SimpleJSON();
         arr.setEmptyArray();
         map.put("arr", arr);
         //System.out.println("test: " + test_json);
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json.toJSON());
             //System.out.println("json: " + json);
             assertEquals(json.getType(), "array");
             assertEquals(json.get().getClass().getSimpleName(), ArrayList.class.getSimpleName());
             assertEquals(test_json.size(), json.size());
             for(int i = 0; i < json.size(); i++){
                 ////System.out.println("count: " + i);
                 assertEquals(test_json.get(i).getType(), json.get(i).getType());
                 if(test_json.get(i).get() != null && json.get(i).get() != null){
                     assertEquals(test_json.get(i).get().getClass().getSimpleName(), json.get(i).get().getClass().getSimpleName());
                 }
                 ////System.out.println(test_json.get(i).equals(json.get(i)));
                 assertTrue(test_json.get(i).equals(json.get(i)));
             }
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testParseMap(){ //TODO add Array
         try{
             SimpleJSON test_json = new SimpleJSON();
             test_json.setEmptyMap();
             test_json.put("key", "value");
             test_json.put("int", 121);
             test_json.put("float", 199213.21f);
             test_json.put("boolean", false);
             test_json.put("array", new SimpleJSON(new ArrayList<SimpleJSON>()));
             ////System.out.println("now adding");
             test_json.get("array").add(10);
             test_json.get("array").add("monkey");
             test_json.get("array").add(false);
             test_json.get("array").add(123.2123f);
             test_json.get("array").add(new SimpleJSON());
             test_json.put("null", new SimpleJSON());
             //System.out.println("test: " + test_json);
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json.toJSON());
             //System.out.println("json: " + json);
             assertEquals(json.getType(), "map");
             assertEquals(json.get().getClass().getSimpleName(), HashMap.class.getSimpleName());
             assertEquals(test_json.size(), json.size());
             for(Map.Entry<String, SimpleJSON> entry : test_json.entrySet()){
                 String key = entry.getKey();
                 SimpleJSON value = entry.getValue();
                 assertTrue(json.containsKey(key));
                 SimpleJSON other_value = json.get(key);
                 assertNotNull(other_value);
                 assertEquals(value.getType(), other_value.getType());
                 if(value.get() != null && other_value.get() != null){
                     assertEquals(value.get().getClass().getSimpleName(), other_value.get().getClass().getSimpleName());
                 }
                 //System.out.println(value.equals(other_value));
                 assertTrue(value.equals(other_value));
             }
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }catch(Exception e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }
     public void testFullParse1(){
         String test_json = "{\"string\":\"value\",\"array\":[1,2,3,4],\"null\":null,\"map\":{\"int\":1021,\"number\":123123.01223,\"negative_int\":-123219,\"negative_number\":-2131.231}}";
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json);
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }

     public void testFullParseAbuse(){
         SimpleJSON test_json = new SimpleJSON();
         test_json.setEmptyMap();
         test_json.put("string", "abcdef");
         test_json.put("number", 123);
         test_json.put("frac", 1231.12312);
         test_json.put("negnumber", -12312);
         test_json.put("negfrac", -123.113);
         test_json.put("boolean", true);
         test_json.put("null", new SimpleJSON());
         SimpleJSON arr = new SimpleJSON();
         arr.setEmptyArray();
         arr.add(test_json);
         arr.add("abdwfw");
         arr.add(2324);
         arr.add(false);
         arr.add(arr);
         test_json.put("array", arr);
         SimpleJSON something = new SimpleJSON();
         something.setEmptyMap();
         something.put("recursion", test_json);
         test_json.put("map", something);
         try{
             SimpleJSON json = SimpleJSONParser.fromJSON(test_json.toJSON());
         }catch(ParseException e){
             System.err.println("From " + Thread.currentThread().getStackTrace()[1].getMethodName());
             e.printStackTrace();
             fail();
         }
     }
}
