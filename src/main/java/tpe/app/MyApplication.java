package tpe.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tpe.AppConfiguration;
import tpe.domain.Message;
import tpe.service.MailService;
import tpe.service.MessageService;
import tpe.service.SmsService;

import java.util.Random;

public class MyApplication {
    public static void main(String[] args) {

        Message message = new Message();
        message.setMessage("Spring ile calismak");

        //config class okunmasi gerek
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        //context = her bir componentan birer bean olusturup, classin bagimliligi var ise
        // bagimliligi DI ile enjekte edip, icersinde beanleri tutar


        //MessageService service = context.getBean(MessageService.class);//Spring akilli
        //service.sendMessage(message);

        MessageService service = context.getBean("smsService",SmsService.class);
        service.sendMessage(message);

        //interfacein birden fazla impl var ise hangisini istedigimizi belirtmeliyiz

        //messagleri kalici hale getirelim

//        MessageService service = context.getBean(MailService.class);
//        service.sendMessage(message);
//        service.savedMessage(message);//DbRepoyu newlemedik,mailservice yenilenmedi
//        //enjekte edilecek birden fazla bean varsa qualfier ile secim yap

        //3rd party classlarin objesini istersel
        //Random random = new Random();

//        Random random = context.getBean(Random.class);
//        System.out.println(random.nextInt(100));

        MessageService service1 = context.getBean(MailService.class);
        MessageService service2 = context.getBean(MailService.class);

        //Springte default Scope singleton;sadece bir tane bean olusturulur her yerde kullanilir
        // objenin yasan dongusunden tamamen Spring sorumludur

        //Ihtiyaca gore scope:prototype; her istendiginde yeni bir bean olusturur.
        //ancak objenin destroy edilmesinden Spring sorumlu degildir.
//        if (service1==service2){
//            System.out.println("ayni referansli objeler");
//            System.out.println(service1);
//            System.out.println(service2);
//        }else {
//            System.out.println("FArkli referansli objeler");
//            System.out.println(service1);
//            System.out.println(service2);
//        }

        SmsService service3 = context.getBean(SmsService.class);
        service3.sendMessage(message);
        service3.printContact();
        service3.printProperties();



        //scope prototype olan beani yok etmek icin kullanilan yontem
        context.getBeanFactory().destroyBean(service2);




















        context.close();//icerisindeki beanlerde imha edilir.


    }
}
