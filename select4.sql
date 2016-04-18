SELECT spieler.vname,spieler.nname, sum(spiel.dauer) AS sum
FROM Person AS spieler LEFT JOIN Spieler_Spiel as spiel on spieler.persnr = spiel.spielernummer
WHERE spiel.datum < '2017-01-01' AND spiel.datum >'2015-12-31'
GROUP BY spieler.persnr
ORDER BY sum DESC, spieler.nname ASC, spieler.vname ASC;