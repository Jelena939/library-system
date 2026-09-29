package com.exemple.labb1_26;

public class LibrarySystem {
    static void main() {

        Library library = new Library();

        //Böcker
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

        //Medlemmar
        Member member0 = library.addMember(new Member("1111", "Frodo Baggins", 0));
        Member member1 = library.addMember(new Member("2222", "Samwise Gamgee", 0));
        Member member2 = library.addMember(new Member("3333", "Gandalf the Grey", 0));
        Member member3 = library.addMember(new Member("4444", "Bilbo Baggins", 0));
        Member member4 = library.addMember(new Member("5555", "Sauron", 0));
        Member member5 = library.addMember(new Member("6666", "Gimli", 0));


        Member member = library.findMember("1111");
        /*
        Todo 1. Programmet ska köra i en loop och visa en meny tills användaren väljer att avsluta. YAS

        todo 2. Meny & interaktivitet: en robust meny (Scanner) som hanterar felaktig inmatning (t.ex.
todo bokstäver där siffror förväntas) utan att programmet kraschar. YAS

todo 6. Felhantering: tydliga meddelanden vid t.ex. bok/medlem som inte hittas, bok som redan är
todo utlånad, eller ogiltiga menyval — programmet ska aldrig krascha på grund av felaktig inmatning.
         */
        boolean running = true;
        do {
            printMenu();

            var choice = IO.readln("Enter your choice: ");

            //Det här gör att tecken som inte är siffror 1 till 7 (t.ex. bokstäver, symboler, 106)
            //fångas och inte ger krasch!
            //Skulle jag använt int istället för String, då måste jag använda try/catch annars
            //kraschar programmet när anv skriver in bokstäver där siffror förväntas
            //Princip: Om du läser in data som String först och validerar den innan
            //konvertering, blir programmet ofta mycket robustare.
            if (!choice.matches("[1-7]")) {
                System.out.println("You must enter a number between 1 and 7.");
                continue;
            }

            switch (choice) {
                case "1" -> addBook(library); //På så sätt händer metod anrop
                case "2" -> findBook(library);//När användaren väljer alternativ 2 ska jag: 1. Fråga efter söktext.
                //2. Ta emot söktexten. 3. Skicka söktexten till library.findBook(...).
                case "3" -> borrowBook(library); //todo 4. kontrollera att boken
                //todo finns och inte redan är utlånad.
                case "4" -> returnBook(library);
                case "5" -> addMember(library);
                case "6" -> showBooks(library); //todo 5.Visa samtliga böcker
                //todo med status (utlånad/tillgänglig och till vem)
                case "7" -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");

            }

        } while (running);


    }

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
                7. Exit
                """;
        System.out.println(menuText);
    }

    //fylla in alla metoder enligt hur den ser ut
    private static void addBook(Library library) {
        String title = IO.readln("Enter book title: ");
        String author = IO.readln("Enter book author: ");
        String isbn = IO.readln("Enter book ISBN: ");

        Book book = new Book(title, author, isbn);
        library.addBook(book); //jag måste lägga den på ett tomt plats i array
    }

    private static void findBook(Library library) {

        //Den här hela scharangen kunde jag skriva in i switch
        String searchText = IO.readln("Enter title or author: ");

        library.findBook(searchText);
    }

    private static void borrowBook(Library library) {

        String text = IO.readln("Enter book title or author: ");
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
            System.out.println("Book could not be borrowed");
     }

    private static void returnBook(Library library){


    }

    private static void addMember(Library library){

    }

    private static void showBooks(Library library){
        library.showBooks();


    }






}


/*
  boolean running = true;
        do {
            printMenu();

            var choice = IO.readln("Enter your choice: ");

            //Det här gör att tecken som inte är siffror 1 till 7 (t.ex. bokstäver, symboler, 106)
            //fångas och inte ger krasch!
            //Skulle jag använt int istället för String, då måste jag använda try/catch annars
            //kraschar programmet när anv skriver in bokstäver där siffror förväntas
            //Princip: Om du läser in data som String först och validerar den innan
            //konvertering, blir programmet ofta mycket robustare.
            if (!choice.matches("[1-7]")) {
                System.out.println("You must enter a number between 1 and 7.");
                continue;
            }

            switch (choice) {
                case "1" -> System.out.println("You choose to add a book");
                case "2" -> System.out.println("You chose to search for a book.");//todo 3. Söka bok på (del av)
                //todo titel eller författare, skiftlägesokänsligt, via egen sökloop (linjärsökning)
                case "3" -> System.out.println("You chose to borrow a book."); //todo 4. kontrollera att boken
                //todo finns och inte redan är utlånad.
                case "4" -> System.out.println("You choose to return a book.");
                case "5" -> System.out.println("You chose to add a new member.");
                case "6" -> System.out.println("You chose to show all books."); //todo 5.Visa samtliga böcker
                //todo med status (utlånad/tillgänglig och till vem)
                case "7" -> System.exit(0);
                default -> System.out.println("Invalid choice. Please try again.");

            }

        } while (running);



 */
