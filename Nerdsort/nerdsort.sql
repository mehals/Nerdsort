drop table if exists item_list_mapping;

drop table if exists sortable_items;
drop table if exists item_lists;

drop table if exists user_profiles;
drop table if exists user_ordering;

create table if not exists USER_PROFILES (
user_id BIGINT NOT NULL auto_increment,
twitter_handle varchar(30) NOT NULL,
PRIMARY KEY (user_id)
);

create table if not exists USER_ORDERING (
list_id BIGINT NOT null,
user_id BIGINT NOT null,
user_ordering text NOT null,
user_ordering_id BIGINT NOT NULL auto_increment,
primary key (user_ordering_id)
);

create table if not exists SORTABLE_ITEMS (
list_id BIGINT NOT NULL,
position int NOT NULL,
item_id BIGINT NOT NULL auto_increment,
image_url varchar(30),
item_name varchar(30) NOT NULL,
PRIMARY KEY (item_id)
);

create table if not exists ITEM_LISTS (
list_id BIGINT NOT NULL auto_increment,
list_name varchar(30) NOT NULL,
PRIMARY KEY (list_id)
);

commit;

alter table sortable_items
add constraint fk_sortable_items_list_id
foreign key (list_id) references item_lists(list_id)
on update cascade
on delete cascade;

create index user_ordering_user_index
on user_ordering (user_id);

create index user_ordering_list_index
on user_ordering (list_id);

commit;