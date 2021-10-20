package br.ce.williamsaito.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/cenarios.feature",
		glue = "br.ce.williamsaito.steps",
		plugin = {"pretty", "json:target/report.json"},
		monochrome = true,
		dryRun = false
		)

public class RunnerAPI {

}
