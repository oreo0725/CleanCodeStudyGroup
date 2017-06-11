package com.tenmax.io.studygroup.ch3_function.ticket;

import com.tenmax.io.studygroup.ch3_function.Person;

/**
 * @author zen
 * @since 2017/06/11
 */
public interface StudyGroupTicketFactory {
    StudyGroupTicket makeTicket(Person person,
                                double originPrice);
}
