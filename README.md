# Workshiftapp
Sovelluksen tarkoitus on helpottaa työvuorojen suunnittelua. Sovelluksella luodaan työjakso, johon lisätään työpäivien vuoroihin työntekijöitä.

## Julkaisut

### Viimeisin julkaisu
[Workshiftapp-1.1](https://github.com/Jikke/ot-harjoitustyo/releases/tag/viikko6)

### Ensimmäinen julkaisu
[Workshiftapp-1.0](https://github.com/Jikke/ot-harjoitustyo/releases/tag/viikko5)

## Dokumentaatio
[vaatimusmaarittely.md](https://github.com/Jikke/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)\
[kayttoohje.md](https://github.com/Jikke/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)\
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
```mvn package```\
generoi hakemistoon target suoritettavan jar-tiedoston __Workshiftapp-1.0-SNAPSHOT.jar__ 

Suoritus komennolla \
```java -jar Workshiftapp-1.0-SNAPSHOT.jar```

### Javadoc

Komento \
```mvn javadoc:javadoc```\
generoi selaimella avattavat javadoc-tiedoston. Tiedoston avaus nettiselaimella kohteesta\
```target/site/apidocs/index.html```

### Checkstyle

Komento\
```mvn jxr:jxr checkstyle:checkstyle```\
tarkistaa checkstyle.xml määritelmien mukaan koodin laadun. Raporttia voi tarkastella selaimella tiedostosta\
```target/site/checkstyle.html```
