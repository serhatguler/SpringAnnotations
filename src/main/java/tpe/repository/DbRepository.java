package tpe.repository;

import org.springframework.stereotype.Component;
import tpe.domain.Message;
@Component
public class DbRepository implements Repository{
    @Override
    public void save(Message message) {
        System.out.println("Mesajiniz DB ye kaydediliyor....");
    }
}