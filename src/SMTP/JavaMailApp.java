package SMTP;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;

public class JavaMailApp{
	
  public static void main(String[] args)  {
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "25");
    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "25");
    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    props.put("mail.smtp.starttls.enable", "true");

    
   
    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication("euripedesanterovieira@gmail.com","rkmisnciijccltpo");
           }
      });
    session.setDebug(true);
    
    try {
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("euripedesanterovieira@gmail.com"));
      Address[] toUser = InternetAddress.parse("gabrieleduardo10102@gmail.com");
      message.setRecipients(Message.RecipientType.TO, toUser);
      message.setSubject("Não tem assunto");
      message.setText("Deu certo");
      Transport.send(message);
     }
    
    catch (Exception e) {
    	System.out.println("Entrei no catch e dei erro\n" + e);
        //throw new RuntimeException(e);
    }
  }
}