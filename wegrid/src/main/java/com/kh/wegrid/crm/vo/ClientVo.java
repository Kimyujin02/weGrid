package com.kh.wegrid.crm.vo;

import lombok.Data;

@Data
public class ClientVo {

    private String no;
    private String rankCode;
    private String rankName;
    private String statusNo;
    private String statusName;
    private String name;
    private String address;
    private String presidentName;
    private String presidentPhone;
    private String presidentEmail;
    private String startDate;
    private String managerName;
    private String managerPhone;
    private String managerEmail;
    private String roadAddress;   // 도로명 주소
    private String detailAddress; // 상세 주소

    // 결합된 주소 반환 메서드
    public String getAddress() {
        return roadAddress + " " + detailAddress;
    }

}
