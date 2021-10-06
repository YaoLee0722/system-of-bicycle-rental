import java.util.Calendar;
import java.util.Date;

public class CustomerRecord {
    private static int initialNumber = 0;
    private String id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private Date issueDate;
    private boolean goldClass;

    public CustomerRecord(String firstName, String lastName, Date birthday, Date issueDate, boolean goldClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.issueDate = issueDate;
        this.goldClass = goldClass;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);
        if (initialNumber  <= 9) {
            this.id = firstName.substring(0,1) + lastName.substring(0, 1) + "-" + calendar.get(Calendar.YEAR) + "-0" + initialNumber;
        }
        else {
            this.id = firstName.substring(0,1) + lastName.substring(0, 1) + "-" + calendar.get(Calendar.YEAR) + "-" + initialNumber;
        }
        initialNumber ++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public boolean isGoldClass() {
        return goldClass;
    }

    public void setGoldClass(boolean goldClass) {
        this.goldClass = goldClass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge(){
        Calendar now = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        now.setTime(new Date());
        birth.setTime(birthday);
        return now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return "CustomerRecord{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", issueDate=" + issueDate +
                ", goldClass=" + goldClass +
                '}';
    }
}
