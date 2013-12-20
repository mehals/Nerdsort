set foreign_key_checks=0;
truncate table nerdsort.item_lists;
truncate table nerdsort.sortable_items;
set foreign_key_checks=1;
commit;

insert into nerdsort.item_lists (list_name) 
values ('Starfleet Captains'), ('Indiana Jones Movies');

insert into nerdsort.sortable_items (list_id, position, item_name, image_url)
values (1, 1, 'Kirk', 'Kirk.jpg'), (1, 2, 'Picard', 'Picard.jpg'), (1, 3, 'Sisko', 'Sisko.jpg'), (1, 4, 'Janeway', 'Janeway.jpg'), (1, 5, 'Archer', 'Archer.jpg'), (1, 6, 'Kirk Prime', 'KirkPrime.jpg');

insert into nerdsort.sortable_items (list_id, position, item_name)
values (2, 1, 'Raiders of the Lost Ark'), (2, 2, 'Temple of Doom'), (2, 3, 'The Last Crusade'), (2, 4, 'Kingdom of the Crystal Skull');
