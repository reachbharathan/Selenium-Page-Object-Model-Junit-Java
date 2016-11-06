import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.testSiute2.Step2PomAccountDemo;
import tests.Smoke;
import tests.TestAccountDemoUsingEntityStep6;

@RunWith(Categories.class)
@Categories.IncludeCategory(Smoke.class)
@Suite.SuiteClasses({Step2PomAccountDemo.class, TestAccountDemoUsingEntityStep6.class})
public class SmokeTestSuite {

}
