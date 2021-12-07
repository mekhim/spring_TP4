package spring.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InitDB implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {

        String sqlStatement[] = {
                "drop table people if exists",
                "create table people(_id serial, lastname varchar(255), firstname varchar(255), address varchar(255))",
                "insert into people(lastname, firstname,address) VALUES ('Berger','Michel','chez lui');",
                "insert into people(lastname, firstname,address) VALUES ('Gall','France','chez elle');",
                "insert into people(lastname, firstname,address) VALUES ('Mekhim','Maxime','chez moi');"
        };

        Arrays.asList(sqlStatement).stream().forEach(sql -> {
            System.out.println(sql);
            jdbcTemplate.execute(sql);
        });

    }
}
