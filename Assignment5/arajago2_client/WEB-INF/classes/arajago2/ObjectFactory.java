
package arajago2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private final static QName _GetSearchListResponse_QNAME = new QName("http://arajago2/", "getSearchListResponse");
    private final static QName _GetSearchList_QNAME = new QName("http://arajago2/", "getSearchList");

    public ObjectFactory() {
    }
    public GetSearchListResponse createGetSearchListResponse() {
        return new GetSearchListResponse();
    }

    public GetSearchList createGetSearchList() {
        return new GetSearchList();
    }

    public StudentModel createStudentModel() {
        return new StudentModel();
    }

    @XmlElementDecl(namespace = "http://arajago2/", name = "getSearchListResponse")
    public JAXBElement<GetSearchListResponse> createGetSearchListResponse(GetSearchListResponse value) {
        return new JAXBElement<GetSearchListResponse>(_GetSearchListResponse_QNAME, GetSearchListResponse.class, null, value);
    }
    @XmlElementDecl(namespace = "http://arajago2/", name = "getSearchList")
    public JAXBElement<GetSearchList> createGetSearchList(GetSearchList value) {
        return new JAXBElement<GetSearchList>(_GetSearchList_QNAME, GetSearchList.class, null, value);
    }

}
