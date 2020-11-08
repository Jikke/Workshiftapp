# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen tarkoitus on helpottaa työvuorojen suunnittelijan työtä. Sovelluksen avulla suunnitellaan työntekijöiden työvuorot työjaksoille.

## Käyttäjät

Alkuvaiheessa sovelluksella on vain _vuorosuunnittelija_ -käyttäjärooli. Myöhemmin saatetaan lisätä _työntekijä_ -käyttäjärooli, joka voi tarkastella itselleen määrättyjä työvuoroja.

## Käyttöliittymäluonnos

Sovellus aukeaa valikkoon, jossa on seuraavat valinnat:

   - Uuden työjakson luonti
   - Työjakson tarkastelu
   - Poistu

## Perusversion tarjoama toiminnallisuus

### Uuden työjakson luonti

   - Määritellään jaksolle uniikki nimi
   - Määritellään työntekijöiden kokonaismäärä tälle jaksolle

Jakso on perusversiossa aina 21 _vuorokausi_ -oliota sisältävä olio. Vuorokausiolio sisältää aamu- ja iltavuoro, sekä vapaapäivä -kentät. Jakso alkaa perusversiossa maanantaina ja päättyy kolmannen viikon sunnuntaihin.

Seuraavaksi jakson luonnissa luodaan _työntekijä_ -oliot tälle jaksolle seuraavasti:
    
   - Annetaan työntekijän nimi
   - Määritellään kyseisen työntekijän työvuorot ja vapaat kullekin jakson vuorokaudelle.

### Työjakson tarkastelu

   - Listaa olemassaolevat jaksot
   - Tulostaa näkyviin syötetyn jakson työntekijöiden vuorot vuorokausittain listattuna

### Poistu

   - Sulkee sovelluksen
   
## Jatkokehitysideoita

Perusversion jälkeen sovellusta voidaan laajentaa esim. seuraavilla toiminnallisuuksilla.

### Tärkeimmät laajennukset

   - Yövuoron lisäys vuorokausiolioon
   - Yövuoron lisäyksen yhteydessä työntekijöiden riittävän vapaa-ajan huomioonotto työvuorojen välissä (vähintään 2 vapaata vuoroa työvuorojen välillä)
   - Jakson luonnin yhteydessä määritellään kuhunkin vuoroon työntekijöiden minimimäärä
   - Sovellus herjaa vuorojen puuttellisesta vahvuudesta, sekä työntekijöiden puuttellisesta vapaa-ajasta
   - Sovellus tarjoaa käyttäjälle vapaiden perusteella potentiaalisia työntekijöitä työvuoroille
   - Työntekijöille määritellään vapaapäivien määrä
   
### Tärkeimpiä seuraavat laajennukset
   
   - Työjakson muokkaus luomisen jälkeen
   - Määritellään kussakin vuorossa tarvittava työntekijöiden minimimäärä
   - Jakso voi alkaa käyttäjän valitsemana viikonpäivänä
   - Työjakson tarkastelu -toiminto piirtää grafiikan tulosteenaan
   - Työjaksojen kopiointi
