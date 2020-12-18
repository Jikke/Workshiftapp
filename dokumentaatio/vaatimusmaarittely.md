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

- Jakson luonnin yhteydessä pyydetään minimityöntekijävaatimukset kullekin vuorolle. 

Työjakso on perusversiossa aina 21 _vuorokausi_ -oliota sisältävä olio. Vuorokausiolio sisältää aamu-, ilta-, yövuoro, sekä vapaapäivä -kentät. Työjakso alkaa perusversiossa maanantaina ja päättyy kolmannen viikon sunnuntaihin.

### Lisää työntekijöitä

   - Luodaan _työntekijä_ -oliot tälle työjaksolle antamalla työntekijän nimi.
  
### Työntekijöiden lisääminen vuoroihin

   - Määritellään kyseisen työntekijän työvuorot ja vapaat kullekin työjakson vuorokaudelle.

### Työjakson tarkastelu

   - Avaa gedit-tekstieditorilla työntekijöiden vuorot vuorokausittain listattuna 
   
### Työntekijän vuoron tarkistus

   - Tulostaa työntekijän nimen ja työpäivän perusteella, missä vuorossa kyseinen työntekijä tuona päivänä on

### Poistu

   - Sulkee sovelluksen
   
## Jatkokehitysideoita

Perusversion jälkeen sovellusta voidaan laajentaa esim. seuraavilla toiminnallisuuksilla.

### Tärkeimmät laajennukset

   - Sovellus tarjoaa käyttäjälle vapaiden perusteella potentiaalisia työntekijöitä työvuoroille
   - Työntekijöille määritellään vapaapäivien määrä
   
### Tärkeimpiä seuraavat laajennukset

   - Työjakso voi alkaa käyttäjän valitsemana viikonpäivänä
   - Työjakson tarkastelu -toiminto piirtää grafiikan tulosteenaan
   - Työjakson pituuden vapaavalintaisuus
   - Työjaksojen kopiointi
