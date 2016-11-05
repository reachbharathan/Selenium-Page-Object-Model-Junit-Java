import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.PaymentTestExtendingBaseTestReadingFromConfigFileStep4;
import tests.Smoke;
import tests.TestAccountDemoUsingEntityStep6;


@RunWith(Categories.class)
@Categories.IncludeCategory(Smoke.class)
@Suite.SuiteClasses({PaymentTestExtendingBaseTestReadingFromConfigFileStep4.class , TestAccountDemoUsingEntityStep6.class})
public class SmokeTestSuite {

}
