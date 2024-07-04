package vn.edu.likelion.project.day04072024;

import java.util.ArrayList;
import java.util.List;

public class sang {
    @FunctionalInterface
    public interface AvarageDouble{
        double getAvarage(List<Double> list);
    }

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(1.5);
        list.add(2.5);
        list.add(3.9);
        list.add(4.7);
        list.add(5.6);
        list.add(6.3);
        list.add(7.9);

        AvarageDouble avarage = sang::dosomething;
        System.out.println(avarage.getAvarage(list));

    }

    public static double dosomething(List<Double> list){
        int num = 0;
        double sum = 0;
        for (double d : list){
            sum += d;
            num++;
        }
        return sum / num;
    }
}
