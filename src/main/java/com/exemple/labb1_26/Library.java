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
        this.members = new Member[6];
        this.counterBook = 0;
        this.counterMember = 0;
        this.isBorrowed = new boolean[14];
        this.borrowedBy = new Member[14];
        //Då blir borrowed[0] status för book[0]
    }

    public Library(Book books) {
        this.books = new Book[]{books};
        this.counterBook = 1;

    }



    public Book addBook(Book book) {  //add new books (return book in another method?)
        if (counterBook >= books.length) {

            growBookArray(); //todo kan man inte använda samma grow array till bägge b och m?
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


    private void growBookArray() {
        books = Arrays.copyOf(books, books.length * 2);
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

    //Linjär sökning
    public void findBook(String text) {
        text = text.toLowerCase();

        for (int i = 0; i < counterBook; i++) {
            if (books[i].title().toLowerCase().contains(text) || books[i].author().toLowerCase().contains(text)) {
                System.out.println(books[i]);

            }
        }
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
    //Nej! till den här metoden. Enligt copilot. Vi ska inte ta bort en bok från biblioteket vid utlåningen!
    //den ska ju finnas kvar i biblioteket.
    /*
    public void removeAtIndex(int index) {
        for (int i = index; i < counterBook - 1; i++) {
            books[i] = books[i + 1];
        }
        counterBook--;
    }
   */


    //Den här biten kan strykas än så länge för att designen bakom
    //utlåningen inte verkar bestämd ännu.
    /*
    public void returnAtIndex(int index) {
        books[index].setAvailable(true);
    }
    private boolean setAvailable() {
        if (returnAtIndex() == true)
            return true;
        else
            return false;
    }
    */





    /*
    public void sort() {
        var copy = Arrays.copyOfRange(books, 0, counterBook);
        BubbleSort.sort(copy);
        books = copy;
    }
    private void BubbleSort() {
    } */





/*Library (klass) — huvudklassen som håller arrayer med böcker och medlemmar (fast storlek),
samt en array/struktur som håller reda på vilka böcker som är utlånade och till vem
Datalagring: böcker och medlemmar lagras i arrayer med fast storlek (ingen
ArrayList/Collections). Hantera fallet att arrayen är full
*/

/*Library class:
•	Book array
•	Member array
•	Loan information

Members och book ska användas av library.
Library ska äga Book[] books, Member[] members.

Library kanske kan kontrollera?
1.	finns medlemmen?
2.	finns boken?
3.	får medlemmen låna?

 */