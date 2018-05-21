package com.simplejson.parser;

/*
 *  @author Tom Ansill
 *  @email tom@ansill.com
 */

import com.simplejson.SimpleJSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;

/** Parser class for SimpleJSON */
public class SimpleJSONParser{

    private SimpleJSONParser(){} // Prevents instaniation

    /** Creates SimpleJSON from String
     *  @param json_string JSON-formatted String
     *  @return SimpleJSON
     *  @throws ParseException thrown when there's a problem with parsing the string
     */
    public static SimpleJSON fromJSON(String json_string) throws ParseException{
        //System.out.println("> fromJSON: " + json_string + " len: " + json_string.length());
        StringReader reader = new StringReader(json_string);
        SimpleJSON result = null;
        try{
            result = SimpleJSONParser.fromJSON(reader);
        }catch(IOException ioe){
            // This may never happen
            ioe.printStackTrace();
        }catch(ParseException p){
            // Throw upstream
            throw p;
        }finally{
            // Close it
            reader.close();
        }
        return result;
    }

    /** Creates SimpleJSON from stream. <b>NOTE:</b> We do not close the reader.
     *  You are responsible for closing the reader
     *  @param reader stream for reading
     *  @return SimpleJSON
     *  @throws IOException thrown when there's a problem with reading the stream
     *  @throws ParseException thrown when there's a problem with parsing the string
     */
    public static SimpleJSON fromJSON(Reader reader) throws IOException, ParseException{
        SimpleJSONParserSingleThreadRecursion parser = new SimpleJSONParserSingleThreadRecursion();
        return parser.fromJSON(reader);
    }
}
