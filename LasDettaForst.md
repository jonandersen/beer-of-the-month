# Introduktion #

I projektet kommer vi att använda oss av subversion för att hantera källkoden.
Tillvägagångssätt är upp till var och en att välja men jag tycker det är passande att lägga upp en liten guide för att få igång subversion med eclipse.
Alla måste ha en gmail och uppge användarnamn till mig (Johan) så att jag kan lägga till er i projektet.

## Subclipse ##

Subclipse är ett plugin till eclipse som verkar fungera ganska bra, strular denna guide finns det lite mer info [här](http://subclipse.tigris.org/servlets/ProjectProcess?pageID=p4wYuA).

Installationsprocess steg för steg:
  * Starta Eclipse och skapa ett nytt workspace, antingen i starten eller under **File > Switch Workspace**.
  * Gå in i **Help > Software Updates** och välj **Add Site...** under fliken **Available Software**.
  * Klistra in http://subclipse.tigris.org/update_1.6.x i rutan och tryck på OK.
  * Bocka i kryssrutan till vänster om länknamnet och välj **Install**, följ instruktionerna.

## Lägg till repository ##

Nästa steg är att lägga till projektets repository och checka ut detta:
  * Gå in i **Window > Open Perspective > Other...** och välj **SVN Repository Exploring**
  * Klicka på den nytillagda vyn brevid **Java** och **Debug** uppe i högra hörnet.
  * Högerklicka i det vita utrymmet under **SVN Repositories** och välj **New > Repository Location...**
  * Klistra in länken https://cykelgarage.googlecode.com/svn/ och tryck på OK.
Användarnamn är gmail namnet och lösen finns här: http://code.google.com/hosting/settings, om det inte fungerar så fråga någon. Alla i projektet har samma lösenord.

## Checkout ##

För att få tillgång till alla filer behöver man göra en checkout. Högerklicka på **trunk** under https://cykelgarage.googlecode.com/svn i svn vyn och välj **Checkout...**
Tryck på finish och följ instruktionerna för att skapa ett nytt javaprojekt.
Nu är det bara att gå tillbaka till Java vyn uppe i högra hörnet och börja koda.

## Uppdatera källkod ##

Innan varje gång man ska börja jobba är det bra att uppdatera koden. Högerklicka på filen/mappen som behöver uppdateras och välj **Team > Update**. Gör det till en vana att börja varje dag med en uppdatering!
På liknande sätt kan man lägga upp ändrad kod. Högerklicka på filen och välj **Team > Commit** och skriv en bra kommentar om det är något viktigt ni ändrat.
Försök att låta bli att ladda upp hela projektmappen då en massa onödiga klassfiler laddas upp.

## Övrigt ##

Det finns en väldig massa saker man kan göra mha subversion. Varje gång man laddar upp filer så skapas en ny revision av projektet, på så sätt går det alltid att komma tillbaka till tidigare stadier av koden ifall något går fel.
Övrigt om subversion finns att läsa här: http://svnbook.red-bean.com/

Ett annan väldigt bra klient om man använder windows är [TortoiseSVN](http://tortoisesvn.tigris.org/)