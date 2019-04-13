package com.sti.bootcamp.servlet.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sti.bootcamp.servlet.dao.AccountDao;
import com.sti.bootcamp.servlet.model.Account;
import com.sti.bootcamp.servlet.model.dto.CommonResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class AccountDaoWsImpl implements AccountDao {
    private static final ObjectMapper MAPPER = new ObjectMapper();//boleh dibuat static final, karena object mapper thread-safe
    private static final ParameterizedTypeReference<CommonResponse<Account>> PARAMETERIZED_TYPE_COMMON_RESP_ACCOUNT = new ParameterizedTypeReference<CommonResponse<Account>>() {
    };
    private static final TypeReference<CommonResponse<List<Account>>> TYPE_COMMON_RESP_ACCOUNTS = new TypeReference<CommonResponse<List<Account>>>() {
    };
    private static final TypeReference<CommonResponse<Account>> TYPE_COMMON_RESP_ACCOUNT = new TypeReference<CommonResponse<Account>>() {
    };

    @Override
    public List<Account> getList() {
        List<Account> list = null;

        RestTemplate restTemplate = new RestTemplate();
        String getAccountsUrl = "http://localhost:8080/accounts?cif=2";//untuk sample masih hardcode, untuk real project sebaiknya dibuatkan di properties atau enum

        //contoh menggunakan getForEntity --> otomatis menggunakan method GET
        ResponseEntity<String> response = restTemplate.getForEntity(getAccountsUrl, String.class);

        if (response.getStatusCode() != HttpStatus.OK) {//gunakan ResponseEntity agar dapat validasi HTTP Status terlebih dahulu
            System.out.println(String.format("error %s", response.getStatusCodeValue()));
        } else if (StringUtils.isEmpty(response.getBody())) {
            System.out.println("response null");
        } else {
            try {
                //contoh untuk GET dengan mengambil response dalam bentuk String terlebih dahulu (response.getBody), baru diconvert ke dalam object menggunakan ObjectMapper
                CommonResponse<List<Account>> respBody = MAPPER.readValue(response.getBody(), TYPE_COMMON_RESP_ACCOUNTS);
                if (!respBody.getResponseCode().equalsIgnoreCase("01")) {
                    System.out.println(String.format("failed with message %s", respBody.getResponseMessage()));
                } else {
                    list = respBody.getData();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return list;
    }

    @Override
    public Account getById(int customerNumber) {
        return null;
    }

    @Override
    public Account save(Account customer) {
        return null;
    }
}
