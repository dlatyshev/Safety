package io.customertimes.automation.utilities;

public class TestUtilities extends Base {
    protected void sleep(long millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
