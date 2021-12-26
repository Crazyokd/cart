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

-- delete from book where `name` = "小黄书";

-- insert into book(`name`, author, price, image, description) values("小红书", "Hux", 23.23, "redBook", "小红书");
-- insert into book(`name`, author, price, image, description) values("小黄书", "Hux", 23.23, "yellowBook.jpg", "小黄书");
-- insert into book(`name`, author, price, image, description) values("小白书", "Hux", 23.23, "whileBook.jpg", "小白书");
-- insert into book(`name`, author, price, image, description) values("小蓝书", "Hux", 23.23, "blueBook.jpg", "小蓝书");
-- insert into book(`name`, author, price, image, description) values("小绿书", "Hux", 23.23, "greenBook.jpg", "小绿书");
-- insert into book(`name`, author, price, image, description) values("小紫书", "Hux", 23.23, "purpleBook.jpg", "小紫书");
-- insert into book(`name`, author, price, image, description) values("小黑书", "Hux", 23.23, "blackBook.jpg", "小黑书");
-- insert into book(`name`, author, price, image, description) values("小王子", "Rekord" 45.32, "defaultBook.jpg", "小王子");

-- select * from user;
-- select * from book;

-- 分页查询
-- select * from book limit 1,4;


-- 删除cartitem表
-- drop table if exists cartitem;

-- 创建cartitem表
create table if not exists cartitem
	(
		`id` int(11) primary key auto_increment,
        book_id int(11) not null,
        quantity int(11) not null,
		user_id int(11) not null,
        constraint cartitem_book_id foreign key(`book_id`) references book(`id`),
        constraint cartitem_user_id foreign key(`user_id`) references user(`id`)
    )ENGINE=InnoDB DEFAULT charset=utf8;

-- select * from cartitem;

-- select book_id,quantity,price
-- from cartitem,book
-- where cartitem.book_id = book.id and user_id = 1;

-- select book.* from book,cartitem where cartitem.book_id = book.id;

-- select book.* from cartitem,book where cartitem.book_id = book.id and user_id = 1;

