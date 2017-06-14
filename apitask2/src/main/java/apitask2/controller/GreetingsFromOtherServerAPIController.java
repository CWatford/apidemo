package apitask2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * Simple controller, open to public, facade around greetings url
 * 
 * @author col
 *
 */
@RestController
@RequestMapping(value = "/callgreetings")
public class GreetingsFromOtherServerAPIController {
    
	final String uri = "http://localhost:80/greetings";
	
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> greetings() {
        String result = callService();
    	return new ResponseEntity<String>(result, HttpStatus.OK) ;
    }
 
    public String callService() {
    	RestTemplate restTemplate = new RestTemplate();
    	return restTemplate.getForObject(uri, String.class);
    }
    
    
}
