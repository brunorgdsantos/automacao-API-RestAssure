package com.dbserver.desafio_tecnico.runner;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.dbserver.desafio_tecnico.apitests.tests")
@IncludeTags("ApiTests")
public class TestsRunner {

}
