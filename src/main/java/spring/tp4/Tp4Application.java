package spring.tp4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.tp4.dao.IPeopleDAO;
import spring.tp4.model.People;

@SpringBootApplication
public class Tp4Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp4Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(IPeopleDAO repository){
        return (args -> {
            repository.save(new People(1,"Berger","Michel","chez lui"));
            repository.save(new People(2,"Gall","France","chez elle"));
            repository.save(new People(3,"Mekhim","Maxime","chez moi"));
        });
    }

}
