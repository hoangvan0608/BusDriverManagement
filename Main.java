package ITSOL.BusDriverManagement;

import ITSOL.BusDriverManagement.OOP.BusNumber;
import ITSOL.BusDriverManagement.OOP.Driver;
import ITSOL.BusDriverManagement.OOP.PlanBus;
import ITSOL.BusDriverManagement.Service.Management;
import ITSOL.BusDriverManagement.fileIO.IOFile;

import java.sql.Connection;
import java.util.*;

public class Main {
    static Scanner scanner =new Scanner(System.in);
    static List<Driver> driverList;
    static List<BusNumber> busNumberList;
    static List<PlanBus> planBusList;
    static Management management = new Management();
    static {
        driverList = IOFile.readObjectFromFile("driverBus.txt");
        busNumberList = IOFile.readObjectFromFile("bus.txt");
        planBusList = IOFile.readObjectFromFile("plan.txt");
    }
    public static void main(String[] args) {
        int choose = -1;
        boolean check = true;
        do {
            try {
                menu();
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose)
                {
                    case 1:
                        management.inputDrivers();
                        driverList = management.getDriverList();
                        IOFile.writeObjectToFile(driverList,"driverBus.txt");
                        break;
                    case 2:
                        if(driverList != null)
                        {
                            management.setDriverList(driverList);
                        }
                        management.showDrivers();
                        break;
                    case 3:
                        management.inputBuses();
                        busNumberList = management.getBusNumberList();
                        IOFile.writeObjectToFile(busNumberList,"bus.txt");
                        break;
                    case 4:
                        if(busNumberList != null)
                        {
                            management.setBusNumberList(busNumberList);
                        }
                        management.showBuses();
                        break;
                    case 5:
                        driverList = management.getDriverList();
                        busNumberList = management.getBusNumberList();
                        management.inputPlan(driverList,busNumberList);
                        planBusList = management.getPlanBusList();
                        IOFile.writeObjectToFile(planBusList,"plan.txt");
                        break;
                    case 6:
                        if(planBusList != null)
                        {
                            management.setPlanBusList(planBusList);
                        }
                        management.showPlan();
                        break;
                    case 7:
                        planBusList = management.getPlanBusList();
                        Collections.sort(planBusList, new Comparator<PlanBus>() {
                            @Override
                            public int compare(PlanBus o1, PlanBus o2) {
                                return o1.getDriver().getName().compareTo(o2.getDriver().getName());
                            }
                        });
                        IOFile.writeObjectToFile(planBusList,"plan.txt");
                        management.showPlan();
                        break;
                    case 8:
                        planBusList = management.getPlanBusList();
                        Collections.sort(planBusList, new Comparator<PlanBus>() {
                            @Override
                            public int compare(PlanBus o1, PlanBus o2) {
                                return o1.getQuantity() - o2.getQuantity();
                            }
                        });
                        IOFile.writeObjectToFile(planBusList,"plan.txt");
                        management.showPlan();
                        break;
                    case 9:
                        management.showDistanceofDrive();
                        break;
                    case 0:
                        System.out.println("Kết thúc chương trình!");
                        check = false;
                        break;
                }
            }
            catch (Exception e)
            {
                System.out.println("Nhap dung chuc nang de su dung!");
                check = true;
            }
        }while (check);

    }
    public static void menu()
    {
        System.out.println("Chon mot trong so cac chuc nang:");
        System.out.println("1. Nhap danh sach lai xe moi");
        System.out.println("2. In danh sach la xe");
        System.out.println("3. Nhap danh sach tuyen xe moi");
        System.out.println("4. In danh sach tuyen xe");
        System.out.println("5. Nhap danh sach phan cong cho cac lai xe");
        System.out.println("6. Hien thi danh sach phan cong");
        System.out.println("7. Sap xep danh sach phan cong lai xe theo ho ten cua lai xe");
        System.out.println("8. Sap xem danh sach phan cong lai xe theo so luong tuyen giam dan");
        System.out.println("9. Thong ke tong khoang cach chay xe trong ngay cua moi lai xe");
        System.out.println("0. Thoát");
        System.out.print("Moi ban lua chon: ");
    }

}
