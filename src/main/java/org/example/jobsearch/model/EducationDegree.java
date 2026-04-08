package org.example.jobsearch.model;

import lombok.Getter;

@Getter
public enum EducationDegree {
    BACHELOR(1), MASTER(2), COLLEGE(3), NO_EDUCATION(0);


    private final int id;

    EducationDegree(int id) {
        this.id = id;
    }
}
