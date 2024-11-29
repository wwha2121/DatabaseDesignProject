package com.wc.watchu.service;

import com.wc.watchu.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private SignUpRepository signUpRepository;

    // Example method to delete a member
    public boolean deleteMemberById(int memberId) {
        if (signUpRepository.existsById(memberId)) {
            signUpRepository.deleteById(memberId);
            return true;
        }
        return false;
    }
}
