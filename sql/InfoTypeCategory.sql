INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (1, "Parking","", 1 );
											
INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (2, "Traffic","", 1 );		

INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (3, "Safety","", 1 );		
											
INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (4, "Bar & Restaurants","", 1 );		

INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (5, "Liquor Store","", 1 );			
											
INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (6, "Tradition","", 1 );			

INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (7, "Supplies","", 1 );														

INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (8, "Flask Us","", 1 );														

											
INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (101, "Venue Map","", 2 );														

INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (102, "Bar & Restaurants","", 2 );			

INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (103, "Flask Us","", 2 );	
											
INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (201, "Nightlife","", 3 );													

INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (202, "Bar & Restaurants","", 3 );			

INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (203, "Getting home","", 3 );		

INSERT INTO flaskevents_infotypecategory (infoTypeCategoryId,infoTypeCategoryName, displayTemplate, infoTypeId)
											VALUES (204, "Flask Us","", 3 );												


SET SQL_SAFE_UPDATES = 0;
Update flaskevents_infotypecategory set displayTemplate=lower(infoTypeCategoryName) where 1=1;

