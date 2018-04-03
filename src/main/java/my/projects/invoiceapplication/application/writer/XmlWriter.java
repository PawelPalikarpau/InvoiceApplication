package my.projects.invoiceapplication.application.writer;

import my.projects.invoiceapplication.application.entity.XmlData;
import my.projects.invoiceapplication.application.util.Notifications;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class XmlWriter extends WriterSupport implements FileWriter {

    @Override
    public void write(List entities, Path path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(XmlData.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(new XmlData(entities), new File(path.toString()));
        } catch (JAXBException ignored) {
            Notifications.showCanNotWriteToFileErrorMessage();
        }
    }

    @Override
    protected Object prepareDataToWrite(List entities) {
        return null;
    }
}
