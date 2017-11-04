package sample.hibernaterest;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

	@RequestMapping("/hi")
	public String insertPlayer()
    {
    	return "12345";
    }
	
	/*@RequestMapping("/players")
	public Player allPlayers()
	{
		//return Arrays.asList(arg0);
	}*/
}
