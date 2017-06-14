package apitask.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitask.common.Messages;
import apitask.config.SpringBootWebApp;

/**
 * 
 * Simple controller, open to public, broadcast message
 * 
 * @author col
 *
 */
@RestController
@RequestMapping(value = "/greetings")
public class GreetingsAPIController {
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> greetings() {
    	return new ResponseEntity<String>(Messages.HELLO_WORLD, HttpStatus.OK) ;
    }
    
    
 
}
