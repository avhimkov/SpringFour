package ch3;

public class StandardLookupDemoBean implements DemoBean {
    private MyHelper myHelper;
    public void setMyHelper(MyHelper myHelper){
        this.myHelper=myHelper;
    }

    @Override
    public MyHelper getHelper() {
        return null;
    }

    @Override
    public void someOperation(){
        myHelper.doSomethingHelpful();
    }
}
