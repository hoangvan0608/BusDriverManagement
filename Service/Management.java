package ITSOL.BusDriverManagement.Service;

import ITSOL.BusDriverManagement.OOP.BusNumber;
import ITSOL.BusDriverManagement.OOP.Driver;
import ITSOL.BusDriverManagement.OOP.PlanBus;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    BusNumber bus;
    List<BusNumber> busNumberList;
    Driver driver;
    List<Driver> driverList;
    Scanner scanner  = new Scanner(System.in);
    PlanBus planBus;
    List<PlanBus> planBusList;
    public void inputBuses()
    {
        busNumberList = new ArrayList<>();
        String strSum;
        do {
            System.out.println("Nhap so luong xe buyt:");
            strSum = scanner.nextLine();
        }while (!strSum.matches("[0-9]+"));
        int sum = Integer.parseInt(strSum);
        for (int i = 0; i < sum; i++) {
            this.bus = new BusNumber();
            System.out.println("Nhap thong tin cho xe buyt "+this.bus.getIdBus());
            bus.inputBusNumber();
            busNumberList.add(bus);
        }
        System.out.println("Them thanh cong "+sum+ " xe buyt!");
    }
    public void showBuses()
    {
        if (busNumberList == null)
            return;
        else {
            for (int i = 0; i < busNumberList.size(); i++) {
                System.out.println(busNumberList.get(i).toString());
            }
        }
    }
    public void inputDrivers()
    {
        driverList = new ArrayList<>();
        String str;
        do {
            System.out.println("Nhap so luong lai xe:");
            str = scanner.nextLine();
        }while (!str.matches("[0-9]+"));
        int sum = Integer.parseInt(str);
        for (int i = 0; i < sum; i++) {
            this.driver = new Driver();
            System.out.println("Nhap thong tin cho xe buyt "+this.driver.getIdDriver());
            driver.inputDriver();
            driverList.add(driver);
        }
        System.out.println("Them thanh cong "+sum+" lai xe!");
    }
    public void showDrivers()
    {
        if (driverList == null)
            return;
        else {
            for (int i = 0; i < driverList.size(); i++) {
                System.out.println(driverList.get(i).toString());
            }
        }
    }
    public void inputPlan(List<Driver> driverList,List<BusNumber> busNumberList)
    {
        if(driverList == null || busNumberList == null)
        {
            return;
        }
        else {
            planBusList = new ArrayList<>();
            for (int i = 0; i < driverList.size(); i++)
            {
                this.planBus = new PlanBus();
                Driver driver = driverList.get(i);
                this.planBus.setDriver(driver);
                System.out.println("Nhap thon tin cho lai xe "+driver.getIdDriver());
                int countBus = busNumberList.size();
                boolean check1 = true;
                int n=0;
                do {
                    try {
                        System.out.println("Nhap so tuyen xe:");
                        n = scanner.nextInt();
                        if(n > countBus || n < 0)
                        {
                            System.out.println("Nhap lai!");
                            continue;
                        }
                        else
                            check1 = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Nhap lai!");
                        continue;
                    }
                }while (check1);
                BusNumber[] tempBus = new BusNumber[n];
                BusNumber[] localbus = new BusNumber[n];
                int[] soLuots = new int[n];
                int sumSoluot = 0;
                for (int j = 0; j <n; j++) {
                    boolean check = true;
                    do {
                        System.out.println("Nhap ID cua xe buyt: ");
                        int idcheck = scanner.nextInt();
                        BusNumber bus = checkIDBus(busNumberList,idcheck);
                        if(bus == null)
                        {
                            System.out.println("Sai ID!");
                            continue;
                        }
                        else {
                            localbus[j] = new BusNumber();
                            tempBus[j] = bus;
                            if(countIDBus(localbus,idcheck) >0)
                            {
                                System.out.println("Trùng ID!");
                                continue;
                            }
                            else {
                                localbus[j] = bus;
                            }
                        }
                        System.out.println("Nhap so chuyen:");
                        int soluot= scanner.nextInt();
                        soLuots[j] = soluot;
                        check = false;
                    } while (check);
                }
                planBus.setBusNumbers(localbus);
                planBus.setCount(soLuots);
                planBusList.add(planBus);
            }
        }
    }
    public void showPlan()
    {
        for (PlanBus p : planBusList )
            if(p!=null)
                System.out.println(p.toString());
    }
    public void showDistanceofDrive()
    {
        for (int i = 0; i < planBusList.size(); i++) {
            String name = planBusList.get(i).getDriver().getName();
            double cout = 0;
            for (int j = 0; j < planBusList.get(i).getBusNumbers().length; j++) {
                cout+= planBusList.get(i).getBusNumbers()[j].getDistance()*planBusList.get(i).getCount()[j];
            }
            System.out.println("Name "+name + "\tKhoang cach: "+cout+"km");
        }
    }

    public BusNumber checkIDBus(List<BusNumber> list, int id)
    {
        for(BusNumber b : list)
        {
            if(b.getIdBus() == id)
                return b;
        }
        return null;
    }
    public int countIDBus(BusNumber[] list, int id)
    {
        int sl = 0;
        for (BusNumber b: list)
        {
            if(b == null)
                continue;
            else {
                if(b.getIdBus() == id)
                {
                    sl++;
                }
            }

        }
        return sl;
    }

    public BusNumber getBus() {
        return bus;
    }

    public void setBus(BusNumber bus) {
        this.bus = bus;
    }

    public List<BusNumber> getBusNumberList() {
        return busNumberList;
    }

    public void setBusNumberList(List<BusNumber> busNumberList) {
        this.busNumberList = busNumberList;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public PlanBus getPlanBus() {
        return planBus;
    }

    public void setPlanBus(PlanBus planBus) {
        this.planBus = planBus;
    }

    public List<PlanBus> getPlanBusList() {
        return planBusList;
    }

    public void setPlanBusList(List<PlanBus> planBusList) {
        this.planBusList = planBusList;
    }
}
