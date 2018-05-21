package com.simplejson;

/*
 *  @author Tom Ansill
 *  @email tom@ansill.com
 */

import com.simplejson.parser.SimpleJSONParser;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.*;

/** The SimpleJSON class that simplifies non-POJO JSON */
public class SimpleJSON implements Iterable{

    /** String value - either has value or null */
    private String s_value = null;

    /** Number value - either has value or null */
    private BigDecimal bd_value = null;

    /** Boolean value - always true or false, is_null to true or any other
     *  values as non-null makes the value unusable*/
    private boolean b_value = false;

    /** Map value - either has value or null */
    private HashMap<String, SimpleJSON> map_value = null;

    /** Array value - either has value or null */
    private ArrayList<SimpleJSON> array_value = null;

    /** flag to declare if this JSON is null */
    private boolean is_null = true;

    /** Default constructor, creates NULL JSON object */
    public SimpleJSON(){}

    /** Copy constructor, clones input json
     *  @param value SimpleJSON value to be cloned
     */
    public SimpleJSON(SimpleJSON value){
        if(value != null){
            this.is_null = value.is_null;
            this.s_value = value.s_value;
            this.bd_value = value.bd_value;
            this.b_value = value.b_value;
            if(value.map_value != null) this.map_value = new HashMap<String, SimpleJSON>(value.map_value);
            if(value.array_value != null) this.array_value = new ArrayList<SimpleJSON>(value.array_value);
        }
    }

    /** Map constructor - creates map SimpleJSON object from Map
     *  @param value Map to use
     */
    public SimpleJSON(Map<String, SimpleJSON> value){
        this.map_value = new HashMap<String, SimpleJSON>(value);
        this.is_null = false;
    }

    /** Array constructor - creates array SimpleJSON object from Collection
     *  @param value collection to use
     */
    public SimpleJSON(Collection<SimpleJSON> value){
        this.array_value = new ArrayList<SimpleJSON>(value);
        this.is_null = false;
    }

    /** String constructor - creates string SimpleJSON object from String
     *  @param value String to use
     */
    public SimpleJSON(String value){
        this.s_value = value;
        this.is_null = false;
    }

    /** BigInteger constructor - creates number SimpleJSON object from BigInteger
     *  @param value BigInteger to use
     */
    public SimpleJSON(BigInteger value){
        this.bd_value = new BigDecimal(value);
        this.is_null = false;
    }

    /** BigDecimal constructor - creates number SimpleJSON object from BigDecimal
     *  @param value BigDecimal to use
     */
    public SimpleJSON(BigDecimal value){
        this.bd_value = value;
        this.is_null = false;
    }

    /** boolean constructor - creates boolean SimpleJSON object from a boolean
     *  @param value boolean to use
     */
    public SimpleJSON(boolean value){
        this.b_value = value;
        this.is_null = false;
    }

    /** integer constructor - creates number SimpleJSON object from integer
     *  @param value integer to use
     */
    public SimpleJSON(int value){
        this.bd_value = new BigDecimal(value);
        this.is_null = false;
    }

    /** long constructor - creates number SimpleJSON object from long
     *  @param value long to use
     */
    public SimpleJSON(long value){
        this.bd_value = new BigDecimal(value);
        this.is_null = false;
    }

    /** float constructor - creates number SimpleJSON object from float
     *  @param value float to use
     */
    public SimpleJSON(float value){
        this.bd_value = new BigDecimal((double)value);
        this.is_null = false;
    }

    /** double constructor - creates number SimpleJSON object from double
     *  @param value double to use
     */
    public SimpleJSON(double value){
        this.bd_value = new BigDecimal(value);
        this.is_null = false;
    }

    /** byte constructor - creates number SimpleJSON from byte
     *  @param value byte to use
     */
    public SimpleJSON(byte value){
        this.bd_value = new BigDecimal((int)value);
        this.is_null = false;
    }

    /** short constructor - creates number SimpleJSON from short
     *  @param value short to use
     */
    public SimpleJSON(short value){
        this.bd_value = new BigDecimal((int)value);
        this.is_null = false;
    }

