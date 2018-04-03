package my.projects.invoiceapplication.application.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

@XmlRootElement
@XmlSeeAlso( { Invoice.class, Customer.class, Address.class } )
public class XmlData {

    private List entities;

    public XmlData() {
    }

    public XmlData(List entities) {
        this.entities = entities;
    }

    public List getEntities() {
        return entities;
    }

    public void setEntities(List entities) {
        this.entities = entities;
    }
}
