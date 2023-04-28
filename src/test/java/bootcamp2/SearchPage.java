package bootcamp2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	public WebDriver driver;

	@FindBy(name = "search")
	private WebElement searchBox;

	@FindBy(name = "search")
	private WebElement clickSearchBox;

	@FindBy(css = ".fa.fa-search")
	private WebElement submitButton;

	@FindBy(linkText = "iMac")
	private WebElement existingProduct;

	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criteria.')]")
	private WebElement nonExistingProduct;

	@FindBy(linkText = "Apple Cinema 30\"")
	private WebElement appleCinemaProductName;

	@FindBy(linkText = "MacBook Air")
	private WebElement multipleProduct;

	@FindBy(linkText = "Phones & PDAs")
	private WebElement phonesAndPDAsButton;

	@FindBy(linkText = "Tablets")
	private WebElement tabletsButton;

	@FindBy(linkText = "Software")
	private WebElement softwareButton;

	@FindBy(linkText = "Samsung Galaxy Tab 10.1")
	private WebElement tabletsLinkSearchResult;

	@FindBy(xpath = "//h2[contains(text(),'Software')]")
	private WebElement softwareLinkSearchResult;

	@FindBy(linkText = "HTC Touch HD")
	private WebElement phonesAndPDAsLinkSearchResult;

	@FindBy(linkText = "Desktops")
	private WebElement DesktopsLink;

	@FindBy(linkText = "Laptops & Notebooks")
	private WebElement LaptopsAndNotebooksLink;

	@FindBy(linkText = "Components")
	private WebElement componentsLink;

	@FindBy(linkText = "Cameras")
	private WebElement camerasLink;

	@FindBy(linkText = "MP3 Players")
	private WebElement MP3PlayersLink;

	@FindBy(linkText = "Continue")
	private WebElement verifyWithContinueButton;

	@FindBy(xpath = "//h2[contains(text(),'Mac')]")
	private WebElement sublinkMacPage;

	@FindBy(linkText = "Show AllDesktops")
	private WebElement sublinkShowAllPageDesktops;

	@FindBy(xpath = "//h2[contains(text(),'Macs')]")
	private WebElement sublinkMacsPage;

	@FindBy(linkText = "Windows")
	private WebElement sublinkWindowsPage;

	@FindBy(linkText = "Show AllLaptops & Notebooks")
	private WebElement sublinkShowAllPageLaptops;

	@FindBy(xpath = "//h2[contains(text(),'Mice and Trackballs')]")
	private WebElement sublinkMiceAndTraceballsPage;

	@FindBy(xpath = "//h2[contains(text(),'Monitors')]")
	private WebElement sublinkMonitorsPage;

	@FindBy(xpath = "//h2[contains(text(),'Printers')]")
	private WebElement sublinkPrintersPage;

	@FindBy(xpath = "//h2[contains(text(),'Scanners')]")
	private WebElement sublinkScannersPage;

	@FindBy(xpath = "//h2[contains(text(),'Web Cameras')]")
	private WebElement sublinkWebCameras;

	@FindBy(linkText = "Show AllComponents")
	private WebElement sublinkShowAllPageComponents;

	@FindBy(xpath = "//h2[contains(text(),'MP3 Players')]")
	private WebElement sublinkShowAllMP3Players;

	@FindBy(xpath = "//h2[contains(text(),'Cameras')]")
	private WebElement verifyCamerasLink;

	@FindBy(xpath = "//h2[contains(text(),'Components')]")
	private WebElement verifyShowAllComponents;

	@FindBy(linkText = "PC (0)")
	private WebElement desktopsSubLinkPC;

	@FindBy(linkText = "Mac (1)")
	private WebElement desktopsSubLinkMac;

	@FindBy(linkText = "Show AllDesktops")
	private WebElement desktopsSublinkShowAll;

	@FindBy(linkText = "Macs (0)")
	private WebElement LaptopsAndNotebooksSublinkMacs;

	@FindBy(linkText = "Windows (0)")
	private WebElement laptopsAndNotebooksSublinkWindows;

	@FindBy(linkText = "Show AllLaptops & Notebooks")
	private WebElement LaptopsAndNotebooksSublinkShowAll;

	@FindBy(linkText = "Mice and Trackballs (0)")
	private WebElement componentsSublinkMiceAndTrackballs;

	@FindBy(linkText = "Monitors (2)")
	private WebElement componentsSublinkMonitors;

	@FindBy(linkText = "Printers (0)")
	private WebElement componentsSublinkPrinters;

	@FindBy(linkText = "Scanners (0)")
	private WebElement componentsSublinkScanners;

	@FindBy(linkText = "Web Cameras (0)")
	private WebElement componentsSublinkWebCameras;

	@FindBy(linkText = "Show AllComponents")
	private WebElement componentsSublinkShowAll;

	@FindBy(linkText = "Show AllMP3 Players")
	private WebElement MP3PlayersSublinkShowAll;

	@FindBy(xpath = "//p[contains(text(),'Example of category description text')]")
	private WebElement showAlldesktopsResultVerify;

	@FindBy(xpath = "//h2[contains(text(),\"Laptops & Notebooks\")]")
	private WebElement verifyShowAllLaptopsandNotebook;

	@FindBy(xpath = "//h2[contains(text(),'MP3 Players')]")
	private WebElement verifyShowAllMP3Players;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement typeInSearchBox(String searchText) {
		searchBox.sendKeys(searchText);
		return searchBox;
	}

	public void clickOnSearchBox() {
		clickSearchBox.click();
	}

	public void clickOnSubmitButton() {
		submitButton.click();
	}

	public String camerasLinkDisplayedOrNot() {
		String displayStatus = verifyCamerasLink.getText();
		return displayStatus;
	}

	public String nonExistingProductDisplayedOrNot() {
		String displayStatus = nonExistingProduct.getText();
		return displayStatus;
	}

	public String appleCinemaProductNameDisplayedOrNot() {
		String displayStatus = appleCinemaProductName.getText();
		return displayStatus;
	}

	public String multipleProductDisplayedOrNot() {
		String displayStatus = multipleProduct.getText();
		return displayStatus;
	}

	public WebElement clickOnPhonesAndPDAsButton() {
		phonesAndPDAsButton.click();
		return phonesAndPDAsButton;
	}

	public WebElement clickOnTabletsButton() {
		tabletsButton.click();
		return tabletsButton;
	}

	public WebElement clickOnSoftwareButton() {
		softwareButton.click();
		return softwareButton;
	}

	public String tabletsLinkSearchResultDisplayedOrNot() {
		String displayStatus = tabletsLinkSearchResult.getText();
		return displayStatus;

	}

	public String softwareLinkSearchResultDisplayedOrNot() {
		String displayStatus = softwareLinkSearchResult.getText();
		return displayStatus;

	}

	public String phonesAndPDAsLinkSearchResultDisplayedOrNot() {
		String displayStatus = phonesAndPDAsLinkSearchResult.getText();
		return displayStatus;

	}

	public void clickOnDesktopsButton() {
		DesktopsLink.click();

	}

	public void clickOnLaptopsAndNotebooksButton() {
		LaptopsAndNotebooksLink.click();

	}
}