    /** Gets JSON type in String
     *  Possible strings:
     *      null - Null
     *      string - String
     *      number - Number
     *      map - Map
     *      array - Array
     *      boolean - Boolean
     *  @return string that describes SimpleJSON
     */
    public synchronized String getType(){
        if(this.is_null) return "null";
        if(this.s_value != null) return "string";
        if(this.bd_value != null) return "number";
        if(this.map_value != null) return "map";
        if(this.array_value != null) return "array";
        return "boolean";
    }

    /** Gets the raw object behind SimpleJSON
     *  Returned object is dependent on SimpleJSON's type
     *  If type of SimpleJSON is null, it returns null
     *  If type of SimpleJSON is string, it returns String
     *  If type of SimpleJSON is numeric, it returns BigDecimal
     *  If type of SimpleJSON is map, it returns HashMap.
     *      Warning: this HashMap is mutable, whatever change you make to it, will
     *      affect this SimpleJSON.
     *  If type of SimpleJSON is array, it returns ArrayList
     *      Warning: this ArrayList is mutable, whatever change you make to it, will
     *      affect this SimpleJSON.
     *  If type of SimpleJSON is boolean, it returns either true or false
     *  @return object
     */
    public synchronized Object get(){
        if(this.is_null) return null;
        if(this.s_value != null) return this.s_value;
        if(this.bd_value != null) return this.bd_value;
        if(this.map_value != null) return this.map_value;
        if(this.array_value != null) return this.array_value;
        return new Boolean(this.b_value);
    }

    /** Gets String from SimpleJSON
     *  This is a best-effort string accessor, it will attempt to convert some
     *  non-string types to String.
     *  If type of SimpleJSON is null, it returns a String that says "null"
     *  If type of SimpleJSON is null, it returns a String with number in it
     *  If type of SimpleJSON is map, error is thrown
     *  If type of SimpleJSON is array, error is thrown
     *  If type of SimpleJSON is boiolean, it returns a String with boolean value
     *  @return string that represents SimpleJSON
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized String getString() throws InvalidTypeException{
        if(this.is_null) return "null";
        if(this.s_value != null) return this.s_value;
        if(this.bd_value != null) return this.bd_value.toString();
        if(this.map_value != null) throw new InvalidTypeException("The SimpleJSON object is a map. A String cannot be get from map.");
        if(this.array_value != null) throw new InvalidTypeException("The SimpleJSON object is an array. A String cannot be get from map.");
        return this.b_value ? "true" : "false";
    }

    /** Gets String from SimpleJSON
     *  This is a strict string accessor, it will only return string if
     *  SimpleJSON's type is string. Attempting to use this method on SimpleJSON
     *  of Any other type will result in an exception
     *  @return string that represents SimpleJSON
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized String getStringOnly() throws InvalidTypeException{
        if(this.is_null || this.s_value == null) throw new InvalidTypeException("The SimpleJSON object is not a string");
        return this.s_value;
    }

    /** Accessor for boolean in SimpleJSON
     *  @return boolean representation
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized boolean getBoolean() throws InvalidTypeException{
        if(this.is_null || this.s_value != null || this.bd_value != null || this.map_value != null || this.array_value != null)
            throw new InvalidTypeException("The SimpleJSON object is not a boolean");
        return this.b_value;
    }

    /** Accessor for number in SimpleJSON
     *  @return byte representation
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized byte getByte() throws InvalidTypeException{
        if(this.is_null || this.bd_value == null) throw new InvalidTypeException("The SimpleJSON object is not a number");
        return (byte)bd_value.intValue();
    }

    /** Accessor for number in SimpleJSON
     *  @return short representation
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized short getShort() throws InvalidTypeException{
        if(this.is_null || this.bd_value == null) throw new InvalidTypeException("The SimpleJSON object is not a number");
        return (short)bd_value.intValue();
    }

    /** Accessor for number in SimpleJSON
     *  @return integer representation
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized int getInt() throws InvalidTypeException{
        if(this.is_null || this.bd_value == null) throw new InvalidTypeException("The SimpleJSON object is not a number");
        return this.bd_value.intValue();
    }

    /** Accessor for number in SimpleJSON
     *  @return long representation
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized long getLong() throws InvalidTypeException{
        if(this.is_null || this.bd_value == null) throw new InvalidTypeException("The SimpleJSON object is not a number");
        return this.bd_value.longValue();
    }

    /** Accessor for number in SimpleJSON
     *  @return BigInteger representation
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized BigInteger getInteger() throws InvalidTypeException{
        if(this.is_null || this.bd_value == null) throw new InvalidTypeException("The SimpleJSON object is not a number");
        return this.bd_value.unscaledValue();
    }

    /** Accessor for number in SimpleJSON
     *  @return float representation
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized float getFloat() throws InvalidTypeException{
        if(this.is_null || this.bd_value == null) throw new InvalidTypeException("The SimpleJSON object is not a number");
        return this.bd_value.floatValue();
    }

    /** Accessor for number in SimpleJSON
     *  @return double representation
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized double getDouble() throws InvalidTypeException{
        if(this.is_null || this.bd_value == null) throw new InvalidTypeException("The SimpleJSON object is not a number");
        return this.bd_value.doubleValue();
    }

    /** Accessor for number in SimpleJSON
     *  @return BigDecimal representation
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized BigDecimal getDecimal() throws InvalidTypeException{
        if(this.is_null || this.bd_value == null) throw new InvalidTypeException("The SimpleJSON object is not a number");
        return this.bd_value;
    }

    /** Sets the SimpleJSON to NULL and discarding its previous state */
    public synchronized void set(){
        this.is_null = true;
        this.s_value = null;
        this.bd_value = null;
        this.map_value = null;
        this.array_value = null;
    }

