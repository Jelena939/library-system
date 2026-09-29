package com.exemple.labb1_26;

import java.util.Arrays;
import java.util.Locale;

public class Library {

    private Book[] books;
    private Member[] members;
    private int counterBook;
    private int counterMember;
    private boolean[] isBorrowed;
    private Member[] borrowedBy;


    public Library() {
        this.books = new Book[14];
        this.members = new Member[6];
        this.counterBook = 0;
        this.counterMember = 0;
        this.isBorrowed = new boolean[14];
        this.borrowedBy = new Member[14];
        //Då blir isBorrowed[0] status för book[0], om jag hade t.ex. [6] och användaren
        //vill låna bok 8, då kraschar systemet
    }

    //Den behövs inte, den ska bort
    public Library(Book books) {
        this.books = new Book[]{books};
        this.counterBook = 1;

    }


    public Book addBook(Book book) {  //add new books (return book in another method?)
        if (counterBook >= books.length) {

            growBookArray();
        }
        books[counterBook++] = book;
        return book;
    }

    public Member addMember(Member member) {
        if (counterMember >= members.length) {

            growMembersArray();
        }
        members[counterMember++] = member;
        return member;
    }

    //Dynamiskt växande arrayer, jag måste få de att växa för isBorrowed och borrowedBy!
    private void growBookArray() {

        int newSize = books.length * 2;

        books = Arrays.copyOf(books, newSize);
        isBorrowed = Arrays.copyOf(isBorrowed, newSize);
        borrowedBy = Arrays.copyOf(borrowedBy, newSize  );
    }

    private void growMembersArray() {
        members = Arrays.copyOf(members, members.length * 2);
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

    //Linjär sökning. Nu väntar metoden på ett sökord t.ex. library.findBook("tolkien")
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



    public Member findMember(String memberID) {
        for (int i = 0; i < counterMember; i++) {
            if (members[i].getMemberID().equals(memberID)) {
                return members[i];
            }
        }
        return null;
    }

    //Utskrift
    public void showBooks() {
        for (int i = 0; i < counterBook; i++) {
            System.out.println(books[i]);

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
            System.out.println(members[i]);
        }
    }
}




//Jag liksom måste ha de men... Får se senare om den kommer till användning
//Visar en bok på ett visst index
//    public Book getBookValue(int index) {
//        if (index < 0 || index >= counterBook) {
//            throw new IndexOutOfBoundsException("Invalid index: " + index);
//        }
//        return books[index];
//    }
//
//    public Member getMemberValue(int index) {
//        if (index < 0 || index >= counterMember) {
//            throw new IndexOutOfBoundsException("Invalid index: " + index);
//        }
//        return members[index];
//    }





    //Visar hur många böcker finns i min biblioteket
    //Får se senare om den kommer till användning
        /*
    public int sizeBook() {
        return counterBook;
    }
    public int sizeMember() {
        return counterMember;
    }
 */