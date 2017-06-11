package com.tenmax.io.studygroup.ch3_function;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zen
 * @since 2017/06/11
 */
public class StudyGroup {

    private Map<LocalDate, List<String>> joinedNameList = new HashMap<>();
    private double income = 0D;

    private StudyGroup(LocalDate date) {
        joinedNameList.put(date, new ArrayList<>());
    }

    private StudyGroup(LocalDate date1,
                       LocalDate date2) {
        joinedNameList.put(date1, new ArrayList<>());
        joinedNameList.put(date2, new ArrayList<>());
    }

    private StudyGroup(LocalDate date1,
                       LocalDate date2,
                       LocalDate date3,
                       LocalDate date4,
                       LocalDate date5) {
        joinedNameList.put(date1, new ArrayList<>());
        joinedNameList.put(date2, new ArrayList<>());
        joinedNameList.put(date3, new ArrayList<>());
        joinedNameList.put(date4, new ArrayList<>());
        joinedNameList.put(date5, new ArrayList<>());

    }

    public boolean joinSession(String name,
                               double submitFee,
                               boolean isTenmaxMember,
                               LocalDate sessionDate) {

        if (!joinedNameList.containsKey(sessionDate)) {
            //no such session
            return false;
        }

        double chargeFee = isTenmaxMember ? 0D : 100D;
        if (submitFee < chargeFee) {
            //not enough fee submitted
            return false;
        }

        addNameToJoin(name, sessionDate);

        income += submitFee;
        return true;
    }

    private void addNameToJoin(String name,
                               LocalDate sessionDate) {
        List<String> nameList = joinedNameList.getOrDefault(sessionDate, new ArrayList<>());
        nameList.add(name);
        joinedNameList.put(sessionDate, nameList);
    }

    public double getIncome() {
        return income;
    }

    public static void main(String[] args) {
        final LocalDate session1 = LocalDate.of(2017, 6, 13);
        final LocalDate session2 = LocalDate.of(2017, 6, 20);
        StudyGroup cleanCodeStudyGroup = new StudyGroup(session1, session2);

        boolean isJoined = cleanCodeStudyGroup.joinSession("大神", 20, true, session1);
        System.out.println("大神 join for 2017/6/13 succ? " + isJoined);

        isJoined = cleanCodeStudyGroup.joinSession("路人甲", 1, false, session1);
        System.out.println("路人甲 join for 2017/6/13 succ? " + isJoined);

        //should only print out income = 20.0
        System.out.println("study group has income = [" + cleanCodeStudyGroup.getIncome() + "]");

    }
}