    /** Sets the SimpleJSON to String and discarding its previous state
     *  @param value String value
     */
    public synchronized void set(String value){
        if(value == null){
            set();
        }else{
            this.is_null = false;
            this.s_value = value;
            this.bd_value = null;
            this.map_value = null;
            this.array_value = null;
        }
    }

    /** Sets the SimpleJSON to boolean and discarding its previous state
     *  @param value boolean value
     */
    public synchronized void set(boolean value){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = null;
        this.map_value = null;
        this.array_value = null;
        this.b_value = value;
    }

    /** Sets the SimpleJSON to numeric and discarding its previous state
     *  @param value byte value
     */
    public synchronized void set(byte value){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = new BigDecimal((int)value);
        this.map_value = null;
        this.array_value = null;
    }

    /** Sets the SimpleJSON to numeric and discarding its previous state
     *  @param value short value
     */
    public synchronized void set(short value){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = new BigDecimal((int)value);
        this.map_value = null;
        this.array_value = null;
    }

    /** Sets the SimpleJSON to numeric and discarding its previous state
     *  @param value integer value
     */
    public synchronized void set(int value){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = new BigDecimal(value);
        this.map_value = null;
        this.array_value = null;
    }

    /** Sets the SimpleJSON to numeric and discarding its previous state
     *  @param value long value
     */
    public synchronized void set(long value){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = new BigDecimal(value);
        this.map_value = null;
        this.array_value = null;
    }

    /** Sets the SimpleJSON to numeric and discarding its previous state
     *  @param value float value
     */
    public synchronized void set(float value){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = new BigDecimal(value);
        this.map_value = null;
        this.array_value = null;
    }

    /** Sets the SimpleJSON to numeric and discarding its previous state
     *  @param value double value
     */
    public synchronized void set(double value){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = new BigDecimal(value);
        this.map_value = null;
        this.array_value = null;
    }

    /** Sets the SimpleJSON to numeric and discarding its previous state
     *  @param value BigInteger value
     */
    public synchronized void set(BigInteger value){
        if(value == null){
            set();
        }else{
            this.is_null = false;
            this.s_value = null;
            this.bd_value = new BigDecimal(value);
            this.map_value = null;
            this.array_value = null;
        }
    }

