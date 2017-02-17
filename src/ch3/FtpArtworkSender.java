package ch3;


public class FtpArtworkSender implements ArtworkSender {

    @Override
    public void sendArtwork(String artWorkPath, Recipient recipient) {
        //FTP
    }

    @Override
    public String getFrendlyName() {
        return "File transfer protocol";
    }

    @Override
    public String getShortName(){
        return "ftp";
    }
}
