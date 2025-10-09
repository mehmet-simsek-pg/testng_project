package konu_anlatimi;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExample {

    @Parameters({"browser","url"})
    @Test
    public void testWithParameters(String browser, String url) {
        System.out.println("Browser: " + browser);
        System.out.println("URL: " + url);
    }
}