    /** Sets the SimpleJSON to numeric and discarding its previous state
     *  @param value BigDecimal value
     */
    public synchronized void set(BigDecimal value){
        if(value == null){
            set();
        }else{
            this.is_null = false;
            this.s_value = null;
            this.bd_value = value;
            this.map_value = null;
            this.array_value = null;
        }
    }

    /** Sets the SimpleJSON to map and discarding its previous state
     *  @param key key for value
     *  @param value SimpleJSON value
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void set(String key, SimpleJSON value) throws NullPointerException{
        if(key == null) throw new NullPointerException("key is null!");
        this.is_null = false;
        this.s_value = null;
        this.bd_value = null;
        this.map_value = new HashMap<String,SimpleJSON>();
        this.array_value = null;

        // If value is null, then convert it to json
        if(value == null) value = new SimpleJSON();

        // If value is array or map, copy it
        if(value.get() instanceof HashMap) value = new SimpleJSON(value);
        if(value.get() instanceof ArrayList) value = new SimpleJSON(value);

        // Add it in the map
        this.map_value.put(key, value);
    }

    /** Sets the SimpleJSON to map and discarding its previous state
     *  @param value Map value
     */
    public synchronized void set(Map<String,SimpleJSON> value){
        if(value == null){
            set();
        }else{
            this.is_null = false;
            this.s_value = null;
            this.bd_value = null;
            this.map_value = new HashMap<String,SimpleJSON>(value);
            this.array_value = null;
        }
    }

    /** Sets the SimpleJSON to array and discarding its previous state
     *  @param value collection value
     */
    public synchronized void set(Collection<SimpleJSON> value){
        if(value == null){
            set();
        }else{
            this.is_null = false;
            this.s_value = null;
            this.bd_value = null;
            this.map_value = null;
            this.array_value = new ArrayList<SimpleJSON>(value);
        }
    }

    /** Sets the SimpleJSON to map and discarding its previous state */
    public synchronized void setEmptyMap(){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = null;
        this.map_value = new HashMap<String,SimpleJSON>();
        this.array_value = null;
    }

    /** Sets the SimpleJSON to array and discarding its previous state */
    public synchronized void setEmptyArray(){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = null;
        this.map_value = null;
        this.array_value = new ArrayList<SimpleJSON>();
    }

    /** Puts key and SimpleJSON value into SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  If null value is given, null SimpleJSON will be be used silently
     *  @param key key to value
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void put(String key, SimpleJSON value) throws InvalidTypeException, NullPointerException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        if(value == null) value = new SimpleJSON();
        if(key == null) throw new NullPointerException("key is null!");

        // If value is array or map, copy it
        if(value.get() instanceof HashMap) value = new SimpleJSON(value);
        if(value.get() instanceof ArrayList) value = new SimpleJSON(value);

        this.map_value.put(key, value);
    }

    /** Puts key and numeric value into SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @param key key to value
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void put(String key, byte value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        this.map_value.put(key, new SimpleJSON(value));
    }

    /** Puts key and numeric value into SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @param key key to value
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void put(String key, short value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        this.map_value.put(key, new SimpleJSON(value));
    }

    /** Puts key and numeric value into SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @param key key to value
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void put(String key, int value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        this.map_value.put(key, new SimpleJSON(value));
    }

    /** Puts key and numeric value into SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @param key key to value
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void put(String key, long value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        this.map_value.put(key, new SimpleJSON(value));
    }

    /** Puts key and numeric value into SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @param key key to value
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void put(String key, float value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        this.map_value.put(key, new SimpleJSON(value));
    }

    /** Puts key and numeric value into SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @param key key to value
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void put(String key, double value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        this.map_value.put(key, new SimpleJSON(value));
    }

    /** Puts key and boolean value into SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @param key key to value
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void put(String key, boolean value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        this.map_value.put(key, new SimpleJSON(value));
    }

    /** Puts key and numeric value into SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @param key key to value
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void put(String key, BigDecimal value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        if(value == null) this.map_value.put(key, new SimpleJSON());
        else this.map_value.put(key, new SimpleJSON(value));
    }

    /** Puts key and numeric value into SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @param key key to value
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void put(String key, BigInteger value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        if(value == null) this.map_value.put(key, new SimpleJSON());
        else this.map_value.put(key, new SimpleJSON(new BigDecimal(value)));
    }

    /** Puts key and string value into SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  If null value is given, null SimpleJSON will be be used silently
     *  @param key key to value
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void put(String key, String value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        if(value == null) this.map_value.put(key, new SimpleJSON());
        else this.map_value.put(key, new SimpleJSON(value));
    }

    /** Puts key and array value into SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  If null value is given, null SimpleJSON will be be used silently
     *  @param key key to value
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void put(String key, Collection<SimpleJSON> value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        if(value == null) this.map_value.put(key, new SimpleJSON());
        else this.map_value.put(key, new SimpleJSON(value));
    }

    /** Puts key and map value into SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  If null value is given, null SimpleJSON will be be used silently
     *  @param key key to value
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     *  @throws NullPointerException thrown if key is null
     */
    public synchronized void put(String key, Map<String,SimpleJSON> value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        if(value == null) this.map_value.put(key, new SimpleJSON());
        else this.map_value.put(key, new SimpleJSON(value));
    }

