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

public class SimpleJSONParserRecursion{

    private long position = 0;

    public SimpleJSONParserRecursion(){}

    public SimpleJSON fromJSON(Reader reader) throws IOException, ParseException{
        //System.out.println("> fromJSON: " + this.position);

        // Use buffered reader
        BufferedReader br = null;

        // If reader is already a BufferedReader, reuse it otherwise create new BufferedReader
        if(reader instanceof BufferedReader) br = (BufferedReader) reader;
        else br = new BufferedReader(reader);

        // Parse it
        SimpleJSON json = handleValue(br);

        // Check for any remaining characters
        int character = -1;
        while((character = br.read()) != -1){
            this.position++;
            if(!Character.isWhitespace((char)character)) throw new ParseException("There's still some characters remaining while reading.", (int)this.position);
        }

        //System.out.println("position: " + this.position);

        return json;
    }

    private SimpleJSON handleValue(BufferedReader br) throws IOException, ParseException{
        //System.out.println("> handleValue: " + this.position);

        // Read until EOF
        int character = -1;
        while((character = br.read()) != -1){

            // Increment position
            this.position++;

            //System.out.println("v>> '" + (char)character + "' " + this.position);

            // Skip if whitespace
            if(Character.isWhitespace((char)character)) continue;

            // Switch on syntax
            switch((char)character){

                // Handle basic syntax
                case '{':   return handleMap(br);
                case '[':   return handleArray(br);
                case '"':   return handleString(br);
                case '-':   return handleNumber(br, '-');

                // Case for null, true, and false
                case 'n':
                case 'f':
                case 't':   char[] buf = new char[3]; // Create a buffer to read next 3 characters
                            int i = br.read(buf, 0, 3);

                            // Exception if EOF
                            if(i != 3) throw new ParseException("Reached end of line!", (int)this.position);

                            // Check if actually 'null'
                            if((char)character == 'n' && buf[0] == 'u' && buf[1] == 'l' && buf[2] == 'l'){
                                this.position += 3;
                                return new SimpleJSON();
                            }

                            // Check if actually 'true'
                            if((char)character == 't' && buf[0] == 'r' && buf[1] == 'u' && buf[2] == 'e'){
                                this.position += 3;
                                return new SimpleJSON(true);
                            }

                            // Check if actually 'false'
                            if((char)character == 'f' && buf[0] == 'a' && buf[1] == 'l' && buf[2] == 's' && ((char)br.read()) == 'e'){
                                this.position += 4;
                                return new SimpleJSON(false);
                            }

                // Handle for numbers, if nothing left, go error
                default:    if(Character.isDigit((char)character)) return handleNumber(br, (char)character);
                            throw new ParseException("Parse error on position " + this.position + ". Expected 'STRING', 'NUMBER', 'NULL', 'TRUE', 'FALSE', '{', '['. Got '" + ((char)character) + "'", (int)this.position);
            }
        }

        // Still here? This means EOF has been reached
        throw new ParseException("Reached end of line!", (int)this.position);
    }

    private SimpleJSON handleMap(BufferedReader br) throws IOException, ParseException{
        //System.out.println("> handleMap: " + this.position);
        HashMap<String,SimpleJSON> map = new HashMap<String,SimpleJSON>();
        int character = -1;
        boolean end = false;
        boolean comma = false;
        boolean first = true;
        String key = null;

        // Loop all
        while(!end &&(character = br.read()) != -1){

            // Increment position
            this.position++;

            //System.out.println("m>> '" + (char)character + "' " + this.position);

            // Skip if whitespace
            if(Character.isWhitespace((char)character)) continue;

            // Switch on syntax
            switch((char)character){
                case '"':   if(key != null) throw new ParseException("Unexpected string", (int)this.position);
                            SimpleJSON exp_key = handleString(br);
                            if(!(exp_key.get() instanceof String)) throw new ParseException("Invalid value for key", (int)this.position);
                            key = exp_key.getStringOnly();
                            comma = false;
                            break;
                case ',':   if(first || comma || key != null) throw new ParseException("Unexpected comma", (int)this.position);
                            comma = true;
                            break;
                case '}':   if(comma || key != null) throw new ParseException("Unexpected end of map", (int)this.position);
                            end = true;
                            break;
                case ':':   if(comma || key == null) throw new ParseException("Unexpected semicolon", (int)this.position);
                            SimpleJSON value = handleValue(br);
                            //System.out.println(">> new pair: " + key + " : " + value + " " + this.position);
                            map.put(key, value);
                            comma = false;
                            first = false;
                            key = null;
                            break;
                default:    throw new ParseException("Unexpected syntax '" + (char)character + "'", (int)this.position);
            }
            //System.out.println("## map tracker: end : " + end + " comma: " + comma + " first: " + first + " char: '" + (char)character + "' key: " + key + " position: " + this.position);
        }

        if(!end) throw new ParseException("Missing end of map", (int)this.position);

        SimpleJSON json = new SimpleJSON(map);
        //System.out.println("map>>>> " + json);
        return new SimpleJSON(map);
    }

