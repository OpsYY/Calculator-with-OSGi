package org.example.numbers;

import org.example.numbers.impl.ConverterServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

public class Activator implements BundleActivator {
    private ServiceRegistration<NumberConverter> publishedService;

    @Override
    public void start(BundleContext context) throws Exception {
        publishedService = context.registerService(
                NumberConverter.class, new ConverterServiceImpl(),
                new Hashtable<>()
        );
        System.out.println("Number Converter started.");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        publishedService.unregister();
        System.out.println("Number Converter stopped.");
    }

}
