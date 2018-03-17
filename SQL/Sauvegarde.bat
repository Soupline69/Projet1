@ECHO OFF
set $date=%date:~4%
set $date=%$date:/=-%

cd "C:\Program Files\MySQL\MySQL Server 5.7\bin"
mysqldump.exe --databases coiffeur --result-file="C:\MesSauvegardes\%$date%.sql" --host=localhost --user=root --password=christelle
