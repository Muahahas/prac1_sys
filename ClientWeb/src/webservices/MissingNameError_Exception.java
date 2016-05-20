
package webservices;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.14.redhat-1
 * 2016-05-19T18:31:30.466+02:00
 * Generated source version: 2.7.14.redhat-1
 */

@WebFault(name = "MissingNameError", targetNamespace = "http://webservices/")
public class MissingNameError_Exception extends Exception {
    
    private webservices.MissingNameError missingNameError;

    public MissingNameError_Exception() {
        super();
    }
    
    public MissingNameError_Exception(String message) {
        super(message);
    }
    
    public MissingNameError_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingNameError_Exception(String message, webservices.MissingNameError missingNameError) {
        super(message);
        this.missingNameError = missingNameError;
    }

    public MissingNameError_Exception(String message, webservices.MissingNameError missingNameError, Throwable cause) {
        super(message, cause);
        this.missingNameError = missingNameError;
    }

    public webservices.MissingNameError getFaultInfo() {
        return this.missingNameError;
    }
}