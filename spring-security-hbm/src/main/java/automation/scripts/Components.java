/*******************************************************************
 * A user specified class, which removes all the dependencies 
 * that may associate with code or tool used
 *******************************************************************/

package automation.scripts;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.thoughtworks.selenium.SeleneseTestBase;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;

public class Components extends SeleneseTestBase {

    public static final String TIMEOUT = "120000";
    public Logger logger = Logger.getRootLogger();
    public static ThreadLocal<Selenium> selenium = new ThreadLocal<Selenium>();
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

    // public static DefaultSelenium selenium;
    public static ChromeDriverService service;
    // public static ThreadLocal<WebDriver> driver = new
    // ThreadLocal<WebDriver>();
    public String Chromeflag = "";
    public static File CurrentPath = new File("");
    public static final File PROJECT_PATH = new File(CurrentPath.getAbsolutePath());

    public String ObjectFile = "";

    /**
     * Test execution begins from this method. Selenium server is started and the session is instantiated.
     */
    @Parameters({ "hostname", "Browser", "URL" })
    @BeforeSuite(groups = { "demo", "multiEnvironment" }, description = "To initialize parameters in Components")
    public void startUp(String hostname, String browser, String URL) throws IOException, Exception, SeleniumException {

        RemoteWebDriver dri = driver.get();
        Selenium sel = selenium.get();

        if (browser.equalsIgnoreCase("*firefox")) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            dri = new RemoteWebDriver(new URL("http://" + hostname + ":4444/wd/hub"), capabilities);
            driver.set(dri);
            logger.info("started firefox browser on host" + hostname);
        } else if (browser.equalsIgnoreCase("*iehta")) {

            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            dri = new RemoteWebDriver(new URL("http://" + hostname + ":4444/wd/hub"), capabilities);
            driver.set(dri);
            logger.info("started IE browser on host" + hostname);
        }

