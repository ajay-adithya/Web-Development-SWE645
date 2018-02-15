
package arajago2;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "Search", targetNamespace = "http://arajago2/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Search {


    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSearchList", targetNamespace = "http://arajago2/", className = "arajago2.GetSearchList")
    @ResponseWrapper(localName = "getSearchListResponse", targetNamespace = "http://arajago2/", className = "arajago2.GetSearchListResponse")
    @Action(input = "http://arajago2/Search/getSearchListRequest", output = "http://arajago2/Search/getSearchListResponse")
    public List<StudentModel> getSearchList(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

}
