package com.tenmax.io.studygroup.ch3_function;

/**
 * @author zen
 * @since 20161214.
 */
public class Person {

    private StudyGroupMemberType memberType;

    public StudyGroupMemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(StudyGroupMemberType memberType) {
        this.memberType = memberType;
    }

    public Person(StudyGroupMemberType memberType) {
        this.memberType = memberType;

    }

}
