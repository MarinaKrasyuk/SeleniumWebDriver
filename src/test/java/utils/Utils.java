package utils;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.Current;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static void takeSnapShot(WebDriver webdriver) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        Date date=new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd_hh.mm.ss");
        String date_str=formatForDateNow.format(date);
        String fileName="./ScreenShot_Folder/"+ date_str+".png";
        FileUtils.copyFile(SrcFile,new File(fileName));

    }
}
