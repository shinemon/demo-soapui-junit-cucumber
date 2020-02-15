package com.mailshine.demo.automation;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"json:target/cucumber.json"},features = {"."}, strict = true)
public class RunCucumberTest {
}
