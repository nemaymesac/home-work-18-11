package com.pageobject;

import org.openqa.selenium.WebElement;

import java.util.List;

public class VacanciesPage {

    private static final String testAutEngineerVacancy = "//a[@class='menu-link reload-page' and contains(text(), 'Test Automation')]";
    private static final String skillsAndQualifications = ".//div[@data-href='https://ctco.lv/careers/vacancies/test-automation-engineer-2/']//ul[1]//li";

    private BaseFunc baseFunc;

    public VacanciesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void clickTestAutomationEngVanancy() {
        WebElement element = baseFunc.findElementsByXpath(testAutEngineerVacancy).get(0);
        baseFunc.moveMouseToElement(element);
        element.click();
    }

    public int getSkillsAndQualificationListSize() {
        List<WebElement> elements = baseFunc.findElementsByXpath(skillsAndQualifications);
        return elements.size();
    }

}
