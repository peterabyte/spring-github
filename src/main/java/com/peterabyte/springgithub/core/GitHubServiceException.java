package com.peterabyte.springgithub.core;

public class GitHubServiceException extends RuntimeException {
    public GitHubServiceException() {
        super();
    }

    public GitHubServiceException(String message) {
        super(message);
    }

    public GitHubServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public GitHubServiceException(Throwable cause) {
        super(cause);
    }

    protected GitHubServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
