package ct7liang.android.databasecreate.dateData;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018-08-17.
 *
 */
@Entity
public class Year {

    @Id(autoincrement = true)
    public Long id;

    @NotNull
    private int year;

    @NotNull
    private int days;

    @NotNull
    private int month;

    @NotNull
    private int leapMonth;

    @NotNull
    private String monthType;

    @NotNull
    private int leapMonthDays;

    @Generated(hash = 2037387639)
    public Year(Long id, int year, int days, int month, int leapMonth,
            @NotNull String monthType, int leapMonthDays) {
        this.id = id;
        this.year = year;
        this.days = days;
        this.month = month;
        this.leapMonth = leapMonth;
        this.monthType = monthType;
        this.leapMonthDays = leapMonthDays;
    }

    @Generated(hash = 1750568959)
    public Year() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDays() {
        return this.days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getLeapMonth() {
        return this.leapMonth;
    }

    public void setLeapMonth(int leapMonth) {
        this.leapMonth = leapMonth;
    }

    public String getMonthType() {
        return this.monthType;
    }

    public void setMonthType(String monthType) {
        this.monthType = monthType;
    }

    public int getLeapMonthDays() {
        return this.leapMonthDays;
    }

    public void setLeapMonthDays(int leapMonthDays) {
        this.leapMonthDays = leapMonthDays;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}