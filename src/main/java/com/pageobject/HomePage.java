package com.pageobject;
import org.openqa.selenium.WebElement;

public class HomePage {
    private static final String careersButton = "menu-item-127";
    private static final String vacanciesFromDropDown = ".//li[@id='menu-item-127']//a[@href='https://ctco.lv/careers/vacancies/']";

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void hoverCareersButton() {
        WebElement element = baseFunc.findElementById(careersButton);
        baseFunc.moveMouseToElement(element);
    }

    public void clickVacanciesButton() {
        WebElement element = baseFunc.findElementByXpath(vacanciesFromDropDown);
        baseFunc.moveMouseToElement(element);
        element.click();
    }

}
