package com.yzb.config;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final Logger log = Logger.getLogger(WebAppInitializer.class);

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        log.info("init spring context ...");
        return new Class[] {RootConfigure.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        log.info("init mvc configure ...");
        return new Class[] {WebConfigure.class};
    }

    @Override
    protected String[] getServletMappings() {
        log.info("init servlet ...");
        return new String[] {"/"};
    }

}
