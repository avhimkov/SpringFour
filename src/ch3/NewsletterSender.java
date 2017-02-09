package ch3;

public interface NewsletterSender {
    void setSmtpServer(String smtpServer);
    String getSmtServer();
    void setFromAddress(String fromAddress);
    String getFromeAddress();
    void send();
}
