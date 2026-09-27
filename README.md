# Library System
Java Library System

## Teknologi
- Java Oracle OpenJDK 25.0.2
- Intellij IDEA 2026.2.3
- Maven build tool
- Git 2.55.0.windows.5
- GitHub Jelena939  jelena.aleksejeva@iths.se  GPG-key verified 


## Författare 
Jelena Aleksejeva

## OBS! 
Jag hade tyvärr trasslat mig in med brancher när jag skapade projektet.
Jag har försökt lösa det, och det verkar som att jag lyckades, på ett något 
provisoriskt sätt. Däremot resulterade röran i att jag commitade Book-record
och README.md ett par gånger utan vettiga ändringar, bara för att kolla att 
det funkar. Självklart lär man sig och senare i livet kommer man att agera
mer professionellt. Kanske...

## Projektstruktur

- src/main/java/com/exemple/labb1_26
    - Books.java - record som innehåller final data som titel, författare, ISBN.
    - Members.java - klass som ska innehålla logik kring medlemmar och lån.
    - LibrarySystem.java - klass som innehåller arrayer för medlemmar och böcker; den 
samordnar allt. 
  - Library (Main.java) - interaktiv gränssnitt som användaren ser. Det är "en bild på 
skärmen som åskådaren iakttar." Allt annat är teknologi bakom.
  
    
## Reflektion

### Record kontra class
Jag väljer att använda record för att lagra en oföränderlig data om mina böcker.
Record passar bra just därför att information om en viss bok ändras inte - 
och själva record ändras inte efter skapandet.
Däremot skapar jag en klass för att lagra information om medlemmar. Klasser används
när objektets tillstånd kan ändras dvs när objektet har ett beteende, så som 
medlemmar i min bibliotek: de kan, t.ex., låna och returnera böcker.

