package ch3;

public abstract class AЬstractLookupDemoBean implements DemoBean{
    public abstract MyHelper getMyHelper();

    @Override
    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }
}
