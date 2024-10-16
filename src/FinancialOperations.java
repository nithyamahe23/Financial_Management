import java.util.*;
import java.util.stream.Collectors;

public class FinancialOperations {

    // 1.Get Hourly Rate
    //Traditional method
    public static double getHourlyRateSum(List<Employee> employees)
    {
        double hourlyRateSum = 0.0;

        for(Employee employee : employees)
        {
            hourlyRateSum += employee.getHourly_rate();
        }
        return hourlyRateSum;
    }

    //Using Lambdas
    public static double getHourlyRateSumLambda(List<Employee> employees)
    {
        double hourlyRateSumLamda = employees.stream().
                                    mapToDouble(Employee :: getHourly_rate).sum();
        return hourlyRateSumLamda;
    }

    // 2. Sum Department Salary
    //Traditional method
    public static double sumDepartmentSalary(List<Employee> employees, String department)
    {
        double sumDepartmentSalary = 0.0;
        for(Employee employee : employees)
        {
            if(department.equals(employee.getDepartment()))
            {
                sumDepartmentSalary += employee.getSalary();
            }
        }
        return sumDepartmentSalary;
    }

    //Using Lambda
    public static double sumDepartmentSalaryLambda(List<Employee> employees, String department)
    {
        double sumDepartmentSalary = employees.stream().filter(employee -> employee.getDepartment().equals(department))
                .mapToDouble(Employee :: getSalary).sum();
        return sumDepartmentSalary;
    }

    // 3. Average salary by department
    // Traditional
    public static double getAverageSalaryByDepartment(List<Employee> employees, String department)
    {
        double totalSalary = 0.0;
        double averageSalary = 0.0;
        int count = 0;
        for(Employee employee : employees)
        {
            if(department.equals(employee.getDepartment()))
            {
                totalSalary += employee.getSalary();
                count += 1;
            }
        }
        averageSalary = totalSalary / count;
        return averageSalary;
    }
    //Lambda
    public static double getAverageSalaryByDepartmentLambda(List<Employee> employees, String department)
    {
        double averageSalaryByDepartment = 0.0;

        averageSalaryByDepartment = employees.stream().
                filter(employee->employee.getDepartment().equals(department))
                                            .//mapToDouble(Employee :: getSalary).average().orElse(0.0);
                        mapToDouble(employee->employee.getSalary()).average().orElse(0.0);

        return averageSalaryByDepartment;
    }

    //4. Sum Department hourly rate
    //Traditional
    public static double sumDepartmentHourlyRate(List<Employee> employees, String department)
    {
        double sumDepartmentHourlyRate = 0.0;
        for(Employee employee : employees)
        {
            if(department.equals(employee.getDepartment()))
            {
                sumDepartmentHourlyRate += employee.getHourly_rate();
            }
        }
        return sumDepartmentHourlyRate;
    }

    //Lambda
    public static double sumDepartmentHourlyRateLambda(List<Employee> employees, String department)
    {
        double sumDepartmentHourlyRate = employees.stream().filter(employee -> department.equals(employee.getDepartment()))
                                            .mapToDouble(Employee :: getHourly_rate).sum();
        return sumDepartmentHourlyRate;
    }

    //5. Average Hourly rate by department
    //Traditional
    public static double getAverageHourlyRateByDepartment(List<Employee> employees, String department)
    {
        double totalHourlyRate = 0.0;
        int count = 0;
        for(Employee employee : employees)
        {
            if(department.equals(employee.getDepartment()))
            {
                totalHourlyRate += employee.getHourly_rate();
                count += 1;
            }
        }
        double averageHourlyRate = totalHourlyRate / count;
        return averageHourlyRate;
    }

    //Lambda
    public static double getAverageHourlyRateByDepartmentLambda(List<Employee> employees, String department)
    {
        double averageHourlyRate = employees.stream().filter(employee -> department.equals(employee.getDepartment())).
                                        mapToDouble(Employee :: getHourly_rate).average().orElse(0.00);
        return averageHourlyRate;
    }

    // 6. Total Salary by Department
    //Traditional
    /*public static Map<String, Double> getTotalSalaryByDepartment(List<Employee> employees)
    {
        Map<String, Double> salaryByDepartmentMap = new HashMap<>();
        double totalSalary = 0.0;
        for(Employee employee : employees)
        {
            totalSalary += employee.getSalary();
            salaryByDepartmentMap.put(employee.getDepartment(), )
        }
        return salaryByDepartmentMap;
    }
*/

    public static Map<String, Double> getTotalSalaryByDepartmentLambda(List<Employee> employees)
    {
        Map<String, Double> salaryByDepartmentMap = new HashMap<>();

        salaryByDepartmentMap = employees.stream().
                collect(Collectors.groupingBy(Employee :: getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));

        return salaryByDepartmentMap;
    }

    //7. Get average salary by department
    public static Map<String, Double> getAverageSalaryByDepartment(List<Employee> employees)
    {
        Map<String, Double> averageSalaryByDepartmentMap = new HashMap<>();
        averageSalaryByDepartmentMap = employees.stream().
                collect(Collectors.groupingBy(Employee :: getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        return averageSalaryByDepartmentMap;
    }

    //8. total hourly rate by department
    public static Map<String, Double> getTotalHourlyRateByDepartment(List<Employee> employees)
    {
        Map<String, Double> totalHourlyRateByDepartmentMap = new HashMap<>();
        totalHourlyRateByDepartmentMap = employees.stream().
                collect(Collectors.groupingBy(Employee :: getDepartment,
                        Collectors.summingDouble(Employee::getHourly_rate)));
        return totalHourlyRateByDepartmentMap;
    }

    //9. Average hourly rate by department
    public static Map<String, Double> getAverageHourlyRateByDepartment(List<Employee> employees)
    {
        Map<String, Double> averageHourlyRateByDepartmentMap = new HashMap<>();
        averageHourlyRateByDepartmentMap = employees.stream().
                collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.averagingDouble(Employee::getHourly_rate )));
        return averageHourlyRateByDepartmentMap;
    }

    //10. Get getSumOfEmployeeIdDigits
    //To calculate sum of digits  4657
    public static int getNumSum(int number)
    {
        int resultSum = 0;

        while(number > 0)
        {
            resultSum += number%10; //get the last digit from the no
            number = number/10; //get the quotient
        }
        return resultSum;
    }
    public static int getSumOfEmployeeIdDigits(List<Employee> employees)
    {
        Set<String> fjndf = new HashSet<>();

       return employees.stream().mapToInt(employee -> getNumSum(employee.getId())).sum();



    }

}
