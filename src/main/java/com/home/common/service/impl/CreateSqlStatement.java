package com.home.common.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CreateSqlStatement {

    public static Integer processId = 21221;

    static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
    static SimpleDateFormat sql_formatter = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");

    static {
        Map<Integer, List<Integer>> serverCronMap = new HashMap<Integer, List<Integer>>();
        List<Integer> cronList = null;
        int count = 1;
        for (int i = 0; i < 8; i++) {
            cronList = new ArrayList<Integer>();
            for (int j = 0; j < 5; j++) {
                cronList.add(count++);
            }
            serverCronMap.put(i, cronList);
        }
    }

    public static String createCronLogQuery(int cron_id, int server_id, String start_time, String end_time,
            int run_time, int threshold, int processId) {
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO cron_log_history ( cron_id,server_id,start_time,end_time,run_time,threshold,processId ) VALUES (");
        sb.append(cron_id
                + ","
                + server_id
                + ",'"
                + start_time
                + "','"
                + end_time
                + "',"
                + run_time
                + ","
                + (cron_id % 3 == 0 ? threshold : (cron_id % 2 == 0 ? (threshold + new Random().nextInt(threshold / 2))
                        : (threshold - new Random().nextInt(threshold / 2)))) + "," + processId);
        sb.append(")");
        return sb.toString();
    }

    public static String createCronForCastQuery(int cron_id, int server_id, String start_time, String end_time,
            int run_time, int threshold, int processId) {
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO cron_forecasting ( cron_id,server_id,start_time,end_time,run_time ) VALUES (");
        sb.append(cron_id + "," + server_id + ",'" + start_time + "','" + end_time + "'," + run_time);
        sb.append(")");
        return sb.toString();
    }

    public static String createCronAlertQuery(int cron_id, int server_id, String start_time, String end_time,
            int run_time, int threshold, int processId) {
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO cron_alert(cron_id,server_id,dc_id,description,start_time,end_time,run_time,threshold) VALUES (");
        sb.append(cron_id
                + ","
                + server_id
                + ","
                + server_id
                + ",'"
                + getDescription(cron_id)
                + "','"
                + start_time
                + "','"
                + end_time
                + "',"
                + run_time
                + ","
                + (cron_id % 3 == 0 ? threshold : (cron_id % 2 == 0 ? (threshold + new Random().nextInt(threshold / 2))
                        : (threshold - new Random().nextInt(threshold / 2)))));
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, ParseException {

        // String logFileName = "cronLogHistory.1.csv";
        // String OutputlogFileName = "cronloghistory.sql";
        // Integer result = 1;

//        String logFileName = "cronForecasting.1.csv";
//        String OutputlogFileName = "cronAlert.sql";
//        Integer result = 2;

        String logFileName = "cronForecasting.1.csv";
        String OutputlogFileName = "cronForecasting.sql";
        Integer result = 3;

        File file = new File(logFileName);
        BufferedWriter bw = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;
            line = reader.readLine();

            File outputFile = new File(OutputlogFileName);
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(outputFile.getAbsoluteFile()));

            while ((line = reader.readLine()) != null) {
                String tokens[] = line.trim().split(",");
                String startTime = tokens[1];
                Date date = sql_formatter.parse(startTime);
                Integer executionTime = (int) Double.parseDouble(tokens[2]);
                long endTimeLong = date.getTime() + executionTime;
                Date endTime = new Date(endTimeLong);
                String endTimeString = sql_formatter.format(endTime);
                Integer threadShould = 0;
                if (tokens.length > 3) {
                    threadShould = Integer.parseInt(tokens[3]);
                } else {
                    threadShould = (int) executionTime;
                }
                for (int i = 1; i < 40; i++) {
                    switch (result) {
                        case 1:
                            writeData(
                                    createCronLogQuery(i, 0, startTime, endTimeString, executionTime, threadShould,
                                            processId++), bw);
                            break;
                        case 2:
                            writeData(
                                    createCronAlertQuery(i, 0, startTime, endTimeString, executionTime, threadShould,
                                            processId++), bw);
                            break;

                        case 3:
                            writeData(
                                    createCronForCastQuery(i, 0, startTime, endTimeString, executionTime, threadShould,
                                            processId++), bw);
                            break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            bw.close();
            reader.close();
        }
    }

    public static void writeData(String writeData, BufferedWriter bw) {
        try {
            bw.write(writeData + ";\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDescription(Integer cronId) {
        cronId = cronId % 10;
        String alertMessage = "";
        switch (cronId) {
            case 1:
                alertMessage = "Not able to get connection.";
                break;
            case 2:
                alertMessage = "Too much time on Execution.";
                break;
            case 3:
                alertMessage = "Not able to get Database connection.";
                break;
            case 4:
                alertMessage = "Column is not present in Database.";
                break;
            case 5:
                alertMessage = "Some Error Occured.";
                break;
            case 6:
                alertMessage = "You don't have access for this feature.";
                break;
            case 7:
                alertMessage = "Invalid credentials.";
                break;
            case 8:
                alertMessage = "Service is unavailable.";
                break;
            case 9:
                alertMessage = "Resource not found.";
                break;
            default:
                alertMessage = "Please contact customer support.";
                break;
        }
        return alertMessage;
    }
}
