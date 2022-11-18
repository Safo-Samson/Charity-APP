package church;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Creating Madina Branch".toUpperCase());
        Branch madina = new Branch("Madina ");
        System.out.println();
//
        System.out.println("Testing Set pastor and checking the count".toUpperCase());
        System.out.println(madina);
        madina.setPastor("Danso", " Addy");
        System.out.println("pastor : " + madina.getPastor());
        System.out.println(madina.getTotalNumOfMembers());
        System.out.println();

        System.out.println("Creating new members and checking the count".toUpperCase());
        Branch.Member sam = madina.new Member("Samson ","Safo", "male",22, "madina", LocalDate.of(2000, Month.JULY, 12));
        Branch.Member junior = madina.new Member("James","Zams","male",22, "madina",LocalDate.of(2000, Month.JULY, 12));
        Branch.Member rita = madina.new Member("Rita","Owusu","female",48, "madina",LocalDate.of(2000, Month.JULY, 12));
        Branch.Member nanaNti= madina.new Member("Nana","Nti","male",8, "madina",LocalDate.of(2000, Month.JULY, 12));
        Branch.Member old = madina.new Member("Old", "Old","male", 68,"madina",LocalDate.of(2000, Month.JULY, 12));
//
        System.out.println(madina.getTotalNumOfMembers());
        System.out.println(madina.getNumOfAdults());
        System.out.println(madina.getNumOfElderly());
        System.out.println(madina.getNumOfYoka());
        System.out.println(madina.getNumOfSabbathSchool());
        System.out.println();


        System.out.println("Printing All members of a Branch".toUpperCase());
        List<Branch.Member> madinaMembers = new ArrayList<>();

        madinaMembers.add(sam);
        madinaMembers.add(junior);
        madinaMembers.add(nanaNti);
        madinaMembers.add(old);

           // todo using the comparator
        //Collections.sort(madinaMembers, (s1, s2) -> s1.getAge() > s2.getAge() ? 1 : -1);
        madina.printAllMembers(madinaMembers);

        System.out.println();
//
        System.out.println("Taifa".toUpperCase());
        Branch Taifa = new Branch("Taifa");
        Taifa.setPastor("Robert", "Ntiful");
        System.out.println("Taifa total: "+ Taifa.getTotalNumOfMembers());
        Branch.Member kofyy = Taifa.new Member("Yawfi","Safo", "male", 21, "Taifa", LocalDate.of(2000, Month.JULY, 12));
        Branch.Member sav = Taifa.new Member("Kwame", "Safo", "male", 25, "Taifa",LocalDate.of(2000, Month.JULY, 12));
        Branch.Member mary = Taifa.new Member("Mary", "Safo", "female", 15, "Taifa",LocalDate.of(2000, Month.JULY, 12));
        Branch.Member nanaYaa = Taifa.new Member("Esther", "Safo", "female", 17, "Taifa",LocalDate.of(2000, Month.JULY, 12));
        System.out.println(kofyy.getDate());
//
        System.out.println(Taifa.getTotalNumOfMembers());
        System.out.println(Taifa.getNumOfAdults());
        System.out.println(Taifa.getNumOfElderly());
        System.out.println(Taifa.getNumOfYoka());
        System.out.println(Taifa.getNumOfSabbathSchool());
        System.out.println("Taifa total: "+ Taifa.getTotalNumOfMembers());
        System.out.println();

        List<Branch.Member> taifaMembers = new ArrayList<>();
        taifaMembers.add(kofyy);
        taifaMembers.add(sav);
        taifaMembers.add(mary);
        taifaMembers.add(nanaYaa);
        Taifa.printAllMembers(taifaMembers);
        System.out.println();
        System.out.println();

        System.out.println("combining and printing branches".toUpperCase());
        List<List<Branch.Member>> combined = new ArrayList<>();
        combined.add(madinaMembers);
        combined.add(taifaMembers);

        for(List<Branch.Member> branch: combined){
            for(Branch.Member member: branch)
                System.out.println(member);
        }
        List<Branch.Member> combined2 = new ArrayList<>();

        for(List<Branch.Member> branch: combined){
            for(Branch.Member member: branch)
                combined2.add(member);
        }

        Collections.sort(combined2);
        System.out.println(combined2);
        System.out.println();

        // todo using the priority queue to sort out members based on age (Max heap) not working
        System.out.println("using the priority queue to sort out members based on age".toUpperCase());
        PriorityQueue<Branch.Member> adekanfo = new PriorityQueue<>();

        adekanfo.add(sam);
        adekanfo.add(rita);
        adekanfo.add(old);
        adekanfo.add(nanaNti);
        adekanfo.add(junior);

        Comparator<Branch.Member> ageCompare = new Comparator<Branch.Member>() {
            @Override
            public int compare(Branch.Member o1, Branch.Member o2) {
                if(o1.getAge() > o2.getAge())
                    return -1;
                else if (o1.getAge() < o2.getAge())
                    return 1;
                else
                    return 0;
            }
        };

        //Collections.sort(adekanfo, ageCompare);

        int i = 0;
       while(i < adekanfo.size()){
            Branch.Member nmem = adekanfo.poll();
            System.out.println(nmem +" : " + nmem.getName().length());
        }
        System.out.println();

        System.out.println("Searching for Members in a branch".toUpperCase());
        Collections.sort(madinaMembers);
         int found = Collections.binarySearch(madinaMembers, nanaNti);

        System.out.println("member in branch " + found);
        System.out.println();

        System.out.println("Testing the Mmasuo for members".toUpperCase());
        sam.setY2011(1000);
        System.out.println(sam.getY2015());
        System.out.println();


    }
}
