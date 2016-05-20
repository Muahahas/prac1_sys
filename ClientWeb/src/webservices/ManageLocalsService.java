package webservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.14.redhat-1
 * 2016-05-19T18:31:30.588+02:00
 * Generated source version: 2.7.14.redhat-1
 * 
 */
@WebServiceClient(name = "ManageLocalsService", 
                  wsdlLocation = "http://localhost:8080/ServidorWeb/ManageLocals?wsdl",
                  targetNamespace = "http://webservices/") 
public class ManageLocalsService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://webservices/", "ManageLocalsService");
    public final static QName ManageLocalsPort = new QName("http://webservices/", "ManageLocalsPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/ServidorWeb/ManageLocals?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ManageLocalsService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/ServidorWeb/ManageLocals?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ManageLocalsService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ManageLocalsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ManageLocalsService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ManageLocalsService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ManageLocalsService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ManageLocalsService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ManageLocals
     */
    @WebEndpoint(name = "ManageLocalsPort")
    public ManageLocals getManageLocalsPort() {
        return super.getPort(ManageLocalsPort, ManageLocals.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ManageLocals
     */
    @WebEndpoint(name = "ManageLocalsPort")
    public ManageLocals getManageLocalsPort(WebServiceFeature... features) {
        return super.getPort(ManageLocalsPort, ManageLocals.class, features);
    }

}