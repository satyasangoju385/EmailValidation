package mx.emails.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.emails.EmailVerificationService;

@RestController
@RequestMapping("/api")
public class EmailVerificationController {

	@Autowired
    private EmailVerificationService emailVerificationService;
    
    @GetMapping({ "/verify/{email}" })
    public ResponseEntity<Map<String, Boolean>> verifyEmail(@PathVariable final String email) {
        final Map<String, Boolean> response = Map.of("isValid", this.emailVerificationService.verifyEmail(email));
        return ResponseEntity.ok(response);
    }

}
