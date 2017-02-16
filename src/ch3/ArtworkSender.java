package ch3;

public interface ArtworkSender {
    void sendArtwork(String artWorkPath, Recipient recipient);
    String getFrendlyName();
    String getShortName();
}
