package ch3;

import ch3.Container;
import ch3.Dependency;
import ch3.ManagedComponent;

public class ContextualizedDependencyLookup implements ManagedComponent {
    private Dependency dependency;

    @Override
    public void performLookup(Container container){
        this.dependency = (Dependency) container.getDependency("myDependency");
    }
    @Override
    public String toString(){
        return dependency.toString();
    }
}
