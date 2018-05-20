import java.text.ParseException;
import java.util.LinkedList;
import java.util.HashMap;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.simplejson.*;

/**
 * Unit test for simple App.
 */
public class SimpleJSONNullTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SimpleJSONNullTest(String testName){
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite(SimpleJSONNullTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testType(){
        SimpleJSON json = new SimpleJSON();
        assertTrue(json.getType().equals("null"));
    }

    public void testGet(){
        SimpleJSON json = new SimpleJSON();
        assertTrue(json.get() == null);
    }

    public void testGetString(){
        SimpleJSON json = new SimpleJSON();
        try{
            assertEquals(json.getString(), "null");
        }catch(InvalidClassException e){
            assert false;
        }
    }

    public void testGetStringOnly(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.getStringOnly();
            fail();
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testGetBoolean(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.getBoolean();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testGetByte(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.getByte();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testGetShort(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.getShort();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testGetInt(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.getInt();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testGetLong(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.getLong();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testGetInteger(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.getInteger();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testGetFloat(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.getFloat();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testGetDouble(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.getDouble();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testGetDecimal(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.getDecimal();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testPut(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.put("abcdef", new SimpleJSON());
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testPutAllSimpleJSON(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.putAll(new SimpleJSON());
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testPutAllMap(){
        SimpleJSON json = new SimpleJSON();
        try{
            HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
            map.put("something", json);
            json.putAll(map);
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testClear(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.clear();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testRemoveKey(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.remove("abcdef");
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testRemoveIndex(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.remove(0);
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testRemoveAll(){
        SimpleJSON json = new SimpleJSON();
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("sef"));
            json.removeAll(lst);
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testRetainAll(){
        SimpleJSON json = new SimpleJSON();
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("sef"));
            json.retainAll(lst);
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testAdd(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.add(new SimpleJSON());
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testAddAll(){
        SimpleJSON json = new SimpleJSON();
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("aewfw"));
            lst.add(new SimpleJSON("something"));
            json.addAll(lst);
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testContains(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.contains(new SimpleJSON("abcdef"));
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testContainsAll(){
        SimpleJSON json = new SimpleJSON();
        try{
            LinkedList<SimpleJSON> lst = new LinkedList<SimpleJSON>();
            lst.add(new SimpleJSON("aewfw"));
            lst.add(new SimpleJSON("something"));
            json.containsAll(lst);
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testContainsKey(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.containsKey("abcdef");
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testContainsValue(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.containsKey("abcdef");
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void isEmpty(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.isEmpty();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testGetMap(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.get("abcdef");
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testGetArray(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.get(0);
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testKeySet(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.keySet();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testValues(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.values();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testEntrySet(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.entrySet();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testToArray(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.toArray();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testToArrayWithArray(){
        SimpleJSON json = new SimpleJSON();
        try{
            SimpleJSON[] arr = new SimpleJSON[1];
            json.toArray(arr);
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testSize(){
        SimpleJSON json = new SimpleJSON();
        try{
            json.size();
            assert false;
        }catch(InvalidClassException e){
            assert true;
        }
    }

    public void testIterator(){
        SimpleJSON json = new SimpleJSON();
        json.iterator();
    }

    public void testHashCode(){
        SimpleJSON json = new SimpleJSON();
        assertTrue(json.hashCode() == 0);
    }

    public void testEquals(){
        SimpleJSON json = new SimpleJSON();
        SimpleJSON json1 = new SimpleJSON();
        SimpleJSON json_str = new SimpleJSON("abdef");
        assertTrue(json.equals(json));
        assertTrue(json.equals(json1));
        assertFalse(json.equals(json_str));
    }

    public void testToJSON(){
        SimpleJSON json = new SimpleJSON();
        String out = json.toJSON();
        assertTrue(out.equals("null"));
    }

    /*
    public void testParse(){
        //TODO
        SimpleJSON json = null;
        try{
            json = SimpleJSON.parse("null");
        }catch(ParseException e){
            assert false;
        }
        assertTrue(json.getType().equals("null"));
        assertTrue(json.get() == null);
    }*/
}
