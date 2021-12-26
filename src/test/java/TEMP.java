import core.shared.RunManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.unit.ParentXPathObject;
import unit.web.mock.MockTestCase;

public class TEMP {

//    @BeforeTest
//    public void initMock() {
//        MockTestCase mockTestCase = new MockTestCase();
//        mockTestCase.init("PROD", "chrome");
//    }
//
//    @Test
//    public void test(){
//        new ParentXPathObject();
//    }

    @Test
    public void test() {
        RunManager runManager = new RunManager();
        runManager.createRunFolder("MobileTest");
    }
}
