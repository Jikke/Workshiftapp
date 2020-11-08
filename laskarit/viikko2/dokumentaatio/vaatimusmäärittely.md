# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen tarkoitus on helpottaa työvuorojen suunnittelijan työtä. Sovelluksen avulla suunnitellaan työntekijöiden työvuorot työjaksoille.

## Käyttäjät

Alkuvaiheessa sovelluksella on vain _vuorosuunnittelija_ -käyttäjärooli. Myöhemmin saatetaan lisätä _työntekijä_ -käyttäjärooli, joka voi tarkastella itselleen määrättyjä työvuoroja.

## Käyttöliittymäluonnos



## Perusversion tarjoama toiminnallisuus

### Työjakson luonti

   - Määritellään jaksolle uniikki nimi
   - Määritellään työntekijöiden kokonaismäärä
   - Määritellään kussakin vuorossa tarvittava työntekijöiden minimimäärä

Jakso on perusversiossa aina 21 _vuorokausi_ -oliota sisältävä olio. Jakso alkaa perusversiossa maanantaina ja päättyy kolmannen viikon sunnuntaihin. Täten viikonloput ovat 6. - 7., 13. - 14. ja 20. - 21. vuorokausina.
   
### Työntekijöiden luonti  
    
    - Annetaan työntekijän nimi
    - Määritellään kyseisen työntekijän työvuorot ja vapaat kullekin jakson vuorokaudelle.
