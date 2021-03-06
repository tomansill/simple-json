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
public class SimpleJSONBooleanTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SimpleJSONBooleanTest(String testName){
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite(SimpleJSONBooleanTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testType(){
        SimpleJSON json = new SimpleJSON(true);
        assertTrue(json.getTypeString().equals("boolean"));
    }

    public void testGet(){
        SimpleJSON json = new SimpleJSON(true);
        assertTrue(((Boolean)json.get()).booleanValue() == true);
    }

    public void testGetString(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            assertEquals(json.getString(), "true");
            assert true;
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testGetStringOnly(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.getStringOnly();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetBoolean(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            assertTrue(json.getBoolean() == true);
            assert true;
        }catch(InvalidTypeException e){
            assert false;
        }
    }

    public void testGetByte(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.getByte();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetShort(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.getShort();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetInt(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.getInt();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetLong(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.getLong();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetInteger(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.getInteger();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetFloat(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.getFloat();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetDouble(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.getDouble();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetDecimal(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.getDecimal();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testSetNull(){
        SimpleJSON json = new SimpleJSON(true);
        json.set();
        assertEquals(null, json.get());
    }

    public void testSetString(){
        SimpleJSON json = new SimpleJSON(true);
        json.set("hello");
        assertEquals("string", json.getTypeString());
        assertEquals("hello", json.get());
    }

    public void testSetBoolean(){
        SimpleJSON json = new SimpleJSON(true);
        json.set(true);
        assertEquals("boolean", json.getTypeString());
        assertEquals(true, json.get());
    }

    public void testSetByte(){
        SimpleJSON json = new SimpleJSON(true);
        json.set((byte)10);
        assertEquals("number", json.getTypeString());
        assertEquals((byte)10, json.getByte());
    }

    public void testSetShort(){
        SimpleJSON json = new SimpleJSON(true);
        json.set((short)10);
        assertEquals("number", json.getTypeString());
        assertEquals((short)10, json.getShort());
    }

    public void testSetInteger(){
        SimpleJSON json = new SimpleJSON(true);
        json.set(10);
        assertEquals("number", json.getTypeString());
        assertEquals(10, json.getInt());
    }

    public void testSetLong(){
        SimpleJSON json = new SimpleJSON(true);
        json.set(10L);
        assertEquals("number", json.getTypeString());
        assertEquals(10L, json.getLong());
    }

    public void testSetFloat(){
        SimpleJSON json = new SimpleJSON(true);
        json.set(10.0f);
        assertEquals("number", json.getTypeString());
        assertEquals(10.0f, json.getFloat());
    }

    public void testSetDouble(){
        SimpleJSON json = new SimpleJSON(true);
        json.set(10.0);
        assertEquals("number", json.getTypeString());
        assertEquals(10.0, json.getDouble());
    }

    public void testSetBigInteger(){
        SimpleJSON json = new SimpleJSON(true);
        json.set(new BigInteger("10"));
        assertEquals("number", json.getTypeString());
        assertEquals("10", json.getString());
    }

    public void testSetBigDecimal(){
        SimpleJSON json = new SimpleJSON(true);
        json.set(new BigDecimal("10"));
        assertEquals("number", json.getTypeString());
        assertEquals("10", json.getString());
    }

    public void testSetMapSinglePair(){
        SimpleJSON json = new SimpleJSON(true);
        json.set("key", new SimpleJSON("value"));
        assertEquals("map", json.getTypeString());
        assertEquals("value", json.get("key").getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetMapDirect(){
        SimpleJSON json = new SimpleJSON(true);
        HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
        map.put("key", new SimpleJSON("value"));
        json.set(map);
        assertEquals("map", json.getTypeString());
        assertEquals("value", json.get("key").getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetArray(){
        SimpleJSON json = new SimpleJSON(true);
        ArrayList<SimpleJSON> array = new ArrayList<SimpleJSON>();
        array.add(new SimpleJSON("value"));
        json.set(array);
        assertEquals("array", json.getTypeString());
        assertEquals("value", json.get(0).getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetEmptyMap(){
        SimpleJSON json = new SimpleJSON(true);
        json.setEmptyMap();
        assertEquals("map", json.getTypeString());
        assertEquals(0, json.size());
    }

    public void testSetEmptyArray(){
        SimpleJSON json = new SimpleJSON(true);
        json.setEmptyArray();
        assertEquals("array", json.getTypeString());
        assertEquals(0, json.size());
    }

    public void testPut(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.put("abcdef", new SimpleJSON());
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testPutAllSimpleJSON(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.putAll(new SimpleJSON());
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testPutAllMap(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
            map.put("something", json);
            json.putAll(map);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testClear(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.clear();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testRemoveKey(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.remove("abcdef");
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testRemoveIndex(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.remove(0);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testRemoveAll(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("sef"));
            json.removeAll(lst);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testRetainAll(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("sef"));
            json.retainAll(lst);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAdd(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.add(new SimpleJSON());
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddAll(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("aewfw"));
            lst.add(new SimpleJSON("something"));
            json.addAll(lst);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testContains(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.contains(new SimpleJSON("abcdef"));
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testContainsAll(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("aewfw"));
            lst.add(new SimpleJSON("something"));
            json.containsAll(lst);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testContainsKey(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.containsKey("abcdef");
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testContainsValue(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.containsKey("abcdef");
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void isEmpty(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.isEmpty();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetMap(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.get("abcdef");
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetArray(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.get(0);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddJSON(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.add(new SimpleJSON());
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddBoolean(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.add(true);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddByte(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.add((byte)10);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddShort(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.add((short)10);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddInteger(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.add(10);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddLong(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.add(10L);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddFloat(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.add(10.0f);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddDouble(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.add(10.0);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddString(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.add("abcdef");
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddBigInteger(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.add(new BigInteger("10"));
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddBigDecimal(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.add(new BigDecimal("10"));
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddCollection(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            ArrayList<SimpleJSON> list = new ArrayList<SimpleJSON>();
            list.add(new SimpleJSON());
            json.add(list);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddMap(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
            map.put("key", new SimpleJSON());
            json.add(map);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddAllCollection(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            ArrayList<SimpleJSON> list = new ArrayList<SimpleJSON>();
            list.add(new SimpleJSON());
            json.addAll(list);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testIsEmpty(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.isEmpty();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testKeySet(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.keySet();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testValues(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.values();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testEntrySet(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.entrySet();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testToArray(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.toArray();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testToArrayWithArray(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            SimpleJSON[] arr = new SimpleJSON[1];
            json.toArray(arr);
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testSize(){
        SimpleJSON json = new SimpleJSON(true);
        try{
            json.size();
            assert false;
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testIterator(){
        SimpleJSON json = new SimpleJSON(true);
        json.iterator();
    }

    public void testHashCode(){
        SimpleJSON json = new SimpleJSON(true);
        assertTrue(json.hashCode() == new SimpleJSON(true).hashCode());
    }

    public void testEquals(){
        SimpleJSON json = new SimpleJSON(true);
        SimpleJSON json1 = new SimpleJSON(true);
        SimpleJSON json2 = new SimpleJSON(false);
        SimpleJSON json_str = new SimpleJSON("abdef");
        assertTrue(json.equals(json));
        assertTrue(json.equals(json1));
        assertFalse(json.equals(json2));
        assertFalse(json.equals(json_str));
    }

    public void testToJSON(){
        SimpleJSON json = new SimpleJSON(true);
        String out = json.toJSON();
        assertTrue(out.equals("true"));
    }

    public void testParse(){
        SimpleJSON json = null;
        try{
            json = SimpleJSON.fromJSON("true");
        }catch(ParseException e){
            assert false;
        }
        assertTrue(json.getTypeString().equals("boolean"));
        assertTrue(json.getBoolean() == true);
    }
}
