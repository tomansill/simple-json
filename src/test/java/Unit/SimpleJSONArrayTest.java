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
        assertTrue(json.get() == null);
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
        json.add(1201)
        try{
            assertEquals(2, json.size())
            json.clear();
            assertEquals(0, json.size())
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
        json.add(1201)
        try{
            assertEquals(2, json.size())
            json.remove(0);
            assertEquals(1, json.size())
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
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("aewfw"));
            lst.add(new SimpleJSON("something"));
            json.addAll(lst);
            fail(); //TODO
        }catch(InvalidTypeException e){
            fail(e.getMessage());
        }
    }

    public void testContains(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.contains(new SimpleJSON("abcdef"));
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testContainsAll(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("aewfw"));
            lst.add(new SimpleJSON("something"));
            json.containsAll(lst);
            fail();
        }catch(InvalidTypeException e){}
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

    public void isEmpty(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.isEmpty();
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
            json.get(0);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddJSON(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(new SimpleJSON());
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddBoolean(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(true);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddByte(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add((byte)10);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddShort(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add((short)10);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddInteger(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(10);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddLong(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(10L);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddFloat(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(10.0f);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddDouble(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(10.0);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddString(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add("abcdef");
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddBigInteger(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(new BigInteger("10"));
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddBigDecimal(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.add(new BigDecimal("10"));
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddCollection(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            ArrayList<SimpleJSON> list = new ArrayList<SimpleJSON>();
            list.add(new SimpleJSON());
            json.add(list);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddMap(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
            map.put("key", new SimpleJSON());
            json.add(map);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testAddAllCollection(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            ArrayList<SimpleJSON> list = new ArrayList<SimpleJSON>();
            list.add(new SimpleJSON());
            json.addAll(list);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testIsEmpty(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.isEmpty();
            fail();
        }catch(InvalidTypeException e){}
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
        try{
            json.toArray();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testToArrayWithArray(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            SimpleJSON[] arr = new SimpleJSON[1];
            json.toArray(arr);
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testSize(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        try{
            json.size();
            fail();
        }catch(InvalidTypeException e){}
    }

    public void testIterator(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        json.iterator();
    }

    public void testHashCode(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        assertTrue(json.hashCode() == 0);
    }

    public void testEquals(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        SimpleJSON json1 = new SimpleJSON();
        SimpleJSON json_str = new SimpleJSON("abdef");
        assertTrue(json.equals(json));
        assertTrue(json.equals(json1));
        assertFalse(json.equals(json_str));
    }

    public void testToJSON(){
        SimpleJSON json = new SimpleJSON(new ArrayList<SimpleJSON>());
        String out = json.toJSON();
        assertTrue(out.equals("null"));
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
