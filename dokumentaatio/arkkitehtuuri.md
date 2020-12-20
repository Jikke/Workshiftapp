# Arkkitehtuurikuvaus

### Pakkaukset

_Workshiftapp.ui_ -paketti on sovellukselle JavaFX:llä toteutettu käyttöliittymä. Sovelluslogiikka löytyy _Workshiftapp.domain_ -paketista.

### Käyttöliittymä

Sovellus aukeaa UI.java-luokan luomaan Päävalikko-näkymään, jossa on seuraavat kuusi valintaa

 - Luo uusi jakso
 - Lisää työntekijöitä
 - Työntekijöiden lisääminen vuoroihin
 - Työjakson tarkastelu
 - Työntekijän vuoron tarkastus
 - Poistu
 
Kaikki valinnat avaavat uudet näkymät, jotka ovat omia Scene-oloitaan. Virheilmoitukset, sekä jakson luomisilmoitus ovat toteutettu AlertBox-luokan display-metodin palauttamalla ilmoitusikkunalla.

UI.java-luokka on irroitettu muusta sovelluslogiikasta. Se vain antaa parametrit metodeille, jotka Period- , Day-  ja Person-luokat toteuttavat.

### Tiedostojen tallennus

Valinnalla "Työjakson tarkastelu" tallennetaan työjakson työvuorotiedot tektitiedostoon _period_files_ -kansioon. Niitä voi muokata ja uudelleentallentaa samalla valinnalla. Sovelluksen sulkemisen yhteydessä sovellus kysyy käyttäjältä, haluaako tämä tyhjentää _period_files_ -kansion sisällön vai säilyttää sen.

### Luokkakaavio

Period-luokkaan liitetään jakson Day-oliot, sekä käytettävissä olevat työntekijät eli Person-oliot. Day-luokan eri Shift-kenttiin lisätään kyseisen päivän työvuoroissa olevat työtenkijät, eli Person-olioiden nimet. Lisäksi Person-olioille lisätään Day-olioiden työvuorot, joissa he ovat töissä.


![Luokkakaavio](https://github.com/Jikke/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/luokkakaavio.png)


### Sekvenssikaavio

Alla kuvattuna Period-luokan luonti sekvenssikaaviona. Alussa käyttäjä valitsee Päävalikossa "Luo uusi jakso"-valinnan, jonka jälkeen pyydetään antamaan aamu-, ilta-, ja yövuorojen minimityöntekijöiden määrän. Onnistuneen arvojen syötön jälkeen luodaan uusi Period-olio, joka luo 21 kappaletta Day-olioita. Nämä lisätään Period-olion days-jonoon. Tämän jälkeen Menu lisää currentPeriod-kenttään uuden Period-luokan olion. Lopuksi palautetaan Päävalikko-näkymä AlertBox-ilmoituksen jälkeen.

![Sekvenssikaavio](https://github.com/Jikke/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/sekvenssikaavio.png)
