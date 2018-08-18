package com.lww.springbase.service;

import com.lww.springbase.aspectj.tx.AfterCommit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.lww.springbase.aspectj.Test.testKey;

@Service
public class AspectServiceImpl implements AspectService {

    @AfterCommit
    @Override
    public String doSomeThing(String something) {

        return something;
    }

    @Override
    @Transactional
    public String transactionalMethod(String something) {
        testKey = something;
        if (something.equals("swap")) {
            throw new NullPointerException("测试");
        }
        return testKey;
    }
}