    /** Concatencate SimpleJSON map into SimpleJSON map
     *  Will only work if input and current SimpleJSONs are set to map
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized void putAll(SimpleJSON value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        if(value.map_value == null) throw new InvalidTypeException("value is not a map!");

        // If value is array or map, copy it
        if(value.get() instanceof HashMap) value = new SimpleJSON(value);

        // Concatencate
        this.map_value.putAll(value.map_value);
    }

    /** Concatencate Map into SimpleJSON map
     *  Will only work if input and current SimpleJSONs are set to map
     *  @param value SimpleJSON value
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized void putAll(Map<String, SimpleJSON> value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        this.map_value.putAll(value);
    }

    /** Clears the SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized void clear() throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        if(this.map_value != null) this.map_value.clear();
        this.array_value.clear();
    }

    /** Removes a key on SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @param key Key to value to be removed
     *  @return SimpleJSON value that is being removed from the map
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized SimpleJSON remove(String key) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        return this.map_value.remove(key);
    }

    /** Removes a key on SimpleJSON map or an index on SimpleJSON array
     *  Will only work if SimpleJSON is set to map or array
     *  @param index index to value to be removed
     *  @return SimpleJSON value that is being removed from the map
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized SimpleJSON remove(int index) throws InvalidTypeException{
        if(this.is_null || (this.map_value == null && this.array_value == null)) throw new InvalidTypeException("The SimpleJSON object is not an array or map");
        if(this.map_value != null) return this.map_value.remove("" + index);
        return this.array_value.remove(index);
    }

    /** Removes values on SimpleJSON array with a collection of SimpleJSONs
     *  Will only work if SimpleJSON is set to array
     *  @param list collection of SimpleJSONs to match and remove
     *  @return true if removing was successful or not
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized boolean removeAll(Collection<SimpleJSON> list) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        return this.array_value.removeAll(list);
    }

    /** Retains values on SimpleJSON array with a collection of SimpleJSONs
     *  Will only work if SimpleJSON is set to array
     *  @param list collection of SimpleJSONs to match and retain
     *  @return true if removing was successful or not
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized boolean retainAll(Collection<SimpleJSON> list) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        return this.array_value.retainAll(list);
    }

    /** Adds a SimpleJSON value to SimpleJSON array
    *   Will only work if SimpleJSON is set to array
    *   If the value is null, then it will be converted to SimpleJSON null silently
    *   @param value value to be added
    *   @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
    */
    public synchronized void add(SimpleJSON value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        if(value == null) value = new SimpleJSON();

        // If value is array or map, copy it
        if(value.get() instanceof HashMap) value = new SimpleJSON(value);
        if(value.get() instanceof ArrayList) value = new SimpleJSON(value);

        this.array_value.add(value);
    }

