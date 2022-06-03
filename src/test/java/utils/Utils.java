package utils;

import com.issoft.education.test.BaseTest;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BaseTest {
    public static void takeSnapShot(WebDriver webdriver) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        Date date=new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd_hh.mm.ss");
        String date_str=formatForDateNow.format(date);
        String fileName="./ScreenShot_Folder/"+ date_str+".png";
        FileUtils.copyFile(SrcFile,new File(fileName));

    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG () {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
