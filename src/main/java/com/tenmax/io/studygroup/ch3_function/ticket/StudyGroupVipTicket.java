package com.tenmax.io.studygroup.ch3_function.ticket;

/**
 * @author zen
 * @since 2017/06/11
 */
public class StudyGroupVipTicket extends StudyGroupTicket {
    StudyGroupVipTicket(double originPrice) {
        super(originPrice);
    }

    @Override
    public double getPrice() {
        return getOriginPrice() * 0.5;
    }

    @Override
    public double getRefundPrice() {
        return getPrice() * 0.9;
    }
}
