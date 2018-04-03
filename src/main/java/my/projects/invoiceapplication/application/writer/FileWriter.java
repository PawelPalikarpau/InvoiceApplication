package my.projects.invoiceapplication.application.writer;

import java.nio.file.Path;
import java.util.List;

public interface FileWriter<T> {
    void write(List<T> entities, Path path);
}
