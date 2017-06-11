package com.tenmax.io.studygroup.ch3_function.ticket;

import com.tenmax.io.studygroup.ch3_function.Person;

/**
 * @author zen
 * @since 2017/06/11
 */
public class StudyGroupTicketSeller {

    private static final double DEFAULT_PRICE = 50D;

    private static StudyGroupTicketFactory ticketFactory = new StudyGroupTicketFactoryImpl();


    private StudyGroupTicketSeller() {
    }

    public static StudyGroupTicket aTicket(Person person) {

        return ticketFactory.makeTicket(person, DEFAULT_PRICE);
    }
}
