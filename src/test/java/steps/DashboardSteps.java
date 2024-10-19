package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class DashboardSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(dashboardPage.pimMenuButton);
    }

    @Then("drop down menu is displayed")
    public void drop_down_menu_is_displayed() {
        Assert.assertTrue(dashboardPage.dashboardMenu.isDisplayed());
    }
}
