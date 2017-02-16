package ch3;


public class FtpArtworkSender implements ArtworkSender {
    @Override
    public void sendArtWork(String artworkPath, Recipient recipient) {
        //FTP
    }

    @Override
    public String getFriendlyName(){
        return "File transfer protocol";
    }
    @Override
    public String getShortName(){
        return "ftp";
    }
}
