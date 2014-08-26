import java.util.Calendar;
import java.util.Date;

public abstract class Employee5 {

    private String name;
    private Date hireDate;

    public Employee5(String aName, Date aHireDate) {
        disallowNullArguments(aName, aHireDate);
        name = aName;
        hireDate = aHireDate;
    }

    protected void disallowNullArguments(Object ... args) {
        boolean shouldThrowException = false;
        for (Object arg: args) {
            if (arg == null) {
                shouldThrowException = true;
            }
        }
        if (shouldThrowException) {
            String msg = "null arguments not allowed. ";
            throw new IllegalArgumentException(msg);
        }
    }

    public abstract double monthlyPay();

    public String getName() {
        return name;
    }

    public Date getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return name + "; " + hireDate;
    }

    // --------------------------------------------------------

    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (!(other instanceof Employee)) return false;
        Employee5 that = (Employee5) other;
        return name.equals(that.name) && hireDate.equals(that.hireDate);
    }

    protected void disallowZeroesAndNegatives(double ... args) {
        boolean shouldThrowException = false;
        String nonPositives = "";
        for (double arg: args) {
            if (arg <= 0.0) {
                shouldThrowException = true;
                nonPositives += arg + " ";
            }
        }
        if (shouldThrowException) {
            String msg = "Following arguments were <= 0: " + nonPositives;
            throw new IllegalArgumentException(msg);
        }
    }
}
