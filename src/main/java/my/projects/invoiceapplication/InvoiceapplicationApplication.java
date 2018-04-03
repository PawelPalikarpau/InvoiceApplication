package my.projects.invoiceapplication;

import my.projects.invoiceapplication.application.ui.main_frame.controller.MainFrameController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InvoiceapplicationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(InvoiceapplicationApplication.class).headless(false).run(args);
		MainFrameController mainFrameController = context.getBean(MainFrameController.class);
		mainFrameController.prepareAndOpenFrame();
	}
}
