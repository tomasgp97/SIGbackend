package com.austral.sigback.utils;

public enum ApplicationStatus {
    REJECTED, //rejected in any instance
    TO_REVIEW, //initial state, has to be filtered by rrhh
    FIRST_INTERVIEW, //after filter by rrhh
    SECOND_INTERVIEW,// after first interview is approved
    APPROVED,// once employee is accepted
}
