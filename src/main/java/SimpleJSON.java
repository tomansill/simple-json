package com.simplejson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class SimpleJSON implements Iterable{

    private String s_value = null;
    private BigDecimal bd_value = null;
    private boolean b_value = false;
    private HashMap<String, SimpleJSON> map_value = null;
    private ArrayList<SimpleJSON> array_value = null;
    private boolean is_null = true;

    public SimpleJSON(){}

    public SimpleJSON(SimpleJSON value){
        this.is_null = value.is_null;
        this.s_value = value.s_value;
        this.bd_value = value.bd_value;
        this.b_value = value.b_value;
        if(value.map_value != null) this.map_value = new HashMap<String, SimpleJSON>(value.map_value);
        if(value.array_value != null) this.array_value = new ArrayList<SimpleJSON>(value.array_value);
    }

    public SimpleJSON(Map<String, SimpleJSON> value){
        this.map_value = new HashMap<String, SimpleJSON>(value);
        this.is_null = false;
    }

    public SimpleJSON(Collection<SimpleJSON> value){
        System.out.println("SimpleJSON(" + value + ")");
        this.array_value = new ArrayList<SimpleJSON>(value);
        System.out.println("val: " + this.array_value);
        this.is_null = false;
    }

    public SimpleJSON(String value){
        this.s_value = value;
        this.is_null = false;
    }

    public SimpleJSON(BigInteger value){
        this.bd_value = new BigDecimal(value);
        this.is_null = false;
    }

    public SimpleJSON(BigDecimal value){
        this.bd_value = value;
        this.is_null = false;
    }

    public SimpleJSON(boolean value){
        this.b_value = value;
        this.is_null = false;
    }

    public SimpleJSON(int value){
        this.bd_value = new BigDecimal(value);
        this.is_null = false;
    }

    public SimpleJSON(long value){
        this.bd_value = new BigDecimal(value);
        this.is_null = false;
    }

    public SimpleJSON(float value){
        this.bd_value = new BigDecimal((double)value);
        this.is_null = false;
    }

    public SimpleJSON(double value){
        this.bd_value = new BigDecimal(value);
        this.is_null = false;
    }

    public SimpleJSON(byte value){
        this.bd_value = new BigDecimal((int)value);
        this.is_null = false;
    }

    public SimpleJSON(short value){
        this.bd_value = new BigDecimal((int)value);
        this.is_null = false;
    }

    public synchronized String getType(){
        if(this.is_null) return "null";
        if(this.s_value != null) return "string";
        if(this.bd_value != null) return "number";
        if(this.map_value != null) return "map";
        if(this.array_value != null) return "array";
        return "boolean";
    }

    public synchronized Object get(){
        if(this.is_null) return null;
        if(this.s_value != null) return this.s_value;
        if(this.bd_value != null) return this.bd_value;
        if(this.map_value != null) return this.map_value;
        if(this.array_value != null) return this.array_value;
        return new Boolean(this.b_value);
    }

    public synchronized String getString() throws InvalidClassException{
        if(this.is_null) return "null";
        if(this.s_value != null) return this.s_value;
        if(this.bd_value != null) return this.bd_value.toString();
        if(this.map_value != null) throw new InvalidClassException();
        if(this.array_value != null) throw new InvalidClassException();
        return this.b_value ? "true" : "false";
    }

    public synchronized String getStringOnly() throws InvalidClassException{
        if(this.is_null || this.s_value == null) throw new InvalidClassException();
        return this.s_value;
    }

    public synchronized boolean getBoolean() throws InvalidClassException{
        if(this.is_null) throw new InvalidClassException();
        return this.b_value;
    }

    public synchronized byte getByte() throws InvalidClassException{
        if(this.is_null || this.bd_value == null) throw new InvalidClassException();
        return (byte)bd_value.intValue();
    }

    public synchronized short getShort() throws InvalidClassException{
        if(this.is_null || this.bd_value == null) throw new InvalidClassException();
        return (short)bd_value.intValue();
    }

    public synchronized int getInt() throws InvalidClassException{
        if(this.is_null || this.bd_value == null) throw new InvalidClassException();
        return this.bd_value.intValue();
    }

    public synchronized long getLong() throws InvalidClassException{
        if(this.is_null || this.bd_value == null) throw new InvalidClassException();
        return this.bd_value.longValue();
    }

    public synchronized BigInteger getInteger() throws InvalidClassException{
        if(this.is_null || this.bd_value == null) throw new InvalidClassException();
        return this.bd_value.unscaledValue();
    }

    public synchronized float getFloat() throws InvalidClassException{
        if(this.is_null || this.bd_value == null) throw new InvalidClassException();
        return this.bd_value.floatValue();
    }

    public synchronized double getDouble() throws InvalidClassException{
        if(this.is_null || this.bd_value == null) throw new InvalidClassException();
        return this.bd_value.doubleValue();
    }

    public synchronized BigDecimal getDecimal() throws InvalidClassException{
        if(this.is_null || this.bd_value == null) throw new InvalidClassException();
        return this.bd_value;
    }

    public synchronized void set(){
        this.is_null = true;
        this.s_value = null;
        this.bd_value = null;
        this.map_value = null;
        this.array_value = null;
    }

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

    public synchronized void set(boolean value){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = null;
        this.map_value = null;
        this.array_value = null;
        this.b_value = value;
    }

    public synchronized void set(byte value){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = new BigDecimal((int)value);
        this.map_value = null;
        this.array_value = null;
    }

    public synchronized void set(short value){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = new BigDecimal((int)value);
        this.map_value = null;
        this.array_value = null;
    }

    public synchronized void set(int value){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = new BigDecimal(value);
        this.map_value = null;
        this.array_value = null;
    }

    public synchronized void set(long value){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = new BigDecimal(value);
        this.map_value = null;
        this.array_value = null;
    }

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

    public synchronized void setEmptyMap(){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = null;
        this.map_value = new HashMap<String,SimpleJSON>();
        this.array_value = null;
    }

    public synchronized void setEmptyArray(){
        this.is_null = false;
        this.s_value = null;
        this.bd_value = null;
        this.map_value = null;
        this.array_value = new ArrayList<SimpleJSON>();
    }

    public synchronized void put(String key, SimpleJSON value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        if(value == null) value = new SimpleJSON();

        // If value is array or map, copy it
        if(value.get() instanceof HashMap) value = new SimpleJSON(value);
        if(value.get() instanceof ArrayList) value = new SimpleJSON(value);

        this.map_value.put(key, value);
    }

    public synchronized void put(String key, byte value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        this.map_value.put(key, new SimpleJSON(value));
    }

    public synchronized void put(String key, short value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        this.map_value.put(key, new SimpleJSON(value));
    }

    public synchronized void put(String key, int value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        this.map_value.put(key, new SimpleJSON(value));
    }

    public synchronized void put(String key, long value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        this.map_value.put(key, new SimpleJSON(value));
    }

    public synchronized void put(String key, float value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        this.map_value.put(key, new SimpleJSON(value));
    }

    public synchronized void put(String key, double value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        this.map_value.put(key, new SimpleJSON(value));
    }

    public synchronized void put(String key, boolean value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        this.map_value.put(key, new SimpleJSON(value));
    }

    public synchronized void put(String key, BigDecimal value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        if(value == null) this.map_value.put(key, new SimpleJSON());
        else this.map_value.put(key, new SimpleJSON(value));
    }

    public synchronized void put(String key, BigInteger value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        if(value == null) this.map_value.put(key, new SimpleJSON());
        else this.map_value.put(key, new SimpleJSON(new BigDecimal(value)));
    }

    public synchronized void put(String key, String value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        if(value == null) this.map_value.put(key, new SimpleJSON());
        else this.map_value.put(key, new SimpleJSON(value));
    }

    public synchronized void put(String key, Collection<SimpleJSON> value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        if(value == null) this.map_value.put(key, new SimpleJSON());
        else this.map_value.put(key, new SimpleJSON(value));
    }

    public synchronized void put(String key, Map<String,SimpleJSON> value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        if(value == null) this.map_value.put(key, new SimpleJSON());
        else this.map_value.put(key, new SimpleJSON(value));
    }

    public synchronized void putAll(SimpleJSON value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();

        if(this == null) new SimpleJSON();

        // If value is array or map, copy it
        if(value.get() instanceof HashMap) value = new SimpleJSON(value);
        if(value.get() instanceof ArrayList) value = new SimpleJSON(value);

        this.map_value.putAll(value.map_value);
    }

    public synchronized void putAll(Map<String, SimpleJSON> value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        this.map_value.putAll(value);
    }

    public synchronized void clear() throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        if(this.map_value != null) this.map_value.clear();
        this.array_value.clear();
    }

    public synchronized SimpleJSON remove(String key) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        return this.map_value.remove(key);
    }

    public synchronized SimpleJSON remove(int index) throws InvalidClassException{
        if(this.is_null || (this.map_value == null && this.array_value == null)) throw new InvalidClassException();
        if(this.map_value != null) return this.map_value.remove("" + index);
        return this.array_value.remove(index);
    }

    public synchronized boolean removeAll(Collection<SimpleJSON> lst) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        return this.array_value.removeAll(lst);
    }

    public synchronized boolean retainAll(Collection<SimpleJSON> lst) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        return this.array_value.retainAll(lst);
    }

    public synchronized void add(SimpleJSON value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        if(value == null) value = new SimpleJSON();

        // If value is array or map, copy it
        if(value.get() instanceof HashMap) value = new SimpleJSON(value);
        if(value.get() instanceof ArrayList) value = new SimpleJSON(value);

        this.array_value.add(value);
    }

    public synchronized void add(boolean value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        this.array_value.add(new SimpleJSON(value));
    }

    public synchronized void add(byte value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        this.array_value.add(new SimpleJSON(value));
    }

    public synchronized void add(short value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        this.array_value.add(new SimpleJSON(value));
    }

    public synchronized void add(int value) throws InvalidClassException{
        System.out.println(this.is_null + "............" + this.array_value);
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        this.array_value.add(new SimpleJSON(value));
    }

    public synchronized void add(long value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        this.array_value.add(new SimpleJSON(value));
    }

    public synchronized void add(float value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        this.array_value.add(new SimpleJSON(value));
    }

    public synchronized void add(double value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        this.array_value.add(new SimpleJSON(value));
    }

    public synchronized void add(String value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        if(value == null) this.array_value.add(new SimpleJSON());
        this.array_value.add(new SimpleJSON(value));
    }

    public synchronized void add(BigDecimal value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        if(value == null) this.array_value.add(new SimpleJSON());
        this.array_value.add(new SimpleJSON(value));
    }

    public synchronized void add(BigInteger value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        if(value == null) this.array_value.add(new SimpleJSON());
        this.array_value.add(new SimpleJSON(new BigDecimal(value)));
    }

    public synchronized void add(Collection<SimpleJSON> value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        if(value == null) this.array_value.add(new SimpleJSON());
        this.array_value.add(new SimpleJSON(value));
    }

    public synchronized void add(Map<String,SimpleJSON> value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        if(value == null) this.array_value.add(new SimpleJSON());
        this.array_value.add(new SimpleJSON(value));
    }

    public synchronized void addAll(Collection<SimpleJSON> value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        this.array_value.addAll(value);
    }

    public synchronized boolean contains(SimpleJSON value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        return this.array_value.contains(value);
    }

    public synchronized boolean containsAll(Collection<SimpleJSON> value) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        return this.array_value.containsAll(value);
    }

    public synchronized boolean containsKey(String key) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        return this.map_value.containsKey(key);
    }

    public synchronized boolean containsValue(SimpleJSON value) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        return this.map_value.containsValue(value);
    }

    public synchronized boolean isEmpty() throws InvalidClassException{
        if(this.is_null ||  (this.map_value == null && this.array_value == null)) throw new InvalidClassException();
        if(this.map_value != null) return this.map_value.isEmpty();
        return this.array_value.isEmpty();
    }

    public synchronized SimpleJSON get(String key) throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        return this.map_value.get(key);
    }

    public synchronized SimpleJSON get(int key) throws InvalidClassException{
        if(this.is_null ||  (this.map_value == null && this.array_value == null)) throw new InvalidClassException();
        if(this.map_value != null) return this.map_value.get("" + key);
        return this.array_value.get(key);
    }

    public synchronized Set<String> keySet() throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        return this.map_value.keySet();
    }

    public synchronized Collection<SimpleJSON> values() throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        return this.map_value.values();
    }

    public synchronized Set<Map.Entry<String,SimpleJSON>> entrySet() throws InvalidClassException{
        if(this.is_null || this.map_value == null) throw new InvalidClassException();
        return this.map_value.entrySet();
    }

    public synchronized Object[] toArray() throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        return this.array_value.toArray();
    }

    public synchronized SimpleJSON[] toArray(SimpleJSON[] a) throws InvalidClassException{
        if(this.is_null || this.array_value == null) throw new InvalidClassException();
        return this.array_value.toArray(a);
    }

    public synchronized int size() throws InvalidClassException{
        if(this.is_null ||  (this.map_value == null && this.array_value == null)) throw new InvalidClassException();
        if(this.map_value != null) return this.map_value.size();
        return this.array_value.size();
    }

    @Override
    public synchronized Iterator<SimpleJSON> iterator(){
        if(this.is_null || this.array_value == null){
            ArrayList<SimpleJSON> lst = new ArrayList<SimpleJSON>();
            lst.add(this);
            return lst.iterator();
        }
        return this.array_value.iterator();
    }

    @Override
    public synchronized int hashCode(){
        if(this.is_null) return 0;
        if(this.s_value != null) return this.s_value.hashCode();
        if(this.bd_value != null) return this.bd_value.hashCode();
        if(this.s_value != null) return this.map_value.hashCode();
        if(this.array_value != null) return this.array_value.hashCode();
        return this.b_value ? 1 : -1;
    }

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
                            System.out.println("testing arrays!");
                            System.out.println("##this: " + this.array_value);
                            System.out.println("##other: " + value.array_value);
                            return this.array_value.equals(value.array_value);
            default:        return false;
        }
    }

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

    @Override
    public synchronized String toString(){
        return this.toJSON();
    }
}
