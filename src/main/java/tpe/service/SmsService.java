package tpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import tpe.domain.Message;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;
import java.util.Random;

@Component("smsService")
public class SmsService implements MessageService{

    @PostConstruct // constructor metodu cagrildiktan sonra
    public void init(){
        System.out.println("SmsService objesi olusturuluyor.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("SmsService objesi  destroy edildi");
    }

    //Random random = new Random();
    @Autowired
    private Random random;

    @Override
    public void sendMessage(Message message) {
        System.out.println("sms servis" + message.getMessage());
    }

    @Override
    public void savedMessage(Message message) {

    }


    //degiskenlerin degerlerini disaridan vermek isteriz
    @Value("${app.email}")
    private String email;
    @Value("${app.phone}")
    private String phone;
    public void printContact(){
        System.out.println("email: "+email);
        System.out.println("phone_number: "+phone);
    }

    //degiskenlerin degerlerini disardan vermek icin Properties classi kullanabliriz
    @Autowired
    private Properties properties;
    public void printProperties(){
        System.out.println("contact email: "+properties.getProperty("mymail"));
    }


}
