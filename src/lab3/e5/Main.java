package lab3.e5;

public class Main {
    public static void main(String[] args) {


        EmailMessage message = new EmailMessage.Builder()
                .addFrom("sbobek@agh.edu.pl")
                .addTo("student@agh.edu.pl")
                .addSubject("Mail testowy")
                .addContent("Brak tresci")
                .build();
//        System.out.println(message);

//        message.send();
    }
}
