package com.example.gobangdemo.mode;

import lombok.Data;
import org.omg.CORBA.WStringSeqHelper;

@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private int score;
    private int totalCount;
    private int winCount;
}
