package com.mailshine.demo.automation;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.RestTestRequestStep;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.support.SoapUIException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.xmlbeans.XmlException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetEmployeesTest {

    private final String PATH = "soapUIXml/";
    private final String GET_EMP_SOAPUI_PROJECT = "DemoProject1-soapui-project.xml";

    @When("^I perform Get Employees Rest API call against the demo endpoint$")
    public void getEmployeeApiCall() throws IOException, SoapUIException, XmlException {
        executeSoapUiTest(GET_EMP_SOAPUI_PROJECT, "EmployeesTestSuite", "Employees TestCase", "Request 1");
    }

    @Then("^I should get a list of employees successfully$")
    public void getEmployeeApiAssertion()  {
        // TODO with soapui junit
    }

    public void executeSoapUiTest(String soapUiProjectName, String testSuiteName, String testCaseName, String testStepName) throws IOException, SoapUIException, XmlException {

        WsdlProject soapUiProject = new WsdlProject("src/test/resources/soapUIXml/DemoProject1-soapui-project.xml");
        WsdlTestSuite testSuite = soapUiProject.getTestSuiteByName(testSuiteName);
        WsdlTestCase testCase =  testSuite.getTestCaseByName(testCaseName);

        for (TestStep testStep: testCase.getTestStepList()){
            if (testStep instanceof RestTestRequestStep){
                //TODO
                //Like set endpoint
                //Like set header etc.
            }
        }

        TestRunner testRunner = testCase.run(new PropertiesMap(), false);
        assertEquals(TestRunner.Status.FINISHED, testRunner.getStatus());
    }
}
