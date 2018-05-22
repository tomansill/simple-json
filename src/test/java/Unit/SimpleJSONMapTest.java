import java.text.ParseException;
import java.util.LinkedList;
import java.util.HashMap;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.simplejson.*;
import com.simplejson.parser.*;

import java.math.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class SimpleJSONMapTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SimpleJSONMapTest(String testName){
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite(SimpleJSONMapTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testType(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        assertTrue(json.getType().equals("map"));
    }

    public void testGet(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        assertTrue(json.get() instanceof HashMap);
    }

    public void testGetString(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertEquals(json.getString(), "null");
            fail();
        }catch(InvalidTypeException e){
        }
    }

    public void testGetStringOnly(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.getStringOnly();
            fail();
        }catch(InvalidTypeException e){
        }
    }

    public void testGetBoolean(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.getBoolean();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetByte(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.getByte();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetShort(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.getShort();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetInt(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.getInt();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetLong(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.getLong();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetInteger(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.getInteger();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetFloat(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.getFloat();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetDouble(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.getDouble();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetDecimal(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.getDecimal();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testSetNull(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.set();
        assertEquals(null, json.get());
    }

    public void testSetString(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.set("hello");
        assertEquals("string", json.getType());
        assertEquals("hello", json.get());
    }

    public void testSetBoolean(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.set(true);
        assertEquals("boolean", json.getType());
        assertEquals(true, json.get());
    }

    public void testSetByte(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.set((byte)10);
        assertEquals("number", json.getType());
        assertEquals((byte)10, json.getByte());
    }

    public void testSetShort(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.set((short)10);
        assertEquals("number", json.getType());
        assertEquals((short)10, json.getShort());
    }

    public void testSetInteger(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.set(10);
        assertEquals("number", json.getType());
        assertEquals(10, json.getInt());
    }

    public void testSetLong(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.set(10L);
        assertEquals("number", json.getType());
        assertEquals(10L, json.getLong());
    }

    public void testSetFloat(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.set(10.0f);
        assertEquals("number", json.getType());
        assertEquals(10.0f, json.getFloat());
    }

    public void testSetDouble(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.set(10.0);
        assertEquals("number", json.getType());
        assertEquals(10.0, json.getDouble());
    }

    public void testSetBigInteger(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.set(new BigInteger("10"));
        assertEquals("number", json.getType());
        assertEquals("10", json.getString());
    }

    public void testSetBigDecimal(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.set(new BigDecimal("10"));
        assertEquals("number", json.getType());
        assertEquals("10", json.getString());
    }

    public void testSetMapSinglePair(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.set("key", new SimpleJSON("value"));
        assertEquals("map", json.getType());
        assertEquals("value", json.get("key").getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetMapDirect(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
        map.put("key", new SimpleJSON("value"));
        json.set(map);
        assertEquals("map", json.getType());
        assertEquals("value", json.get("key").getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetArray(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        ArrayList<SimpleJSON> array = new ArrayList<SimpleJSON>();
        array.add(new SimpleJSON("value"));
        json.set(array);
        assertEquals("array", json.getType());
        assertEquals("value", json.get(0).getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetEmptyMap(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.setEmptyMap();
        assertEquals("map", json.getType());
        assertEquals(0, json.size());
    }

    public void testSetEmptyArray(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.setEmptyArray();
        assertEquals("array", json.getType());
        assertEquals(0, json.size());
    }

    public void testPutWithNull(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertEquals(null, json.get("abcdef"));
            json.put("abcdef", new SimpleJSON());
            assertTrue(json.get("abcdef").get() == null);
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testPutWithString(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertEquals(null, json.get("abcdef"));
            json.put("abcdef", new SimpleJSON("string"));
            assertEquals("string", json.get("abcdef").getStringOnly());
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testPutWithByte(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertEquals(null, json.get("abcdef"));
            json.put("abcdef", new SimpleJSON((byte)1));
            assertEquals((byte)1, json.get("abcdef").getByte());
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testPutWithShort(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertEquals(null, json.get("abcdef"));
            json.put("abcdef", new SimpleJSON((short)600));
            assertEquals((short)600, json.get("abcdef").getShort());
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testPutWithInt(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertEquals(null, json.get("abcdef"));
            json.put("abcdef", new SimpleJSON((int)1213213));
            assertEquals((int)1213213, json.get("abcdef").getInt());
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testPutWithLong(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertEquals(null, json.get("abcdef"));
            json.put("abcdef", new SimpleJSON(696969696696L));
            assertEquals(696969696696L, json.get("abcdef").getLong());
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testPutWithFloat(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertEquals(null, json.get("abcdef"));
            json.put("abcdef", new SimpleJSON(200.22f));
            assertEquals(200.22f, json.get("abcdef").getFloat());
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testPutWithDouble(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertEquals(null, json.get("abcdef"));
            json.put("abcdef", new SimpleJSON(2200.22));
            assertEquals(2200.22, json.get("abcdef").getDouble());
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testPutWithBigInteger(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertEquals(null, json.get("abcdef"));
            json.put("abcdef", new SimpleJSON(new BigInteger("10")));
            assertEquals(new BigInteger("10"), json.get("abcdef").getInteger());
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testPutWithBigDecimal(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertEquals(null, json.get("abcdef"));
            json.put("abcdef", new SimpleJSON(new BigDecimal("10")));
            assertEquals(new BigDecimal("10"), json.get("abcdef").getDecimal());
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testPutWithBoolean(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertEquals(null, json.get("abcdef"));
            json.put("abcdef", new SimpleJSON(true));
            assertEquals(true, json.get("abcdef").getBoolean());
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testPutAllSimpleJSON(){
        SimpleJSON json1 = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json1.put("abc", 10);
        SimpleJSON json2 = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json2.put("def", "happy");
        try{
            json1.putAll(json2);
            assertEquals(json1.get("abc").getInt(), 10);
            assertEquals(json1.get("def").getStringOnly(), "happy");
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testPutAllMap(){
        SimpleJSON json1 = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json1.put("abc", 10);
        HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
        map.put("def", new SimpleJSON("happy"));
        try{
            json1.putAll(map);
            assertEquals(json1.get("abc").getInt(), 10);
            assertEquals(json1.get("def").getStringOnly(), "happy");
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testClear(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.put("abc", 10);
        json.put("def", "happy");
        try{
            assertEquals(2, json.size());
            json.clear();
            assertEquals(0, json.size());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testRemoveKey(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.put("abc", 10);
        json.put("def", "something");
        try{
            assertEquals(2 , json.size());
            assertEquals(10, json.remove("abc").getInt());
            assertEquals(1 , json.size());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testRemoveIndex(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.put("1", 10);
        json.put("2", "something");
        try{
            assertEquals(2 , json.size());
            assertEquals(10, json.remove(1).getInt());
            assertEquals(1 , json.size());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testRemoveAll(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("sef"));
            json.removeAll(lst);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testRetainAll(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("sef"));
            json.retainAll(lst);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAdd(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.add(new SimpleJSON());
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddAll(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("aewfw"));
            lst.add(new SimpleJSON("something"));
            json.addAll(lst);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testContains(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.contains(new SimpleJSON("abcdef"));
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testContainsAll(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("aewfw"));
            lst.add(new SimpleJSON("something"));
            json.containsAll(lst);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testContainsKey(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.put("abcdef", 10);
        try{
            assertTrue(json.containsKey("abcdef"));
            assertFalse(json.containsKey("sfewf"));
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testContainsValue(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.put("abcdef", 10);
        try{
            assertTrue(json.containsValue(new SimpleJSON(10)));
            assertFalse(json.containsValue(new SimpleJSON(99)));
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testIsEmpty(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertTrue(json.isEmpty());
            json.put("abcdef", 10);
            assertFalse(json.isEmpty());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testGetMap(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.put("abcdef", 10);
        try{
            assertEquals(json.get("abcdef").getInt(), 10);
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testGetArray(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        json.put("10", 10);
        try{
            assertEquals(json.get(10).getInt(), 10);
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddJSON(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.add(new SimpleJSON());
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddBoolean(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.add(true);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddByte(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.add((byte)10);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddShort(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.add((short)10);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddInteger(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.add(10);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddLong(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.add(10L);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddFloat(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.add(10.0f);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddDouble(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.add(10.0);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddString(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.add("abcdef");
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddBigInteger(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.add(new BigInteger("10"));
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddBigDecimal(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.add(new BigDecimal("10"));
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddCollection(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            ArrayList<SimpleJSON> list = new ArrayList<SimpleJSON>();
            list.add(new SimpleJSON());
            json.add(list);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddMap(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
            map.put("key", new SimpleJSON());
            json.add(map);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddAllCollection(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            ArrayList<SimpleJSON> list = new ArrayList<SimpleJSON>();
            list.add(new SimpleJSON());
            json.addAll(list);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testKeySet(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertFalse(json.keySet() == null);
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testValues(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertFalse(json.values() == null);
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testEntrySet(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertFalse(json.entrySet() == null);
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testToArray(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            json.toArray();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testToArrayWithArray(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            SimpleJSON[] arr = new SimpleJSON[1];
            json.toArray(arr);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testSize(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertEquals(0, json.size());
            json.put("something", "else");
            assertEquals(1, json.size());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testIterator(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        try{
            assertFalse(json.iterator() == null);
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testHashCode(){
        SimpleJSON json1 = new SimpleJSON(new HashMap<String,SimpleJSON>());
        SimpleJSON json2 = new SimpleJSON(new HashMap<String,SimpleJSON>());
        assertEquals(json1.hashCode(), json2.hashCode());
    }

    public void testEquals(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        SimpleJSON json1 = new SimpleJSON(new HashMap<String,SimpleJSON>());
        SimpleJSON json_str = new SimpleJSON("abdef");
        assertTrue(json.equals(json));
        assertTrue(json.equals(json1));
        assertFalse(json.equals(json_str));
    }

    public void testToJSON(){
        SimpleJSON json = new SimpleJSON(new HashMap<String,SimpleJSON>());
        String out = json.toJSON();
        assertEquals("{}", out);
        json.put("string", "value");
        out = json.toJSON();
        assertEquals("{\"string\":\"value\"}", out);
        json.clear();
        json.put("number", 100);
        out = json.toJSON();
        assertEquals("{\"number\":100}", out);
        json.clear();
        json.put("boolean", true);
        out = json.toJSON();
        assertEquals("{\"boolean\":true}", out);
        json.clear();
        json.put("array", new SimpleJSON(new ArrayList<SimpleJSON>()));
        out = json.toJSON();
        assertEquals("{\"array\":[]}", out);
        json.clear();
        json.put("null", new SimpleJSON());
        out = json.toJSON();
        assertEquals("{\"null\":null}", out);
    }

    public void testParse(){
        SimpleJSON json = null;
        try{
            json = SimpleJSON.fromJSON("{\"key\":\"value\"}");
        }catch(ParseException e){
            fail();
        }
        assertEquals("map", json.getType());
        assertEquals("value", json.get("key").getStringOnly());
    }
}
