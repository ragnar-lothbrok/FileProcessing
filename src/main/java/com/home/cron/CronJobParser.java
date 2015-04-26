package com.home.cron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CronJobParser {

    private static final String HASH = "#";
    private static final String CRONTAB_FOR_SERVER = "CRONTAB FOR SERVER";
    private static final String CRONTAB_START = "CRONTAB FILE FOR";
    private static final String CRONTAB_END = "clear";

    public List<CronJob> parse(InputStream inputStream, Integer serverId) {
        List<CronJob> cronJobList = new ArrayList<CronJob>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String comment = null;
        try {
            comment = reader.readLine();
            while (comment != null) {
                if (comment.indexOf(CRONTAB_START) != -1) {
                    String tokens[] = comment.split(":");
                    serverId = 1;
                    while ((comment = reader.readLine()) != null && comment.trim().length() == 0)
                        ;
                    while (comment != null && comment.indexOf(CRONTAB_START) == -1) {
                        if (comment.trim().length() > 0) {
                            if (comment.startsWith(HASH) && isComment(comment)) {
                                String expression = reader.readLine();
                                while ((expression != null && expression.trim().length() == 0)
                                        || (isComment(expression))) {
                                    if (expression.trim().length() > 0 && isComment(expression))
                                        comment = expression;
                                    expression = reader.readLine();
                                    continue;
                                }
                                cronJobList.add(getCronJob(comment, expression, serverId));
                            } else {
                                cronJobList.add(getCronJob(null, comment, serverId));
                            }
                        }
                        comment = reader.readLine();
                        if (comment != null && comment.indexOf(CRONTAB_START) != -1)
                            break;
                    }
                } else {
                    comment = reader.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return cronJobList;
    }

    public CronJob getCronJob(String cronComment, String cronJobInfo, Integer serverId) {
        CronJob cronJob = null;
        if (cronJobInfo == null || cronJobInfo.trim().length() == 0) {
            return cronJob;
        } else {
            cronJobInfo = cronJobInfo.trim();
            cronJob = new CronJob();
            cronJob.setCronComment(cronComment);
            cronJob.setCronCommand(cronJobInfo);
            cronJob.setCronStatus(cronJobInfo.startsWith(HASH) ? "inactive" : "active");
            cronJob.setServerId(serverId);
            int index = cronJobInfo.indexOf(" /");
            System.out.println(cronJobInfo);
            while (cronJobInfo.charAt(index) != '*' && cronJobInfo.charAt(index) != '?'
                    && !(cronJobInfo.charAt(index) >= '0' && cronJobInfo.charAt(index) <= '9')) {
                index--;
            }
            String cronExpression = null;
            if (index != -1)
                cronExpression = cronJobInfo.substring(0, index+1);
            while(cronExpression.charAt(0) == '#'){
                cronExpression = cronExpression.substring(1,cronExpression.length());
            }
            cronJob.setCronExpression(cronExpression);
            cronJob.setCronCommand(cronJobInfo.substring(index + 1, cronJobInfo.length()));
        }
        return cronJob;
    }

    /**
     * Method will identify that given line is a cron or a Comment
     * 
     * @param line
     * @return
     */
    public boolean isComment(String line) {
        boolean isComment = false;
        if (line != null) {
            if (line.trim().length() < 6) {
                isComment = true;
            } else {
                String tokens[] = line.split(" ");
                if (1 == tokens.length) {
                    isComment = true;
                } else {
                    int count = 0;
                    for (int i = 0; i < tokens.length; i++) {
                        if ((tokens[i].trim().charAt(0) >= 'A' && tokens[i].trim().charAt(0) <= 'Z')
                                || (tokens[i].trim().charAt(0) >= 'a' && tokens[i].trim().charAt(0) <= 'z')) {
                            isComment = true;
                            break;
                        }
                        count++;
                        if (count == 5) {
                            isComment = false;
                            break;
                        }
                    }
                }
            }
        }
        return isComment;
    }

    /**
     * Method will compare 2 complete cron information and return the result
     * 
     * @param completeCron1
     * @param completeCron2
     * @return
     */
    public boolean isEqual(String completeCron1, String completeCron2) {
        if (completeCron1 != null && completeCron2 != null) {
            completeCron1 = completeCron1.replaceAll("\\s+", "");
            completeCron2 = completeCron2.replaceAll("\\s+", "");
            return completeCron1.equals(completeCron2);
        }
        return false;
    }
}
