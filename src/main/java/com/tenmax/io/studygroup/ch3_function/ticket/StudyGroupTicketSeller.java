package com.tenmax.io.studygroup.ch3_function.ticket;

import com.tenmax.io.studygroup.ch3_function.Person;

/**
 * @author zen
 * @since 2017/06/11
 */
public class StudyGroupTicketSeller {

    private static final double DEFAULT_PRICE = 50D;

    public static StudyGroupTicket aTicket(Person person) {
        StudyGroupTicket ticket = new StudyGroupTicket(DEFAULT_PRICE);
        ticket.setMemberType(person.getMemberType());

        return ticket;
    }
}
