package com.zyh.zyhTest.utils;

public enum GroupEnum {
    TD("Tongdun","同盾"),
    Gj("Guiji","硅基")
    ;

    private String groupId;
    private String groupIdCn;

    GroupEnum(String groupId, String groupIdCn) {
        this.groupId = groupId;
        this.groupIdCn = groupIdCn;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupIdCn() {
        return groupIdCn;
    }
}
