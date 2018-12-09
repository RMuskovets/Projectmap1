CREATE DATABASE IF NOT EXISTS db_proekt_1;
USE db_proekt_1;

CREATE TABLE if not exists type (
  id INT(11) not null auto_increment primary key,
  parent_id int(11) not null,
  nazva text not null
) engine=InnoDB default charset=utf8;

create table if not exists mitka (
  id int(11) not null auto_increment primary key,
  typ_id int(11) not null,
  gradus_x float not null,
  gradus_y float not null,
  nazva text not null,
  vlasnyk_id int(11) not null,
  seredniy_rating_id int(11) not null,
  komentari_ids longtext not null
) engine=InnoDB default charset=utf8;

create table if not exists user (
  id int(11) not null auto_increment primary key,
  typ_id int(11) not null,
  imja text not null,
  parol text not null
) engine=InnoDB default charset=utf8;

create table if not exists komentar (
  id int(11) not null auto_increment primary key,
  rating_id int(11) not null,
  nazva text not null,
  komentar longtext not null
) engine=InnoDB default charset=utf8;

create table if not exists rating (
  id int(11) not null auto_increment primary key,
  rating float not null
) engine=InnoDB default charset=utf8;

create table if not exists marshrut_mark_bind (
  id int(11) not null auto_increment primary key,
  marshrut_id int(11) not null references marshrut (id) on delete cascade,
  mark_id int(11) not null references mitka (id) on delete cascade
);

create table if not exists marshrut (
  id int(11) not null auto_increment primary key,
  start_point_id int(11) not null,
  end_point_id int(11) not null,
  -- v_promizhku_ids longtext not null,
  podiya_id int(11) not null default -1
) engine=InnoDB default charset=utf8;

create table if not exists pravki (
  id int(11) not null auto_increment primary key,
  content longtext not null,
  nazva_zminnoi text not null,
  nove_znachenna text not null
) engine=InnoDB default charset=utf8;

create table podiya_user_bind (
  id int(11) not null auto_increment primary key,
  user_id int not null references user (id) on delete cascade,
  podiya_id int not null references podiya (id) on delete cascade
) engine=InnoDB default charset=utf8;

create table podiya (
  id int(11) not null auto_increment primary key,
  nazva text not null,
  chas_pochatok datetime not null,
  chas_kinec datetime not null
) engine=InnoDB default charset=utf8;

-- ÂÀÆËÈÂÎ: Ïîëÿ podiya.zaprosheni, marshrut.v_promizhku_ids, mitka.komentari_ids - öå 
-- òåêñòîâ³ ïîëÿ ("ìàñèâè"), êóäè çàíîñÿòüñÿ äàí³ ×ÅÐÅÇ ÊÎÌÓ!