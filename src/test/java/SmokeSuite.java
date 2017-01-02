import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.Smoke;
import tests.testSiute2.Step1PomAccountDemo;

/**
 * Package name PACKAGE_NAME
 * Created by Bharathan on 02/01/17.
 * Project Name AccountDemoQAWorkshop
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(Smoke.class)
@Suite.SuiteClasses(Step1PomAccountDemo.class)
public class SmokeSuite {

}
