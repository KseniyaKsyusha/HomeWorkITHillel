
 SELECT * 
 FROM MyHomeWorkDB.homework h 

 SELECT * 
 FROM  MyHomeWorkDB.lesson l
 INNER JOIN MyHomeWorkDB.homework h ON l.homework_id = h.id 

 SELECT * 
 FROM  MyHomeWorkDB.lesson l
 INNER JOIN MyHomeWorkDB.homework h ON l.homework_id = h.id 
 ORDER BY l.updatedAt DESC 

 SELECT *
 FROM MyHomeWorkDB.schedule s 
 Inner Join MyHomeWorkDB.scheduled_lessons sl ON s.id = sl.schedule_id 
 Inner Join MyHomeWorkDB.lesson l ON l.id = sl.lesson_id 

 SELECT s.name, COUNT(sl.lesson_id) AS l_count 
 FROM MyHomeWorkDB.schedule s 
 Inner Join MyHomeWorkDB.scheduled_lessons sl ON s.id = sl.schedule_id 
 GROUP BY sl.schedule_id 
 ORDER BY s.name 
