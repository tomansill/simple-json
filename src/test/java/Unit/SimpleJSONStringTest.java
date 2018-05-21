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
public class SimpleJSONStringTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SimpleJSONStringTest(String testName){
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite(SimpleJSONStringTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testType(){
        SimpleJSON json = new SimpleJSON("something");
        assertTrue(json.getType().equals("string"));
    }

    public void testGet(){
        SimpleJSON json = new SimpleJSON("something");
        assertEquals(((String)json.get()), "something");
    }

    public void testGetString(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            assertEquals(json.getString(), "something");
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testGetStringOnly(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            assertEquals(json.getStringOnly(), "something");
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testGetBoolean(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.getBoolean();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetByte(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.getByte();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetShort(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.getShort();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetInt(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.getInt();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetLong(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.getLong();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetInteger(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.getInteger();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetFloat(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.getFloat();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetDouble(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.getDouble();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetDecimal(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.getDecimal();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testSetNull(){
        SimpleJSON json = new SimpleJSON("something");
        json.set();
        assertEquals(null, json.get());
    }

    public void testSetString(){
        SimpleJSON json = new SimpleJSON("something");
        json.set("hello");
        assertEquals("string", json.getType());
        assertEquals("hello", json.get());
    }

    public void testSetBoolean(){
        SimpleJSON json = new SimpleJSON("something");
        json.set(true);
        assertEquals("boolean", json.getType());
        assertEquals(true, json.get());
    }

    public void testSetByte(){
        SimpleJSON json = new SimpleJSON("something");
        json.set((byte)10);
        assertEquals("number", json.getType());
        assertEquals((byte)10, json.getByte());
    }

    public void testSetShort(){
        SimpleJSON json = new SimpleJSON("something");
        json.set((short)10);
        assertEquals("number", json.getType());
        assertEquals((short)10, json.getShort());
    }

    public void testSetInteger(){
        SimpleJSON json = new SimpleJSON("something");
        json.set(10);
        assertEquals("number", json.getType());
        assertEquals(10, json.getInt());
    }

    public void testSetLong(){
        SimpleJSON json = new SimpleJSON("something");
        json.set(10L);
        assertEquals("number", json.getType());
        assertEquals(10L, json.getLong());
    }

    public void testSetFloat(){
        SimpleJSON json = new SimpleJSON("something");
        json.set(10.0f);
        assertEquals("number", json.getType());
        assertEquals(10.0f, json.getFloat());
    }

    public void testSetDouble(){
        SimpleJSON json = new SimpleJSON("something");
        json.set(10.0);
        assertEquals("number", json.getType());
        assertEquals(10.0, json.getDouble());
    }

    public void testSetBigInteger(){
        SimpleJSON json = new SimpleJSON("something");
        json.set(new BigInteger("10"));
        assertEquals("number", json.getType());
        assertEquals("10", json.getString());
    }

    public void testSetBigDecimal(){
        SimpleJSON json = new SimpleJSON("something");
        json.set(new BigDecimal("10"));
        assertEquals("number", json.getType());
        assertEquals("10", json.getString());
    }

    public void testSetMapSinglePair(){
        SimpleJSON json = new SimpleJSON("something");
        json.set("key", new SimpleJSON("value"));
        assertEquals("map", json.getType());
        assertEquals("value", json.get("key").getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetMapDirect(){
        SimpleJSON json = new SimpleJSON("something");
        HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
        map.put("key", new SimpleJSON("value"));
        json.set(map);
        assertEquals("map", json.getType());
        assertEquals("value", json.get("key").getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetArray(){
        SimpleJSON json = new SimpleJSON("something");
        ArrayList<SimpleJSON> array = new ArrayList<SimpleJSON>();
        array.add(new SimpleJSON("value"));
        json.set(array);
        assertEquals("array", json.getType());
        assertEquals("value", json.get(0).getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetEmptyMap(){
        SimpleJSON json = new SimpleJSON("something");
        json.setEmptyMap();
        assertEquals("map", json.getType());
        assertEquals(0, json.size());
    }

    public void testSetEmptyArray(){
        SimpleJSON json = new SimpleJSON("something");
        json.setEmptyArray();
        assertEquals("array", json.getType());
        assertEquals(0, json.size());
    }

    public void testPut(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.put("abcdef", new SimpleJSON());
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testPutAllSimpleJSON(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.putAll(new SimpleJSON());
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testPutAllMap(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
            map.put("something", json);
            json.putAll(map);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testClear(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.clear();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testRemoveKey(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.remove("abcdef");
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testRemoveIndex(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.remove(0);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testRemoveAll(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("sef"));
            json.removeAll(lst);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testRetainAll(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("sef"));
            json.retainAll(lst);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAdd(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.add(new SimpleJSON());
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddAll(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("aewfw"));
            lst.add(new SimpleJSON("something"));
            json.addAll(lst);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testContains(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.contains(new SimpleJSON("abcdef"));
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testContainsAll(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("aewfw"));
            lst.add(new SimpleJSON("something"));
            json.containsAll(lst);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testContainsKey(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.containsKey("abcdef");
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testContainsValue(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.containsKey("abcdef");
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void isEmpty(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.isEmpty();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetMap(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.get("abcdef");
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetArray(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.get(0);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddJSON(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.add(new SimpleJSON());
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddBoolean(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.add(true);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddByte(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.add((byte)10);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddShort(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.add((short)10);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddInteger(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.add(10);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddLong(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.add(10L);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddFloat(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.add(10.0f);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddDouble(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.add(10.0);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddString(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.add("abcdef");
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddBigInteger(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.add(new BigInteger("10"));
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddBigDecimal(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.add(new BigDecimal("10"));
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddCollection(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            ArrayList<SimpleJSON> list = new ArrayList<SimpleJSON>();
            list.add(new SimpleJSON());
            json.add(list);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddMap(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
            map.put("key", new SimpleJSON());
            json.add(map);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddAllCollection(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            ArrayList<SimpleJSON> list = new ArrayList<SimpleJSON>();
            list.add(new SimpleJSON());
            json.addAll(list);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testIsEmpty(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.isEmpty();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testKeySet(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.keySet();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testValues(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.values();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testEntrySet(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.entrySet();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testToArray(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.toArray();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testToArrayWithArray(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            SimpleJSON[] arr = new SimpleJSON[1];
            json.toArray(arr);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testSize(){
        SimpleJSON json = new SimpleJSON("something");
        try{
            json.size();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testIterator(){
        SimpleJSON json = new SimpleJSON("something");
        json.iterator();
    }

    public void testHashCode(){
        SimpleJSON json = new SimpleJSON("something");
        assertTrue(json.hashCode() == new SimpleJSON("something").hashCode());
    }

    public void testEquals(){
        SimpleJSON json = new SimpleJSON("something");
        SimpleJSON json1 = new SimpleJSON("something");
        SimpleJSON json2 = new SimpleJSON("else");
        SimpleJSON json_str = new SimpleJSON(123);
        assertTrue(json.equals(json));
        assertTrue(json.equals(json1));
        assertFalse(json.equals(json2));
        assertFalse(json.equals(json_str));
    }

    public void testToJSON(){
        SimpleJSON json = new SimpleJSON("something");
        String out = json.toJSON();
        assertTrue(out.equals("\"something\""));
    }

    public void testParse(){
        SimpleJSON json = null;
        try{
            json = SimpleJSON.fromJSON("\"something\"");
        }catch(ParseException e){
            e.printStackTrace();
            fail();
        }
        assertTrue(json.getType().equals("string"));
        assertEquals(json.getStringOnly(), "something");
    }
}
