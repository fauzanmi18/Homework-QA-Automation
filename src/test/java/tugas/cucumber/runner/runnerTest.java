package tugas.cucumber.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/tugas/cucumber/features",
        glue = {"tugas/cucumber/steps",},
        plugin = {"html:target/HTML_report_test.html"}
        //tags = "@positive"
)
public class runnerTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        // Inisialisasi driver hanya sekali pada awal uji
        if (driver == null) {
            driver = new FirefoxDriver();
        }
    }

    // Menggunakan variabel statis driver dalam skenario
    public static WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public static void tearDown() {
        // Tutup sesi browser hanya setelah semua skenario selesai dijalankan
        if (driver != null) {
            driver.quit();
        }
    }
}
