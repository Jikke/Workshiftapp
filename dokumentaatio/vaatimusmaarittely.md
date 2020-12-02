# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla suunnitellaan työntekijöiden työvuorot työjaksoille. Sovelluksen tarkoitus on helpottaa työvuorojen suunnittelijan työtä.

## Käyttäjät

Alkuvaiheessa sovelluksella on vain _vuorosuunnittelija_ -käyttäjärooli. Myöhemmin saatetaan lisätä _työntekijä_ -käyttäjärooli, joka voi tarkastella itselleen määrättyjä työvuoroja.

## Käyttöliittymäluonnos

Sovellus aukeaa valikkoon, jossa on seuraavat valinnat:

   - Uuden työjakson luonti
   - Työntekijän lisääminen vuoroihin
   - Työjakson tarkastelu
   - Työntekijän vuoron tarkastelu
   - Poistu

## Sovelluksen tarjoama toiminnallisuus

### Uuden työjakson luonti

- \[x] (viikko 5) Jakson luonnin yhteydessä pyydetään minimityöntekijävaatimukset kullekin vuorolle. 

Työjakso on perusversiossa aina 21 _vuorokausi_ -oliota sisältävä olio. Vuorokausiolio sisältää aamu-, ilta-, yövuoro, sekä vapaapäivä -kentät. Työjakso alkaa perusversiossa maanantaina ja päättyy kolmannen viikon sunnuntaihin.

### Uusien työntekijöiden luonti

   - \[x] Luodaan _työntekijä_ -oliot tälle työjaksolle antamalla työntekijän nimi.
  
### Työntekijän lisääminen vuoroihin

   - \[x] Määritellään kyseisen työntekijän työvuorot ja vapaat kullekin työjakson vuorokaudelle.

### Työjakson tarkastelu

   - \[x] Tulostaa työntekijöiden vuorot vuorokausittain listattuna 
   
### Työntekijän vuoron tarkistus

   - \[x] Tulostaa työntekijän nimen ja työpäivän perusteella, missä vuorossa kyseinen työntekijä tuona päivänä on

### Poistu

   - \[x] Sulkee sovelluksen
   
## Jatkokehitysideoita

Perusversion jälkeen sovellusta voidaan laajentaa esim. seuraavilla toiminnallisuuksilla.

### Tärkeimmät laajennukset

   - \[x] Yövuoron lisäys vuorokausiolioon
   - \[x] (viikko 5) Yövuoron lisäyksen yhteydessä työntekijöiden riittävän vapaa-ajan huomioonotto työvuorojen välissä (vähintään 2 vapaata vuoroa työvuorojen välillä)
   - \[x] (viikko 5) Työjakson luonnin yhteydessä määritellään kuhunkin vuoroon työntekijöiden minimimäärä
   - \[x] (viikko 5) Sovellus herjaa vuorojen puuttellisesta vahvuudesta, sekä työntekijöiden puuttellisesta vapaa-ajasta
   - \[ ] Sovellus tarjoaa käyttäjälle vapaiden perusteella potentiaalisia työntekijöitä työvuoroille
   - \[ ] Työntekijöille määritellään vapaapäivien määrä
   
### Tärkeimpiä seuraavat laajennukset
   
   - \[ ] Graafinen käyttöliittymä
   - \[x] (viikko 5) Työjakson muokkaus luomisen jälkeen
   - \[ ] Työjakso voi alkaa käyttäjän valitsemana viikonpäivänä
   - \[ ] Työjakson tarkastelu -toiminto piirtää grafiikan tulosteenaan
   - \[ ] Työjakson pituuden vapaavalintaisuus
   - \[ ] Työjaksojen kopiointi
