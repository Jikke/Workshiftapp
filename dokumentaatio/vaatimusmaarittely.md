# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla suunnitellaan työntekijöiden työvuorot työjaksoille. Sovelluksen tarkoitus on helpottaa työvuorojen suunnittelijan työtä.

## Käyttäjät

Tällä hetkellä sovelluksella on vain _vuorosuunnittelija_ -käyttäjärooli. Myöhemmin voitaisiin lisätä _työntekijä_ -käyttäjärooli, joka voi tarkastella itselleen määrättyjä työvuoroja.

## Käyttöliittymä

Sovellus aukeaa valikkoon, jossa on seuraavat valinnat:

   - Luo uusi jakso
   - Lisää työntekijöitä
   - Työntekijöiden lisääminen vuoroihin
   - Työjakson tarkastelu
   - Työntekijän vuoron tarkastelu
   - Poistu

## Sovelluksen tarjoama toiminnallisuus

### Luo uusi jakso

- Jakson luonnin yhteydessä pyydetään minimityöntekijävaatimukset kullekin vuorolle (aamu, ilta, yö). 

### Lisää työntekijöitä

   - Luodaan _työntekijä_ -oliot tälle työjaksolle antamalla työntekijän nimi.
  
### Työntekijöiden lisääminen vuoroihin

   - Määritellään kyseisen työntekijän työvuorot ja vapaat kullekin työjakson vuorokaudelle.

### Työjakson tarkastelu

   - Pyytää nimen .txt-tiedostolle, johon listataan työntekijöiden vuorot vuorokausittain. Tämän jälkeen luo ja avaa sen _period-files_ -kansiosta gedit-tekstieditorilla. 
   
### Työntekijän vuoron tarkistus

   - Tulostaa työntekijän nimen ja työpäivän perusteella, missä vuorossa kyseinen työntekijä tuona päivänä on.

### Poistu

   - Kysyy käyttäjältä, poistetaanko _period_files_ -kansion sisältö, jonka jälkeen sulkee sovelluksen.
   
## Jatkokehitysideoita

Perusversion jälkeen sovellusta voidaan laajentaa esim. seuraavilla toiminnallisuuksilla.

   - Sovellus tarjoaa käyttäjälle vapaiden perusteella potentiaalisia työntekijöitä työvuoroille
   - Työjakso voi alkaa käyttäjän valitsemana viikonpäivänä
   - Työjakson tarkastelu -toiminto piirtää grafiikan tulosteenaan
   - Työjakson pituuden vapaavalintaisuus
