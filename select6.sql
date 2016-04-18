CREATE VIEW trainer_view AS (
SELECT trainer.persnr, person.vname, person.nname, person.geschlecht, person.gebdat, trainer.gehalt, trainer.von, trainer.bis 
FROM trainer INNER JOIN person on trainer.persnr = person.persnr);

DROP VIEW trainer_view;