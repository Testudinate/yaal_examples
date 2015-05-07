import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import java.io.File;

/**
 * @author yablokov a.
 */
public class YourMojoTest extends AbstractMojoTestCase {
    protected void setUp() throws Exception {
        // required for mojo lookups to work
        super.setUp();
    }

    public void testMojoGoal() throws Exception {
        File testPom = new File(getBasedir(),
                "src/test/resources/unit/basic-test/basic-test-plugin-config.xml");

        ShowTestHierachyMavenPlugin mojo = (ShowTestHierachyMavenPlugin) lookupMojo("hello_world", testPom);

        assertNotNull(mojo);
    }
}
