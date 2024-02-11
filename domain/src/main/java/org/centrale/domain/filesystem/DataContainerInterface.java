package org.centrale.domain.filesystem;

public interface DataContainerInterface {
    public int getSize();
    public String getPath();

    public void setParent(MyDirectory dir);
    public MyDirectory getParent();
}
