package com.memorynotfound.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application implements ApplicationRunner {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private EmailService emailService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("Sending Email with Thymeleaf HTML Template Example");

        Mail mail = new Mail();
        mail.setFrom("no-reply@memorynotfound.com");
        mail.setTo("claire0230025@gmail.com");
        mail.setSubject("<PaperReview!>您收到一篇審文邀請");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", "user");
        model.put("location", "Taipei");
        model.put("signature", "PaperReview");

        model.put("activityName","activityName");
        model.put("activityHold","activityHold");
        model.put("articleName","articleName");
        model.put("articleValue","articleValue");



        mail.setModel(model);

        emailService.sendSimpleMessage(mail);
    }
}
