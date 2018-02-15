package arajago2;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "SearchImplService", targetNamespace = "http://arajago2/", wsdlLocation = "http://localhost:8080/arajago2_server/WS?wsdl")
public class SearchImplService
    extends Service
{

    private final static URL SEARCHIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException SEARCHIMPLSERVICE_EXCEPTION;
    private final static QName SEARCHIMPLSERVICE_QNAME = new QName("http://arajago2/", "SearchImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/arajago2_server/WS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SEARCHIMPLSERVICE_WSDL_LOCATION = url;
        SEARCHIMPLSERVICE_EXCEPTION = e;
    }

    public SearchImplService() {
        super(__getWsdlLocation(), SEARCHIMPLSERVICE_QNAME);
    }

    public SearchImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SEARCHIMPLSERVICE_QNAME, features);
    }

    public SearchImplService(URL wsdlLocation) {
        super(wsdlLocation, SEARCHIMPLSERVICE_QNAME);
    }

    public SearchImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SEARCHIMPLSERVICE_QNAME, features);
    }

    public SearchImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SearchImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Search
     */
    @WebEndpoint(name = "SearchImplPort")
    public Search getSearchImplPort() {
        return super.getPort(new QName("http://arajago2/", "SearchImplPort"), Search.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Search
     */
    @WebEndpoint(name = "SearchImplPort")
    public Search getSearchImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://arajago2/", "SearchImplPort"), Search.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SEARCHIMPLSERVICE_EXCEPTION!= null) {
            throw SEARCHIMPLSERVICE_EXCEPTION;
        }
        return SEARCHIMPLSERVICE_WSDL_LOCATION;
    }

}
