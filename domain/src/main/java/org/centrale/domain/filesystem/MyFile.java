package org.centrale.domain.filesystem;

public class MyFile implements DataContainerInterface {
    private final String name;
    private final int size;
    private MyDirectory parent;
    public MyFile(String name, int size) {
        this.name = name;
        this.size = size;
        this.parent = null;
    }
    @Override
    public int getSize() {
        return this.size;
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
