insert into flaskevents_infotypecategory values(1,"General","");
insert into flaskevents_infotypecategory values(2,"Tradition","");
insert into flaskevents_infotypecategory values(3,"Weather","");
insert into flaskevents_infotypecategory values(4,"Parking","");
insert into flaskevents_infotypecategory values(5,"Traffic","");
insert into flaskevents_infotypecategory values(6,"Food","");
insert into flaskevents_infotypecategory values(7,"Liquor","");
insert into flaskevents_infotypecategory values(8,"Advertisements","");
insert into flaskevents_infotypecategory values(9,"Hospitals","");
insert into flaskevents_infotypecategory values(10,"First Aid","");
insert into flaskevents_infotypecategory values(11,"Police Stations","");
insert into flaskevents_infotypecategory values(12,"Fire Stations","");

SET SQL_SAFE_UPDATES = 0;
Update flaskevents_infotypecategory set displayTemplate=lower(infoTypeCategoryName) where 1=1;

