package com.exemple.labb1_26;

public class Member {

    private String memberID;
    private String name;
    private int activeLoans;
    private static final int MAX_LOANS = 2;


    public Member(String memberID, String name, int activeLoans) {
        if (memberID == null || name == null || activeLoans < 0) {
            throw new IllegalArgumentException("Member ID and name cannot be " +
                    "empty space and activeLoans cannot be negative");
        }
        this.memberID = memberID;
        this.name = name;
        this.activeLoans = activeLoans;
    }
    //jag behöver kanske bara den här av alla.
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

//

    public int getActiveLoans() {
        return activeLoans;
    }


    public static int getMaxLoans() {
        return MAX_LOANS;
    }


    public boolean canBorrow() {

        return activeLoans < MAX_LOANS;
    }
//Jag byter namn till borrow istället föt borrowBook så då kan jag använda borrowBook() i Library
    //tror jag, alltså jag måste ha koll på mina activloans++ och --!
    //För att göra det jag byter till boolean


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

    //    public void setMemberID(String memberID) {
//        if (memberID == null) {
//            throw new IllegalArgumentException("Member ID is invalid");
//        }
//        this.memberID = memberID;
//    }

    //    public void setName(String name) {
//        if (name == null) {
//            throw new IllegalArgumentException("Name is invalid");
//        }
//        this.name = name;
//    }



}
