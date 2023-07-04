package mx.emails;

import java.util.regex.Pattern;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailVerificationService {
	@Autowired
    private MXService mxService;
    
    
    public boolean verifyEmail(final String email) {
        if (!this.checkEmailSyntax(email)) {
            return false;
        }
        final String domain = email.substring(email.indexOf("@") + 1);
        try {
            final String mxRecord = this.mxService.getMXRecord(domain);
            return mxRecord.contains("MX");
        }
        catch (NamingException e) {
            return false;
        }
    }
    
    private boolean checkEmailSyntax(final String email) {
        final String emailRegex = "^(.+)@(.+)$";
        final Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

}