    /** Adds a boolean value to SimpleJSON array
    *   Will only work if SimpleJSON is set to array
    *   @param value value to be added
    *   @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
    */
    public synchronized void add(boolean value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        this.array_value.add(new SimpleJSON(value));
    }

    /** Adds a numeric value to SimpleJSON array
    *   Will only work if SimpleJSON is set to array
    *   @param value value to be added
    *   @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
    */
    public synchronized void add(byte value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        this.array_value.add(new SimpleJSON(value));
    }

    /** Adds a numeric value to SimpleJSON array
    *   Will only work if SimpleJSON is set to array
    *   @param value value to be added
    *   @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
    */
    public synchronized void add(short value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        this.array_value.add(new SimpleJSON(value));
    }

    /** Adds a numeric value to SimpleJSON array
    *   Will only work if SimpleJSON is set to array
    *   @param value value to be added
    *   @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
    */
    public synchronized void add(int value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        this.array_value.add(new SimpleJSON(value));
    }

    /** Adds a numeric value to SimpleJSON array
    *   Will only work if SimpleJSON is set to array
    *   @param value value to be added
    *   @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
    */
    public synchronized void add(long value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        this.array_value.add(new SimpleJSON(value));
    }

    /** Adds a numeric value to SimpleJSON array
    *   Will only work if SimpleJSON is set to array
    *   @param value value to be added
    *   @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
    */
    public synchronized void add(float value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        this.array_value.add(new SimpleJSON(value));
    }

    /** Adds a numeric value to SimpleJSON array
    *   Will only work if SimpleJSON is set to array
    *   @param value value to be added
    *   @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
    */
    public synchronized void add(double value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        this.array_value.add(new SimpleJSON(value));
    }

    /** Adds a string value to SimpleJSON array
    *   Will only work if SimpleJSON is set to array
    *   If the value is null, then it will be converted to SimpleJSON null silently
    *   @param value value to be added
    *   @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
    */
    public synchronized void add(String value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        if(value == null) this.array_value.add(new SimpleJSON());
        this.array_value.add(new SimpleJSON(value));
    }

    /** Adds a BigDecimal value to SimpleJSON array
    *   Will only work if SimpleJSON is set to array
    *   If the value is null, then it will be converted to SimpleJSON null silently
    *   @param value value to be added
    *   @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
    */
    public synchronized void add(BigDecimal value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        if(value == null) this.array_value.add(new SimpleJSON());
        this.array_value.add(new SimpleJSON(value));
    }

    /** Adds a BigInteger value to SimpleJSON array
    *   Will only work if SimpleJSON is set to array
    *   If the value is null, then it will be converted to SimpleJSON null silently
    *   @param value value to be added
    *   @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
    */
    public synchronized void add(BigInteger value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        if(value == null) this.array_value.add(new SimpleJSON());
        this.array_value.add(new SimpleJSON(new BigDecimal(value)));
    }

    /** Adds a Collection of SimpleJSONs to SimpleJSON array
    *   Will only work if SimpleJSON is set to array
    *   If the value is null, then it will be converted to SimpleJSON null silently
    *   @param value value to be added
    *   @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
    */
    public synchronized void add(Collection<SimpleJSON> value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        if(value == null) this.array_value.add(new SimpleJSON());
        this.array_value.add(new SimpleJSON(value));
    }

    /** Adds a map value to SimpleJSON array
    *   Will only work if SimpleJSON is set to array
    *   If the value is null, then it will be converted to SimpleJSON null silently
    *   @param value value to be added
    *   @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
    */
    public synchronized void add(Map<String,SimpleJSON> value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        if(value == null) this.array_value.add(new SimpleJSON());
        this.array_value.add(new SimpleJSON(value));
    }

