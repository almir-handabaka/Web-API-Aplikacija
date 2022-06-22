## KriptoInfo - aplikacija za izlistavanje i prikaz detalja o top kripto valutama
## Predmet: Razvoj mobilnih aplikacija
## Predmetni profesor: prof.dr. Elmedin Selmanović
## Projekat radili: Almir Handabaka 126/IT-19, Erdin Idrizović 118/IT-19

### Uvod
Zadatak ovog projekta je bio da kreiramo Android aplikaciju koja će vršiti prezentaciju podataka dobivenih preko Web API-ja po našem izboru. Kolega i ja smo odlučili da nam tema bude vezana za najbolje kripto valute trenutno. API koji smo koristili zove se Coinranking API (https://developers.coinranking.com/api/documentation) i pomoću njega dobijamo neke osnovne podatke o najpopularnijim kriptovalutama. 
Aplikacija se sastoji iz uvodnog dijela, te više fragmenata. Jedan fragment se odnosi na postavke koji omogućava način izlistavanja valuta po želji korisnika, drugi fragment na kojem se nalazi ta lista kripto valuta u formi kartica te mogućnost sortiranja i osvježavanja liste. Klikom na neku od kartica otvara se idući fragment sa prikazom detaljnijih informacija vezanih za odabranu kripto valutu.

Retrofit je korišten za dohvacanje podataka sa API-ja, Glide za učitavanje slika, ROOM za databazu.

### Detaljniji opis aplikacije i njene funkcionalnosti

#### Uvodni dio aplikacije
Na samom početnu aplikacije, dočekat će nas fragment na kojem se nalazi logo aplikacije kao i dva dugmeta koja vode na postavke i na prikaz izlistanih valuta. U gornjem desnom ćošku nalazi se app bar, unutar kojeg se nalaze tri itema. Odabirom prvog itema, aplikacija korisnika navodi na fragment unutar kojeg se nalaze osnovne informacije vezane za samu aplikaciju. Odabirom drugog itema, aplikacija korisnika navodi na fragment unutar kojeg se nalaze osnovne informacije o studentima koji su radili na ovom projektu. Treći item zapravo predstavlja share button, te klikom na njega šalje se predefinisana poruka. 

#### Izbor grupe podataka koje korisnik želi pregledati
Izbor grupe podataka se vrši unutar postavki. Do njih dodjemo klikom na dugme "Postavke" koje se nalazi na početnom fragmentu. U postavkama imamo 2 spinner dugmeta, jedan služi za odabir kategorije kriptovalute (top 50 je default), drugi za menjanje prikaza cijene (default je USD). Dostupne kategorije su sledeće: top 50, layer-1, DeFi, Stablecoin, NFT, DEX, Exchange, Staking, DAO, Meme, Privacy. prikaz vrijednosti može biti u USD, EUR, BAM, GBP, BTC i ETH.

#### Lista izabranih podataka
Fragment s listom izabranih podataka se sastoji iz 2 dijela, gornji dio sadrzi spinner i refresh dugme. Spinner sluzi za odabir opcija za sortiranje ali lista ce se tek sortirati po odabranoj opciji posle klika na refresh dugme. Donji dio fragmenta je recycler view, sastoji se od kartica na kojima su osnovne informacije o nekoj kriptovaluti (naziv, simbol, rank, logo, cijena), klikom na karticu odlazimo na prikaz detalja o datoj kriptovaluti.

#### Filtriranje podataka po nekom kriteriju putem izbornika
Listu podataka možemo sortirati po sledećim parametrima: - najbolje ka najgore
- najgore ka najbolje
- cijena
- marketcap
- 24h volume
U zavisnosti od izbora ponudjenih opcija za filtriranje, lista ce se sortirati klikom na refresh dugme.

#### Mogućnost odabira elementa liste kako bi se dobile dodatne informacije
Klikom na neku datu karticu odlazimo na detalje o datoj kriptovaluti. Informacije koje možemo vidjeti su sledeće: naziv, simbol, rank, logo, cijena, market cap, BTC cijena, 24h volume.

#### Keširanje podataka kako bi bili dostupni offline
Svaki fragment koji prikazuje neke podatke kupi ih direktno iz ROOM databaze koja se prethodno popuni podacima koji su pokupljeni pomoću Retrofit biblioteke sa Coinranking API-ja. Prije ucitavanja podataka, ukoliko je mobitel povezan na internet baza ce se popuniti svjezim podacima sa API-ja, u suprotnom će se prikazati podaci koji se već nalaze spaseni u bazi, tako aplikacija može djelimično raditi i dok je mobitel offline. Glide biblioteka je iskorištena za učitavanje slike. URL slike dobijemo preko našeg API-ja i spasimo u bazu. Ova biblioteka ima mehanizme za keširanje slika koje smo iskoristili. Isto tako u slučaju neke greške bit će učitan placeholder slika.

#### Prikazivanje liste slike
....


### Tehnički zahtjevi
### Kroz rad na ovoj aplikaciji upotrijebili smo sljedeće tehničke zahtjeve:

#### Fragmenti
Fragment predstavlja dio korisničke veze sa našom aplikacijom. Fragment definira i upravlja izgledom aplikacije i rukuje vlastitim ulaznim događajima. Oni ne mogu živjeti sami, moraju biti smješteni unutar neke aktivnosti ili drugog fragmenta.
Formalnije, fragment predstavlja ponašanje ili dio korisničkog sučelja u aktivnosti. Možete prikazati više fragmenata u jednoj aktivnosti ili ponovo koristiti fragment u više aktivnosti. Fragment možete zamisliti kao modularni dio aktivnosti koji ima svoj životni ciklus, prima vlastite ulazne događaje i koji možete dodati ili ukloniti dok je aktivnost pokrenuta.
Konkretno naša aplikacija se sastoji iz više fragmenata unutar kojih se mogu obaviti niz akcija u zavisnosti od toga što korisnik želi i što aplikacija nudi.
#### Constraint layout
Constraint layout omogućava da se kreira veliki i kompleksni layout sa ravnon hijerarhijom (bez ugnježdenih view grupa). Sličan je RelativeLayout u tome da svi views su namješteni u zavisnosti odnosa između susjednih views i parent layout-a ali više fleksibilniji od RelativeLayout i lakši za korištenje unutar Android Studio Layout Editora. Također, duplicira svu funkcionalnost LinearLayout-a i RelativeLayout-a, dok dozvoljava programeru da raspored učini ravnijim sa manje hijerarhije i ugniježđenja. Manje ugniježđenja znači mogućnost mjerenja, rasporeda i crtanja pogleda u manje prolaza, čime se povećava brzina prikaza korisničkog sučelja.
Unutar naše aplikacije, constraint layout je iskorišten u xml fajlu koji je vezan za početni fragment.
#### View and data binding
View binding ili vezivanje pogleda predstavlja funkcija koja nam omogućava da lakše pišemo kod koji je u interakciji sa views odnosno pogledima. Jednom kada je povezivanje pogleda omogućeno, on generiše klasu povezivanja za svaki XML fajl izgleda koji je prisutan u tom modulu. Instanca klase povezivanja sadrži direktne reference na sve poglede koji imaju ID u odgovarajućem rasporedu. Često povezivanje view-a zamjenjuje findViewById.
Data Binding je biblioteka podrške koja nam omogućava da povežemo komponente korisničkog interfejsa sa našim xml fajlovima koristeći deklarativni format, a ne programski. Rasporedi su često definisani u aktivnostima kodom koji poziva metode okvira korisničkog interfejsa. Konkretno unutar naše aplikacije, koristili smo bindinge da pozovemo akcije dugmadi i izvršimo određenu radnju, također za povezivanje id-eva text view-a za dodavanje teksta na određenim fragmentima(fragment na kojem se nalaze detalji o gradu na koji je korisnik kliknuo).
#### Navigation komponenta
Navigacija se odnosi na interakcije koje korisnicima omogućavaju navigaciju kroz različite dijelove sadržaja unutar naše aplikacije, u njih i nazad iz njih. Komponenta navigacije se sastoji od tri ključna dijela:
Grafikon navigacije: XML resurs koji sadrži sve informacije vezane za navigaciju na jednoj lokaciji. Uključuje sva pojedinačna područja sadržaja unutar naše aplikacije, kao i moguće puteve kojima korisnik može proći kroz naše aplikacije. NavHost: Prazan kontejner koji prikazuje odredišta s našeg navigacijskog grafikona. Komponenta Navigacija sadrži zadanu implementaciju NavHost-a, NavHostFragment, koja prikazuje odredišta fragmenta.
NavController: Objekt koji upravlja navigacijom aplikacije unutar NavHosta. NavController upravlja zamjenom odredišnog sadržaja u NavHost-u dok se korisnici kreću kroz našu aplikaciju. Dok se krećete kroz svoju aplikaciju, kažete NavControlleru da želite navigirati ili duž određene staze u vašem navigacijskom grafikonu ili direktno do određenog odredišta. NavController tada pokazuje odgovarajuće odredište u NavHost-u.
#### Prosljeđivanje podataka putem intent-a
Postoje dvije osnovne vrste namjera: eksplicitne i implicitne namjere. Eksplicitne namjere su najstrožije, ukazujući na određenu komponentu koja treba da obradi zahtjev. Eksplicitne namjere se obično koriste kada se krećete između komponenti unutar vaše aplikacije, a znate koje je ime klase. Možete ih koristiti i za navigaciju do poznate aplikacije treće strane ako ste potpuno sigurni koju vrstu namjere mogu podnijeti.

Implicitne namjere, s druge strane, ne specificiraju namjeravanu metu, već umjesto toga pružaju dovoljno informacija da sistem može riješiti koja komponenta treba da obradi namjeru. Za komponente koje vaša aplikacija ne posjeduje, ovo je preporučena vrsta namjere. Ako više aplikacija može podnijeti namjeru, sistem pokreće zadanu aplikaciju ili dopušta korisniku da odabere jednu.

Unutar aplikacije je korišten eksplicitni intent, za prikaz detalja na kliknutu karticu.
#### App bar sa bar jednim item-om i up button-om
App bar ili action bar je jedan od najbitnijih dizajnerskih elemenata u aktivnostima naše aplikacije zato što pruža vizuelnu strukturu i interaktivne elemente koji su poznati korisnicima. Korištenje app bara čini aplikaciju konzistentnom sa ostalim Android aplikcijama, dopuštajući korisniku da brzo shvati kako koristiti našu aplikaciju i da ima dobro iskustvo. Ključne funkcije app bara su sljedeće:
- posvećeni prostor koji aplikaciji daje identitet i prikazuje korisnikovu lokaciju unutar naše aplikacije
- pristup bitnim akcijama koje su predvidljive, kao pretraga
- podrška za navigaciju i promjenu pogleda sa tabovima ili dropdown listama.

Naša aplikacija treba da ima lagan način da se vrate na početni ekran aplikacije. Jednostavan način da se to izvede je Up button na app baru za sve aktivnosti osim glavne. Kada korisnik klikne Up button aplikacija se vraća na parent aktivnost.        Unutar naše aplikacije, Android prati aktivnosti koje smo otvorili kao kolekciju aktivnosti u grupi, poznatoj kao back stack. Kada se naša aplikacija prvi put pokrene, prva aktivnost se dodaje na back stack. Dok prolazite kroz aplikaciju, Android ima pristup "posljednji ušao, prvi izašao" za praćenje aktivnosti koje ste posjetili. Android dodaje najnoviju aktivnost koju ste upravo započeli na vrh grupe.      
Evo jednostavnog primjera funkcionisanja back stack-a:                                 Stanje 1: Nova aktivnost (aktivnost 2) se pokreće i dodaje na vrh hrpe. Aktivnost 2 sada ima fokus i korisnik može komunicirati s njom.                                    Stanje 2: Kada pokrenete drugu (aktivnost 3), ona se dodaje na vrh steka. Aktivnost 2 je zaustavljena, a aktivnost 3 sada ima fokus.                                         Stanje 3: Kada dodirnete dugme Nazad, Android izbacuje aktivnost 3 sa gomile i završava je. Aktivnost 2 je sada na vrhu hrpe i nastavlja se. 

Mi smo iskoristili item-e da nas odvedu do fragmenata unutar koji se nalaze neke informacije vezano za samu aplikaciju i fragmenta koji nam prikazuje informacije o studentima koji su radili na ovom projektu. Također pored tih opcija, imamo i share opciju gdje korisnik može podijeliti odnosno poslati predefinisanu poruku.
#### Share button kojim se može poslati predefinisana poruka
Share dugme se koristi da se podijele informacije preko emaila, Bluetooth-a, Facebook-a, Twittera, WhatsAppa, etc sa drugom osobom ili grupom na bilo kojoj socijalnoj mreži. Možemo podijeliti bilo kakav tip poruke kao što su tekst, slike, video, linkove, etc.
Kako smo rekli prethodno, u aplikaciji share dugme se nalazi kao item unutar app bar-a, te prilikom odabira te opcije šaljemo predefinisanu poruku.
### Fragment sa različitim horizontalnim i vertikalnim layout-om
Što se tiče fragmenta sa različitim horizontalnim i vertikalnim layout-om, tu opciju smo iskoristili na početnom fragmentu, odnosno prvom fragmentu koji se prikaže prilikom otvaranja ove aplikacije. Prilikom okretanja telefona u stranu, odnosno u horizontalnom položaju, izgled fragmenta se mijenja u odnosu na izgled fragmenta kada je pozicija telefona u vertikalnom položaju. Razlika se odnosi u položaju dugmadi, tj. kada je u pitanju vertikalni položaj telefona, dugmad ispod logo-a se nalaze jedan ispod drugog, dok kada je u pitanju horizontalni položaj telefona, dugmad ispod logo-a se nalaze jedan pored drugog. 
#### Spašavanje podataka kako bi se sačuvali prilikom zatvaranja aplikacije od samog Android OS-a
Anroid koristi sličan fajl sistem nalik na disk-based fajl sisteme na drugim platformama. Postoji više opcija da se čuvaju naši podaci:
- App-specific storage
- Shared storage
- Preferences
- Databases
U našoj aplikaciji mi smo koristili Room databazu. Room databaza je lokalna databaza. Lokalne baze se većinom koriste ukoliko uređaj ne može pristupiti internetu a želimo da korisnik nastavi koristiti aplikaciju dok je offline. Room je biblioteka koja pruža nivo apstrakcije preko SQLite databaze. Pomoću Room-a možemo da kreiramo databazu i da izvršavamo CRUD operacije veoma lagano.
#### Room database sa entitetima i data access objektima (DAO)
Biblioteka Room persistence pruža sloj apstrakcije preko SQLite-a kako bi se omogućio robusniji pristup bazi podataka, uz iskorištavanje pune snage SQLite-a.
Room je biblioteka objektno relacijskog mapiranja koja pretvara podatke iz njihove reprezentacije u bazi podataka u objekte kojima možemo direktno manipulirati u kodu aplikacije. Takođe može obrnuti proces, gurajući podatke iz objekata nazad u bazu podataka.
Room pruža sljedeće benefite:
- compile-time verifikacija SQL upita
- anotacija koja umanjuje repetivnost i greške
- lagano migriranje databaze
Komponente Room databaze
Glavne komponente room databaze su Entity, Database i DAO
- Entity: Entity je klasa koja je označena sa @Entity. Ova klasa predstavlja našu tabelu i sadrži sve kolone koje će imati.
- Database je apstraktna klasa u kojoj čuvamo sve naše tabele
- DAO skraćeno za Database access object je interfejs klasa pomoću koje možemo da vršimo razne operacije unutar naše databaze.
Da biste pristupili podacima vaše aplikacije pomoću biblioteke postojanosti sobe, radite s objektima za pristup podacima ili DAO-ovima. Definirajte interakcije baze podataka koje želite da imate u DAO klasi, umjesto da koristite alate za izgradnju upita ili direktne upite. Room također provjerava sve vaše upite u Dao klasama kada se aplikacija kompajlira, tako da ako postoji problem u jednom od upita, odmah ćete biti obaviješteni. Sa deklarisanim DAO, možemo kreirati našu bazu podataka room. Obilježite klasu sa @Database i uključite listu entiteta. Svojstvo entiteta napomene @Database deklarira koji će objekti biti pohranjeni u ovoj bazi podataka. Unutar klase uključite apstraktnu metodu koja ne uzima argumente i vraća klasu koja je označena sa @Dao.  Koristimo Room.databaseBuilder() da kreiramo bazu podataka koristeći kontekst aplikacije, klasu MyDatabase i ime baze podataka.
#### Prikupljanje podataka sa interneta upotrebom Retrofit biblioteke
....
#### Prikazivanje slika pomoću Glide biblioteke u grid view-u
....
#### Recycler View
RecyclerView nam omogućava da efikasno prikazujemo veliki broj podataka. Mi dostupimo podatke i definišemo kako svaki element izgleda i RecyclerView biblioteka dinamički kreira elemente kad su potrebni. Kao što naziv govori, Recycler View reciklira te individualne elemente. Kako item bude skrolan van ekrana RecyclerView ne uništava njegov view nego RecyclerView iskorištava taj view za novi item koji su skrolani na ekran. Ova metoda puno povećava perfomanse, popravlja responzivnost naše aplikacije i smanjuje potrošnju baterije.
Widget za prikaz lista podataka "Reciklira" (ponovno koristi) prikaze stavki kako bi pomicanje bilo efikasnije. Može specificirati izgled stavke liste za svaku stavku u skupu podataka. Podržava animacije i prijelaze.
Osnovni RecyclerView adapter morat će nadjačati sljedeće tri funkcije:
getItemCount -> vraća ukupan broj dostupnih stavki na vašoj listi podataka
onCreateViewHolder -> se poziva da kreira novi izgled stavke liste
onBindViewHolder -> se poziva kada se ponovo koristi izgled stavke liste ažuriranjem podataka koji se prikazuju unutar njega
ViewHolder predstavlja izgled stavke liste i ima reference na sve poglede unutar izgleda stavke liste.
Kada imate veliki broj stavki na svojoj listi (veći od količine prostora na ekranu da ih sve prikažete), nemojte kreirati prikaz za stavke do kojih još niste pomaknuli.
Metoda onCreateViewHolder() adaptera je pozvana da kreira držače pogleda za broj stavki koje se mogu prikazati na ekranu u jednom trenutku. Nakon tog početnog kreiranja, kada skrolujete, sistem uklanja poglede stavki liste van ekrana iz hijerarhije i poziva onBindViewHolder() na adapteru da „reciklira“ prikaze stavki liste i ponovo ih koristi. Vrijednosti unutar prikaza stavke liste se ažuriraju kako bi odražavale podatke u novoj stavci liste (koja će se uskoro pojaviti na ekranu), a prikaz stavke liste se vraća natrag u hijerarhiju prikaza.
Konkretno, unutar naše aplikacije, Recycler View smo koristili za prikaz liste kripto valuta koji su prikazani kao kartice i također u fragmentu gdje se vrši prikaz liste kripto valuta nakon kupljenja podataka sa apija ili u slučaju da je mobitel bez interneta, onda kupljenja podataka iz baze.
#### Repositoy komponenta
....
