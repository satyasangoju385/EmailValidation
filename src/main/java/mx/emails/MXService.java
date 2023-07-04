package mx.emails;

import java.util.Hashtable;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.springframework.stereotype.Service;

@Service
public class MXService {
	public String getMXRecord(final String hostName) throws NamingException {
        final Hashtable<String, String> env = new Hashtable<String, String>();
        env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
        final DirContext dirContext = new InitialDirContext(env);
        final Attributes attrs = dirContext.getAttributes(hostName, new String[] { "MX" });
        return attrs.toString();
    }
}
