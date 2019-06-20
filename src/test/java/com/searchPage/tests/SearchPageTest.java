package com.searchPage.tests;

import com.searchmodules.pages.SearchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {
    @Test
    @Parameters({"keyword"})
    public void searchKeyWord(){
        SearchPage search = new SearchPage( driver );
        search.goTo();
        search.doSearch( "java" );
        search.goToVideos();
        int size =search.printResult();
        Assert.assertTrue(size>0);
    }




}
