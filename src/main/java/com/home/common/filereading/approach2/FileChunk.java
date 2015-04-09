package com.home.common.filereading.approach2;


public class FileChunk implements Comparable<FileChunk> {
    private Object buffer;
    private Long startPosition;
    private Long readBytes;
    private Long endPosition;
    private String threadName;
    private static Long constantReadSize;

    public Object getBuffer() {
        return buffer;
    }

    public void setBuffer(Object buffer) {
        this.buffer = buffer;
    }

    public Long getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Long startPosition) {
        this.startPosition = startPosition;
    }

    public Long getReadBytes() {
        return readBytes;
    }

    public void setReadBytes(Long readBytes) {
        this.readBytes = readBytes;
    }

    public Long getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Long endPosition) {
        this.endPosition = endPosition;
    }

    public static Long getConstantReadSize() {
        return constantReadSize;
    }

    public static void setConstantReadSize(Long constantReadSize) {
        FileChunk.constantReadSize = constantReadSize;
    }

    public int compareTo(FileChunk o) {
        return startPosition.compareTo(((FileChunk) o).getStartPosition());
    }

    public String getThreadName() {
        return threadName;
    }

    @Override
    public String toString() {
        return "FileChunk [buffer=" + buffer + ", startPosition=" + startPosition + ", readBytes=" + readBytes
                + ", endPosition=" + endPosition + ", threadName=" + threadName + "]\n";
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

}
