package util;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class ExecutionListener extends RunListener
{


    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println("ExecutionListener : Test " + description.getMethodName() + " completed");
    }

    /**
     *  Called when an atomic test fails.
     * */
    public void testFailure(Failure failure) throws java.lang.Exception
    {
        System.out.println("Execution Listener : Test case failed : "+ failure.getDescription().getMethodName());
    }

}