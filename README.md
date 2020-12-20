# Workshiftapp
Sovelluksen tarkoitus on helpottaa työvuorojen suunnittelua. Sovelluksella luodaan työjakso, johon lisätään työpäivien vuoroihin työntekijöitä.

## Huomioitavaa

Työjaksojen tarkastelu on toteutettu gedit-tekstieditoria käyttäen. Täten tarkastelu ei ole mahdollista suoraan sovelluksen avulla ilman sitä. Jaksosta kuitenkin luodaan .txt tiedosto projektin _period_files_ -kansioon, josta sitä voi tarkastella avaamalla sen manuaalisesti työasemasta löytyvällä tekstieditorilla.

## Julkaisut

### Viimeisin julkaisu
[Workshiftapp-1.1](https://github.com/Jikke/ot-harjoitustyo/releases/tag/viikko6)

### Ensimmäinen julkaisu
[Workshiftapp-1.0](https://github.com/Jikke/ot-harjoitustyo/releases/tag/viikko5)

## Dokumentaatio
[Käyttöohje](https://github.com/Jikke/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)\
[Vaatimusmäärittely](https://github.com/Jikke/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)\
[Arkkitehtuurikuvaus](https://github.com/Jikke/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)\
[Testausdokumentti](https://github.com/Jikke/Workshiftapp/blob/master/dokumentaatio/testausdokumentti.md)\
[Työaikakirjanpito](https://github.com/Jikke/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikataulukko.md)\

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
tarkistaa tiedoston [checkstyle.xml](https://github.com/Jikke/Workshiftapp/blob/master/Workshiftapp/checkstyle.xml) määritelmien mukaan koodin laadun. Raporttia voi tarkastella selaimella tiedostosta\
```target/site/checkstyle.html```
