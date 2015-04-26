package com.home.cron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Component;

@Component
public class CronLogParser {

	private final static String CRON_JOB_NAME = "Cron_Job_Name";
	private final static String CRONJOB_LOG = "CRONJOB LOG";

//	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd kk:mm:ss");
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");

	public List<CronLogBean> getCronLogs(InputStream inputStream,
			Integer serverId) {
		List<CronLogBean> cronLogList = new ArrayList<CronLogBean>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream));
		String logInfo = null;
		try {
			while ((logInfo = reader.readLine()) != null) {
				while (logInfo != null && logInfo.trim().length() > 0) {
					cronLogList.add(getCronLogBean(logInfo));
					logInfo = reader.readLine();
					if (logInfo != null && logInfo.indexOf(CRONJOB_LOG) != -1) {
						break;
					}
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
		Collections.sort(cronLogList, new CronLogComparator());
		return updateCronLogs(cronLogList);
	}

	public CronLogBean getCronLogBean(String logInfo) {
		CronLogBean cronLogBean = null;
		String tokens[] = logInfo.trim().split("\\|");
		cronLogBean = new CronLogBean();
		cronLogBean.setCronName(tokens[0]);
		try {
			if (tokens.length > 1 && tokens[1].trim().length() > 0)
				cronLogBean.setServerIp(tokens[1].trim());
			if (tokens.length > 2 && tokens[2].trim().length() > 0)
				cronLogBean.setStartTime(formatter.parse(tokens[2].trim()));
			if (tokens.length > 3 && tokens[3].trim().length() > 0)
				cronLogBean.setEndTime(formatter.parse(tokens[3].trim()));
			if (tokens.length > 4 && tokens[4].trim().length() > 0)
				cronLogBean.setProcessId(Integer.parseInt(tokens[4].trim()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cronLogBean;
	}

	public List<CronLogBean> updateCronLogs(List<CronLogBean> cronLogList) {
		List<CronLogBean> updatedCronLogs = new ArrayList<CronLogBean>();
		ListIterator<CronLogBean> iterator = cronLogList.listIterator();
		while (iterator.hasNext()) {
			CronLogBean cronLogBean1 = iterator.next();
			if (cronLogBean1.getStartTime() == null) {
				updatedCronLogs.add(cronLogBean1);
			} else {
				if (iterator.hasNext()) {
					CronLogBean cronLogBean2 = iterator.next();
					if (cronLogBean1.getCronName().equals(
							cronLogBean2.getCronName())) {
						if (cronLogBean2.getEndTime() != null) {
							cronLogBean1.setEndTime(cronLogBean2.getEndTime());
						}else{
							iterator.previous();
						}
						updatedCronLogs.add(cronLogBean1);
					} else {
						iterator.previous();
					}
				}
			}

		}
		return updatedCronLogs;
	}
}

class CronLogComparator implements Comparator<CronLogBean> {

	public int compare(CronLogBean o1, CronLogBean o2) {
		int result =  o1.getCronName().compareTo(o2.getCronName());
		if(result == 0 && o1.getProcessId() != null && o2.getProcessId() != null){
			return o1.getProcessId().compareTo(o2.getProcessId());
		} 
		return result;
	}

}