    private SimpleJSON handleArray(BufferedReader br) throws IOException, ParseException{
        //System.out.println("> handleArray: " + this.position);
        LinkedList<SimpleJSON> list = new LinkedList<SimpleJSON>();
        int character = -1;
        boolean end = false;
        boolean comma = false;
        boolean first = true;

        // Mark the reader as we may go back
        br.mark(3);

        // Loop all
        while(!end && (character = br.read()) != -1){

            // Increment position
            this.position++;

            //System.out.println("a>> '" + (char)character + "' " + this.position);

            // Skip if whitespace
            if(Character.isWhitespace((char)character)){
                br.mark(1); // Mark the reader as we may go back
                continue;
            }

            // Switch on syntax
            switch((char)character){
                case ',':   if(first || comma) throw new ParseException("Unexpected comma", (int)this.position);
                            comma = true;
                            break;
                case ']':   if(comma) throw new ParseException("Unexpected end of array", (int)this.position);
                            //System.out.println("ARRAY END " + this.position);
                            end = true;
                            break;
                default:    br.reset();
                            this.position--;
                            list.add(handleValue(br));
                            //System.out.println("VALUE EXTRACTED ON ARRAY " + this.position);
                            first = false;
                            comma = false;
                            break;
            }
            br.mark(3); // Mark the reader as we may go back
        }

        if(!end) throw new ParseException("Missing end of array", (int)this.position);

        SimpleJSON json = new SimpleJSON(list);
        //System.out.println("arr>>>> " + json + " " + this.position);
        return new SimpleJSON(list);
    }

    private SimpleJSON handleString(BufferedReader br) throws IOException, ParseException{
        //System.out.println("> handleString: " + this.position);
        StringBuilder sb = new StringBuilder();
        int character = -1;
        boolean solidus = false;
        boolean end = false;

        // Loop all
        while((character = br.read()) != -1){

            // Increment position
            this.position++;

            //System.out.println("s>> '" + (char)character + "' " + this.position);

            // Check for reverse solidus
            if((char)character == '\\' && !solidus){
                solidus = true;
                sb.append('\\');
                continue;
            }

            if(solidus){
                //System.out.println("########################solidus: " + (char)character);
            }

            // End of string reached
            if(!solidus && (char)character == '"'){
                end = true;
                break;
            }

            // Handle reverse solidus
            if(solidus){
                solidus = false;

                // Switch on characters
                switch((char)character){

                    // Aappend
                    case '"':   sb.append('"');
                                break;
                    case '\\':  sb.append('\\');
                                break;
                    case '/':  sb.append('/');
                                break;
                    case 'b':  sb.append('\b');
                                break;
                    case 'f':  sb.append('\f');
                                break;
                    case 'n':  sb.append('\n');
                                break;
                    case 'r':  sb.append('\r');
                                break;
                    case 't':  sb.append('\t');
                                break;

                    // Unicode - requires 4 hexidecimal digits that appends to it
                    case 'u':  sb.append('u');
                                char[] buf = new char[4];
                                int num = br.read(buf, 0, 4);
                                if(num != 4) throw new ParseException("Parse error at position " + this.position, (int)this.position);
                                for(int i = 0; i < buf.length; i++){

                                    // Increment position
                                    this.position++;

                                    // Check if hexidecimal
                                    if(buf[i] < 'a' && buf[i] > 'f' && buf[i] < 'A' && buf[i] > 'F'){
                                        throw new ParseException("Parse error at position " + this.position, (int)this.position);
                                    }

                                    // Append to stream
                                    sb.append(buf[i]);
                                }
                                break;

                    // Error
                    default:    throw new ParseException("Parse error at position " + this.position + " Reason: unrecognized character after solidus '" + (char)character + "'", (int)this.position);
                }

            // Regular character
            }else{

                // Check if character is unicode
                //if(Character.UnicodeBlock.of((char)character) != Character.UnicodeBlock.BASIC_LATIN){
                //if(Character.isValidCodePoint(character)){
                //    //System.out.println("Not a unicode");
                //    throw new ParseException("Parse error at position " + this.position + " Reason: Not a Unicode character '" + (char)character + "'", (int)this.position);
                //}

                // Append
                sb.append((char)character);
            }
        }

        // If string is not terminated, throw exception
        if(!end) throw new ParseException("Reached end of line!", (int)this.position);

        // Return the JSON with the string
        return new SimpleJSON(sb.toString());
    }

    private SimpleJSON handleNumber(BufferedReader br, char start) throws IOException, ParseException{
        //System.out.println("> handleNumber start: '" + start + "' position: " + this.position);
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        int character = -1;
        // Mark for reset
        br.mark(1);
        while((character = br.read()) != -1){

            // Increment position
            this.position++;

            //System.out.println("n>> '" + (char)character + "' " + this.position);

            // A comma for map or array may slip on here, make sure we catch it and clean up
            if(!Character.isDigit((char)character) && (char)character != '-' && (char)character != 'e' && (char)character != 'E' && (char)character != '.' && !Character.isWhitespace((char)character)){
                br.reset();
                this.position--;
                break;
            }

            // Mark for reset
            br.mark(1);

            // Exit if whitespace
            if(Character.isWhitespace((char)character)) break;

            // Append
            sb.append((char)character);
        }

        // Check if it's not just '-';
        String out = sb.toString();
        if(out.equals("-")) throw new ParseException("Invalid number at position " + (this.position-1), (int)(this.position-1));

        // Convert to number
        try{
            //System.out.println("Number conversion: " + out);
            SimpleJSON json = new SimpleJSON(new BigDecimal(out));
            //System.out.println(">>>>>> " + json);
            return new SimpleJSON(new BigDecimal(out));
        }catch(NumberFormatException nfe){
            throw new ParseException("Invalid number at position " + (this.position - out.length()), (int)(this.position - out.length()));
        }
    }
}
