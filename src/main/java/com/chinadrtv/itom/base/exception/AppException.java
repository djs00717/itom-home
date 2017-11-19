package com.chinadrtv.itom.base.exception;

public class AppException extends Exception {

    // serial version id
    private static final long serialVersionUID = 9049160567189835471L;

    /**
     * Code be used to get the error message, which is defined in the related
     * error constants file
     */
    private String errorCode;

    /**
     * Holds the exception message description.
     */
    private String description;

    /**
     * Root cause of this exception
     */
    private Throwable cause;

    /**
     * Constructs the new exception object.
     * 
     * @param errCode
     *            a string containing the exception code.
     * @param description
     *            a string containing the exception description.
     */
    public AppException(String errCode, String description) {
        super(description);
        this.errorCode = errCode;
        this.description = description; 
    }

   /**
    * 
    * @param errCode
    * @param description
    * @param cause
    */
    public AppException(String errCode, String description, Throwable cause) {
        super(description,cause);
        this.errorCode = errCode;
        this.description = description;
        this.cause = cause;
    }

    /**
     * 
     * @author Fu Qinghui<qinghui.fu@capgemini.com>
     * @version 2013-5-11 下午8:14:27
     * @return
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 
     * @author Fu Qinghui<qinghui.fu@capgemini.com>
     * @version 2013-5-11 下午8:14:21
     * @param errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

   /**
    * 
    * @author Fu Qinghui<qinghui.fu@capgemini.com>
    * @version 2013-5-11 下午8:14:06
    * @return
    */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @author Fu Qinghui<qinghui.fu@capgemini.com>
     * @version 2013-5-11 下午8:14:01
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @author Fu Qinghui<qinghui.fu@capgemini.com>
     * @version 2013-5-11 下午8:13:55
     * @return
     */
    public Throwable getCause() {
        return cause;
    }

   /**
    * 
    * @author Fu Qinghui<qinghui.fu@capgemini.com>
    * @version 2013-5-11 下午8:13:48
    * @param cause
    */
    public void setCause(Throwable cause) {
        this.cause = cause;
    }
	/**
	 * 
	 * @author Fu Qinghui<qinghui.fu@capgemini.com>
	 * @version 2013-5-11 下午8:13:35
	 */
    public void printStackTrace() {
        super.printStackTrace();
        if (this.cause != null) {
            System.err.println("<---- Caused by:");
            this.cause.printStackTrace();
            System.err.println("---->");
        }
    }

    /**
     * 
     * @author Fu Qinghui<qinghui.fu@capgemini.com>
     * @version 2013-5-11 下午8:13:28
     * @param ps
     */
    public void printStackTrace(java.io.PrintStream ps) {
        super.printStackTrace(ps);
        if (this.cause != null) {
            ps.println("<---- Caused by:");
            this.cause.printStackTrace(ps);
            ps.println("---->");
        }
    }

   /**
    * 
    * @author Fu Qinghui<qinghui.fu@capgemini.com>
    * @version 2013-5-11 下午8:13:20
    * @param pw
    */
    public void printStackTrace(java.io.PrintWriter pw) {
        super.printStackTrace(pw);
        if (this.cause != null) {
            pw.println("<---- Caused by:");
            this.cause.printStackTrace(pw);
            pw.println("---->");
        }
    }

   /**
    * 
    * @author Fu Qinghui<qinghui.fu@capgemini.com>
    * @version 2013-5-11 下午8:13:12
    * @return
    */
    public String toString() {
        if (this.cause == null) {
            return super.toString();
        } else {
            return super.toString() + "<---- Caused by: " + cause.toString() + " ---->";
        }
    }
}
