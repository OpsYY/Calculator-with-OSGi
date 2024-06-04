package org.example.ui;

import org.example.numbers.NumberConverter;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class Activator implements BundleActivator {
    private UI.MyInterface ui;

    @Override
    public void start(BundleContext context) throws Exception {
        var service = context.getService(
                context.getServiceReference(NumberConverter.class)
        );

        ui = new UI.MyInterface(service);

        System.out.println(service);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        SwingUtilities.invokeLater(() -> {
            ui.dispatchEvent(new WindowEvent(ui, WindowEvent.WINDOW_CLOSING));
        });
        System.out.println("UI stopped.");
    }

}
