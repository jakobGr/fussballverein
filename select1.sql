SELECT  FanClub.sid,FanClub.name
FROM FanClub LEFT JOIN (SELECT * FROM Angestellter_FanClub WHERE persnr = 10000
AND anfang < current_date AND ende > current_date) AS betreut
ON FanClub.sid = betreut.sid AND FanClub.name = betreut.name
WHERE persnr IS NULL;