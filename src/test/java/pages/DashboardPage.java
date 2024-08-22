package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    @FindBy(className = "oxd-userdropdown-img")
    public WebElement imgProfile;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "oxd-userdropdown-icon")
    public WebElement btnProfile;

    @FindBy(className="oxd-userdropdown-name")
    WebElement lblUsername;
    @FindBy(css = "[role=\"menuitem\"]")
    List<WebElement> cbUserMenu;
    @FindBy(linkText = "Logout")
    public WebElement btnLogOut;

    public void doLogout() {
//        btnProfile.click();
//        btnLogOut.click();
        lblUsername.click();
        cbUserMenu.get(3).click();
    }

}