# Library System
Java Library System

## Teknologi
- Java Oracle OpenJDK 25.0.2
- Intellij IDEA 2026.2.3
- Maven build tool
- Git 2.55.0.windows.5
- GitHub Jelena939  jelena.aleksejeva@iths.se


## Författare 
Jelena Aleksejeva

## Projektstruktur

- src/main/java/com/exemple/labb1_26
    - Book.java - record som innehåller oföränderlig data om böcker som titel, författare, ISBN.
    - Member.java - klass som innehåller logik kring enskilda medlemmar och lån.
    - Library.java - klass sköter logik kring medlem- och bokklasser och kopplar den till main metoden 
  LibrarySystem. Klassen innehåller arrayer med medlemmar och böcker; arrayer växer när nya medlemmar
  och böcker läggs till. Klassen innehåller metoder som söker, adderar och visar bok- och medlemslistor
  samt hanterar utlåning, returnering av böcker.
  - LibrarySystem.java - gränssnitt där användaren interagerar med programmet. Innehåller menyn med
  olika val och länkar den till aktuella metoder i Library klassen och visar resultatet av användarens val.
  
  
    
## Reflektion

### Record kontra class
Jag väljer att använda record för att lagra en oföränderlig data om mina böcker.
Record passar bra just därför att information om en viss bok ändras inte - 
och själva record ändras inte efter skapandet.
Däremot skapar jag en klass för att lagra information om medlemmar. Klasser används
när objektets tillstånd kan ändras dvs när objektet har ett beteende, så som 
medlemmar i min bibliotek: de kan, t.ex., låna och returnera böcker.

Så tanken är att användaren läser menyn och gör ett val. Valet anropar en specifik metod i
Library klassen. Library klassen sköter aktuell samarbete mellan medlems- och bokklasser
och kopplar den tillbaka till main genom att returnera svar. Pågår så länge tills användaren
väljer att avsluta programmet.

