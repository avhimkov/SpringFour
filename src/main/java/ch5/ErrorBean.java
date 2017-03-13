package ch5;

public class ErrorBean {
    public void errorProneMethod() throws Exception{
        throw new Exception("Foo");
    }

    public void otherErrorProneMethod() throws IllegalArgumentException{
        new IllegalArgumentException("Bar");
    }
}
