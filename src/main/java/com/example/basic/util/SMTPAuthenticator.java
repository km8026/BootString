package com.example.basic.util;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {
 @Override
 protected PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication(
       "km802694@gmail.com", "rnmuagzhcbotyzcb");
 }
}
