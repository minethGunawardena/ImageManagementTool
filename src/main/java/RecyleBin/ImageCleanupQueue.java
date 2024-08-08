package RecyleBin;

import java.io.Console;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import imageX.Console.*;

public class ImageCleanupQueue {
    ImageXConsole consoleX = new ImageXConsole();
    private static final long FILE_DELETION_DELAY_MS = 24*60 * 1000; // 1 day in milliseconds
    private static final long QUEUE_PROCESS_INTERVAL_MS = 1000 * 1000; // 1 minute in milliseconds

    private final Queue<File> deletionQueue = new LinkedList<>();
    private final Timer timer;

    public ImageCleanupQueue() {
        timer = new Timer(true); // Daemon thread
    }

    public void startCleanup() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                processQueue();
            }
        }, 0, QUEUE_PROCESS_INTERVAL_MS);
    }

    private void processQueue() {
        if (deletionQueue.isEmpty()) {
            // Stop the timer if the queue is empty
            stopCleanup();
            return;
        }

        File file = deletionQueue.poll(); // Retrieve and remove the file at the head of the queue

        if (file != null && file.isFile()) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - file.lastModified() >= FILE_DELETION_DELAY_MS) {
                if (file.delete()) {
                    consoleX.consoleLog("Deleted: " + file.getName());
                } else {
                    consoleX.consoleLog("Failed to delete: " + file.getName());
                }
            } else {
                // Re-add the file to the end of the queue if it hasn't reached the deletion delay yet
                deletionQueue.add(file);
            }
        }
    }

    public void stopCleanup() {
        timer.cancel();
    }

    public void addFilesToQueue(File[] files) {
        for (File file : files) {
            if (file.isFile()) {
                deletionQueue.add(file);
            }
        }
    }

    public void viewImages() {
        File[] files = new File(".").listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    consoleX.consoleLog("Image: " + file.getName());
                }
            }
        }
    }

}

