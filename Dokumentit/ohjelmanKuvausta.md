#Ohjelma rakenteen Kuvausta:

##Käyttöloogika rakennetta:
Pelin perustana toimii Pelilauta-luokka. Pelilauta luo 2-ulotteisen taulukon, johon tallenetaan Ruutu-olioita.
Pelilauta luokassa loudaan myös peliin tarvittavat Pelinappula-oliot. Nappulat asetetaan lähtö ruuduille kun ne on

luotu. Ruudut-oliot tuntevat nappulan, joka niihin asetetaan pelin alkaessa tai sen aikana. Pelinappula-luokan 
päävastuuna on taas tietää mihin ruutuihin ne voivat pelin kuluessa liikkua. Pelinappuat tuntevat peliaudan, 
jotta tämä olisi mahdollista. Jokainen Pelinappula kuuluu jommalle kummalle pelaajalle.

Pelaaja-oliot luodaan pelin alkaessa käyttöliittymän kautta. Pelaaja-olio pitää pitää kirjaa pelaajan käyttämistä
vuoroista, onnistuneista syönneistä ja omista nappuloista. Vuoron alkaessa Pelaaja kysyy kaikilta nappuloiltaa pystyvätkö 
ne liikkumaan tai syömään. Pelaaja myös liikuttaa nappuloita, "kysyen näiltä lupaa", saatuaan käskyn käyttölittymästä. 
Nappuloita Pelaaja säilyttää ArrayLista:ssa ja nappuloita, jotka pystyvät syömään, toisessa ArrayList:ssa. Lista 
päivitetään aina vuoron alkaessa. Pelaaja tallentaa myös nappulan, joka onnistuu syömään, siltä varalta, että sillä on 
uusi syönti mahdollisuus ja Pelaaja saa uuden vuoron. Pelaaja-oliot tuntevat myös pelilaudan, jotta ne löytävät 
omat nappulat.

##Käyttöliittymän rakennetta

Käyttäliittymässä on paljon erilaisia popup toimintoja, jotka laukaistaa nappia painamalla tai jonkun pelitilanteen 
ilmetessä. Esim. Aloitus nappi aukaisee popup ikkunan, johon pelaajat kirjoittavat nimet ja aloittavat pelin. Voitto 
popup-ikkuna aukeaa taas kun vuorossa oleva pelaaja ei pysty enään jatkamaan vuoroaan häviää pelin.
 
Liitin käyttöliittymään myös peliä helpottavia elementtejä kuten kirjain-lukuyhdistelmän ruutujen tunnistamista 
varten ja "What?" nappulan, joka antaa tietoa mahdollisista siirroista.

Itse pelilauta koostuu JButton-luokkaa laajentavista tammiruutu-olioista. Jokaiseen tammiruutuu-olioon liityy 
vastaava ruutu pelilaudalta ja näin nappuloiden siirtäminen onnistuu helposti tammiruutuja painelemalla. Ohjelma maalaa
valitut tammiruudut pelin hahmottamisen helpoittamiseksi. Kun pelaaja löytää sallitun siirron vuoro vaihtuu automaattisesti
käyttölogiikan puolella.

##Tekoalysta

Jäi kesken. Ideana oli tekoäly, joka yksinkertaisesti arpoo mahdollisista siirroista jonkun. Tekoaly sinänsä on 
melko valmis mutta vuoron käytön tasolla koodi perustuu vielä liikaan ruutujen käsin valitsemiselle.
