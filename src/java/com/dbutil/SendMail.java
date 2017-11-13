/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dbutil;
 
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author VSS
 */
public class SendMail {
   
     String from = "studentprojectveriton@gmail.com";
     String pass ="studentproject1234";
     String host = "smtp.gmail.com";
   public void SendTo(String to, String msg) throws MessagingException {

   
    // Sender's email ID needs to be mentioned
    
    // Recipient's email ID needs to be mentioned.
  // String to = "vinayaka@veritonsoftware.com";

   

   // Get system properties
   Properties properties = System.getProperties();
   // Setup mail server
   properties.put("mail.smtp.starttls.enable", "true");
   properties.put("mail.smtp.host", host);
   properties.put("mail.smtp.user", from);
   properties.put("mail.smtp.password", pass);
   properties.put("mail.smtp.port", "587");
   properties.put("mail.smtp.auth", "true");

   // Get the default Session object.
   Session session = Session.getDefaultInstance(properties);

   try{
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));

      // Set Subject: header field
      message.setSubject("Confirmation Message");

      // Now set the actual message
      message.setText("\n Your password is: "+msg+" \n Thank you.");

      // Send message
      Transport transport = session.getTransport("smtp");
      transport.connect(host, from, pass);
      transport.sendMessage(message, message.getAllRecipients());
      transport.close();
      
   }catch (MessagingException mex) {
      mex.printStackTrace();
   }
}
   
   public void MailTo(String to, String msg) throws MessagingException {

   
    // Sender's email ID needs to be mentioned
    
    // Recipient's email ID needs to be mentioned.
  // String to = "vinayaka@veritonsoftware.com";

   

   // Get system properties
   Properties properties = System.getProperties();
   // Setup mail server
   properties.put("mail.smtp.starttls.enable", "true");
   properties.put("mail.smtp.host", host);
   properties.put("mail.smtp.user", from);
   properties.put("mail.smtp.password", pass);
   properties.put("mail.smtp.port", "587");
   properties.put("mail.smtp.auth", "true");

   // Get the default Session object.
   Session session = Session.getDefaultInstance(properties);

   try{
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));

      // Set Subject: header field
      message.setSubject("Patient Notification");

      // Now set the actual message
      message.setText("\n Patient Id is: "+msg+" \n Thank you.");

      // Send message
      Transport transport = session.getTransport("smtp");
      transport.connect(host, from, pass);
      transport.sendMessage(message, message.getAllRecipients());
      transport.close();
      
   }catch (MessagingException mex) {
      mex.printStackTrace();
   }
}
    
    
    
    
    
}
