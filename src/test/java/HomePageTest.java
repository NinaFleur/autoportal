import org.junit.Assert;
import org.junit.Test;
import pageobject.HomePage;
import pageobject.SearchResultPage;

public class HomePageTest {

    private HomePage homePage;
    private SearchResultPage searchResults;

    @Test
    public void searchTest() {
        homePage = new HomePage();
        homePage
                .searchForQuery("Tata");

        searchResults = new SearchResultPage();
        searchResults.getSearchResults();
    }


}

