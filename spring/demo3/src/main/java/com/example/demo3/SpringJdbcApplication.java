package com.example.demo3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SpringJdbcApplication implements ApplicationRunner {

    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //create
        Member member = Member.builder()
                .name("정혁")
                .email("a@gmail.com").age(10).build();
        memberRepository.save(member);

        //insert
        member.setAge(11);
        memberRepository.save(member);
    }
}
