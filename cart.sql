create database if not exists cart;

use cart;
create table if not exists user
	(
		`id` INT(11) auto_increment,
		`username` varchar(40) not null unique,
		`password` varchar(40) not null,
		`phone` varchar(40) not null,
		`email` varchar(40) not null,
        primary key(`id`)
	);
    

select * from user;