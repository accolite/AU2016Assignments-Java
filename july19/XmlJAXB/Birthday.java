package com.accolite.xmldom;

public class Birthday
{
    private String month;

    private String year;

    private String day;

    public Birthday(){
    	
    }
    
    public Birthday(String month, String day, String year){
    	this.month = month;
    	this.year = year;
    	this.day = day;
    }
    
    public String getMonth ()
    {
        return month;
    }

    public void setMonth (String month)
    {
        this.month = month;
    }

    public String getYear ()
    {
        return year;
    }

    public void setYear (String year)
    {
        this.year = year;
    }

    public String getDay ()
    {
        return day;
    }

    public void setDay (String day)
    {
        this.day = day;
    }

    @Override
    public String toString()
    {
        return "[month = "+month+", year = "+year+", day = "+day+"]";
    }
}