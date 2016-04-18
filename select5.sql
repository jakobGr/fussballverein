SELECT spieler.vname,spieler.nname, sum(spiel.dauer) AS sum
FROM Person AS spieler LEFT JOIN Spieler_Spiel as spiel on spieler.persnr = spiel.spielernummer
WHERE spiel.datum < '2017-01-01' AND spiel.datum >'2015-12-31'
GROUP BY spieler.persnr
HAVING 
sum(spiel.dauer) = (
select sum(dauer) 
FROM Spieler_Spiel 
WHERE datum < '2017-01-01' AND datum >'2015-12-31'
group by spielernummer 
order by sum(dauer) DESC 
LIMIT 1) 
ORDER BY spieler.nname ASC, spieler.vname ASC;