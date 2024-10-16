import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Read the employees from CSV
        List<Employee> employees = CSVReader.readEmployeesFromCSV("financial_management_system.csv");

        // 1. Get Hourly rate

        System.out.println("-----Hourly Rate------");
        double hourlyRateTraditional = FinancialOperations.getHourlyRateSum(employees);
        double hourlyRateLambda = FinancialOperations.getHourlyRateSumLambda(employees);
        System.out.println("Hourly Rate Traditional : " + hourlyRateTraditional);
        System.out.println("Hourly Rate Lambda : " + hourlyRateLambda);

        // 2. Sum Department Salary

        System.out.println("-------Sum Department Salary--------");
        double sumDepartmentSalaryTraditional = FinancialOperations.sumDepartmentSalary(employees, "Finance");
        double sumDepartmentSalaryLambda = FinancialOperations.sumDepartmentSalaryLambda(employees, "Finance");
        System.out.println("Sum Department Salary Traditional : " + sumDepartmentSalaryTraditional);
        System.out.println("Sum Department Salary Lambda : " + sumDepartmentSalaryLambda);

        //3. Average Salary By Department
        System.out.println("-------Average Salary By Department---------");
        double avgSalaryByDepartmentTraditional = FinancialOperations.getAverageSalaryByDepartment(employees, "Finance");
        double avgSalaryByDepartmentLambda = FinancialOperations.getAverageSalaryByDepartmentLambda(employees, "Finance");
        System.out.println("Average Salary By Department Traditional: " + avgSalaryByDepartmentTraditional);
        System.out.println("Average Salary By Department Lambda: " + avgSalaryByDepartmentLambda);

        //4. Sum department hourly rate
        System.out.println("-------Sum Department hourly Rate---------");
        double sumDepartmentHourlyRateTraditional = FinancialOperations.sumDepartmentHourlyRate(employees, "Finance");
        double sumDepartmentHourlyRateLambda = FinancialOperations.sumDepartmentHourlyRateLambda(employees, "Finance");
        System.out.println("Sum Department Hourly Rate Traditional: " + sumDepartmentHourlyRateTraditional);
        System.out.println("Sum Department Hourly Rate Lambda: " + sumDepartmentHourlyRateLambda);

        //5.Average Hourly rate by department
        System.out.println("-------Average Department hourly Rate---------");
        double averageDepartmentHourlyRateTraditional = FinancialOperations.getAverageHourlyRateByDepartment(employees, "Finance");
        double averageDepartmentHourlyRateLambda = FinancialOperations.getAverageHourlyRateByDepartmentLambda(employees, "Finance");
        System.out.println("Average Department Hourly Rate Traditional: " + averageDepartmentHourlyRateTraditional);
        System.out.println("Average Department Hourly Rate Lambda: " + averageDepartmentHourlyRateLambda);

        //6. Total Salary By Department
        System.out.println("-------Total Salary By Department---------");
        Map<String, Double> totalSalaryByDepartment = FinancialOperations.getTotalSalaryByDepartmentLambda(employees);
        System.out.println(totalSalaryByDepartment);

        //7.Get average salary by department
        System.out.println("-------Average Salary By Department---------");
        Map<String, Double> avgSalaryByDepartment = FinancialOperations.getAverageSalaryByDepartment(employees);
        System.out.println(avgSalaryByDepartment);

        //8.total hourly rate by department
        System.out.println("-------Total Hourly Rate By Department---------");
        Map<String, Double> totalHourlyRateByDepartment = FinancialOperations.getTotalHourlyRateByDepartment(employees);
        System.out.println(totalHourlyRateByDepartment);

        //9.average hourly rate by department
        System.out.println("-------Average Hourly Rate By Department---------");
        Map<String, Double> avgHourlyRateByDepartment = FinancialOperations.getAverageHourlyRateByDepartment(employees);
        System.out.println(avgHourlyRateByDepartment);

        //10. Get sum of employee ID digits
        System.out.println("-------Sum of Employee ID digits---------");
        int sum = FinancialOperations.getSumOfEmployeeIdDigits(employees);
        System.out.println(sum);

        //Write the employees of department to csv
        List<Employee> hrDept = employees.stream().filter(employee -> employee.getDepartment().equals("HR")).toList();
        CSVWriter.writeEmployeesToCSV(hrDept, "output_hr_employees_csv");

        List<Employee> financeDept = employees.stream().filter(employee -> employee.getDepartment().equals("Finance")).toList();
        CSVWriter.writeEmployeesToCSV(financeDept, "output_finance_employees_csv");

        List<Employee> salesDept = employees.stream().filter(employee -> employee.getDepartment().equals("Sales")).toList();
        CSVWriter.writeEmployeesToCSV(salesDept, "output_sales_employees_csv");

        List<Employee> marketingDept = employees.stream().filter(employee -> employee.getDepartment().equals("Marketing")).toList();
        CSVWriter.writeEmployeesToCSV(marketingDept, "output_marketing_employees_csv");

        List<Employee> operationsDept = employees.stream().filter(employee -> employee.getDepartment().equals("Operations")).toList();
        CSVWriter.writeEmployeesToCSV(operationsDept, "output_operations_employees_csv");
    }
}
