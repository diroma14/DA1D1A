DECLARE n VARCHAR(250);
DECLARE c VARCHAR(250);
DECLARE acabar DEFAULT FALSE;

DECLARE cursor1 CURSOR FOR
    SELECT nombre,categoria FROM pokemon;
DECLARE CONTINUE HANDLER FOR NOT FOUND
OPEN cursor1;
l_cur1: loop
  FETCH cursor1 INTO 
  n,c;
  IF acabar IS TRUE
    LEAVE l_cur1;
  END IF
end loop
CLOSE cursor1;
