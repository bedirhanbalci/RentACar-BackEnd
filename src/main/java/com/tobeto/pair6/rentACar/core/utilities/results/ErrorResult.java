package com.tobeto.pair6.rentACar.core.utilities.results;

public class ErrorResult extends Result {

    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(false, message);
    }

}
