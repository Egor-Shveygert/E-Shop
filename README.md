**Eshop**

Cielom projektu je naprogramovať aplikačný server v jazyku Java s pomocou frameworku Spring.

Aplikačný server umožňuje správu tovaru, skladu a nákupných košíkov.
Webové rozhranie (API), ako aj objekty, ktoré sa používajú na komunikáciu s vonkajším svetom sú definované v zadaní a musi byť použité na komunikáciu cez webové služby. Mimo webového rozhrania môžete použiť ďalšie objekty podľa vášho návrhu, ak to uznáte za vhodné.

Špecifikáciu webového rozhrania, ktoré má aplikácia poskytovať nájdete tu: https://app.swaggerhub.com/apis-docs/sk-stuba-fei-uim-oop/OOP_Zadanie_3/1.0.0

Pokiaľ je v API uvedené, že sa má vrátiť kód 404 a v popise nie je povedané kedy, je ho potrebné vrátiť v prípade, že poskytnuté ID v systéme neexistuje.

### Popis systému

Podrobný popis jednotlivých operácii je uvedený v špecifikácii API.

Systém umožňuje pridávanie a odoberanie produktov zo sortimentu obchodu. Ďalej umožňuje úpravu existujúcich produktov, ako aj navýšenie stavu produktov na sklade.

Systém umožňuje vytváranie a vymazávanie objednávok. Do objednávok je možné pridávať produkty v určenom množstve (pokiaľ je produktu na sklade dostatok). Systém ďalej umožňuje zaplatenie ešte nezaplatených objednávok. Do zaplatených objednávok nie je možné pridávať ďalšie položky.

## Automatizované testy

Projekt obsahuje automatizované testy. Testy sa **NESPÚŠŤAJÚ** automaticky pri git push. Pokiaľ si chcete overiť na koľko vaša implementácia spĺňa testy musíte si ich spustiť sami. Testy sa dajú spustiť 2 spôsobmi:
* cez Maven, spustením _test_ lifecycle-u (bočné menu > maven > _projekt_ > lifecycle > test)
* spustením testov rovno z triedy ktorá ich obsahuje (nachádza sa v src/test/sk/.../oop/assignment3/Assignment3Tests.java)

-----------------------
**Eshop**

Task is to create an application server using Java with the Spring framework.

Application server  enables management of the goods, warehouse and shopping carts. Web Interface(API), and also the objects that are used to communicate with the outside world are defined in the specification and must be used to communicate through web services. Outside the web interface you can use any other objects according to your design, if you deem it appropriate.

Web interface specification that the application has to provide can be found here: https://app.swaggerhub.com/apis-docs/sk-stuba-fei-uim-oop/OOP_Zadanie_3/1.0.0

If the specification states that a 404 code should be returned, and the description does not say when, it is necessary to return if given ID does not exist in the system.

### System description

A detailed description of each operation is given in the API specification.

The system allows adding and removing products from the store's assortment. Also, it allows editing of existing products as well as increase the status of products in stock.

The system allows you to create and delete orders. It is possible to add products in orders in the specified quantity (if there is enough product in stock). The system also allows the payment of unpaid orders. It is not possible to add additional items to paid orders.

## Automatic tests
Project contains automatic tests. Tests **DO NOT** run automatically on git push. If you want to verify how many of your implementations pass the tests, you must run them yourself. Tests can be run in 2 ways:

* using Maven, by launching lifecycle (side menu> maven> project> lifecycle> test)
* by running tests directly from the class that contains them (located in rc/test/sk/.../oop/assignment3/Assignment3Tests.java))
