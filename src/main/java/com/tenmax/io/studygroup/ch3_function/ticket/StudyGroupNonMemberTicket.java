package com.tenmax.io.studygroup.ch3_function.ticket;

/**
 * @author zen
 * @since 2017/06/11
 */
public class StudyGroupNonMemberTicket extends StudyGroupTicket {
    StudyGroupNonMemberTicket(double originPrice) {
        super(originPrice);
    }

    @Override
    public double getPrice() {
        return getOriginPrice();
    }

    @Override
    public double getRefundPrice() {
        return 0d;
    }
}
