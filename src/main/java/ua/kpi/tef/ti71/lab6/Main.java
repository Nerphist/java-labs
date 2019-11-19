package ua.kpi.tef.ti71.lab6;

import ua.kpi.tef.ti71.lab6.entity.Test;
import ua.kpi.tef.ti71.lab6.utils.ObservableList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ObservableList<Test> list = new ObservableList<>();
        list.getObservable().subscribe(test -> {
            System.out.println(new CheckTest(test).getfullResult());
        });
        TestFabric testFabric = new TestFabric();
        var scanner = new Scanner(System.in);
        boolean isInterrupted = false;
        while (!isInterrupted){
            System.out.println("What test do you want to solve? (M - Math / L - Language / E - exit)");
            var choice = scanner.nextLine().trim();
            Test newTest;
            switch (choice){
                case "M":
                    choice = "Math";
                    break;
                case "L":
                    choice = "Language";
                    break;
                default:
                    isInterrupted = true;
                    break;
            }
            newTest = testFabric.getTestByName(choice);
            list.add(newTest);
        }
    }

}
