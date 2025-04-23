CREATE OR REPLACE TRIGGER trigger_name
[AFTER \ BEFORE] [DELETE\INSERT\UPDATE]
ON table_name FOR EACH ROW
    INSERT INTO logs(log)
    VALUES(CONCAT("Se ha eliminado old.name"));


