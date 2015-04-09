package com.home.common.filereading.approach2;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class FileReadService {

    @Autowired
    ThreadPoolTaskExecutor executor;

    private static Integer CHUNK_SIZE = 20480000;

    @SuppressWarnings("unchecked")
    public List<FileChunk> readFile(String fileName, List<FileChunk> fileConentList) {
        try {
            fileConentList = new ArrayList<FileChunk>();
            RandomAccessFile randomAccessFile = new RandomAccessFile("CSV.csv", "r");
            if (randomAccessFile != null) {
                FileChannel fileChannel = randomAccessFile.getChannel();
                long totalBytes = randomAccessFile.getChannel().size();
                System.out.println("Total bytes in file : " + totalBytes);
                List<Future<FileChunk>> list = new ArrayList<Future<FileChunk>>();
                Callable<FileChunk> fileReader = null;
                Future<FileChunk> future = null;
                long startIndex = 0;
                for (int i = 0; i < (totalBytes / CHUNK_SIZE); i++) {
                    fileReader = new FileReader(fileChannel, startIndex, CHUNK_SIZE);
                    future = executor.submit(fileReader);
                    list.add(future);
                    startIndex += CHUNK_SIZE;
                }
                //For reading rest of the chunk
                if (startIndex < totalBytes) {
                    fileReader = new FileReader(fileChannel, startIndex, totalBytes - startIndex);
                    future = executor.submit(fileReader);
                    list.add(future);
                }
                for (Future<FileChunk> fut : list) {
                    try {
                        if (fut != null)
                            fileConentList.add(fut.get(1000, TimeUnit.MILLISECONDS));
                    } catch (InterruptedException e) {
                    } catch (ExecutionException e) {
                    } catch (TimeoutException e) {
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return fileConentList;
    }
}
