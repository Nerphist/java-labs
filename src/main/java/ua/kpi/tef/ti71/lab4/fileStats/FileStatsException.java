package ua.kpi.tef.ti71.lab4.fileStats;

public class FileStatsException extends RuntimeException {
    public FileStatsException(String message) {
        super(message);
    }

    public FileStatsException(String message, Throwable cause) {
        super(message, cause);
    }
}
