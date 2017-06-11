package com.tenmax.io.studygroup.ch3_function;

import com.tenmax.io.studygroup.ch3_function.ticket.StudyGroupMemberType;
import com.tenmax.io.studygroup.ch3_function.ticket.StudyGroupTicket;
import com.tenmax.io.studygroup.ch3_function.ticket.StudyGroupTicketSeller;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author zen
 * @since 2017/06/11
 */
public class TicketPriceTest {

    private final static double PRICE = 50D;

    @Test
    public void test_getPrice_WHEN_vip_buy_ticket_THEN_get_50off_discount() throws Exception {

        StudyGroupTicket ticket = createStudyGroupTicket(StudyGroupMemberType.VIP);

        assertThat(ticket.getPrice()).isEqualTo(PRICE * 0.5);
    }

    @Test
    public void test_getPrice_WHEN_member_buy_ticket_THEN_get_20off_discount() throws Exception {

        StudyGroupTicket ticket = createStudyGroupTicket(StudyGroupMemberType.MEMBER);

        assertThat(ticket.getPrice()).isEqualTo(PRICE * 0.8);
    }

    @Test
    public void test_getPrice_WHEN_nonMember_buy_ticket_THEN_no_discount() throws Exception {

        StudyGroupTicket ticket = createStudyGroupTicket(StudyGroupMemberType.NON_MEMBER);

        assertThat(ticket.getPrice()).isEqualTo(PRICE);
    }

    private StudyGroupTicket createStudyGroupTicket(StudyGroupMemberType memberType) {
        Person person = new Person(memberType);
        return StudyGroupTicketSeller.aTicket(person);
    }
}
