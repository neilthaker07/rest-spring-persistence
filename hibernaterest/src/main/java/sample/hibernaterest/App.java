package sample.hibernaterest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
		/* ctx = new ClassPathXmlApplicationContext("beans.xml");
        Player playerInfo = (Player) ctx.getBean("player");
        System.out.println(playerInfo.getName());
        ctx.close();*/
    	SpringApplication.run(App.class, args);
    	
    }
}
