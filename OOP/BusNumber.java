package ITSOL.BusDriverManagement.OOP;

import java.io.Serializable;
import java.util.Scanner;

public class BusNumber implements Serializable {
    private static int IdTEMP = 100;
    private int idBus;
    private double distance;
    private int totalPoints;

    public void inputBusNumber()
    {
        Scanner scanner = new Scanner(System.in);
        String strDistance;
        do {
            System.out.println("Nhập Khoảng cách:");
            strDistance = scanner.nextLine();
        }while (!strDistance.matches("[0-9]+([.][0-9]+)?"));
        this.setDistance(Double.parseDouble(strDistance));
        String strPoints;
        do {
            System.out.println("Nhập số điểm dừng:");
            strPoints = scanner.nextLine();
        }while (!strPoints.matches("[0-9]+"));
       this.setTotalPoints(Integer.parseInt(strPoints));
    }

    @Override
    public String toString() {
        return "BusNumber{" +
                "idBus=" + idBus +
                ", distance=" + distance +
                "km, totalPoints=" + totalPoints +
                '}';
    }

    public BusNumber() {
        this.idBus = IdTEMP++;
    }

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
