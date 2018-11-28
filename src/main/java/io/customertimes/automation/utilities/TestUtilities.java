package io.customertimes.automation.utilities;

public class TestUtilities {
    protected void sleep(long millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
