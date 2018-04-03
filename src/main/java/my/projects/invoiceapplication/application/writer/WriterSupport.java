package my.projects.invoiceapplication.application.writer;

import java.util.List;

public abstract class WriterSupport<T> {
    protected abstract T prepareDataToWrite(List<T> entities);
}
