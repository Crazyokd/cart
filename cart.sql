create database if not exists cart;

-- drop table if exists user;
-- 创建user表 
use cart;
create table if not exists user
	(
		`id` INT(11) auto_increment,
		`username` varchar(40) not null unique,
		`password` varchar(40) not null,
		`phone` varchar(40) not null,
		`email` varchar(40) not null,
        primary key(`id`)
	)ENGINE=InnoDB DEFAULT charset=utf8;

-- drop table if exists book;
-- 创建book表 
create table if not exists book
	(
		id int(11) primary key auto_increment,
		name varchar(100) not null unique,
		author varchar(100) not null,
		price double not null,
		image varchar(100),
		description varchar(255)
	)ENGINE=InnoDB DEFAULT charset=utf8;

-- insert into book(`name`, author, price, image, description) values("小红书", "Hux", 23.23, "redBook", "小红书");
-- insert into book(`name`, author, price, image, description) values("小黄书", "Hux", 23.23, "yellowBook", "小黄书");
-- insert into book(`name`, author, price, image, description) values("小白书", "Hux", 23.23, "whileBook", "小白书");
-- insert into book(`name`, author, price, image, description) values("小蓝书", "Hux", 23.23, "blueBook", "小蓝书");
-- insert into book(`name`, author, price, image, description) values("小绿书", "Hux", 23.23, "greenBook", "小绿书");
-- insert into book(`name`, author, price, image, description) values("小紫书", "Hux", 23.23, "purpleBook", "小紫书");
-- insert into book(`name`, author, price, image, description) values("小黑书", "Hux", 23.23, "blackBook", "小黑书");

-- select * from user;
-- select * from book;