    /** Add a collection of SimpleJSONs to SimpleJSON array
     *  Will only work if SimpleJSON is set to array
     *  @param value value to be added
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized void addAll(Collection<SimpleJSON> value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        this.array_value.addAll(value);
    }

    /** Checks if array contains a value
     *  Will only work if SimpleJSON is set to array
     *  @param value value to be checked
     *  @return true if value exists in the array, otherwise false
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized boolean contains(SimpleJSON value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        return this.array_value.contains(value);
    }

    /** Checks if array contains a set of values
     *  Will only work if SimpleJSON is set to array
     *  @param value collection of values to be checked
     *  @return true if values exists in the array, otherwise false
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized boolean containsAll(Collection<SimpleJSON> value) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        return this.array_value.containsAll(value);
    }

    /** Checks if map contains a key
     *  Will only work if SimpleJSON is set to map
     *  @param key key to be checked
     *  @return true if key exists in the map, otherwise false
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized boolean containsKey(String key) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        return this.map_value.containsKey(key);
    }

    /** Checks if map contains a value
     *  Will only work if SimpleJSON is set to map
     *  @param value value to be checked
     *  @return true if value exists in the map, otherwise false
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized boolean containsValue(SimpleJSON value) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        return this.map_value.containsValue(value);
    }

    /** Method to find out if SimpleJSON map or array is empty
     *  Will only work if SimpleJSON is set to array or map
     *  @return true if array or map is empty
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized boolean isEmpty() throws InvalidTypeException{
        if(this.is_null ||  (this.map_value == null && this.array_value == null)) throw new InvalidTypeException("The SimpleJSON object is not an array or map");
        if(this.map_value != null) return this.map_value.isEmpty();
        return this.array_value.isEmpty();
    }

    /** Accesses an entry in SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @param key key to get entry
     *  @return SimpleJSON value if found. If not found, null
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized SimpleJSON get(String key) throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        return this.map_value.get(key);
    }

    /** Accesses an entry in SimpleJSON array or map
     *  Will only work if SimpleJSON is set to array or map
     *  @param key key to get entry
     *  @return SimpleJSON value if found. If not found, null
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized SimpleJSON get(int key) throws InvalidTypeException{
        if(this.is_null ||  (this.map_value == null && this.array_value == null)) throw new InvalidTypeException("The SimpleJSON object is not an array or map");
        if(this.map_value != null) return this.map_value.get("" + key);
        return this.array_value.get(key);
    }

    /** Returns keySet of SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @return Set of strings
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized Set<String> keySet() throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        return this.map_value.keySet();
    }

    /** Returns values of SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @return Collection of SimpleJSONs
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized Collection<SimpleJSON> values() throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        return this.map_value.values();
    }

    /** Returns entrySet of SimpleJSON map
     *  Will only work if SimpleJSON is set to map
     *  @return Set of Map.Entry of String and SimpleJSON
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized Set<Map.Entry<String,SimpleJSON>> entrySet() throws InvalidTypeException{
        if(this.is_null || this.map_value == null) throw new InvalidTypeException("The SimpleJSON object is not a map");
        return this.map_value.entrySet();
    }

    /** Returns array version of SimpleJSON array
     *  Will only work if SimpleJSON is set to array
     *  @return Array of SimpleJSONs in Object type
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized Object[] toArray() throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        return this.array_value.toArray();
    }

    /** Returns array version of SimpleJSON array
     *  Will only work if SimpleJSON is set to array
     *  @param a the array into which the elements of this list are to be stored,
     *      if it is big enough; otherwise, a new array of the same runtime type
     *      is allocated for this purpose.
     *  @return Array of SimpleJSONs in Object type
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized SimpleJSON[] toArray(SimpleJSON[] a) throws InvalidTypeException{
        if(this.is_null || this.array_value == null) throw new InvalidTypeException("The SimpleJSON object is not an array");
        return this.array_value.toArray(a);
    }

    /** Returns the count of SimpleJSON array or map
     *  Will only work if SimpleJSON is set to array or map
     *  @return count of values
     *  @throws InvalidTypeException Thrown when SimpleJSON is in invalid type
     */
    public synchronized int size() throws InvalidTypeException{
        if(this.is_null ||  (this.map_value == null && this.array_value == null)) throw new InvalidTypeException("The SimpleJSON object is not an array or map");
        if(this.map_value != null) return this.map_value.size();
        return this.array_value.size();
    }

