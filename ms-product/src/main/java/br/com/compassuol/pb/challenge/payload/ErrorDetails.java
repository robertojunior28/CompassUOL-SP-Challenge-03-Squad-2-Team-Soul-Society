package br.com.compassuol.pb.challenge.payload;

import java.util.Date;

public class ErrorDetails {
    private Date timesTamp;
    private String message;
    private String details;

    public ErrorDetails(Date timesTamp, String message, String details) {
        this.timesTamp = timesTamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimesTamp() {
        return timesTamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
