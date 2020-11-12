# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla suunnitellaan työntekijöiden työvuorot työjaksoille. Sovelluksen tarkoitus on helpottaa työvuorojen suunnittelijan työtä.

## Käyttäjät

Alkuvaiheessa sovelluksella on vain _vuorosuunnittelija_ -käyttäjärooli. Myöhemmin saatetaan lisätä _työntekijä_ -käyttäjärooli, joka voi tarkastella itselleen määrättyjä työvuoroja.

## Käyttöliittymäluonnos

Sovellus aukeaa valikkoon, jossa on seuraavat valinnat:

   - Uuden työjakson luonti
   - Työjakson tarkastelu
   - Poistu

## Perusversion tarjoama toiminnallisuus

### Uuden työjakson luonti

   - Määritellään uniikki työjaksotunniste
   - Määritellään työntekijöiden kokonaismäärä tälle työjaksolle

Työjakso on perusversiossa aina 21 _vuorokausi_ -oliota sisältävä olio. Vuorokausiolio sisältää aamu- ja iltavuoro, sekä vapaapäivä -kentät. Työjakso alkaa perusversiossa maanantaina ja päättyy kolmannen viikon sunnuntaihin.

Seuraavaksi työjakson luonnissa luodaan _työntekijä_ -oliot tälle työjaksolle seuraavasti:
    
   - Annetaan työntekijän nimi
   - Määritellään kyseisen työntekijän työvuorot ja vapaat kullekin työjakson vuorokaudelle.

### Työjakson tarkastelu

   - Listaa olemassaolevat työjaksot
   - Tulostaa näkyviin syötetyn työjaksotunnisteen perusteella työjakson työntekijöiden vuorot vuorokausittain listattuna

### Poistu

   - Sulkee sovelluksen
   
## Jatkokehitysideoita

Perusversion jälkeen sovellusta voidaan laajentaa esim. seuraavilla toiminnallisuuksilla.

### Tärkeimmät laajennukset

   - Yövuoron lisäys vuorokausiolioon
   - Yövuoron lisäyksen yhteydessä työntekijöiden riittävän vapaa-ajan huomioonotto työvuorojen välissä (vähintään 2 vapaata vuoroa työvuorojen välillä)
   - Työjakson luonnin yhteydessä määritellään kuhunkin vuoroon työntekijöiden minimimäärä
   - Sovellus herjaa vuorojen puuttellisesta vahvuudesta, sekä työntekijöiden puuttellisesta vapaa-ajasta
   - Sovellus tarjoaa käyttäjälle vapaiden perusteella potentiaalisia työntekijöitä työvuoroille
   - Työntekijöille määritellään vapaapäivien määrä
   
### Tärkeimpiä seuraavat laajennukset
   
   - Graafinen käyttöliittymä
   - Työjakson muokkaus luomisen jälkeen
   - Työjakso voi alkaa käyttäjän valitsemana viikonpäivänä
   - Työjakson tarkastelu -toiminto piirtää grafiikan tulosteenaan
   - Työjakson pituuden vapaavalintaisuus
   - Työjaksojen kopiointi