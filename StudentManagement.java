import java.util.Scanner;

public class StudentManagement {
    static Scanner sc = new Scanner(System.in);
    static Student students[]=new Student[100];
    static int count =0;
    static void addStudent(){
        System.out.println("Enter ID :");
        int id = sc.nextInt();

        System.out.println("Enter Name :");
        String name = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter Age :");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter course :");
        String course = sc.nextLine();
    

        System.out.println("Enter marks :");
        int marks =sc.nextInt();

        students[count] = new Student(id,name,age,course,marks);
        count++;
         System.out.println("Student Added Successfully.");
    }
    static void viewStudent(){
        if(count==0){
            System.out.println("No Student Found");
        }
        for(int i =0;i<count;i++){
            students[i].display();
        }
    }
    static void searchStudent(){
        System.out.println("Enter Student ID :");
        int id = sc.nextInt();
        boolean found = false;

        for(int i=0;i<count ;i++){
            if(students[i].id == id){
                students[i].display();
                found =true;
                break;
            }
        }if(!found){
            System.out.println("Student not found");
        }
        
    }
    static void updateStudent(){
        System.out.print("Enter Student ID : ");
        int id = sc.nextInt();

        boolean found = false;
        for(int i=0;i<count;i++){
            if(students[i].id == id){
                sc.nextLine();
                System.out.println("Enter new Name :");
                students[i].name = sc.nextLine();
                System.out.print("Enter New Age : ");
                students[i].age = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter New Course : ");
                students[i].course = sc.nextLine();

                System.out.print("Enter New Marks : ");
                students[i].marks = sc.nextInt();

                System.out.println("Student Updated Successfully.");

                found = true;

                break;

            }
        }
        if(!found){
            System.out.println("Student Not Found.");
        }
    }
    static void deleteStudent(){
        System.out.println("Enter Student ID :");
        int id = sc.nextInt();
        boolean found = false;
        for(int i=0;i<count;i++){
            if(students[i].id==id){
                for(int j=i;j<count-1;j++){
                    students[j] = students[j+1];
                }
                students[count-1]=null;
                count--;
                found =true;
                System.out.println("Student Deleted Successfully.");

                break;

            }

        }

        if (!found) {

            System.out.println("Student Not Found.");

        }
    }
    public static void main(String[] args) {
        while(true){
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            switch(choice){
                case 1 ->addStudent();
                case 2 ->viewStudent();
                case 3 ->searchStudent();
                case 4 ->updateStudent();
                case 5 ->deleteStudent();
                case 6 -> {
                    System.out.println("Thank You..");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice");

            }
        }
    }
}
