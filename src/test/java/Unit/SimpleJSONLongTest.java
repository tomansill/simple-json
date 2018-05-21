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
public class SimpleJSONLongTest extends TestCase{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SimpleJSONLongTest(String testName){
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite(SimpleJSONLongTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testType(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        assertTrue(json.getType().equals("number"));
    }

    public void testGet(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        assertTrue(((BigDecimal)json.get()).longValue() == 6786786676866L);
    }

    public void testGetString(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            assertEquals(json.getString(), "6786786676866");
        }catch(InvalidTypeException e){
            fail();
        }
    }

    public void testGetStringOnly(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.getStringOnly();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetBoolean(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            assertEquals(10, json.getBoolean());
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetByte(){
        long test_value = Long.MAX_VALUE;
        int incrementer = 2;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals((byte)test_value, json.getByte());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);

        test_value = Long.MIN_VALUE;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals((byte)test_value, json.getByte());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);
    }

    public void testGetShort(){
        long test_value = Long.MAX_VALUE;
        int incrementer = 2;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals((short)test_value, json.getShort());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);

        test_value = Long.MIN_VALUE;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals((short)test_value, json.getShort());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);
    }

    public void testGetInt(){
        long test_value = Long.MAX_VALUE;
        int incrementer = 2;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals((int)test_value, json.getInt());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);

        test_value = Long.MIN_VALUE;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals((int)test_value, json.getInt());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);
    }

    public void testGetLong(){
        long test_value = Long.MAX_VALUE;
        int incrementer = 2;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals((long)test_value, json.getLong());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);

        test_value = Long.MIN_VALUE;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals((long)test_value, json.getLong());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);
    }

    public void testGetInteger(){
        long test_value = Long.MAX_VALUE;
        int incrementer = 2;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals(new BigInteger(test_value + ""), json.getInteger());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);
        test_value = Long.MIN_VALUE;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals(new BigInteger(test_value + ""), json.getInteger());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);
    }

    public void testGetFloat(){
        long test_value = Long.MAX_VALUE;
        int incrementer = 2;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals((float)test_value, json.getFloat());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);
        test_value = Long.MIN_VALUE;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals((float)test_value, json.getFloat());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);
    }

    public void testGetDouble(){
        long test_value = Long.MAX_VALUE;
        int incrementer = 2;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals((double)test_value, json.getDouble());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);
        test_value = Long.MIN_VALUE;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals((double)test_value, json.getDouble());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);
    }

    public void testGetDecimal(){
        long test_value = Long.MAX_VALUE;
        int incrementer = 2;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals(new BigDecimal(test_value), json.getDecimal());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);
        test_value = Long.MIN_VALUE;
        do{
            SimpleJSON json = new SimpleJSON(test_value);
            try{
                assertEquals(new BigDecimal(test_value), json.getDecimal());
            }catch(InvalidTypeException e){
                e.printStackTrace();
                fail();
            }
            test_value /= incrementer;
        }while(test_value != 0);
    }

    public void testSetNull(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.set();
        assertEquals(null, json.get());
    }

    public void testSetString(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.set("hello");
        assertEquals("string", json.getType());
        assertEquals("hello", json.get());
    }

    public void testSetBoolean(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.set(true);
        assertEquals("boolean", json.getType());
        assertEquals(true, json.get());
    }

    public void testSetByte(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.set((byte)10);
        assertEquals("number", json.getType());
        assertEquals((byte)10, json.getByte());
    }

    public void testSetShort(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.set((short)10);
        assertEquals("number", json.getType());
        assertEquals((short)10, json.getShort());
    }

    public void testSetInteger(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.set(10);
        assertEquals("number", json.getType());
        assertEquals(10, json.getInt());
    }

    public void testSetLong(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.set(10L);
        assertEquals("number", json.getType());
        assertEquals(10L, json.getLong());
    }

    public void testSetFloat(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.set(10.0f);
        assertEquals("number", json.getType());
        assertEquals(10.0f, json.getFloat());
    }

    public void testSetDouble(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.set(10.0);
        assertEquals("number", json.getType());
        assertEquals(10.0, json.getDouble());
    }

    public void testSetBigInteger(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.set(new BigInteger("10"));
        assertEquals("number", json.getType());
        assertEquals("10", json.getString());
    }

    public void testSetBigDecimal(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.set(new BigDecimal("10"));
        assertEquals("number", json.getType());
        assertEquals("10", json.getString());
    }

    public void testSetMapSinglePair(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.set("key", new SimpleJSON("value"));
        assertEquals("map", json.getType());
        assertEquals("value", json.get("key").getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetMapDirect(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
        map.put("key", new SimpleJSON("value"));
        json.set(map);
        assertEquals("map", json.getType());
        assertEquals("value", json.get("key").getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetArray(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        ArrayList<SimpleJSON> array = new ArrayList<SimpleJSON>();
        array.add(new SimpleJSON("value"));
        json.set(array);
        assertEquals("array", json.getType());
        assertEquals("value", json.get(0).getStringOnly());
        assertEquals(1, json.size());
    }

    public void testSetEmptyMap(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.setEmptyMap();
        assertEquals("map", json.getType());
        assertEquals(0, json.size());
    }

    public void testSetEmptyArray(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.setEmptyArray();
        assertEquals("array", json.getType());
        assertEquals(0, json.size());
    }

    public void testPut(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.put("abcdef", new SimpleJSON());
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testPutAllSimpleJSON(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.putAll(new SimpleJSON());
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testPutAllMap(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
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
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.clear();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testRemoveKey(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.remove("abcdef");
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testRemoveIndex(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.remove(0);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testRemoveAll(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
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
        SimpleJSON json = new SimpleJSON(6786786676866L);
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
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.add(new SimpleJSON());
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddAll(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
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
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.contains(new SimpleJSON("abcdef"));
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testContainsAll(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
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
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.containsKey("abcdef");
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testContainsValue(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.containsKey("abcdef");
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void isEmpty(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.isEmpty();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetMap(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.get("abcdef");
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testGetArray(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.get(0);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddJSON(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.add(new SimpleJSON());
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddBoolean(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.add(true);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddByte(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.add((byte)10);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddShort(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.add((short)10);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddInteger(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.add(10);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddLong(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.add(10L);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddFloat(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.add(10.0f);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddDouble(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.add(10.0);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddString(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.add("abcdef");
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddBigInteger(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.add(new BigInteger("10"));
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddBigDecimal(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.add(new BigDecimal("10"));
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testAddCollection(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
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
        SimpleJSON json = new SimpleJSON(6786786676866L);
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
        SimpleJSON json = new SimpleJSON(6786786676866L);
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
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.isEmpty();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testKeySet(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.keySet();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testValues(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.values();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testEntrySet(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.entrySet();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testToArray(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.toArray();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testToArrayWithArray(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            SimpleJSON[] arr = new SimpleJSON[1];
            json.toArray(arr);
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testSize(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        try{
            json.size();
            fail();
        }catch(InvalidTypeException e){
            assert true;
        }
    }

    public void testIterator(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        json.iterator();
    }

    public void testHashCode(){
        long testvalue = 6786786676866L;
        SimpleJSON json = new SimpleJSON(testvalue);
        assertTrue(json.hashCode() == new SimpleJSON(testvalue).hashCode());
    }

    public void testEquals(){
        SimpleJSON json = new SimpleJSON(6786786676866L);
        SimpleJSON json1 = new SimpleJSON(6786786676866L);
        SimpleJSON json2 = new SimpleJSON((long)9);
        SimpleJSON json_str = new SimpleJSON("abcdef");
        assertTrue(json.equals(json));
        assertTrue(json.equals(json1));
        assertFalse(json.equals(json2));
        assertFalse(json.equals(json_str));
    }

    public void testToJSON(){
        long testvalue = 6786786676866L;
        SimpleJSON json = new SimpleJSON(testvalue);
        String out = json.toJSON();
        assertTrue(out.equals(testvalue + ""));
    }

    public void testParse(){
        long testvalue = 6786786676866L;
        SimpleJSON json = null;
        try{
            json = SimpleJSON.fromJSON(testvalue+"");
        }catch(ParseException e){
            fail();
        }
        assertTrue(json.getType().equals("number"));
        assertTrue(json.getLong() == testvalue);
    }
}
