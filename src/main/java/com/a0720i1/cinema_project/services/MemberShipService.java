package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.account.AccountMemberDTO;
import com.a0720i1.cinema_project.models.dto.membership.MembershipUpdateDTO;
import com.a0720i1.cinema_project.models.entity.Membership;


public interface MemberShipService {
    Membership findByEmail(String email);
    Membership findByPhone(String phone);
    Membership findByCard(String card);
    Membership findById(long id);
    Membership findByAccountId(long accountId);
    void createMembership(AccountMemberDTO membership);
    void updateMembership(MembershipUpdateDTO membership);
    void createMembershipSocial(Membership membership);
}
