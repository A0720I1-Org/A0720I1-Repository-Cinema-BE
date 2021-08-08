package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.dto.account.AccountMemberDTO;
import com.a0720i1.cinema_project.models.dto.membership.MembershipUpdateDTO;
import com.a0720i1.cinema_project.models.entity.Account;
import com.a0720i1.cinema_project.models.entity.Membership;
import com.a0720i1.cinema_project.repositories.AccountRepository;
import com.a0720i1.cinema_project.repositories.MemberShipRepository;
import com.a0720i1.cinema_project.services.MemberShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberShipServiceImpl implements MemberShipService {
    @Autowired
    MemberShipRepository memberShipRepository;
    @Autowired
    AccountRepository accountRepository;
    @Override
    public Membership findByEmail(String email) {
        return memberShipRepository.findByEmail(email);
    }

    @Override
    public Membership findByPhone(String phone) {
        return memberShipRepository.findByPhone(phone);
    }

    @Override
    public Membership findByCard(String card) {
        return memberShipRepository.findByCard(card);
    }

    @Override
    public Membership findById(long id) {
        return null;
    }

    @Override
    public Membership findByAccountId(long accountId) {
        return memberShipRepository.findByAccountId(accountId);
    }

    @Override
    public void createMembership(AccountMemberDTO membership) {
        Account account = accountRepository.findAccountByUsername(membership.getUsername());
        memberShipRepository.createMembership(membership.getMemberCode(),membership.getName(),
                membership.getCard(),membership.getPhone(),membership.getEmail(),membership.getBirthday(),
                membership.getGender(),membership.getImageURL(),membership.getWardId(),account.getId());
    }

    @Override
    public void updateMembership(MembershipUpdateDTO membership) {
        memberShipRepository.updateMembership(membership.getName(),membership.getCard(),membership.getPhone()
                ,membership.getEmail(),membership.getBirthday(),membership.getGender(),membership.getImageURL(),
                membership.getWardId(),membership.getId());
    }

    @Override
    public void createMembershipSocial(Membership membership) {
        memberShipRepository.createMembershipWithSocial(membership.getEmail(),membership.getAccount().getId(),this.generateMemberCode());
    }
    public String generateMemberCode() {
        int number1 = (int) Math.floor(1000 + Math.random() * 9000);
        int number2 = (int) Math.floor(1000 + Math.random() * 9000);
        int number3 = (int) Math.floor(1000 + Math.random() * 9000);
        int number4 = (int) Math.floor(1000 + Math.random() * 9000);
        return number1+"-"+number2+"-"+number3+"-"+number4;
    }
}
