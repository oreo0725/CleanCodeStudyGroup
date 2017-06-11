package com.tenmax.io.studygroup.ch3_function.ticket;

/**
 * @author zen
 * @since 2017/06/11
 */
public abstract class StudyGroupTicket extends AbstractTicket {

    private final double originPrice;

    StudyGroupTicket(double originPrice) {
        this.originPrice = originPrice;
    }

    public final double getOriginPrice() {
        return originPrice;
    }

}
