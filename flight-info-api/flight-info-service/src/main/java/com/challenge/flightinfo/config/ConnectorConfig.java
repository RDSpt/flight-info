package com.challenge.flightinfo.config;

//@Configuration
public class ConnectorConfig {

//  @Bean
//  public TomcatServletWebServerFactory servletContainer() {
//    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//      @Override
//      protected void postProcessContext(Context context) {
//        SecurityConstraint securityConstraint = new SecurityConstraint();
//        securityConstraint.setUserConstraint("CONFIDENTIAL");
//        SecurityCollection collection = new SecurityCollection();
//        collection.addPattern("/*");
//        securityConstraint.addCollection(collection);
//        context.addConstraint(securityConstraint);
//      }
//    };
//    tomcat.addAdditionalTomcatConnectors(getHttpConnector());
//    return tomcat;
//  }
//
//  private Connector getHttpConnector() {
//    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//    connector.setScheme("http");
//    connector.setPort(8080);
//    connector.setSecure(false);
//    connector.setRedirectPort(8443);
//    return connector;
//  }
}