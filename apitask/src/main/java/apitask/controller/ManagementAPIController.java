package apitask.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitask.common.Messages;

@RestController
@RequestMapping(value = "/admin/internal")
public class ManagementAPIController {

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> greetings() {
		return new ResponseEntity<String>(Messages.HELLO_MANAGEMENT, HttpStatus.OK);
	}

}