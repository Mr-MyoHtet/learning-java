package com.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.github.pagehelper.util.StringUtil;

public class StudentSqlProvider {
    public String buildSelect(@Param("name") String name, @Param("email") String email,
            @Param("bio") String bio) {
        return new SQL() {
            {
                SELECT("*");
                FROM("student");
                if (StringUtil.isNotEmpty(name)) {
                    WHERE("name= #{name}");
                }
                if (StringUtil.isNotEmpty(email)) {
                    WHERE("email= #{email}");
                }
                if (StringUtil.isNotEmpty(bio)) {
                    WHERE("bio= #{bio}");
                }
            }
        }.toString();
    }
}