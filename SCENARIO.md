# Scenariusze Testowe
Strona internetowa: http://seleniumdemo.com

# RegisterTest

### Scenariusz 1: Poprawna rejestracja.
**Opis:** Użytkownik rejestruje się do aplikacji przy użyciu poprawnych danych.

**Kroki:**
1. Otwórz stronę rejestracji.
2. W polu "Email address" wprowadź poprawny adres email.
3. W polu "Password" wprowadź poprawne hasło.
3. Kliknij przycisk "Register".

**Oczekiwany wynik:** 
 - System prawidłowo zarejestruje użytkownika.
 - Na ekranie pojawi się sekcja "My account"
 - Weryfikacja tekstu przywitania. 
******************************************************
### Scenariusz 2: Próba rejestracji użytkownika z adresem email wcześniej wykorzystanym przy rejestracji.
**Opis:** Użytkownik dokonuje próby rejestracji za pomocą adresu email, który został wcześniej wykorzystany do rejestracji.

**Kroki:**
1. Otworzyć stronę rejestracji.
2. Dokonać prawidłowej rejestracji. Po rejestracji wylogować się.
3. W polu "Email address" wprowadź email wykorzystany przy rejestracji w kroku 1
4. W polu "Password" wprowadź poprawne hasło.
5. Kliknij przycisk "Register".

**Oczekiwany wynik:** 
 - System uniemożliwi dokonanie rejestracji.
 - Na ekranie pojawi się komunikat błędu: "Error: An account is already registered with your email address. Please log in."
******************************************************
### Scenariusz 3: Próba rejestracji bez podania adresu email oraz hasła.
**Opis:** Weryfikacja zachowania strony w momencie próby rejestracji bez podania adresu email oraz hasła.

**Kroki:**
1. Otworzyć stronę rejestracji.
2. Kliknij przycisk "Register"

**Oczekiwany wynik:** 
 - System uniemożliwi dokonanie rejestracji.
 - Na ekranie pojawi się komunikat błędu: "Error: Please provide a valid email address.".
******************************************************
### Scenariusz 4: Próba rejestracji bez podania hasła. 
**Opis:** Weryfikacja zachowania strony w momencie próby rejestracji bez podania hasła.

**Kroki:**
1. Otwórz stronę rejestracji.
2. W polu "Email address" wprowadź poprawny adres email.
3. Kliknij przycisk "Register"

**Oczekiwany wynik:** 
 - System uniemożliwi dokonanie rejestracji.
 - Na ekranie pojawi się komunikat błędu: "Error: Please enter an account password.".
******************************************************
 ### Scenariusz 5: Próba rejestracji bez podania adresu email.
**Opis:** Weryfikacja zachowania strony w momencie próby rejestracji bez podania adresu email.

**Kroki:**
1. Otwórz stronę rejestracji.
2. W polu "Password" wprowadź poprawne hasło.
3. Kliknij przycisk "Register".

**Oczekiwany wynik:** 
 - System uniemożliwi dokonanie rejestracji.
 - Na ekranie pojawi się komunikat błędu: "Error: Please provide a valid email address.".
******************************************************
### Scenariusz 6: Weryfikacja walidacji hasła "Very weak".
**Opis:** Weryfikacja poprawności walidacji hasła "Very weak".

**Kroki:**
1. Otwórz stronę rejestracji.
2. W polu "Email address" wprowadź poprawny adres email.
3. W polu "Password" wprowadź hasło spełniające założenia "Very weak".

**Oczekiwany wynik:** 
 - Pod polem "password" pojawi się komunikat "Very weak - Please enter a stronger password.".
******************************************************
### Scenariusz 7: Weryfikacja walidacji hasła "Weak".
**Opis:** Weryfikacja poprawności walidacji hasła "Weak".

**Kroki:**
1. Otwórz stronę rejestracji.
2. W polu "Email address" wprowadź poprawny adres email.
3. W polu "Password" wprowadź hasło spełniające założenia "Weak".

**Oczekiwany wynik:** 
 - Pod polem "password" pojawi się komunikat "Weak - Please enter a stronger password.".
 ******************************************************
### Scenariusz 8: Weryfikacja walidacji hasła "Medium".
**Opis:** Weryfikacja poprawności walidacji hasła "Medium".

**Kroki:**
1. Otwórz stronę rejestracji.
2. W polu "Email address" wprowadź poprawny adres email.
3. W polu "Password" wprowadź hasło spełniające założenia "Medium"

**Oczekiwany wynik:** 
 - Pod polem "password" pojawi się komunikat "Medium".
******************************************************
### Scenariusz 9: Weryfikacja walidacji hasła "Strong".
**Opis:** Weryfikacja poprawności walidacji hasła "Strong".

