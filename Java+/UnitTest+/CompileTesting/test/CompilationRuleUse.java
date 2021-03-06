import com.google.testing.compile.CompilationRule;
import org.junit.Rule;
import org.junit.Test;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import static org.junit.Assert.assertNotNull;

/**
 * Использование правила CompilationRule.
 */
public class CompilationRuleUse {
    @Rule
    public CompilationRule rule = new CompilationRule();

    @Test
    public void testName() {
        Elements elements = rule.getElements();
        assertNotNull(elements);

        Types types = rule.getTypes();
        assertNotNull(types);

        TypeElement typeElement = elements.getTypeElement("GenerateProcessor");
        assertNotNull(typeElement);
    }
}
