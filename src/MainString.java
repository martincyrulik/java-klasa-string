/**
 * String przechowuje tekst jako tablicę bajtów (byte). Dla ułatwienia operacji na
 * tekstach opakowano te rozwiązania w klasę. Programista nie musi zatem zajmować się
 * tworzeniem tabeli, zmienianiem jej rozmiarów itd.
 * Każdy bajt, to dziesiętna wartość znaku z tabeli Unicode. Np.
 * String s = "Hello"; jest przechowywane w Javie jako:
 * byte[] = {72, 101, 108, 108, 111};
 *
 * W Javie mamy dwie możliwości tworzenia obiektów typu String:
 * 1) z wykorzystaniem konstruktora
 * 2) z bezpośrednim przypisaniu wartości do zmiennej.
 *
 * Obiekty typu String są przechowywane na stercie gdy są tworzone z użyciem konstruktora,
 * w przypadku bezpośredniego przypisania wartości do zmniennej w specjalnej strukturze
 * String Pool, która z kolei przechowywana jest na stercie.
 */


public class MainString {
    public static void main(String[] args) {

        //Tworzenie obiektu typu String z wykorzystaniem konstruktora:
        String name1 = new String("Szymon"); //ten obiekt jest przechowywany na stercie
        System.out.println("Moje imię to: " + name1);

        //Tworzenie obiektu z bezpośrednim przypisaniem wartości do zmiennej
        String surname = "Kowalski";        // obiekt przechowywany w String Pool na stercie

        /**
         *Strig - to najczęściej używany typ w Javie, twórcy języka stworzyli dla nego specjalną
         * strukturę w pamięci o nazwie String Pool.
         *
         * Ciekawostka: ---> w String Pool teksty się nie powtarzają. W praktyce oznacza to, że
         * każda kolejna zmienna, która korzysta z tekstu, który jest już w pamięci String Pool
         * otrzymuje referencję do już istniejęacego obiektu w pamięci - nie jest dla niej
         * tworzone nowe osobne miejsce w pamięci. Dzięki takiej optymalizacji, Java nie musi
         * przechowywać powtarzających się tekstów.
         *
         * Klasa String to klasa immutable. Oznacza to - w największym skrócie - że jest
         * to klasa której obiektów nie możemy modyfikować.
         */

        //String to klasa immutable
        String title = "Ala ma kota";   //tekst zapisywany jest w String Pool

        //gdy przypiszę nową wartość
        title = "Ela ma kota";  //w tej sytuacji String stworzy nowy tekst i zmiennej title
                                //przypisze referencję do nowego tekstu (obiektu)/ Nie jest
                                //to więc typowa zmiana wartości obiektu, lecz podmiana na
                                //nowy obiekt.

        /**
         * Klasa String posiada wiele metod przydatnych podczas pracy z tekstami.
         * Obecnie jest ich około 75 :)
         */

        /***********************************************************************************
         *                               char charAt(int index)
         *
         * Metoda umożliwia pobranie znaku ze wskzanego indeksu. Pierwszy znak ma index = 0,
         * kolejny o 1 większy, itd. Metoda zwraca znak (char)
         ***********************************************************************************/

        //Dla podanej tablicy imion wyświetl te które rozpoczynają się na literę "K"
        String[] names = {"Marek", "Karol", "Justyna", "Karolina"};
        for (String name : names){
            if (name.charAt(0) == 'K'){
                System.out.println(name);
            }
        }

        /***********************************************************************************
         *                               int lastIndexOf(int ch)
         *
         * Metoda umożliwia sprawdzenie, na którym miejscu tekstu znajduje się ostanie
         * wystąpienie określonego znaku. Zwraca liczbę całkowitą.
         * Istnieją też przeciążenia:
         *
         * int lastIndexOf(int ch, int fromIndex)
         * int lastIndexOf(String str)
         * int lastIndexOf(String str, int fromIndex)
         *
         ***********************************************************************************/

        String text = "Lorem ipsum is sumply dummy text of the printing and typesetting industry. Lorem ipsum has been the industry's standard dummy text ever since 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
        System.out.println(text.lastIndexOf('.'));

        /***********************************************************************************
         *                               boolean startsWith(String prefix)
         *
         * Metoda umożliwia sprawdzenie czy tekst na którym wywoływana jest metoda, rozpoczyna
         * się innym tekstem (prefiksem). Zwraca wartość typu boolean.
         ***********************************************************************************/

        String[] pesels = {"99011222239", "88011751221", "50112751261"};
        for (String pesel : pesels){
            if(pesel.startsWith("88")){
                System.out.println(pesel);
            }
        }

        /***********************************************************************************
         *                               boolean endsWith(String suffix)
         *
         * Metoda umożliwia sprawdzenie czy tekst na którym wywoływana jest metoda, kończy się
         * innym tekstem (sufiksem). Zwraca wartość typu boolean.
         ***********************************************************************************/

        //Dla podanej tablicy nazw plików, wyświetl te, które mają rozszerzenie ".txt".

        String[] files = {"cv.pdf", "passwords.txt", "example.sql", "notes.txt", "draft.doc"};
        for (String file: files){
            if (file.endsWith(".txt")){
                System.out.println(file);
            }
        }

        /***********************************************************************************
         *                               int length()
         *
         * Metoda umożliwia sprawdzenie długości tekstu. Zwraca liczbę całkowitą.
         *
         ***********************************************************************************/

        //Dla podanej tablicy imion wyświeyl te, których długość jest większa niż 5

        String[] names2 = {"Marek", "Karol", "Justyna", "Karolina"};
        for (String name : names2){
            if (name.length() > 5){
                System.out.println(name);
            }
        }

        /***********************************************************************************
         *                             boolean isEmpty()
         *
         * Metoda zwraca true, gdy tekst jest długości 0, w przeciwnym wypadku zwraca false
         *
         ***********************************************************************************/

        //Sprawdź czy tekst jest długości 0
        String something = "abc";
        if (something.isEmpty()){
            System.out.println("Tekst ma długość 0");
        } else {
            System.out.println("Tekst nie ma długości 0");
        }

        /***********************************************************************************
         *                             String repeat(int count)
         *
         * Metoda tworzy nowy tekst, który jest wielokrotnością tekstu, na którym
         * wywoływana jest metoda.
         *
         ***********************************************************************************/

        //Dla podanego tekstu powiel go 100-krotnie. Tak przygotowany tekst może przydać się
        //jako dane przykładowe dla innego zadania.
        String tekst = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n";
        String newText = tekst.repeat(100);
        System.out.println(newText);

        /***********************************************************************************
         *                     String replace(char oldChar, char newChar)
         *
         * Metoda tworzy nowy tekst, na podstawie tekstu, na którym jest wywoływana. W nowym
         * tekście zostanie zamieniony pierwszy znaleziony znak 'oldChar' na 'newChar'
         *
         ***********************************************************************************/

        //Dla podanego tekstu zamień pierwsze wystąpienie 'x' na 'Z'
        text = "Lorem ipsum is simply dummy text of the printing and typesetting industry.";
        text = text.replace('x', 'Z');
        System.out.println(text);

        /***********************************************************************************
         *               String replaceAll(String regex, String replacement)
         *
         * Metoda tworzy nowy tekst, na podstawie tekstu, na którym jest wywoływana. W nowym
         * tekście zostaną zamienione wszystkie Stringi określone w 'regex' na
         * 'replacement'.
         *
         ***********************************************************************************/

        //Zamień w tekście wszystkie słowa "śnieg" na "deszcz". Wyświetl nowy tekst.

        text = "Gdy pada śnieg, ulice stoją w korkach. Są miejsca, w których opady śniegu występują przez cały rok.";
        text = text.replaceAll("śnieg", "deszcz");
        System.out.println(text);

        /***********************************************************************************
         *                      String[] split(String regex)
         *
         * Metoda umożliwia stworzenie tablicy tekstów na podstawie tekstu, na którm jest
         * wywoływana. Regex dopuszcza wywrażenie regularne, ale w najprostszej formie,
         * może to być wskazanie znaku, który służy jako separator
         *
         *                      String[] split(String regex, int limit)
         * Metoda ogranicza liczbę słów, na które zostanie podzielony tekst.
         *
         ***********************************************************************************/

        //Dla podanego tekstu, policz ile ma słów.

        text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        String[] words = text.split(" ");
        System.out.println("Number of words: " + words.length);

        /***********************************************************************************
         *                              String trim()
         *
         * Metoda tworzy nowy tekst, na podstawie tekstu, na którym jest wywoływana. Nowy
         * tekst nie posiada początkowych i końcowych białych znaków typu: spacja, tabulacja,
         * nowa linia itp.
         *
         ***********************************************************************************/

        /***********************************************************************************
         *                              String strip()
         *
         * Metoda tworzy nowy tekst, na podstawie tekstu, na którym jest wywoływana. Nowy
         * tekst nie posiada początkowych i końcowych białych znaków typu: spacja, tabulacja,
         * nowa linia itp.
         *
         *              String stripLeading() oraz String stripTrailing()
         * Metody odpowiedzialne są za usuwanie białych znaków odpowiednio
         * na początku i końcu tekstu
         *
         ***********************************************************************************/

        /***********************************************************************************
         *                              trim vs strip
         *
         * Metoda strip() została wprowadzona w Javie 11. Metoda strip wykorzystuje
         * metodę Character.isWhitespace(int).
         *
         * Metoda trim() jest w Javie od momentu jej powstania, korzysta z warunku, który mówi,
         * że białym znakiem jest wszystko, co jest mniejsze lub równe \u0020 w Unicode.
         *
         * Obecnie istnieją białe znaki zdefiniowane w wyższym zakresie niż \u0020, których
         * trim() nie obejmuje (np. \u2001). Dlatego rekomendowane jest użycie metody strip.
         *
         ***********************************************************************************/

        //Dla podanego tekstu stwórz nowy, bez końcowych i początkowych białych znaków.
        text = "\u2001 Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n\n";
        String textTrimmed = text.trim();
        System.out.println(textTrimmed);

        String textStripped = text.strip();
        System.out.println(textStripped);

        /***********************************************************************************
         *                      String substring(int beginIndex)
         *
         * Metoda tworzy nowy tekst na podstawie tekstu, na którym jest wywoływana. Nowy
         * tekst jest podzbiorem tekstu bazowego. W przypadku tej metody będzie to tekst
         * od indeksu 'beginIndex' do końca.
         *
         *                  String substring(int beginIndex, int endIndex)
         * Metoda tworzy nowy tekst, który jest podzbiorem od 'beginIndex' do 'endIndex'
         *
         ***********************************************************************************/

        //Dla podanych numerów pesel wyciągnij dzień i miesiąc urodzenia osoby. Wyświetl te dane.
        String[] nrPesels = {"99011222239", "88011751221", "50112751261"};
        for (String pesel : nrPesels){
            String month = pesel.substring(2, 4);
            String day = pesel.substring(4, 6);
            System.out.println(day + "." + month);
        }

        /***********************************************************************************
         *                            char[] toCharArray()
         *
         * Metoda tworzy tablicę znaków na podstawie tekstu.
         *
         ***********************************************************************************/

        //Dla podanych ciągów liczb wyświetl tylko liczby parzyste. Np. 12312 -> 22, 5429 -> 42

        String[] numbers = {"5412", "55123541", "1188", "987654321"};
        for (String  number : numbers){
            for (char c : number.toCharArray()){
                if (c % 2 == 0){
                    System.out.println(c);  //!!! c jest odpowiednikiem dziesiętnym w tabeli kodów ASCII
                }                   //ale na szczęście parzysty kod dziesiętny odpowiada jednocześnie
            }                       //parzysemu znakowi (liczbie) w tabeli Unicode.
        }

        /***********************************************************************************
         *                            String to LowerCase()
         *
         * Metoda tworzy nowy tekst, którego wszystkie znaki są małymi literami.
         *
         ***********************************************************************************/

        //Dla podanych nazw użytkowników, zamień je na małe litery.
        // Po zmianie wartości wyświetl wynik w konsoli

        String[] users = {"Marek12", "JuRekStefffaniak", "buziaczekDEFnowy"};
        for (int i = 0; i < users.length ; i++) {
            users[i] = users[i].toLowerCase();
        }
        for (String user : users){
            System.out.println(user);
        }

        /***********************************************************************************
         *                            SEKWENCJE WYWOŁAŃ
         *
         * Wszystkie mwtody z klasy String zwracające nowy String umożliwiają
         * wywoływanie metod sekwencyjnie, jedna po drugiej.
         *
         ***********************************************************************************/

        //Dla podanego tekstu:
        // -->  usuń początkowe i końcowe białe znaki
        // -->  usuń wszystkie przecinki
        // -->  zamień wszystkie spacje na średniki
        // -->  zamień wszystkie znaki na małe litery
        text = "    Jurek, Czarek i Karol znają się od lat";
        String newtext = text.strip().replaceAll(",", "").replaceAll(" ", ";").toLowerCase();
        System.out.println(newtext);


    }
}
