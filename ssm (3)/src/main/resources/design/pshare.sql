/*
 Target Server Type    : MySQL
 Date: 21/02/2019 10:08:51
*/
DROP DATABASE IF EXISTS pshare_ssm;
CREATE DATABASE pshare_ssm DEFAULT CHARACTER SET utf8;
USE pshare_ssm;
 
CREATE TABLE user_ (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT "用户id",
  name varchar(255) DEFAULT NULL COMMENT "用户名",
  password varchar(255) DEFAULT NULL COMMENT "用户密码",
  email varchar(255) DEFAULT NULL COMMENT "用户邮箱",
  github varchar(255) DEFAULT NULL COMMENT "用户github地址",
  avatarURL varchar(255) DEFAULT NULL COMMENT "用户头像",
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "用户表";
 
CREATE TABLE category_ (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT "分类id",
  name varchar(255) DEFAULT NULL COMMENT "分类名",
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT "分类表";
 
CREATE TABLE property_ (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT "属性id",
  cid int(11) DEFAULT NULL COMMENT "外键：分类id",
  name varchar(255) DEFAULT NULL COMMENT "属性名",
  PRIMARY KEY (id),
  CONSTRAINT fk_property_category FOREIGN KEY (cid) REFERENCES category_ (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "属性名称表";
 
CREATE TABLE paper_ (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT "文章id",
  uid int(11) DEFAULT NULL COMMENT "外键：用户id",
  cid int(11) DEFAULT NULL COMMENT "外键：分类id",
  title varchar(255) DEFAULT NULL COMMENT "文章标题",
  description varchar(255) DEFAULT NULL COMMENT "描述",
  updateTime varchar(255) DEFAULT NULL COMMENT "更新时间",
  wordSum varchar(255) DEFAULT NULL COMMENT "字数",
  content varchar(255) DEFAULT NULL COMMENT "正文",
  
  PRIMARY KEY (id),
  CONSTRAINT fk_paper_category FOREIGN KEY (cid) REFERENCES category_ (id),
  CONSTRAINT fk_paper_user FOREIGN KEY (uid) REFERENCES user_ (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT "文章表";

CREATE TABLE tags_ (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT "标签id",
  pid int(11) DEFAULT NULL COMMENT "外键：文章id",
  name varchar(255) DEFAULT NULL COMMENT "标签名",
  PRIMARY KEY (id),
  CONSTRAINT fk_tags_paper FOREIGN KEY (pid) REFERENCES paper_ (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT "标签表";


CREATE TABLE propertyvalue_ (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT "属性值id",
  pid int(11) DEFAULT NULL COMMENT "外键：文章id",
  ptid int(11) DEFAULT NULL COMMENT "外键：属性id",
  value varchar(255) DEFAULT NULL COMMENT "属性值",
  PRIMARY KEY (id),
  CONSTRAINT fk_propertyvalue_property FOREIGN KEY (ptid) REFERENCES property_ (id),
  CONSTRAINT fk_propertyvalue_paper FOREIGN KEY (pid) REFERENCES paper_ (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT "属性值表";
 
CREATE TABLE paperimage_ (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT "文章照片id",
  pid int(11) DEFAULT NULL COMMENT "外键：文章id",
  type varchar(255) DEFAULT NULL COMMENT "照片类型",
  imgPath varchar(255) DEFAULT NULL COMMENT "照片路径",
  PRIMARY KEY (id),
  CONSTRAINT fk_paperimage_paper FOREIGN KEY (pid) REFERENCES paper_ (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "文章图片表";
 
CREATE TABLE review_ (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT "评论id",
  content varchar(4000) DEFAULT NULL COMMENT "评论内容",
  uid int(11) DEFAULT NULL COMMENT "外键：用户id",
  pid int(11) DEFAULT NULL COMMENT "外键：文章id",
  createDate datetime DEFAULT NULL COMMENT "评论时间",
  PRIMARY KEY (id),
  CONSTRAINT fk_review_paper FOREIGN KEY (pid) REFERENCES paper_ (id),
  CONSTRAINT fk_review_user FOREIGN KEY (uid) REFERENCES user_ (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT "评论表";

CREATE TABLE news_ (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT "消息id",
  uid int(11) DEFAULT NULL COMMENT "外键：用户id",
  newsSum int(11) DEFAULT NULL COMMENT "消息数量",
  msg varchar(255) DEFAULT NULL COMMENT "消息内容",
  sendTime varchar(255) DEFAULT NULL COMMENT "发送时间",
  PRIMARY KEY (id),
  CONSTRAINT fk_news_user FOREIGN KEY (uid) REFERENCES user_ (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT "消息表";
 
CREATE TABLE payment_ (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT "支付id",
  pid int(11)  DEFAULT NULL COMMENT "外键：文章id",
  payMan varchar(255) DEFAULT NULL COMMENT "打赏人",
  getMan varchar(255) DEFAULT NULL COMMENT "被打赏作者",
  payNum varchar(255) DEFAULT NULL COMMENT "支付金额",
  PRIMARY KEY (id),
  CONSTRAINT fk_payment_paper FOREIGN KEY (pid) REFERENCES user_ (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT "消息表";
-- ----------------------------
-- data for test
-- ----------------------------
insert into user_ values(1,'demo1',"pw1",null,null,null);
insert into user_ values(2,'demo2',"pw2",null,null,null);
insert into user_ values(3,'demo3',"pw3",null,null,null);
insert into user_ values(4,'demo4',"pw4",null,null,null);
insert into user_ values(5,'demo5',"pw5",null,null,null);

insert into category_ values(1,'java');
insert into category_ values(2,'c#');
insert into category_ values(3,'c++');
insert into category_ values(4,'python');
insert into category_ values(5,'php');

insert into paper_ values(1,1,1,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(2,1,2,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(3,1,3,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(4,1,4,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(5,1,5,"title1","description1","updateTime","wordSum","content");

insert into paper_ values(6,2,1,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(7,2,2,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(8,2,3,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(9,2,4,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(10,2,5,"title1","description1","updateTime","wordSum","content");

insert into paper_ values(11,3,1,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(12,3,2,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(13,3,3,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(14,3,4,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(15,3,5,"title1","description1","updateTime","wordSum","content");

insert into paper_ values(16,4,1,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(17,4,2,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(18,4,3,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(19,4,4,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(20,4,5,"title1","description1","updateTime","wordSum","content");

insert into paper_ values(21,5,1,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(22,5,2,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(23,5,3,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(24,5,4,"title1","description1","updateTime","wordSum","content");
insert into paper_ values(25,5,5,"title1","description1","updateTime","wordSum","content");

insert into tags_ values(1,1,"artificial");
insert into tags_ values(2,2,"artificial");
insert into tags_ values(3,3,"artificial");
insert into tags_ values(4,4,"artificial");
insert into tags_ values(5,5,"artificial");
insert into tags_ values(6,6,"artificial");
insert into tags_ values(7,7,"artificial");
insert into tags_ values(8,8,"artificial");
insert into tags_ values(9,9,"artificial");
insert into tags_ values(10,10,"artificial");
insert into tags_ values(11,11,"artificial");
insert into tags_ values(12,12,"artificial");
insert into tags_ values(13,13,"artificial");
insert into tags_ values(14,14,"artificial");
insert into tags_ values(15,15,"artificial");
insert into tags_ values(16,16,"artificial");
insert into tags_ values(17,17,"artificial");
insert into tags_ values(18,18,"artificial");
insert into tags_ values(19,19,"artificial");
insert into tags_ values(20,20,"artificial");
insert into tags_ values(21,21,"artificial");
insert into tags_ values(22,22,"artificial");
insert into tags_ values(23,23,"artificial");
insert into tags_ values(24,24,"artificial");
insert into tags_ values(25,25,"artificial");

insert into tags_ values(26,1,"artificial");
insert into tags_ values(27,2,"artificial");
insert into tags_ values(28,3,"artificial");
insert into tags_ values(29,4,"artificial");
insert into tags_ values(30,5,"artificial");
insert into tags_ values(31,6,"artificial");
insert into tags_ values(32,7,"artificial");
insert into tags_ values(33,8,"artificial");
insert into tags_ values(34,9,"artificial");
insert into tags_ values(35,10,"artificial");
insert into tags_ values(36,11,"artificial");
insert into tags_ values(37,12,"artificial");
insert into tags_ values(38,13,"artificial");
insert into tags_ values(39,14,"artificial");
insert into tags_ values(40,15,"artificial");
insert into tags_ values(50,16,"artificial");
insert into tags_ values(41,17,"artificial");
insert into tags_ values(42,18,"artificial");
insert into tags_ values(43,19,"artificial");
insert into tags_ values(44,20,"artificial");
insert into tags_ values(45,21,"artificial");
insert into tags_ values(46,22,"artificial");
insert into tags_ values(47,23,"artificial");
insert into tags_ values(48,24,"artificial");
insert into tags_ values(49,25,"artificial");

insert into review_ values(null,"review",1,1,null);
insert into review_ values(null,"review",2,1,null);
insert into review_ values(null,"review",1,2,null);
insert into review_ values(null,"review",2,2,null);
insert into review_ values(null,"review",1,3,null);
insert into review_ values(null,"review",2,3,null);
insert into review_ values(null,"review",1,4,null);
insert into review_ values(null,"review",2,4,null);
insert into review_ values(null,"review",1,5,null);
insert into review_ values(null,"review",2,5,null);
insert into review_ values(null,"review",1,6,null);
insert into review_ values(null,"review",2,6,null);
insert into review_ values(null,"review",1,7,null);
insert into review_ values(null,"review",2,7,null);
insert into review_ values(null,"review",1,8,null);
insert into review_ values(null,"review",2,8,null);
insert into review_ values(null,"review",1,9,null);
insert into review_ values(null,"review",2,9,null);
insert into review_ values(null,"review",1,10,null);
insert into review_ values(null,"review",2,10,null);
insert into review_ values(null,"review",1,11,null);
insert into review_ values(null,"review",2,11,null);
insert into review_ values(null,"review",1,12,null);
insert into review_ values(null,"review",2,12,null);
insert into review_ values(null,"review",1,13,null);
insert into review_ values(null,"review",2,13,null);
insert into review_ values(null,"review",1,14,null);
insert into review_ values(null,"review",2,14,null);
insert into review_ values(null,"review",1,15,null);
insert into review_ values(null,"review",2,15,null);
insert into review_ values(null,"review",1,16,null);
insert into review_ values(null,"review",2,16,null);
insert into review_ values(null,"review",1,17,null);
insert into review_ values(null,"review",2,17,null);
insert into review_ values(null,"review",1,18,null);
insert into review_ values(null,"review",2,18,null);
insert into review_ values(null,"review",1,19,null);
insert into review_ values(null,"review",2,19,null);
insert into review_ values(null,"review",1,20,null);
insert into review_ values(null,"review",2,20,null);
insert into review_ values(null,"review",1,21,null);
insert into review_ values(null,"review",2,21,null);
insert into review_ values(null,"review",1,22,null);
insert into review_ values(null,"review",2,22,null);
insert into review_ values(null,"review",1,23,null);
insert into review_ values(null,"review",2,23,null);
insert into review_ values(null,"review",1,24,null);
insert into review_ values(null,"review",2,24,null);
insert into review_ values(null,"review",1,25,null);
insert into review_ values(null,"review",2,25,null);

