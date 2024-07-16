package tpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tpe.domain.Message;
import tpe.repository.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component//bu classtan bean olusturulsun ,dafault:mailService
@Scope("prototype")// default:Singleton
public class MailService implements MessageService{


    @PostConstruct // constructor metodu cagrildiktan sonra
    public void init(){
        System.out.println("MailService objesi olusturuluyor.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("MailService objesi  destroy edildi");
    }


    //field injection
//    @Autowired
//    @Qualifier("dbRepository") //yada fileRepository
//    private Repository repo;


    //setter injection
//    private Repository repo;
//    @Autowired
//    @Qualifier("fileRepository")
//    public void setRepo(Repository repo) {
//        this.repo = repo;
//    }

    //COnstructor injection : daha guvelir ,anlasilir,test etmesi kolay
    private Repository repo;
    @Autowired//classin icinde bir tane constructor varsa ,@Autowired kullanmak zorunlu degil
    public MailService(@Qualifier("fileRepository") Repository repo) {
        this.repo = repo;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("mail servis" + message.getMessage());
    }

    @Override
    public void savedMessage(Message message) {
        //reponun objesine ihtiyac var

        repo.save(message);
    }
}
