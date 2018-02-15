
package arajago2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSearchListResponse", propOrder = {
    "_return"
})
public class GetSearchListResponse {

    @XmlElement(name = "return")
    protected List<StudentModel> _return;

    public List<StudentModel> getReturn() {
        if (_return == null) {
            _return = new ArrayList<StudentModel>();
        }
        return this._return;
    }

}
