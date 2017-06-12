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

    private Map<LocalDate, List<String>> sessionRegisterMap = new HashMap<>();
    private double income = 0D;

    //initial available session
    private StudyGroup(LocalDate date1,
                       LocalDate date2,
                       LocalDate date3,
                       LocalDate date4,
                       LocalDate date5) {
        sessionRegisterMap.put(date1, new ArrayList<>());
        sessionRegisterMap.put(date2, new ArrayList<>());
        sessionRegisterMap.put(date3, new ArrayList<>());
        sessionRegisterMap.put(date4, new ArrayList<>());
        sessionRegisterMap.put(date5, new ArrayList<>());

    }

    public boolean joinSession(String name,
                               double submitFee,
                               boolean isTenmaxMember,
                               LocalDate sessionDate) {

        if (!sessionRegisterMap.containsKey(sessionDate)) {
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
        List<String> nameList = sessionRegisterMap.getOrDefault(sessionDate, new ArrayList<>());
        nameList.add(name);
        sessionRegisterMap.put(sessionDate, nameList);
    }

    public double getIncome() {
        return income;
    }

    public static void main(String[] args) {
        final LocalDate session1 = LocalDate.of(2017, 6, 13);
        final LocalDate session2 = LocalDate.of(2017, 6, 20);
        final LocalDate session3 = LocalDate.of(2017, 6, 27);
        final LocalDate session4 = LocalDate.of(2017, 7, 4);
        final LocalDate session5 = LocalDate.of(2017, 7, 11);
        StudyGroup cleanCodeStudyGroup = new StudyGroup(session1, session2, session3, session4, session5);

        boolean isJoined = cleanCodeStudyGroup.joinSession("大神", 20, true, session1);
        System.out.println("大神 join for 2017/6/13 succ? " + isJoined);

        isJoined = cleanCodeStudyGroup.joinSession("路人甲", 1, false, session1);
        System.out.println("路人甲 join for 2017/6/13 succ? " + isJoined);

        //should only print out income = 20.0
        System.out.println("study group has income = [" + cleanCodeStudyGroup.getIncome() + "]");

    }
}
