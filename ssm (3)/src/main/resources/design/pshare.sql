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
  cid int(11) DEFAULT NULL COMMENT "外键：分类id",
  title varchar(255) DEFAULT NULL COMMENT "文章标题",
  author varchar(255) DEFAULT NULL COMMENT "文章作者",
  updateTime varchar(255) DEFAULT NULL COMMENT "更新时间",
  wordSum varchar(255) DEFAULT NULL COMMENT "字数",
  content varchar(255) DEFAULT NULL COMMENT "正文",
  PRIMARY KEY (id),
  CONSTRAINT fk_paper_category FOREIGN KEY (cid) REFERENCES category_ (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT "文章表";
 
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
  pid int(11) int(11) DEFAULT NULL COMMENT "外键：文章id",
  payMan varchar(255) DEFAULT NULL COMMENT "打赏人",
  getMan varchar(255) DEFAULT NULL COMMENT "被打赏作者",
  payNum varchar(255) DEFAULT NULL COMMENT "支付金额",
  PRIMARY KEY (id),
  CONSTRAINT fk_payment_paper FOREIGN KEY (pid) REFERENCES user_ (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT "消息表";
 

