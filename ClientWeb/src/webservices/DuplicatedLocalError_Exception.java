
package webservices;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.14.redhat-1
 * 2016-05-19T18:31:30.493+02:00
 * Generated source version: 2.7.14.redhat-1
 */

@WebFault(name = "DuplicatedLocalError", targetNamespace = "http://webservices/")
public class DuplicatedLocalError_Exception extends Exception {
    
    private webservices.DuplicatedLocalError duplicatedLocalError;

    public DuplicatedLocalError_Exception() {
        super();
    }
    
    public DuplicatedLocalError_Exception(String message) {
        super(message);
    }
    
    public DuplicatedLocalError_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedLocalError_Exception(String message, webservices.DuplicatedLocalError duplicatedLocalError) {
        super(message);
        this.duplicatedLocalError = duplicatedLocalError;
    }

    public DuplicatedLocalError_Exception(String message, webservices.DuplicatedLocalError duplicatedLocalError, Throwable cause) {
        super(message, cause);
        this.duplicatedLocalError = duplicatedLocalError;
    }

    public webservices.DuplicatedLocalError getFaultInfo() {
        return this.duplicatedLocalError;
    }
}
