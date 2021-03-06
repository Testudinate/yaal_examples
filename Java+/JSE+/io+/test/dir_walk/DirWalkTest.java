package dir_walk;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class DirWalkTest {
    private static File rootDir;

    @BeforeClass
    public static void setUp() {
        rootDir = new File("resourcesTest");
        assertTrue(rootDir.exists());
    }

    @Test
    public void recursiveDirectoryList() {
        List<File> files = RecursiveDirectoryList.findFiles(rootDir, ".*.xml");
        System.out.println(files);
        assertThat(files, containsInAnyOrder(
                new File(rootDir, "dir_walk/dirForWalk/subDir/config.xml"),
                new File(rootDir, "dir_walk/dirForWalk/subDir/subSubDir/context.xml")
        ));
    }

    @Test
    public void contentDirectoryList() {
        ContentDirectoryList directoryList = new ContentDirectoryList(rootDir, ".*.xml");
        directoryList.process();
        List<File> files = directoryList.getResult();
        assertThat(files, containsInAnyOrder(
                new File(rootDir, "dir_walk/dirForWalk/subDir"),
                new File(rootDir, "dir_walk/dirForWalk/subDir/subSubDir")
        ));
    }
}