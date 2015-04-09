package com.home.common.filereading.approach2;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.Callable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@SuppressWarnings("rawtypes")
@Service
@Scope("prototype")
public class FileReader implements Callable {

    private FileChannel fileChannel;

    private long startPosition;

    private long length;

    FileChunk fileChunk = new FileChunk();

    public FileReader(FileChannel fileChannel, long startPosition, long length) {
        this.fileChannel = fileChannel;
        this.startPosition = startPosition;
        this.length = length;
        fileChunk.setConstantReadSize(length);
    }

    public FileChunk call() throws Exception {
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, startPosition, length);
        buffer.load();
        fileChunk.setThreadName(Thread.currentThread().getName());
        fileChunk.setBuffer(buffer);
        fileChunk.setStartPosition(startPosition);
        fileChunk.setEndPosition(startPosition + buffer.limit());
        fileChunk.setReadBytes((long) buffer.limit());
        return fileChunk;
    }

}
