package com.exemple.labb1_26;

import java.util.Arrays;

public class Library {

    private Book[] books;
    private Member[] members;
    private int counterBook;
    private int counterMember;
    private boolean[] isBorrowed;
    private Member[] borrowedBy;


    public Library() {
        this.books = new Book[14];
        this.members = new Member[7];
        this.counterBook = 0;
        this.counterMember = 0;
        this.isBorrowed = new boolean[14];
        this.borrowedBy = new Member[14];
    }

    public Library(Book books) {
        this.books = new Book[]{books};
        this.counterBook = 1;
    }

    public Book addBook(Book book) {
        if (counterBook >= books.length) {

            growBookArray();
        }
        books[counterBook++] = book;
        return book;
    }

    private void growBookArray() {

        int newSize = books.length * 2;

        books = Arrays.copyOf(books, newSize);
        isBorrowed = Arrays.copyOf(isBorrowed, newSize);
        borrowedBy = Arrays.copyOf(borrowedBy, newSize);
    }

    //Linjär sökning.
    //Detta här är för användaren
    public void findBook(String text) {
        text = text.toLowerCase();

        boolean found = false;

        for (int i = 0; i < counterBook; i++) {
            if (books[i].title().toLowerCase().contains(text) || books[i].author().toLowerCase().contains(text)) {
                System.out.println(books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found");
        }
    }

    //och detta är för systemets interna arbete
    public int findBookIndex(String title) {
        for (int i = 0; i < counterBook; i++) {
            if (books[i].title().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    public boolean borrowBook(int bookIndex, Member member) {
        if (isBorrowed[bookIndex]) {
            return false;
        }
        if (!member.borrow()) {
            return false;
        }
        isBorrowed[bookIndex] = true;
        borrowedBy[bookIndex] = member;

        return true;
    }

    public boolean returnBook(int bookIndex) {
        if (!isBorrowed[bookIndex]) {
            return false;
        }
        borrowedBy[bookIndex].returnBack();
        borrowedBy[bookIndex] = null;
        isBorrowed[bookIndex] = false;

        return true;
    }

    public boolean addMember(Member member) {
        if (findMember(member.getMemberID()) != null) {
            return false; //Säger att: Member with the same ID already exists
        }
        if (counterMember >= members.length) {

            growMembersArray();
        }
        members[counterMember++] = member;
        return true;
    }

    private void growMembersArray() {
        members = Arrays.copyOf(members, members.length * 2);
    }


    public Member findMember(String memberID) {
        for (int i = 0; i < counterMember; i++) {
            if (members[i].getMemberID().equals(memberID)) {
                return members[i];
            }
        }
        return null;
    }

    public void showBooks() {
        for (int i = 0; i < counterBook; i++) {
            System.out.println(i + ": " + books[i].title() + " by " + books[i].author());

            if (isBorrowed[i]) {
                System.out.println("Borrowed by " + borrowedBy[i].getName());
            }
            else {
                System.out.println("Available");
            }
        }
    }

    public void showMembers() {
        for (int i = 0; i < counterMember; i++) {
            System.out.println(i + ". MemberID " + members[i].getMemberID() + " - " + members[i].getName() +
                                " \t (active loans: " + members[i].getActiveLoans() + ")");
        }
    }
}