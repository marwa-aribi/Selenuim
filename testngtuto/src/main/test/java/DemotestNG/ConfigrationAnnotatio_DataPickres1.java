package DemotestNG;

import org.testng.annotations.*;

public class ConfigrationAnnotatio_DataPickres1 {
    @Test
    public void test1_bootstrap_DataPicker(){
        System.out.println("test methode 1:bootstrapDataPickres ");
    }
    @Test
    public void test2_jquery_DataPicker(){
        System.out.println("test methode 2:jqueryDataPickres ");
    }
    @BeforeTest
    public void beformethode(){
        System.out.println("excute befor each methode  ");
    }

    @AfterMethod
    public void aftermethod()  {
    System.out.println("excute after each methode  ");
    }
}
