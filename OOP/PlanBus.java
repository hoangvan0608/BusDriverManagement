package ITSOL.BusDriverManagement.OOP;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class PlanBus implements Serializable {
    Driver driver;
    BusNumber[] busNumbers;
    int[] count;


    public PlanBus(Driver driver, BusNumber[] busNumbers, int[] count) {
        this.driver = driver;
        this.busNumbers = busNumbers;
        this.count = count;
    }

    @Override
    public String toString() {
        return "PlanBus{" +
                "driver=" + driver +
                ", busNumbers=" + Arrays.toString(busNumbers) +
                ", count=" + Arrays.toString(count) +
                '}';
    }

    public PlanBus() {
    }

    public Driver getDriver() {
        return driver;
    }
    public int getQuantity()
    {
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum+=count[i];
        }
        return sum;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public BusNumber[] getBusNumbers() {
        return busNumbers;
    }

    public void setBusNumbers(BusNumber[] busNumbers) {
        this.busNumbers = busNumbers;
    }

    public int[] getCount() {
        return count;
    }

    public void setCount(int[] count) {
        this.count = count;
    }
}
