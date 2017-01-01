import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.Regression;
import tests.testSiute2.Step1PomAccountDemo;

@RunWith(Categories.class)
@Categories.IncludeCategory(Regression.class)
@Suite.SuiteClasses({Step1PomAccountDemo.class})
public class RegressionTestSuite {

}
