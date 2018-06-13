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
public class SimpleJSONArrayTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SimpleJSONArrayTest(String testName){
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite(SimpleJSONArrayTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testType(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        assertTrue(json.getType().equals("array"));
    }

    public void testGet(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        assertTrue(json.get() instanceof ArrayList);
    }

    public void testGetString(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.getString();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetStringOnly(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.getStringOnly();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetBoolean(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.getBoolean();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetByte(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.getByte();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetShort(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.getShort();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetInt(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.getInt();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetLong(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.getLong();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetInteger(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.getInteger();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetFloat(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.getFloat();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetDouble(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.getDouble();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetDecimal(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.getDecimal();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testSetNull(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.set();
        assertEquals(null, json.get());
    }

    public void testSetString(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.set("hello");
        assertEquals("string", json.getType());
        assertEquals("hello", json.get());
    }

    public void testSetBoolean(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.set(true);
        assertEquals("boolean", json.getType());
        assertEquals(true, json.get());
    }

    public void testSetByte(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.set((byte)10);
        assertEquals("number", json.getType());
        assertEquals((byte)10, json.getByte());
    }

    public void testSetShort(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.set((short)10);
        assertEquals("number", json.getType());
        assertEquals((short)10, json.getShort());
    }

    public void testSetInteger(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.set(10);
        assertEquals("number", json.getType());
        assertEquals(10, json.getInt());
    }

    public void testSetLong(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.set(10L);
        assertEquals("number", json.getType());
        assertEquals(10L, json.getLong());
    }

    public void testSetFloat(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.set(10.0f);
        assertEquals("number", json.getType());
        assertEquals(10.0f, json.getFloat());
    }

    public void testSetDouble(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.set(10.0);
        assertEquals("number", json.getType());
        assertEquals(10.0, json.getDouble());
    }

    public void testSetBigInteger(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.set(new BigInteger("10"));
        assertEquals("number", json.getType());
        assertEquals("10", json.getString());
    }

    public void testSetBigDecimal(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.set(new BigDecimal("10"));
        assertEquals("number", json.getType());
        assertEquals("10", json.getString());
    }

    public void testSetMapSinglePair(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.set("key", new SimpleJSON("value"));
        assertEquals("map", json.getType());
        assertEquals("value", json.get("key").getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetMapDirect(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
        map.put("key", new SimpleJSON("value"));
        json.set(map);
        assertEquals("map", json.getType());
        assertEquals("value", json.get("key").getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetArray(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        ArrayList<SimpleJSON> array = new ArrayList<SimpleJSON>();
        array.add(new SimpleJSON("value"));
        json.set(array);
        assertEquals("array", json.getType());
        assertEquals("value", json.get(0).getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetEmptyMap(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.setEmptyMap();
        assertEquals("map", json.getType());
        assertEquals(0, json.size());
    }

    public void testSetEmptyArray(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.setEmptyArray();
        assertEquals("array", json.getType());
        assertEquals(0, json.size());
    }

    public void testPut(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.put("abcdef", new SimpleJSON());
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testPutAllSimpleJSON(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.putAll(new SimpleJSON());
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testPutAllMap(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
            map.put("something", json);
            json.putAll(map);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testClear(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.add("something");
        json.add(1201);
        try{
            assertEquals(2, json.size());
            json.clear();
            assertEquals(0, json.size());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testRemoveKey(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.remove("abcdef");
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testRemoveIndex(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.add("something");
        json.add(1201);
        try{
            assertEquals(2, json.size());
            json.remove(0);
            assertEquals(1, json.size());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testRemoveAll(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.add("sef");
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("sef"));
            assertEquals(1, json.size());
            json.removeAll(lst);
            assertEquals(0, json.size());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testRetainAll(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.add("abc");
        json.add("sef");
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("sef"));
            assertEquals(2, json.size());
            json.retainAll(lst);
            assertEquals("sef", json.get(0).getStringOnly());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAdd(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(new SimpleJSON());
            assertEquals(json.get(0).get(), null);
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddAll(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(new SimpleJSON("first"));
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("aewfw"));
            lst.add(new SimpleJSON("something"));
            json.addAll(lst);
            assertEquals("first", json.remove(0).getStringOnly());
            assertEquals("aewfw", json.remove(0).getStringOnly());
            assertEquals("something", json.remove(0).getStringOnly());
            assertEquals(0, json.size());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testContains(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(new SimpleJSON("abcdef"));
            json.contains(new SimpleJSON("abcdef"));
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testContainsAll(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            json.add(new SimpleJSON("aewfw"));
            json.add(new SimpleJSON("something"));
            lst.add(new SimpleJSON("aewfw"));
            lst.add(new SimpleJSON("something"));
            assertTrue(json.containsAll(lst));
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testContainsKey(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.containsKey("abcdef");
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testContainsValue(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.containsKey("abcdef");
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetMap(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.get("abcdef");
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testGetArray(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add("abcdef");
            assertEquals("abcdef", json.get(0).getStringOnly());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddJSON(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(new SimpleJSON());
            assertEquals(null, json.get(0).get());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddBoolean(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(true);
            assertEquals(true, json.get(0).getBoolean());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddByte(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add((byte)10);
            assertEquals((byte)10, json.get(0).getByte());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddShort(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add((short)1021);
            assertEquals((short)1021, json.get(0).getShort());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddInteger(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(12132130);
            assertEquals(12132130, json.get(0).getInt());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddLong(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(1213123123210L);
            assertEquals(1213123123210L, json.get(0).getLong());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddFloat(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(10.1f);
            assertEquals(10.1f, json.get(0).getFloat());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddDouble(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(10.2);
            assertEquals(10.2, json.get(0).getDouble());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddString(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add("abcdef");
            assertEquals("abcdef", json.get(0).getStringOnly());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddBigInteger(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(new BigInteger("10"));
            assertEquals(new BigInteger("10"), json.get(0).getInteger());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddBigDecimal(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(new BigDecimal("10"));
            assertEquals(new BigDecimal("10"), json.get(0).getDecimal());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddCollection(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            ArrayList<SimpleJSON> list = new ArrayList<SimpleJSON>();
            list.add(new SimpleJSON());
            json.add(list);
            assertTrue(json.get(0).get() instanceof ArrayList);
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddMap(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
            map.put("key", new SimpleJSON());
            json.add(map);
            assertTrue(json.get(0).get() instanceof HashMap);
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testAddAllCollection(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            ArrayList<SimpleJSON> list = new ArrayList<SimpleJSON>();
            list.add(new SimpleJSON(1));
            list.add(new SimpleJSON(2));
            json.addAll(list);
            assertEquals(1, json.get(0).getInt());
            assertEquals(2, json.get(1).getInt());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testIsEmpty(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            assertTrue(json.isEmpty());
            json.add("something");
            assertFalse(json.isEmpty());
            json.remove(0);
            assertTrue(json.isEmpty());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testKeySet(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.keySet();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testValues(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.values();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testEntrySet(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.entrySet();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testToArray(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.add("new");
        try{
            Object[] obj = json.toArray();
            SimpleJSON ex = (SimpleJSON) obj[0];
            assertEquals("new", ex.getStringOnly());
        }catch(Exception e){
            fail(e.getMessage());
        }
    }

    public void testToArrayWithArray(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.add("something");
        try{
            SimpleJSON[] arr = json.toArray(new SimpleJSON[1]);
            assertEquals("something", arr[0].getStringOnly());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testSize(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            assertEquals(0, json.size());
            json.add("something");
            assertEquals(1, json.size());
            json.remove(0);
            assertEquals(0, json.size());
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testIterator(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.iterator();
    }

    public void testHashCode(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.add(1);
        SimpleJSON json1 = new SimpleJSON(new ArrayList<SimpleJSON>());
        json1.add(1);
        assertTrue(json.hashCode() == json1.hashCode());
    }

    public void testEquals(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.add("abcdef");
        SimpleJSON json1 = new SimpleJSON();
        json1.setEmptyArray();
        json1.add("abcdef");
        SimpleJSON json_str = new SimpleJSON("abdef");
        assertTrue(json.equals(json));
        assertTrue(json.equals(json1));
        assertFalse(json.equals(json_str));
    }

    public void testToJSON(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        String out = json.toJSON();
        assertTrue(out.equals("[]"));
        json.add("something");
        json.add("else");
        out = json.toJSON();
        assertTrue(out.equals("[\"something\",\"else\"]"));
    }

    public void testParse(){
        SimpleJSON json = null;
        try{
            json = SimpleJSON.fromJSON("null");
        }catch(ParseException e){
            fail();
        }
        assertTrue(json.getType().equals("null"));
        assertTrue(json.get() == null);
    }
}
