package ua.education.onu;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by illia on 05.12.14.
 */
public class ActionsWithDate implements ActionWithDate {

    private static Calendar currentCalendar = Calendar.getInstance();
    private static Calendar diffCalendar = Calendar.getInstance();


    @Override
    public  long[] differenceBetween(Date currentdate, Date diffdate) {


    currentCalendar.setTime(currentdate);
    diffCalendar.setTime(diffdate);



    long ms =   currentCalendar.getTimeInMillis()-diffCalendar.getTimeInMillis();

    long seconds = ms/1000;

    long minutes = seconds/60;

    long hours = minutes/60;

    long days = hours/24;

        System.out.println(Math.abs(days) +" "+ Math.abs(hours) + " " + Math.abs(minutes)+ " "+ Math.abs(seconds));

    long array[] = {Math.abs(days),Math.abs(hours),Math.abs(minutes),Math.abs(seconds)};
    return array;
    }

    @Override
    public  int getYestarday(Date date1) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);

        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(date1.getDate());

        if(  date1.getDate()==1){

            calendar.set(date1.getYear(),date1.getMonth()-1,date1.getDay());


            return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);}
        else return (calendar.get(Calendar.DAY_OF_MONTH)-1);


    }

    @Override
    public  int getTommorow(Date date1) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);

       System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
       System.out.println(date1.getDate());

       if( calendar.getActualMaximum(Calendar.DAY_OF_MONTH) == date1.getDate())

        return 1;
        else return (calendar.get(Calendar.DAY_OF_MONTH)+1);
    }

   @Override
    public  boolean equals(Date date1, Date date2) {
        return (date1.equals(date2))? true: false;
    }

    @Override
    public  boolean betweenDates(Date firstdate, Date middleDate, Date lastDate) {

        return ((!middleDate.after(lastDate)&&!middleDate.before(firstdate))||(!middleDate.after(firstdate)&&!middleDate.before(lastDate)))?true: false;
    }



}
