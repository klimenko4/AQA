package ua.kiev.prog.testngexamples;

import org.testng.annotations.Test;

public class TestRuntime {

	@Test(expectedExceptions = {ArithmeticException.class},
			expectedExceptionsMessageRegExp = "/ by zero")
    public void divisionWithException() {
		int i = 1 / 0;
	}

}