import org.junit.runner.JUnitCore;

/**
 * Package name PACKAGE_NAME
 * Created by Bharathan on 02/01/17.
 * Project Name AccountDemoQAWorkshop
 */
public class TestRunner {
    public static JUnitCore runner;

    public static void main(String[] args) {
        runner = new JUnitCore();
        runner.run(SmokeSuite.class);
        runner.run(RegressionSuite.class);
    }

}
