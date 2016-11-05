import org.junit.runner.JUnitCore;
import util.ExecutionListener;

public class ExecuteWithListener
{
    public static void main(String[] args)
    {
        JUnitCore runner = new JUnitCore();
        //Adding listener here
        runner.addListener(new ExecutionListener());
        runner.run(SmokeTestSuite.class);
    }
}