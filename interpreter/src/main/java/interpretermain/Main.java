package interpretermain;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;
import interpretermain.webinterpreter.ViewScope;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Main implements ServletContextAware {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
        ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<>(
            new FacesServlet(), "*.xhtml");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }


    @Bean
    public static CustomScopeConfigurer viewScope() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        Map<String, Object> scope = new HashMap<>();
        scope.put("view", new ViewScope());
        configurer.setScopes(scope);
        return configurer;
    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        // Iniciar el contexto de JSF
        // http://stackoverflow.com/a/25509937/1199132
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
    }
}
