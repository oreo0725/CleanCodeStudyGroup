package com.tenmax.io.studygroup.ch3_function.ticket;

import com.tenmax.io.studygroup.ch3_function.Person;

/**
 * @author zen
 * @since 2017/06/11
 */
public class StudyGroupTicketFactoryImpl implements StudyGroupTicketFactory {

    @Override
    public StudyGroupTicket makeTicket(Person person,
                                       double originPrice) {
        StudyGroupTicket ticket;
        switch (person.getMemberType()) {
            case VIP:
                ticket = new StudyGroupVipTicket(originPrice);
                break;
            case MEMBER:
                ticket = new StudyGroupMemberTicket(originPrice);
                break;
            case NON_MEMBER:
                ticket = new StudyGroupNonMemberTicket(originPrice);
                break;
            default:
                throw new IllegalArgumentException("Not a supported member type");
        }
        return ticket;
    }
}
