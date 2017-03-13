package ch5;

public class WorkerBean {
    public void doSomeWork (int noOfTime){
        for (int x = 0; x < noOfTime; x++) {
            work();
        }
    }

    private void work(){
        System.out.println("");
    }
}
