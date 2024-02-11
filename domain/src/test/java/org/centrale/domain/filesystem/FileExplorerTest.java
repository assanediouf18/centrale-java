package org.centrale.domain.filesystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileExplorerTest {
    @Test
    public void testInitialize() {
        MyFileExplorer explorer = new MyFileExplorer();
        Assertions.assertEquals("root:", explorer.getCurrentPath());
    }

    @Test
    public void addContainer() {
        MyFileExplorer explorer = new MyFileExplorer();

        explorer.add(new MyDirectory("Dir"));
        Assertions.assertEquals(0, explorer.getSizeFromCurrent());
        explorer.moveTo("Dir");
        Assertions.assertEquals("root:/Dir", explorer.getCurrentPath());

        MyFileExplorer explorer2 = new MyFileExplorer();
        explorer2.add(new MyFile("file", 10));
        Assertions.assertEquals(10, explorer2.getSizeFromCurrent());
        explorer2.moveTo("file");
        Assertions.assertEquals("root:/file", explorer2.getCurrentPath());

        explorer2.add(new MyDirectory("dir"));
        explorer2.moveTo("dir");
        Assertions.assertEquals("root:/file", explorer2.getCurrentPath());
    }
}