### Luokkakaavio

Period-luokkaan liitetään jakson Day-oliot, sekä käytettävissä olevat työntekijät eli Person-oliot. Day-luokan eri Shift-kenttiin lisätään kyseisen päivän työvuoroissa olevat työtenkijät, eli Person-olioiden nimet. Toisaalta Person-olioille lisätään Day-olioiden työvuorot, joissa he ovat töissä.


![Luokkakaavio](https://github.com/Jikke/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/sekvenssikaavio.png)


### Sekvenssikaavio

Alla kuvattuna Period-luokan luonti sekvenssikaaviona. Alussa käyttäjä syöttee Menu-oliolle arvon 1, jonka jälkeen pyydetään antamaan aamu-, ilta-, ja yövuorojen minimityöntekijöiden määrän. Onnistuneen arvojen syötön jälkeen luodaan uusi Period-olio, joka luo 21 kappaletta Day-olioita. Nämä lidsätään Period-olion days-jonoon. Tämän jälkeen Menu lisää currentPeriod-kenttään uuden Period-luokan olion. Lopuksi palautetaan Menu.display(); metodilla käyttäjä takaisin Menu-näkymään.

![Sekvenssikaavio](https://github.com/Jikke/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/sekvenssikaavio1.png)
