package com.nira.cucumbertestrunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "com.nira.steps",
		tags = "@orgsetup"
// , dryRun = true
		
)
public class CucumberTestSuite {}

