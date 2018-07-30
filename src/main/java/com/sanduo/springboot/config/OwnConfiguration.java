// package com.sanduo.springboot.config;
//
// import org.apache.catalina.connector.Connector;
// import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
// import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
/// ***
// * 自定义配置**
// *
// * @author sanduo*@date 2018/06/26
// */
// @Configuration
// public class OwnConfiguration {
//
// @Bean
// public ServletWebServerFactory servletContainer() {
// TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
// tomcat.addConnectorCustomizers();
// return tomcat;
// }
//
// /**
// * 重定向https-http
// *
// * @return
// */
// @Bean
// public Connector httpConnector() {
// Connector connector = new Connector();
// connector.setScheme("http");
// connector.setPort(8888);
// connector.setRedirectPort(9999);
// connector.setSecure(false);
// return connector;
// }
// }
