package com.home.feeds;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronExpression;

public class CronJobSchedule {

    public static void main(String[] args) throws ParseException {

        CronExpression exp = new CronExpression("0 0 * * * ? *");
        Date nextFire = exp.getNextValidTimeAfter(new Date());
        System.out.println(nextFire);
    }
}
