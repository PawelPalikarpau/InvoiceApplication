package my.projects.invoiceapplication.application.service;

import my.projects.invoiceapplication.application.entity.Invoice;
import my.projects.invoiceapplication.application.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> findAll() { return invoiceRepository.findAll(); }

    public void remove(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }

    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }
}
