# Testausdokumentti
 
 Sovellusta on testattu JUnit testeillä, sekä manuaalisesti antamalla erilaisia syötteitä.
 
 ## JUnit testit
 
 Kaikki JUnit testit suorittaa [WorkshiftAppTest.java](https://github.com/Jikke/Workshiftapp/blob/master/Workshiftapp/src/test/java/workshiftapptest/WorkshiftappTest.java) -testausluokka.
 Se testaa domain-paketin Person-, Day- ja Period-luokat. ui-paketin luokkia ei testata JUnitilla. Testikattavuus on 72%.
 
 ## Manuaaliset testit
 
 ui-paketti, sekä erilaisten toimintojen ristiintoimivuus on testattu manuaalisesti antamalla syötteitä käyttöliittymän kautta. 
 
 ## Virheiden käsittely
 
 Virheiden käsittely on pitkälti toteutettu ennaltaehkäisemällä virhetilanteet antamalla käyttäjälle vain tarvitsemansa vaihtoehdot pudotusvalikoin ja radiobuttoneilla.
 Muissa tapauksissa virhesyötteet antavat AlertBox-ikkunan kautta käyttäjää opastavan virheviestin.
