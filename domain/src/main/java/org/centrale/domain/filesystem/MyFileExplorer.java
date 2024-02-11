package org.centrale.domain.filesystem;

import java.sql.SQLOutput;

public class MyFileExplorer {
    MyDirectory root;
    DataContainerInterface current;

    public MyFileExplorer() {
        root = new MyDirectory("root:");
        current = root;
    }

    public void add(DataContainerInterface c) {
        if(current instanceof MyDirectory dir) {
            dir.addChild(c);
        }
    }
    public void moveTo(String name) {
        if(current instanceof MyDirectory dir) {
            for(DataContainerInterface container : dir.getChildren()) {
                if(container.getPath().replace(dir.getPath() + "/", "").equals(name)) {
                    current = container;
                    return;
                }
            }
        }
        System.out.println("Fichier/Dossier introuvable");
    }

    public void list() {
        if(current instanceof MyDirectory dir) {
            for(DataContainerInterface container : dir.getChildren()) {
                System.out.println(container.getPath().replace(dir.getPath(), ""));
            }
        }
        else {
            System.out.println("Nothing to list");
        }
    }

    public void moveBack() {
        if(current.getParent() != null) {
            current = current.getParent();
        }
    }
    public int getSizeFromCurrent() {
        return current.getSize();
    }

    public String getCurrentPath() {
        return current.getPath();
    }
}
