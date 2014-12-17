package ua.education.onu;

import java.util.Date;

/**
 * Created by illia on 05.12.14.
 */
public interface ActionWithDate {

    public  long[] differenceBetween(Date currentdate, Date diffdate);

    public int getYestarday(Date date1);

    public int getTommorow(Date date1);

    public boolean equals(Date date1, Date date2);

    public boolean betweenDates(Date firstdate, Date middleDate, Date lastDate);



}
