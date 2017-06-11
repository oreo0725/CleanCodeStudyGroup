package com.tenmax.io.studygroup.ch3_function.ticket;

/**
 * @author zen
 * @since 2017/06/11
 */
public class StudyGroupTicket {

    private final double originPrice;
    private final StudyGroupMemberType memberType;

    StudyGroupTicket(double originPrice,
                     StudyGroupMemberType memberType) {
        this.originPrice = originPrice;
        this.memberType = memberType;
    }

    public double getPrice() {

        double tempPrice = getOriginPrice();
        switch (memberType) {
            case VIP:
                tempPrice = tempPrice * 0.5;
                break;
            case MEMBER:
                tempPrice = tempPrice * 0.8;
                break;
        }
        return tempPrice;
    }

    public double getOriginPrice() {
        return originPrice;
    }

    public StudyGroupMemberType getMemberType() {
        return memberType;
    }
}