    /** Returns the SimpleJSON iterator
     *  If SimpleJSON is not array or map, it will return a iterator of single SimpleJSON
     *  @return iterator
     */
    @Override
    public synchronized Iterator<SimpleJSON> iterator(){
        if(this.is_null || this.array_value == null){
            ArrayList<SimpleJSON> lst = new ArrayList<SimpleJSON>();
            lst.add(this);
            return lst.iterator();
        }
        return this.array_value.iterator();
    }

    /** Returns the hash code of SimpleJSON
     *  @return hash code
     */
    @Override
    public synchronized int hashCode(){
        if(this.is_null) return 0;
        if(this.s_value != null) return this.s_value.hashCode();
        if(this.bd_value != null) return this.bd_value.hashCode();
        if(this.s_value != null) return this.map_value.hashCode();
        if(this.array_value != null) return this.array_value.hashCode();
        return this.b_value ? 1 : -1;
    }

    /** Compares object with this SimpleJSON to see if they are equal
     *  @param obj Object to be tested
     *  @return true if truly equal, otherwise false
     */
    @Override
    public synchronized boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof SimpleJSON)) return false;
        SimpleJSON value = (SimpleJSON) obj;
        switch(value.getType()){
            case "null":    return this.is_null == value.is_null;
            case "string":  if(this.is_null || this.s_value == null) return false;
                            return this.s_value.equals(value.s_value);
            case "number": if(this.is_null || this.bd_value == null) return false;
                            return this.bd_value.equals(value.bd_value);
            case "boolean": if(this.is_null || this.s_value != null || this.bd_value != null || this.map_value != null || this.array_value != null) return false;
                            return this.b_value == value.b_value;
            case "map":     if(this.is_null || this.map_value == null) return false;
                            return this.map_value.equals(value.map_value);
            case "array":   if(this.is_null || this.array_value == null) return false;
                            return this.array_value.equals(value.array_value);
            default:        return false;
        }
    }

    /** Encodes the SimpleJSON to JSON string
     *  @return JSON encoded string
     */
    public synchronized String toJSON(){

        // Return on basic values
        if(this.is_null) return "null";
        if(this.bd_value != null) return this.bd_value.toString();
        if(this.s_value == null && this.array_value == null && this.map_value == null) return this.b_value ? "true" : "false";

        // Build on complex value
        StringBuilder sb = new StringBuilder();
        if(this.s_value != null){
            sb.append("\"");
            sb.append (this.s_value);
            sb.append("\"");
            return sb.toString();
        }

        if(this.map_value != null){
            sb.append("{");
            boolean first = true;
            for(Map.Entry<String, SimpleJSON> entry : this.map_value.entrySet()){
                if(!first){
                    sb.append(",");
                }else first = false;
                sb.append("\"");
                sb.append(entry.getKey());
                sb.append("\":");
                sb.append(entry.getValue().toJSON());
            }
            sb.append("}");
        }else{
            sb.append("[");
            boolean first = true;
            for(SimpleJSON value : this.array_value){
                if(!first){
                    sb.append(",");
                }else first = false;
                sb.append(value.toJSON());
            }
            sb.append("]");
        }

        // Return the string
        return sb.toString();
    }

    /** Returns string representation of SimpleJSON
     *  @return string representation of SimpleJSON
     */
    @Override
    public synchronized String toString(){
        return "SimpleJSON(" + this.toJSON() + ")";
    }

    /** Parses the string into SimpleJSON object
     *  @param string JSON-formatted string
     *  @return SimpleJSON
     *  @throws ParseException thrown when there's a problem with parsing
     */
    public static SimpleJSON fromJSON(String string) throws ParseException{
        return SimpleJSONParser.fromJSON(string);
    }

    /** Parses the stream into SimpleJSON object
     *  @param reader input stream
     *  @return SimpleJSON
     *  @throws IOException thrown when there's a problem with reading the stream
     *  @throws ParseException thrown when there's a problem with parsing
     */
    public static SimpleJSON fromJSON(Reader reader) throws IOException, ParseException{
        return SimpleJSONParser.fromJSON(reader);
    }
}
