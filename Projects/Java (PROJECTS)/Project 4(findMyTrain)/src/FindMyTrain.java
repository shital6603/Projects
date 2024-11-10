import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMyTrain {
public static void main(String args[])
    {
        TrainSystem system=new TrainSystem();

        Station station1=new Station("S00333","Agra");

        Station station2=new Station("S0044","Lucknow");

        Train train1=new Train("12408","Duranto Exp","Express");
        Train train2=new Train("12608","Intercity","Passenger");

        PlatForm p1=new PlatForm(1);
        PlatForm p2=new PlatForm(2);

        p1.setTrain(train1);
        p2.setTrain(train2);

        List<PlatForm> platformList=new ArrayList<>();
        platformList.add(p1);
        platformList.add(p2);
        station1.setPlatFormList(platformList);

        Schedule s1=new Schedule(train1,station1, "9AM","9:05AM",p1);
        Schedule s2=new Schedule(train1,station2, "10AM","10:02AM",p2);

        system.addStations(station1);
        system.addStations(station2);
        system.addTrain(train1);
        system.addTrain(train2);
        system.addSchedule(s1);
        system.addSchedule(s2);

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the score :");
        String source=sc.nextLine();
        System.out.println("Enter the destination :");
        String des=sc.nextLine();
        List<Schedule> myTrains=system.finMyTrains(source, des);
        System.out.println("Your Trains Between "+source+" and "+des);
        for (Schedule schedule:myTrains)
        {
            System.out.println(schedule);
        }
    }
}
