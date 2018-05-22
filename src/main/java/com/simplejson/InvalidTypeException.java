package com.simplejson;

/*  Some of the documentation pulled from Java's RuntimeException
 *  @author Tom Ansill
 *  @email tom@ansill.com
 */
/** InvalidTypeException exception class. Runtime Exception used to indicate that
 *  the object is in invalid type.
 */
public class InvalidTypeException extends RuntimeException{

    /** Constructs a new runtime exception with null as its detail message.
     *  The cause is not initialized, and may subsequently be initialized by a
     *  call to Throwable.initCause(java.lang.Throwable).
     */
    public InvalidTypeException(){
        super();
    }

    /** Constructor - creates an InvalidTypeException with a message
     *  @param message the detail message.
     */
    public InvalidTypeException(String message){
        super(message);
    }

    /** Constructor - creates an InvalidTypeException with a message and throwable
     *  @param message the detail message.
     *  @param cause the cause. (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public InvalidTypeException(String message, Throwable cause){
        super(message, cause);
    }

    /** Constructor - creates an InvalidTypeException with a message and throwable
     *  @param message the detail message.
     *  @param cause the cause. (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     *  @param enableSuppression whether or not suppression is enabled or disabled
     *  @param writableStackTrace whether or not the stack trace should be writable
     */
    public InvalidTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /** Constructor - creates an InvalidTypeException with a throwable
     *  @param cause the cause. (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public InvalidTypeException(Throwable cause){
        super(cause);
    }
}
