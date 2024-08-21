import java.util.ArrayList;

abstract class Employee{

    private String name;

    private int id;

    public Employee (String name ,int id)
    {
        this.name=name;
        this.id=id;

    }

    public String getName(){

        return name;
    }

    public int getId(){

        return id;

    }

     public abstract double calculateSalary();

     @Override
      public String toString(){

         return "Employee[name="+name+", id="+id+", salary="+calculateSalary()+"]";
     }

 }

 class FullTimeEmployee extends Employee{



    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){

        super(name, id);
        this.monthlySalary=monthlySalary;
    }
    @Override
     public double calculateSalary(){

        return monthlySalary;
    }
 }

 class PartTimeEmployee extends Employee{

     private int hoursWorked;
      private double hourlyRate;

      public PartTimeEmployee(String name, int id, int hoursWorked,double hourlyRate){

          super(name, id);
          this.hoursWorked=hoursWorked;
          this.hourlyRate=hourlyRate;
      }

      @Override

     public double calculateSalary(){

          return hoursWorked*hourlyRate;

      }

 }

 class PayrollSystem{

       private ArrayList<Employee> employeeList;

       public PayrollSystem(){
            employeeList=new ArrayList<>();

       }

       public void addEmployee(Employee employee){

           employeeList.add(employee);
       }


       public void removeEmployee(int id){
             Employee employeeToRemove= null;

           for (Employee employee : employeeList)
           {
                if (employee.getId()==id)
                {
                    employeeToRemove=employee;
                    break;
                }
           }

           if (employeeToRemove != null){

               employeeList.remove(employeeToRemove);
           }
       }

       public void displayEmployees(){

           for (Employee employee:employeeList)
           {
               System.out.println(employee);
           }

       }
    }
 public class Main {
    public static void main(String [] args)
    {
       PayrollSystem payrollSystem=new PayrollSystem();

        FullTimeEmployee emp1 =new FullTimeEmployee("Gaus",1,70000);

        FullTimeEmployee emp2 =new FullTimeEmployee("Mosin",2,90000);

        FullTimeEmployee emp3 =new FullTimeEmployee("Juned",3,60000);
        FullTimeEmployee emp4 =new FullTimeEmployee("Swapnil",4,50000);
        FullTimeEmployee emp5 =new FullTimeEmployee("Priya",5,30000);



        //PartTimeEmployee emp8  =new PartTimeEmployee("Mosin",8,5,2500);
        //PartTimeEmployee emp9  =new PartTimeEmployee("Mosin",9,5,250);
        //PartTimeEmployee emp10 =new PartTimeEmployee("Mosin",10,5,200);
        //PartTimeEmployee emp11 =new PartTimeEmployee("Mosin",11,5,280); /*



        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);


        //payrollSystem.addEmployee(emp8);
        //payrollSystem.addEmployee(emp9);
        //payrollSystem.addEmployee(emp10);

        System.out.println("Initial Employee Details:-");
        payrollSystem.displayEmployees();


        System.out.println(" Now Removing Employees:-");
        payrollSystem.removeEmployee(2);
        payrollSystem.removeEmployee(9);
        //payrollSystem.removeEmployee(8);
        //payrollSystem.removeEmployee(11);


       System.out.println("Remaining Employee Details:- ");
       payrollSystem.displayEmployees();
    }
}