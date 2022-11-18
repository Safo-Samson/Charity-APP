package church;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.*;
// TODO SET THE PASTOR WELL FOR NAME AND MEMBERSHIP TO BE CERTAIN.
// todo how to add new members to the branch

public class Branch implements KristoAsafo, Comparable<Branch> {

    private String name;
    private String pastor;
    int numberOfBranches;
    //todo List all the other major executives of the church and all of them must be members too so the total will be valid
    private int numOfSabbathSchool =0;
    private int numOfYoka=0;
    private int numOfAdults=0;
    private int numOfElderly=0;
    private int totalnumOfMembers= numOfAdults + numOfElderly + numOfYoka + numOfSabbathSchool;
    //private List<Branch.Member> allMembers = new ArrayList<>();

    public Branch(String branch) {
            if (branch != null && branch.trim().length() > 0) {
                name = branch;
                numberOfBranches++;
                System.out.println("New branch " + branch +" was succesfully created.");
            }
            else{
                System.out.println("Branch name cannot be empty");
            }
        }

    // todo getters and setters
    public int getNumOfSabbathSchool() {
        return numOfSabbathSchool;
    }
    public int getNumOfYoka() {
        return numOfYoka;
    }
    public int getNumOfAdults() {
        return numOfAdults;
    }
    public int getNumOfElderly() {
        return numOfElderly;
    }
    public int getTotalNumOfMembers() {
        return totalnumOfMembers;
    }
    public String getBranchName() {
        return name;
    }
//    public List<Branch.Member> getAllMembers() {
//        return allMembers;
//    }

    @Override
    public String getFounder() {
        return KristoAsafo.FOUNDER;
    }
    @Override
    public String getLeader() {
        return KristoAsafo.LEADER;
    }
    public void setPastor(String first, String last) {
        this.pastor = first + " " + last;
        totalnumOfMembers++;
    }

    public String getPastor() {
        return this.pastor;
    }




    public class Member implements Comparable<Member>{
                private String firstName;
                private String lastName;
                //private String middleName;
                private String name = this.getFirstName() + this.getLastName();
                private int age;
                private String gender;
                private String branch;
                private LocalDate date;

                public Member(String first, String last, String gender, int age, String branch, LocalDate date){
                    this.firstName= setFirstName(first);
                    this.lastName= setLastName(last);
                    this.gender = gender;
                    this.age = age;
                    this.date = date;
                    setBranch(branch);
                    categoryCount(age);
                }

                // todo getters and setters for private fiels

                public String setFirstName(String firstName){
                    return setName(firstName);
                }
                public String setLastName(String lastName){
                    return setName(lastName);
                }
                public void setGender(String gender) {
                    this.gender = gender;
                }
                public String setName(String name) {
                    String callerName = "";
                    if(name!= null && name.trim().length()>0) {
                        callerName += name;
                        return callerName;
                    } else
                        throw new IllegalArgumentException("Name cannot be empty");

                }
                public void setBranch(String branch){
                    if(branch!= null && branch.trim().length()>0) {
                        this.branch = branch;
                    } else
                        throw new IllegalArgumentException("Branch nane cannot be empty");
                }


                public String getFirstName() {
                    return firstName;
                }
                public String getLastName() {
                    return lastName;
                }
                public String getBranch() {
                    return branch;
                }
                public int getAge() {
                    return age;
                }
                public void setAge(int age) {
                    this.age = age;
                }
                public String getGender() {
                    return gender;
                }

                public String getName() {
                        return this.getLastName() + " " + this.getFirstName();
                }

            public LocalDate getDate() {
                return date;
            }

        //Todo Testing category of Member (Yoka, Sabbath School, etc)
                public boolean isSabbathSchool(){
                    return this.age < 18;
                }
                public boolean isYoka(){return  this.age >= 18 && this.age<=35;}
                public boolean isAdult(){
                    return this.age > 35 && this.age <= 60;
                }
                public boolean isElderCitizen(){
                    return this.age > 60;
                }

                public void category(){
                    if (this.isAdult())
                        System.out.println(this.getName() + " belongs to the adult category");
                    else if (this.isSabbathSchool())
                        System.out.println(this.getName() + " belongs to the Sabbath School category");
                    else if (this.isYoka())
                        System.out.println(this.getName() + " belongs to the Yoka category");
                    else
                        System.out.println(this.getName() + " belongs to the Elder citizen category");
                }

                private int categoryCount(int age) {
                        if (age < 18)
                            numOfSabbathSchool++;
                        else if (age >= 18 && age < 36)
                            numOfYoka++;
                        else if (age >= 36 && age <= 60)
                            numOfAdults++;
                        else
                            numOfElderly++;

                    return totalnumOfMembers++;
                }
                //todo creating equals, hashcode, branch
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (!(o instanceof Member)) return false;
                    Member member = (Member) o;

                   return age == member.age && Objects.equals(this.name, member.name) && Objects.equals(gender, member.gender);
                }

                public int hashCode() {
                    return Objects.hash(name, age, gender);
                }

                @Override
                public int compareTo(@NotNull Branch.Member o) {

                     if (this.getName().length() > o.getName().length()) {
                         return 1;
                     }
                     else if (this.getName().length() < o.getName().length())
                         return -1;
                     else
                         return 0;
                }

                public String toString(){
                    return getName();
                }
            }








     public void printAllMembers(List<Member> members){
         Collections.sort(members); // sorts members before printing them out.
        for(Member member: members)
            System.out.println(member.getName());
     }
    @Override
    public int compareTo(@NotNull Branch o) {
        if (this.getBranchName().length() > o.getBranchName().length())
            return 1;
        else if (this.getBranchName().length()< o.getBranchName().length())
            return -1;
        else
             return 0;
    }

    @Override
    public String toString(){
        return this.getBranchName();
    }


}
