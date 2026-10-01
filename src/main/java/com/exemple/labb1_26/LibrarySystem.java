package com.exemple.labb1_26;

public class LibrarySystem {
    static void main() {

        Library library = new Library();

        //Boklistan (fyller 12 platser av 14; efteråt får array växa)
        library.addBook(new Book("Florentine", "Emiko Davies", "9781743796764"));
        library.addBook(new Book("Cuisine on screen", "Sachiyo Harada", "9783791393216"));
        library.addBook(new Book("Asiatiska smaker", "Jennie Wallden", "9789174246209"));
        library.addBook(new Book("Teranga", "Coura Mbaye", "978917887584"));
        library.addBook(new Book("The Art of Japanese Cooking", "Shizuo Tsuji", "9781568363882"));
        library.addBook(new Book("Food Pharmacy", "Lina Nertby Aurell, Mia Clase", "9789174245684"));
        library.addBook(new Book("Mastering the Art of Soviet Cooking", "Anya von Bremzen",  "9780552777476"));
        library.addBook(new Book("Mat är Kultur", "Massimo Montanari", "9789186119003"));
        library.addBook(new Book("Italian Food", "Elizabeth David", "9780141181554"));
        library.addBook(new Book("Mastering the Art of French Cooking", "Julia Child", "9780241953396"));
        library.addBook(new Book("Italian Cuisine: a Cultural History", "Massimo Montanari", "9780231122320"));
        library.addBook(new Book("Chiltern Firehouse the Cookbook", "Nuno Mendes", "9781848094659"));

        //Medlemslistan (fyller 6 platser av 7; efteråt får array växa)
        library.addMember(new Member("1111", "Frodo Baggins"));
        library.addMember(new Member("2222", "Samwise Gamgee"));
        library.addMember(new Member("3333", "Gandalf the Grey"));
        library.addMember(new Member("4444", "Bilbo Baggins"));
        library.addMember(new Member("5555", "Sauron"));
        library.addMember(new Member("6666", "Gimli"));

        boolean running = true;
        do {
            printMenu();

            var choice = IO.readln("Enter your choice: ");

            if (!choice.matches("[1-8]")) {
                System.out.println("You must enter a number between 1 and 8.");
                continue;
            }

            switch (choice) {
                case "1" -> addBook(library); //På så sätt händer metod anrop
                case "2" -> findBook(library);
                case "3" -> borrowBook(library);
                case "4" -> returnBook(library);
                case "5" -> addMember(library);
                case "6" -> showBooks(library);
                case "7" -> showMembers(library);
                case "8" -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (running);
    }

    //Fungerar! (testar felaktig inmatning som: 8, f, @)
    public static void printMenu() {
        String menuText = """
                Menu
                ----------
                Welcome to the Library Management System!
                Please select an option:
                1. Add a new book
                2. Search for a book (by title or author)
                3. Borrow a book
                4. Return a book
                5. Add a new member
                6. Show all books
                7. Show all members
                8. Exit
                """;
        System.out.println(menuText);
    }

    //Fungerar! (yes, array växer när man lägger till fler böcker än det finns platser)
    private static void addBook(Library library) {

        String title = IO.readln("Enter book title: ");
        String author = IO.readln("Enter book author: ");
        String isbn = IO.readln("Enter book ISBN: ");

        Book book = new Book(title, author, isbn);

        library.addBook(book);

        System.out.println("Book added successfully!");
    }

    //Fungerar! (toLower; author vs title)
    private static void findBook(Library library) {

        String searchText = IO.readln("Enter title or author: ");

        library.findBook(searchText);
    }

    //Fungerar! (MAX loans, toLower); men inte på del av titel
    private static void borrowBook(Library library) {

        String text = IO.readln("Enter book title: ");
        String memberID = IO.readln("Enter member ID: ");
        int bookIndex = library.findBookIndex(text);
        if(bookIndex == -1) {
            System.out.println("Book not found");
            return;
        }

        Member member = library.findMember(memberID);
        if(member == null) {
            System.out.println("Member not found");
            return;
        }
        boolean success = library.borrowBook(bookIndex, member);
        if(success)
            System.out.println("Book borrowed successfully");
        else
            System.out.println("This book is already borrowed or reader has " +
                    "reached maximum number of loans allowed for one member");
    }

     //Fungerar
    private static void returnBook(Library library){

        String text = IO.readln("Enter book title: ");
        int bookIndex = library.findBookIndex(text);
        if(bookIndex == -1) {
            System.out.println("Book not found");
            return;
        }
        if (library.returnBook(bookIndex))
            System.out.println("Book returned successfully");
        else
            System.out.println("Book could not be returned");
    }

    //Fungerar. (hindrar medlemmar med samma ID, array växer)
    private static void addMember(Library library){

        String memberID = IO.readln("Enter new member ID: ");
        String name = IO.readln("Enter name: ");
        Member member = new Member(memberID, name);

        boolean added = library.addMember(member); //samma princip som med success
        if (added) {
            System.out.println("New member added successfully");
        }
        else {
            System.out.println("Member with ID " + member.getMemberID() + " already exists. " +
                    "Choose another combination.");
        }
    }

    //Funkar (Shows books in order, shows if available or if isBorrowed and by whom)
    private static void showBooks(Library library){
        library.showBooks();
    }


    //Funkar (updates active loans)
    private static void showMembers(Library library){
        library.showMembers();
    }
}
