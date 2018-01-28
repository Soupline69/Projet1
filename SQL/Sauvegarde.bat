@ECHO OFF
set $date=%date:~4%
set $date=%$date:/=-%

cd "C:\Program Files\MySQL\MySQL Server 5.6\bin"
mysqldump.exe --databases sql11218105 --result-file="C:\MesSauvegardes\%$date%.sql" --host=sql11.freesqldatabase.com --user=sql11218105 --password=Pl5z9DwdkF