**Kroki:**
1. Otwórz stronę rejestracji.
2. W polu "Email address" wprowadź poprawny adres email.
3. W polu "Password" wprowadź hasło spełniające założenia "Strong".

**Oczekiwany wynik:** 
 - Pod polem "password" pojawi się komunikat "Strong"
******************************************************
# LoginTest

### Scenariusz 1: Poprawne logowanie.
**Opis:** Użytkownik loguje się do aplikacji przy użyciu poprawnych danych.

**Kroki:**
1. Otwórz stronę rejestracji.
2. Poprawnie Zarejestruj nowego użytkownika.
3. Wyloguj użytkownika.
4. W polu "Username or email address" wprowadź poprzedni zarejestrowany adres email.
5. W polu "Password" wprowadź hasło użytkownika.
6. Kliknij przycisk "Log in".

**Oczekiwany wynik:** 
 - Użytkownik prawidłowo zalogował się do aplikacji.
 - Na ekranie widoczny ekran zalogowane użytkownika.
******************************************************
### Scenariusz 2: Nieudane logowanie.
**Opis:** Użytkownik próbuje się zalogować przy użyciu nieprawidłowego hasła.

**Kroki:**
1. Otwórz stronę rejestracji.
2. Poprawnie Zarejestruj nowego użytkownika.
3. Wyloguj użytkownika.
4. W polu "Username or email address" wprowadź poprzedni zarejestrowany adres email.
5. W polu "Password" wprowadź błędne hasło użytkownika.

**Oczekiwany wynik:** 
 - System uniemożliwił zalogowanie się użytkownika.
 - Na ekranie komunikat błędu "Incorrect username or password.".
******************************************************
# CheckoutTest

### Scenariusz 1: Weryfikacja poprawności zamówienia.
**Opis:** Weryfikacja pełnej ścieżki zamówienia danego produktu.

**Kroki:**
1. Otwórz stronę sklepu.
2. Przejść do strony produktu.
3. Dodać produkt do koszyka poprzez kliknięcie przycisku "Add to cart".
4. Przejść do zawartości koszyka poprzez wybranie przycisku "View cart".
5. Przejść do szczegółów zamówienia poprzez wybranie przycisku "Procced to checkout".
6. Uzupełnić formularz a następnie potwierdzić przyciskiem "Place order".

**Oczekiwany wynik:** 
 - Zamówienie zakończyło się powodzeniem.
 - Weryfikacja strony z podsumowaniem zamówienia.
 - Weryfikacja poprawności zamówienie konkretnego produktu.
******************************************************
# BuyProductTest

### Scenariusz 1: Weryfikacja poprawności komunikatu dodania produktu.
**Opis:** Weryfikacja poprawności komunikatu dodania konkretnego produktu do koszyka.

**Kroki:**
1. Otwórz stronę sklepu.
2. Przejść do strony produktu "Java Selenium WebDriver".
3. Dodać produkt do koszyka poprzez kliknięcie przycisku "Add to cart".

**Oczekiwany wynik:** 
 - Na ekranie pojawia się komunikat "Java Selenium WebDriver” has been added to your cart." informujący o poprawności dodania produktu do koszyka.
******************************************************
### Scenariusz 2: Weryfikacja zawartości koszyka w przypadku dodania jednego produktu.
**Opis:** Weryfikacja zawartości koszyka w przypadku dodania jednego produktu.

**Kroki:**
1. Otwórz stronę sklepu.
2. Przejść do strony produktu "Java Selenium WebDriver".
3. Dodać produkt do koszyka poprzez kliknięcie przycisku "Add to cart".
4. Przejść do zawartości koszyka poprzez wybranie przycisku "View cart".

**Oczekiwany wynik:** 
 - W koszyku prawidłowo znajduje się jeden produkt "Java Selenium WebDriver".
******************************************************
### Scenariusz 3: Weryfikacja zawartości koszyka w przypadku dodania dwóch produktów.
**Opis:** Weryfikacja zawartości koszyka w przypadku dodania dwóch produktów.

**Kroki:**
1. Otwórz stronę sklepu.
2. Przejść do strony produktu "Java Selenium WebDriver".
3. Kliknąć "Add to cart" pod nazwą produktu "GIT basics".
4. Kliknąć "Add to cart" pod nazwą produktu "Java Selenium WebDriver".
5. Przejść do zawartości koszyka poprzez wybranie przycisku "View cart".

**Oczekiwany wynik:** 
 - W koszyku prawidłowo znajdują się dwa produkty: "GIT basics" oraz "Java Selenium WebDriver".
******************************************************
