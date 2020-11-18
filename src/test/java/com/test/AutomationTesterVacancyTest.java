package com.test;

import com.pageobject.BaseFunc;
import com.pageobject.HomePage;
import com.pageobject.VacanciesPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AutomationTesterVacancyTest {

    private final String URL = "https://ctco.lv/";
    private static final Logger LOGGER = LogManager.getLogger(AutomationTesterVacancyTest.class);

    BaseFunc baseFunc = new BaseFunc();
    VacanciesPage vacancies = new VacanciesPage(baseFunc);
    HomePage homePage = new HomePage(baseFunc);


    @BeforeAll
    void openBrowser() {
        LOGGER.info("Open browser and navigate to https://ctco.lv/");
        baseFunc.navigateTo(URL);
    }

    @Test
     void verifyVacancyRequirements() {
        LOGGER.info("Hover Careers button in menu");
        homePage.hoverCareersButton();
        baseFunc.waitSeconds();

        LOGGER.info("Click on vacancies button in drop-down menu");
        homePage.clickVacanciesButton();
        LOGGER.info("Select test automation engineer vacancy");
        vacancies.clickTestAutomationEngVanancy();

        LOGGER.info("Verify that paragraph under Professional skills and qualification: contains exactly 5 skills");
        assertThat(vacancies.getSkillsAndQualificationListSize()).isEqualTo(5);

    }

    @AfterAll
    void tearDown() {
        LOGGER.info("Close browser");
        baseFunc.closeBrowser();
    }

}
