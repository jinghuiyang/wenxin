package com.youzhong.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

//@Configuration
public class Config {
    @Bean

    public Connector connector(){

        Connector connector=new Connector("org.apache.coyote.http11.Http11NioProtocol");

        connector.setScheme("http");

        connector.setPort(8080);

        connector.setSecure(false);

        connector.setRedirectPort(8075);

        return connector;

    }

    @Bean

    public EmbeddedServletContainerFactory servletContainer() {

        TomcatEmbeddedServletContainerFactory tomcat= new TomcatEmbeddedServletContainerFactory() {

            @Override

            protected void postProcessContext(Context context) {

                SecurityConstraint constraint = new SecurityConstraint();

                constraint.setUserConstraint("CONFIDENTIAL");

                SecurityCollection collection = new SecurityCollection();

                collection.addPattern("/");

                constraint.addCollection(collection);

                context.addConstraint(constraint);

            }

        };

        tomcat.addAdditionalTomcatConnectors(connector());

        return tomcat;

    }
}
