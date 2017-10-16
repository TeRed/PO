package lab3.e5;

import java.util.LinkedList;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;

public class EmailMessage {
    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    private EmailMessage(Builder builder) {
        from = builder.from;
        to = builder.to;
        subject = builder.subject;
        content = builder.content;
        mimeType = builder.mimeType;
        cc = builder.cc;
        bcc = builder.bcc;
    }

    public void send() {
        String host="";
        final String user="";//change accordingly
        final String password="xxxxx";//change accordingly

        String to="";//change accordingly

        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.auth", "true");

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

    public static class Builder {
        public Builder addFrom(String from) {
            this.from = from;
            return this;
        }

        public Builder addTo(String to) {
            this.to.add(to);
            return this;
        }

        public Builder addSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder addContent(String content) {
            this.content = content;
            return this;
        }

        public Builder addMimeType(String mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        public Builder addCc(String cc) {
            this.cc.add(cc);
            return this;
        }

        public Builder addBcc(String bcc) {
            this.bcc.add(bcc);
            return this;
        }

        public EmailMessage build() {
            if(from.isEmpty() || to.isEmpty()) return null;
            return new EmailMessage(this);
        }

        public Builder() {
            to = new LinkedList<String>();
            cc = new LinkedList<String>();
            bcc = new LinkedList<String>();
        }

        private String from; //required (must be e-mail)
        private LinkedList<String> to; //required at least one (must be e-mail)
        private String subject; //optional
        private String content; //optional
        private String mimeType;  // optional
        private LinkedList<String> cc; //optional
        private LinkedList<String> bcc; // optional
    }

}
