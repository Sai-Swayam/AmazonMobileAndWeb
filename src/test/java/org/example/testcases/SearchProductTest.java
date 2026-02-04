package org.example.testcases;

import org.example.testcases.helpers.SearchProductTestHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends BaseTest{
    @Test
    public void testSearch() throws InterruptedException {
        String actual = SearchProductTestHelper.helperSearchForProduct(driver, "Philips air fryer\n");
        Assert.assertEquals(actual, "temp test data");
//        Thread.sleep(4000);
    }
}
