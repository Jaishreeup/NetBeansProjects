import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class SendMailBySite {  
 public static void main(String[] args) {  
  
  String host="smtp.gmail.com";  
  final String user="jaishreeup@gmail.com";//change accordingly  
  final String password="Jaishreeup1@";//change accordingly  
    
  String to="jaishree.12cs220@abes.ac.in";//change accordingly  
  
   //Get the session object  
   Properties props = new Properties();  
   props.put("mail.smtp.host",host);  
   props.put("mail.smtp.auth", "true");
                 props.put("mail.smtp.starttls.enable","true" );

//                 System.setProperty("http.proxyHost", "10.3.100.207");
//            System.setProperty("http.proxyPort", "8080");
//            System.setProperty("https.proxyHost", "10.3.100.207");
//            System.setProperty("https.proxyPort", "8080");

   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
    try {  
     MimeMessage message = new MimeMessage(session);  
     message.setFrom(new InternetAddress(user));  
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
     message.setSubject("javatpoint");  
     message.setText("This is simple program of sending email using JavaMail API");  
       
    //send the message  
     Transport.send(message);  
  
     System.out.println("message sent successfully...");  
   
     } catch (MessagingException e) {e.printStackTrace();}  
 }  
}