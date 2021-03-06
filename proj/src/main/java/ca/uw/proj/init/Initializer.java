/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author siva
 */
public class Initializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext c = new AnnotationConfigWebApplicationContext();
        c.register(ProjectConfig.class);
        sc.addListener(new ContextLoaderListener(c));
        c.setServletContext(sc);
        
        Dynamic servlet = sc.addServlet("dispatcher", new DispatcherServlet(c));
        servlet.addMapping("*.html");
        servlet.setLoadOnStartup(1);
        
    }
    
}
