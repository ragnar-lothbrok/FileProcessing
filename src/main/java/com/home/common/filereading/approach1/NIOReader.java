package com.home.common.filereading.approach1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class NIOReader {

    public static Integer CAPACITY = 2000;

    public static void main(String[] args) {
        RandomAccessFile aFile = null;
        FileChannel inChannel = null;
        try {
            aFile = new RandomAccessFile("CSV.csv", "r");
            if (aFile != null) {
                inChannel = aFile.getChannel();
                readUsingByteBuffer(inChannel);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (aFile != null)
                    aFile.close();
                if (inChannel != null)
                    inChannel.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    private static void readUsingBufferedReader() throws IOException {
        BufferedReader br = null;
        String sCurrentLine = null;
        try {
            br = new BufferedReader(new FileReader("CSV.csv"));
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void readUsingMappedByteBuffer(FileChannel inChannel) throws IOException {
        // Create buffer of n bytes
        MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        buffer.load();
        for (int i = 0; i < buffer.limit(); i++) {
            System.out.print((char) buffer.get());
        }
        buffer.clear(); // do something with the data and clear/compact it.
        inChannel.close();
    }

    private static void readUsingByteBuffer(FileChannel inChannel) throws IOException {
        // Create buffer of CAPACITY bytes
        ByteBuffer buffer = ByteBuffer.allocateDirect(CAPACITY);
        if (inChannel != null) {
            while (inChannel.read(buffer) > 0) {
                buffer.flip();

                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear();
            }
            inChannel.close();
        }
    }
}
