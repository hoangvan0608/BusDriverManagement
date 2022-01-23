package ITSOL.BusDriverManagement.OOP;

import java.io.Serializable;
import java.util.Scanner;

public class Driver implements Serializable {
    private static int idTemp = 10000;
    private int idDriver;
    private String name;
    private String address;
    private String phone;
    private String level;
    private final static String LEVEL_A = "Trình độ A";
    private final static String LEVEL_B = "Trình độ B";
    private final static String LEVEL_C = "Trình độ C";
    private final static String LEVEL_D = "Trình độ D";
    private final static String LEVEL_E = "Trình độ E";
    private final static String LEVEL_F = "Trình độ F";

    public Driver() {
        this.idDriver = idTemp++;
    }

    public Driver(String name, String address, String phone, String level) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.level = level;
    }

    public void inputDriver()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập họ tên:");
        this.setName(scanner.nextLine());
        System.out.println("Nhập địa chỉ:");
        this.setAddress(scanner.nextLine());
        System.out.println("Số điện thoại");
        this.setPhone(scanner.nextLine());
        boolean checkLevel = false;
        int checklevel = -1;
        do {
            System.out.println("Chọn trình độ:");
            System.out.println("1. "+LEVEL_A);
            System.out.println("2. "+LEVEL_B);
            System.out.println("3. "+LEVEL_C);
            System.out.println("4. "+LEVEL_D);
            System.out.println("5. "+LEVEL_E);
            System.out.println("6. "+LEVEL_F);
            try {
                System.out.print("Nhập trình độ: ");
                checklevel = Integer.parseInt(scanner.nextLine());
                if( checklevel < 0 || checklevel > 6)
                {
                    System.out.println("Vui lòng nhập 1 số nguyên dương trong đoạn [1,6]!");
                    checkLevel = true;

                }
                else
                    checkLevel = false;
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng! Vui lòng nhập 1 số nguyên dương!");
                checkLevel = true;
            }
            switch (checklevel)
            {
                case 1:
                    this.setLevel(LEVEL_A);
                    break;
                case 2:
                    this.setLevel(LEVEL_B);
                    break;
                case 3:
                    this.setLevel(LEVEL_C);
                    break;
                case 4:
                    this.setLevel(LEVEL_D);
                    break;
                case 5:
                    this.setLevel(LEVEL_E);
                    break;
                case 6:
                    this.setLevel(LEVEL_F);
                    break;
            }

        } while (checkLevel);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "idDriver=" + idDriver +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
