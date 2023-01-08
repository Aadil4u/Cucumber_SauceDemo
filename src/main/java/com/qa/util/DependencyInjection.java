package com.qa.util;

import com.qa.factory.DriverFactory;
import com.saucedemo.pageobjects.PageObjectManager;
import com.saucedemo.pageobjects.ProductDetailsPage;
import com.saucedemo.pageobjects.ProductsPage;
import com.saucedemo.pageobjects.SummaryPage;

public class DependencyInjection {

    public ProductsPage productsPage;
    public SummaryPage summaryPage;

    public ProductDetailsPage productDetailsPage;

    public PageObjectManager pageObjectManager;


    public DependencyInjection() {
        pageObjectManager = new PageObjectManager(DriverFactory.getDriver());
    }
}
