package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Created by Иван on 20.02.2017.
 */

@SpringBootApplication
public class Application {
	
    public static void main(String[] args) throws Exception{
        SpringApplication.run(new Object[] {Application.class}, args);
    }
}
