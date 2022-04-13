package com.etiya.rentACar.core.utilities.results;

public class Result {
    private boolean success;
    private String messages;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String messages) {
        this(success);
        this.messages = messages;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessages() {
        return messages;
    }
}
