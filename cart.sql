create database if not exists cart;

-- drop table if exists user;
-- 创建user表 
use cart;
create table if not exists user
	(
		`id` INT(11) auto_increment comment '用户ID',
		`username` varchar(40) not null unique comment '用户名',
		`password` varchar(40) not null comment '用户密码',
		`phone` varchar(40) not null comment '电话号码',
		`email` varchar(40) not null comment '用户邮箱',
        primary key(`id`)
	)ENGINE=InnoDB DEFAULT charset=utf8;

-- drop table if exists book;
-- 创建book表 
create table if not exists book
	(
		id int(11) primary key auto_increment comment '书籍ID',
		name varchar(100) not null unique comment '书籍名',
		author varchar(100) not null comment '书籍作者',
		price double not null comment '书籍价格',
		image varchar(100) comment '书籍图片',
		description varchar(255) comment '书籍描述'
	)ENGINE=InnoDB DEFAULT charset=utf8;

-- delete from book where `name` = "小黄书";

-- insert into book(`name`, author, price, image, description) values("小红书", "Hux", 23.23, "redBook.jpg", "小红书");
-- insert into book(`name`, author, price, image, description) values("小黄书", "Hux", 23.23, "yellowBook.jpg", "小黄书");
-- insert into book(`name`, author, price, image, description) values("小白书", "Hux", 23.23, "whileBook.jpg", "小白书");
-- insert into book(`name`, author, price, image, description) values("小蓝书", "Hux", 23.23, "blueBook.jpg", "小蓝书");
-- insert into book(`name`, author, price, image, description) values("小绿书", "Hux", 23.23, "greenBook.jpg", "小绿书");
-- insert into book(`name`, author, price, image, description) values("小紫书", "Hux", 23.23, "purpleBook.jpg", "小紫书");
-- insert into book(`name`, author, price, image, description) values("小黑书", "Hux", 23.23, "blackBook.jpg", "小黑书");
-- insert into book(`name`, author, price, image, description) values("小王子", "Rekord", 45.32, "defaultBook.jpg", "小王子");

-- select * from user;
-- select * from book;

-- 分页查询
-- select * from book limit 1,4;


-- 删除cartitem表
-- drop table if exists cartitem;

-- 创建cartitem表
create table if not exists cartitem
	(
		`id` int(11) primary key auto_increment comment '物品项ID',
        book_id int(11) not null comment '书籍ID',
        quantity int(11) not null comment '书籍数量',
		user_id int(11) not null comment '用户ID',
        constraint cartitem_book_id foreign key(`book_id`) references book(`id`),
        constraint cartitem_user_id foreign key(`user_id`) references user(`id`)
    )ENGINE=InnoDB DEFAULT charset=utf8;

-- select * from cartitem;

-- select book_id,quantity,price
-- from cartitem,book
-- where cartitem.book_id = book.id and user_id = 1;

-- select book.* from book,cartitem where cartitem.book_id = book.id;

-- select book.* from cartitem,book where cartitem.book_id = book.id and user_id = 1;

-- delete from cartitem where user_id = ?;