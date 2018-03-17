@ECHO OFF
set $date=%date:~4%
set $date=%$date:/=-%

cd "C:\MesSauvegardes"
mysqldump.exe --databases coiffeur --result-file="C:\MesSauvegardes\%$date%.sql" --host=localhost --user=root --password=94090932782m
