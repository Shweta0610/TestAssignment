package com.cucumbertest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features"
		,glue = {"stepdefnition"}
		,dryRun= false
		,tags={"@Regression"}
		,monochrome=true
		,plugin={"pretty", "html:Reports"}
		)
public class TestRunner {
		
}
