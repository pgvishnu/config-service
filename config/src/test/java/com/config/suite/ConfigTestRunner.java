package com.config.suite;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 * The ConfigTestRunner class.
 * @author pgvishnu
 *
 */
public class ConfigTestRunner {

	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ConfigTestSuite.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println("Config Application Junits results successful?" + result.wasSuccessful());

	}

}
