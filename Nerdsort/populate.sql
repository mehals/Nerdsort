set foreign_key_checks=0;
truncate table nerdsort.item_lists;
truncate table nerdsort.sortable_items;
set foreign_key_checks=1;
commit;

insert into nerdsort.item_lists (list_name) 
values ('Major Franchises'), ('Starfleet Captains'), ('Indiana Jones Movies'), ('Alien Movies');

insert into nerdsort.sortable_items (list_id, position, item_name, image_url)
values (1, 1, 'Star Trek', 'StarTrek.jpg'), (1, 2, 'Star Wars', 'StarWars.jpg'), (1, 3, 'Stargate', 'Stargate.jpg'), (1, 4, 'Battlestar Galactica', 'Battlestar.jpg');

insert into nerdsort.sortable_items (list_id, position, item_name, image_url)
values (2, 2, 'Picard', 'Picard.jpg'), (2, 1, 'Kirk', 'Kirk.jpg'), (2, 3, 'Sisko', 'Sisko.jpg'), (2, 4, 'Janeway', 'Janeway.jpg'), (2, 5, 'Archer', 'Archer.jpg'), (2, 6, 'Kirk Prime', 'KirkPrime.jpg');

insert into nerdsort.sortable_items (list_id, position, item_name, image_url)
values (3, 1, 'Raiders of the Lost Ark', 'Raiders.jpg'), (3, 2, 'Temple of Doom', 'Doom.jpg'), (3, 3, 'The Last Crusade', 'Crusade.jpg'), (3, 4, 'Kingdom of the Crystal Skull', 'Skull.jpg');

insert into nerdsort.sortable_items (list_id, position, item_name, image_url)
values (4, 1, 'Alien', 'alien.jpg'), (4, 2, 'Aliens', 'aliens.jpg'), (4, 3, 'Alien 3', 'alien3.jpg'), (4, 4, 'Alien: Resurrection', 'alienresurrection.jpg'), (4, 5, 'Prometheus', 'prometheus.jpg');

