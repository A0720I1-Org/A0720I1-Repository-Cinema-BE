package com.a0720i1.cinema_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Arrays;
import java.util.Properties;

@Configuration
public class MailConfig {
    private static final String MY_EMAIL = "a0720i1.cg.dn@gmail.com";


    private static final String MY_PASSWORD = "a0720i1cgdn";


    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(MY_EMAIL);
        mailSender.setPassword(MY_PASSWORD);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    public static void main(String[] args) {
            int[] test = {1,2,3,4,5};
            int max = test[0] > test[1] ? test[0] : test[1];
            int second = test[0] > test[1] ? test[1] : test[0];
            for (int i =2 ; i < test.length;i++) {
                if (test[i] > max) {
                    second = max;
                    max = test[i];
                }
                else if(test[i] > second && test[i] < max) {
                    second = test[i];
                }
            }
            System.out.println(second);
        System.out.println(prettyArray(new int[]{2,3,5,7,8,10}));
        System.out.println(changeMoney(new int[]{2,3,5},30));
    }
    public static int prettyArray(int[] array) {
        int countEven= 0 ;
        for (int a: array) {
            if(a%2 ==0) {
                countEven++;
            }
        }
        return  countEven <= array.length-countEven ? countEven : array.length - countEven;
    }
    public static int changeMoney(int[] pence,int money) {
        if(money < 0 || pence.length <=0 ) {
            return 0;
        }
        int count = 0;
        Arrays.sort(pence);
        for (int i = pence.length-1; i >= 0 ; i--) {
            while (money >= pence[i]) {
                count++;
                money = money - pence[i];
            }
        }
        return money > 0 ? 0 : count;
    }
}
