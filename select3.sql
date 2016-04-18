SELECT spiel.mannschaft,spiel.datum,spieler.vname,spieler.nname, spiel.dauer
FROM Spieler_Spiel AS spiel INNER JOIN Person AS spieler ON spiel.spielernummer = spieler.persnr
WHERE spiel.datum < '2017-01-01' AND spiel.datum >'2015-12-31';