
package webservices;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.14.redhat-1
 * 2016-05-21T10:22:37.709+02:00
 * Generated source version: 2.7.14.redhat-1
 */

@WebFault(name = "WrongTypeLocalError", targetNamespace = "http://webservices/")
public class WrongTypeLocalError_Exception extends Exception {
    
    private webservices.WrongTypeLocalError wrongTypeLocalError;

    public WrongTypeLocalError_Exception() {
        super();
    }
    
    public WrongTypeLocalError_Exception(String message) {
        super(message);
    }
    
    public WrongTypeLocalError_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongTypeLocalError_Exception(String message, webservices.WrongTypeLocalError wrongTypeLocalError) {
        super(message);
        this.wrongTypeLocalError = wrongTypeLocalError;
    }

    public WrongTypeLocalError_Exception(String message, webservices.WrongTypeLocalError wrongTypeLocalError, Throwable cause) {
        super(message, cause);
        this.wrongTypeLocalError = wrongTypeLocalError;
    }

    public webservices.WrongTypeLocalError getFaultInfo() {
        return this.wrongTypeLocalError;
    }
}
