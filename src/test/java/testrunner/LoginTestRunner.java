package testrunner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.io.FileReader;
import java.io.IOException;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    DashboardPage dashboard;

    @Test(priority = 1, description = "Admin can't login without valid username")
    public void doLoginWithWrongUsername(){
        loginPage=new LoginPage(driver);
        loginPage.doLogin("anika", "wrongpass");
        String textActual = driver.findElement(By.className("oxd-alert-content-text")).getText();
        String textExpected="Invalid credentials";
        Assert.assertTrue(textActual.contains(textExpected));
    }

    @Test(priority = 2, description = "Admin can't login without valid password")
    public void doLoginWithWrongPassword(){
        loginPage=new LoginPage(driver);
        loginPage.doLogin("Admin", "wrongpass");
        String textActual = driver.findElement(By.className("oxd-alert-content-text")).getText();
        String textExpected="Invalid credentials";
        Assert.assertTrue(textActual.contains(textExpected));
    }

    @Test(priority = 3, description = "Login successfully with valid credentials", groups = "smoke")
    public void doLogin() throws InterruptedException, IOException, ParseException {
        loginPage = new LoginPage(driver);
        JSONArray empArray = Utils.readJSONArray("./src/test/resources/Employees.json");
        JSONObject empObj = (JSONObject) empArray.get(0);
        loginPage.doLogin(empObj.get("username").toString(), empObj.get("password").toString());
        dashboard = new DashboardPage(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashboard.imgProfile.isDisplayed());
        Thread.sleep(3000);
        String urlActual = driver.getCurrentUrl();
        String urlExpected = "/index.php/dashboard/index";
        softAssert.assertTrue(urlActual.contains(urlExpected));
        softAssert.assertAll();
    }

    @AfterTest(groups = "smoke")
    public void doLogout() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.doLogout();
    }
}