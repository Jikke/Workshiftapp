# Workshiftapp
Sovelluksen tarkoitus on helpottaa työvuorojen suunnittelua. Sovelluksella luodaan työjakso, johon lisätään työpäivien vuoroihin työntekijöitä.

## Julkaisut
### Ensimmäinen julkaisu
[Workshiftapp-1.0](https://github.com/Jikke/ot-harjoitustyo/releases/tag/viikko5)

## Dokumentaatio
[vaatimusmaarittely.md](https://github.com/Jikke/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)\
[tyoaikataulukko.md](https://github.com/Jikke/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikataulukko.md)\
[arkkitehtuuri.md](https://github.com/Jikke/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

## Komentorivitoiminnot
### Testaus
Testit suoritetaan komennolla \
```mvn test```\
Testikattavuusraportti luodaan komennolla\
```mvn jacoco:report```\
Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi
Komento \
```mvn package```

generoi hakemistoon target suoritettavan jar-tiedoston __Workshiftapp-1.0-SNAPSHOT.jar__ \

Suoritus komennolla \
```java -jar Workshiftapp-1.0-SNAPSHOT.jar```
