package com.exemple.labb1_26;

public class Member {

    private final String memberID;
    private final String name;
    private int activeLoans;
    private static final int MAX_LOANS = 2;


    public Member(String memberID, String name) {
        if (memberID == null || name == null) {
            throw new IllegalArgumentException("Member ID and name is invalid");
        }
        this.memberID = memberID;
        this.name = name;
        this.activeLoans = 0;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public int getActiveLoans() {
        return activeLoans;
    }

    public static int getMaxLoans() {
        return MAX_LOANS;
    }

    public boolean canBorrow() {

        return activeLoans < MAX_LOANS;
    }

    public boolean borrow() {
        if (canBorrow()) {
            activeLoans++;
            return true;
        }
        return false;
    }

    public boolean returnBack() {
        if (activeLoans > 0) {
            activeLoans--;
            return true;
        }
        return false;
    }
}
