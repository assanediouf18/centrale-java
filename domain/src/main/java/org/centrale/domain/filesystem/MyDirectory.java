package org.centrale.domain.filesystem;

import java.util.ArrayList;
import java.util.List;

public class MyDirectory implements DataContainerInterface{

    private List<DataContainerInterface> children;
    private final String name;
    private MyDirectory parent;

    public MyDirectory(String name) {
        this.name = name;
        this.parent = null;
        children = new ArrayList<>();
    }

    public void addChild(DataContainerInterface container) {
        children.add(container);
        container.setParent(this);
    }

    @Override
    public int getSize() {
        int sum = 0;
        if(this.children.isEmpty()) {
            return 0;
        }
        for(DataContainerInterface container : this.children) {
            sum += container.getSize();
        }
        return sum;
    }

    public List<DataContainerInterface> getChildren() {
        return children;
    }

    @Override
    public String getPath() {
        return ((parent != null) ? parent.getPath() + "/" : "") + this.name;
    }

    @Override
    public void setParent(MyDirectory dir) {
        parent = dir;
    }

    @Override
    public MyDirectory getParent() {
        return parent;
    }
}
