package tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration //bu classta config yapilacak
@ComponentScan("tpe") // bu packagedaki tum componenetleri tara, default:tpe
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Bean //random classindan Spring Bean olusmasini saglar.
    public Random random(){
        return new Random();
    }

    //value annotation ile yaptigimizi properties classi ile de yapabiliriz.
    @Autowired
    private Environment environment;//Enviroment(Springin interface) application.properties degiskenlerin degerini okuyabilmemizi saglar
    @Bean
    public Properties properties(){
        Properties properties = new Properties(); //hastable extend eder
        properties.put("mymail",environment.getProperty("app.email"));
        //properties.put("mymail",app.email);
        return properties;
    }


}