        else if (browser.equalsIgnoreCase("*googlechrome")) {
            Chromeflag = "*googlechrome";
            service = new ChromeDriverService.Builder().usingDriverExecutable(new File(PROJECT_PATH + "/utils/chromedriver_win_16.0.902.0/chromedriver.exe"))
                    .usingAnyFreePort().build();
            service.start();

            driver.set(new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome()));
        }

        sel = new WebDriverBackedSelenium(driver.get(), URL);
        selenium.set(sel);

        selenium.get().setTimeout("120000");
        logger.info("Browser is: " + browser);
        logger.info("Session is: " + selenium.get());

    }

    /**
     * After all the tests are run, this method is called and it stops the selenium server
     */
    @AfterSuite
    public void shutdown() throws IOException {
        logger.info("Session is while shutting down: " + selenium.get());
        if (selenium.get() != null) {

            driver.get().close();
        }

        if (Chromeflag.equalsIgnoreCase("*googlechrome")) {
            Chromeflag = null;
            service.stop();

        }
        logger.info("End Of Execution ");

    }

    /******************************************* COMPONENT FUNCTIONS *****************************************************/

    /**
     * @getPage method gets the required page
     * 
     * @param name
     *            is the name of the page to be opened
     */
    public void getPage(String name) throws InterruptedException, SeleniumException, AssertionError, SQLException, Exception, IOException {
        selenium.get().open(name);
        pauseExecution("2000");

    }

    public void pressEnter(String obj) throws InterruptedException, SQLException {

        selenium.get().keyPress(obj, "\n");
        pauseExecution("2000");

    }

    /**
     * @click method clicks the object and opens the corresponding action
     * 
     * @param name
     *            is the value in the Object reference table
     */
    public void click(String name) throws SeleniumException, AssertionError, SQLException {
        // selenium.click(name);
        driver.get().findElement(By.xpath(name)).click();
    }

    /**
     * @click method clicks the object and opens the corresponding action
     * 
     * @param name
     *            is the value in the Object reference table
     */
    public void clickAndWait(String name, String Expected) throws InterruptedException, SeleniumException, AssertionError, SQLException {
        selenium.get().click(name);
        // driver.get().findElement(By.xpath(name)).click();
        pauseExecution(Expected);
    }

    /**
     * @clickCheck method clicks the object and verifies and make sure the page is directed to right page
     * 
     * @param name
     *            is the value in the Object reference table
     * @param Title
     *            is the title name of the redirected page
     */
    public void clickAndVerifyTitle(String name, String Title) throws InterruptedException, SeleniumException, AssertionError, SQLException {
        selenium.get().click(name);
        waitForPageToLoad("120000");
        assertEquals(selenium.get().getTitle(), Title);
    }

    public void clickAndVerifyElement(String name, String objName) throws InterruptedException, SeleniumException, AssertionError, SQLException {
        selenium.get().click(name);
        waitForPageToLoad("120000");
        assertTrue(selenium.get().isElementPresent(objName));
    }

    public void clickAndVerifyAlert(String name, String Text) throws InterruptedException, SeleniumException, AssertionError, SQLException {
        selenium.get().click(name);
        pauseExecution("10000");
        assertEquals(selenium.get().getAlert(), Text);
    }

    /**
     * @enterValue enters the value in the text field based on the object
     * 
     * @param name
     *            is the name value in the Object Reference Table
     * @param Text
     *            is the text that is entered into the Text Field
     * 
     */
    public void enterValue(String name, String Text) throws SeleniumException, AssertionError, SQLException {
        if (Text.equals("Blank")) {
            selenium.get().type(name, "");
        } else if (Text.equals("RandomID")) {
            selenium.get().type(name, "tester" + GetRandomString() + "@testing.com");
        } else if (Text.equals("RandomString")) {
            selenium.get().type(name, "tester" + GetRandomString());
        } else {

            selenium.get().type(name, Text);
        }

    }

    /**
     * @verifyValue Verifies the value in the text field is equal to the actual value
     * 
     * @param name
     *            is the name value in the Object Reference Table
     * @param Text
     *            is the text that is entered into the Text Field
     */
    public void verifyValue(String name, String Text) throws SeleniumException, AssertionError, SQLException {
        assertEquals(selenium.get().getValue(name), Text);
    }

    /**
     * @wait method waits for the page to load for a given time
     * 
     * @param Time
     *            is the time the page waits for
     */
    public void waitForPageToLoad(String Time) throws SeleniumException, AssertionError, SQLException {
        selenium.get().waitForPageToLoad(Time);
    }

    /**
     * @wait method waits for the page to load for a given time
     * 
     * @param component
     *            is the time the page waits for
     * @throws InterruptedException
     */
    public void pauseExecution(String Expected) throws InterruptedException, SQLException {
        Thread.sleep(Integer.parseInt(Expected));
    }

    /**
     * @verifyText method verifies whether the text is entered or not
     * 
     * @param Text
     *            The text to be entered
     */
    public void verifyText(String Text) throws SeleniumException, AssertionError, SQLException {
        assertTrue(selenium.get().isTextPresent(Text));

    }

    /**
     * @verifyElement method verifies whether the text is entered or not
     * 
     * @param Text
     *            The text to be entered
     */
    public void verifyElement(String Text) throws InterruptedException, SeleniumException, AssertionError, SQLException {
        assertTrue(selenium.get().isElementPresent(Text));
        pauseExecution("3000");

        // checkForVerificationErrors();
    }

    public void getAllElements() throws SeleniumException, AssertionError, SQLException {
        logger.info(selenium.get().getAllButtons());
        logger.info(selenium.get().getAllFields());
        logger.info(selenium.get().getAllLinks());
    }

    public void Check(String xpath1) {
        if (!driver.get().findElement(By.xpath(xpath1)).isSelected()) {
            driver.get().findElement(By.xpath(xpath1)).click();

        }
    }

    public void Uncheck(String xpath1) {
        if (driver.get().findElement(By.xpath(xpath1)).isSelected()) {
            driver.get().findElement(By.xpath(xpath1)).click();
        }
    }

    public void verifyChecked(String name) throws SeleniumException, AssertionError, SQLException {
        assertTrue(selenium.get().isChecked(name));
    }

    public void verifyNotChecked(String name) throws SeleniumException, AssertionError, SQLException {
        assertFalse(selenium.get().isChecked(name));
    }

    public void close() {
        selenium.get().close();
    }

    public void select(String selectLocator, String optionLocator) throws SeleniumException, AssertionError, SQLException {
        selenium.get().select(selectLocator, "label=" + optionLocator);
    }

    public void waitForElementPresent(String objName) throws InterruptedException, SeleniumException, AssertionError, SQLException {

        for (int second = 0;; second++) {
            if (second >= 60)
                fail("timeout");
            try {
                if (selenium.get().isElementPresent(objName))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        pauseExecution("1000");

    }

    public void waitForTextPresent(String Objid, String name) throws InterruptedException, SeleniumException, AssertionError, SQLException {

        for (int second = 0;; second++) {
            if (second >= 60)
                fail("timeout");
            try {
                if (name.equals(selenium.get().getText(Objid)))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        // try {pauseExecution(10000);} catch (Exception e){}
        pauseExecution("1000");
    }

    public void answerOnNextPrompt(String descr) throws SeleniumException, SQLException {

        Alert alert = driver.get().switchTo().alert();
        alert.sendKeys(descr);
        alert.accept();
    }

    public void getPrompt(String Text) throws SeleniumException, AssertionError, SQLException {

        assertEquals(selenium.get().getPrompt(), Text);
    }

    public void chooseCancelOnNextConfirmation(String name, String Expected) throws InterruptedException, SeleniumException, AssertionError, SQLException {
        selenium.get().chooseCancelOnNextConfirmation();
        selenium.get().click(name);
        // selenium.getConfirmation();
        assertTrue(selenium.get().getConfirmation().matches(Expected));
        pauseExecution("5000");
    }

    public void chooseOkOnNextConfirmation(String name, String Expected) throws InterruptedException, SeleniumException, AssertionError, SQLException {

        selenium.get().chooseOkOnNextConfirmation();
        selenium.get().click(name);

        assertTrue(selenium.get().getConfirmation().matches(Expected));
        pauseExecution("20000");
    }

    public void chooseOkOnNextConfirmation1(String name, String Expected) throws InterruptedException, SeleniumException, AssertionError, SQLException {

        selenium.get().click(name);
        selenium.get().chooseOkOnNextConfirmation();

        assertEquals(Expected, selenium.get().getConfirmation());
    }

    public void assertText(String obj, String Text) throws SeleniumException, AssertionError, SQLException {

        assertEquals(selenium.get().getText(obj), Text);
    }

    public void assertEditable(String objName, String flag) throws InterruptedException, SeleniumException, AssertionError, IllegalMonitorStateException,
            SQLException {

        if (flag.equalsIgnoreCase("true"))
            assertTrue(selenium.get().isEditable(objName));
        else if (flag.equalsIgnoreCase("false"))
            assertFalse(selenium.get().isEditable(objName));
        pauseExecution("3000");
    }

    /**
     * @getRandomString method generates a unique random string
     * @return
     */
    public static String GetRandomString() {
        String RandomString = null;
        Calendar objCalendar = new GregorianCalendar();
        RandomString = Integer.toString(objCalendar.get(Calendar.MONTH) + 1) + Integer.toString(objCalendar.get(Calendar.DATE))
                + Integer.toString(objCalendar.get(Calendar.YEAR)) + Integer.toString(objCalendar.get(Calendar.HOUR))
                + Integer.toString(objCalendar.get(Calendar.MINUTE)) + Integer.toString(objCalendar.get(Calendar.SECOND));

        return RandomString;
    }

    public static void testScreenShot1(String path) throws InterruptedException, SeleniumException, AssertionError, IllegalMonitorStateException, IOException {
        // removed VTR
    }
}
