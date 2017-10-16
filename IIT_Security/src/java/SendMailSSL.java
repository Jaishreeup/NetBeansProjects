import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailSSL {
	public static void main(String[] args) {
//            System.setProperty("http.proxyHost", "10.3.100.207");
//            System.setProperty("http.proxyPort", "8080");
//            System.setProperty("https.proxyHost", "10.3.100.207");
//            System.setProperty("https.proxyPort", "8080");
//            
            Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
               props.put("mail.transport.protocol", "smtp" );
              props.put("mail.smtp.starttls.enable","true" );
              props.put("mail.smtp.port", "587");
              props.put("mail.smtp.auth", "true" );
           
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("jaishreeup@gmail.com","Jaishreeup1@");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("jaishreeup@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("jaishreeuprety@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}