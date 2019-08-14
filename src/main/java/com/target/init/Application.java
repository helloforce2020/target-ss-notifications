package com.target.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Notifications application.
 * 
 * @author vinaymajety
 *
 */
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(Application.class, args);
    System.out.println("Launching target-ss-notifications");
  }

}
